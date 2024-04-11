package dal;

import constant.GenderType;
import constant.Size;
import model.Clothes;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class ProductDaoImplementation implements ProductDao<Product> {
    private final Map<Long, Product> productMap;

    public ProductDaoImplementation() throws FileNotFoundException {
        productMap = readProductInventory();
    }

    private Map<Long, Product> readProductInventory() throws FileNotFoundException {
        Map<Long, Product> products = new HashMap<>();
        try {
            File myObj = new File("src/main/resources/ProductInventory.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("id;name;description;color;quantity;price;genderType;size;")) {
                    continue;
                }
                String[] values = data.split(";");

                Product product = new Product.Builder().id(Long.parseLong(values[0]))
                        .name(values[1])
                        .description(values[2])
                        .color(values[3])
                        .quantity(Long.parseLong(values[4]))
                        .price(Double.parseDouble(values[5]))
                        .genderType(GenderType.valueOf(values[6]))
                        .size(Size.valueOf(values[7]))
                        .build();

                products.put(product.getId(), product);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            throw e;
        } catch (Exception e) {
            System.out.println("An error occurred while reading product inventory.");
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Class<Product> getProduct() {
        return Product.class;
    }

    @Override
    public List<Product> findById(Long id) {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getId().equals(id)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByColor(String color) {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getColor().equalsIgnoreCase(color)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByQuantity(Long quantity) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getQuantity().equals(quantity)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByPriceRange(double price) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getPrice()==(price)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByGenderType(String genderType) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getGenderType().name().equalsIgnoreCase(genderType)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findBySize(String size) throws FileNotFoundException {
        List<Product> result = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getSize().name().equalsIgnoreCase(size)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public String addProducts(Product product) {
        productMap.put(product.getId(), product);
        appendToFile(product);
        return "Product added successfully.";
    }

    @Override
    public String deleteProductsById(Long id) {
        if (productMap.containsKey(id)) {
            productMap.remove(id);
            updateFile();
            return "Product deleted successfully.";
        } else {
            return "Product with ID " + id + " not found.";
        }
    }

    @Override
    public String updateProductsById(Long id, Product product) {
        if (productMap.containsKey(id)) {
            productMap.put(id, product);
            updateFile();
            return "Product updated successfully.";
        } else {
            return "Product with ID " + id + " not found.";
        }
    }

    @Override
    public Double getTotalPriceOfProductsByName(String name) {
        double totalPrice = 0;
        for (Product product : productMap.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                totalPrice += product.getPrice() * product.getQuantity();
            }
        }
        return totalPrice;
    }

    private void appendToFile(Product product) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/ProductInventory.csv", true); // true for append mode
            writer.write(product.getId() + ";" + product.getName() + ";" + product.getDescription() + ";" +
                    product.getColor() + ";" + product.getQuantity() + ";" + product.getPrice() + ";" +
                    product.getGenderType() + ";" + product.getSize());
            writer.close();
            System.out.println("Products appended to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending clothes to file.");
            e.printStackTrace();
        }
    }

    private void updateFile() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/ProductInventory.csv");
            writer.write("id;name;description;color;quantity;price;genderType;size\n");
            for (Product product : productMap.values()) {
                writer.write(product.getId() + ";" + product.getName() + ";" + product.getDescription() + ";" +
                        product.getColor() + ";" + product.getQuantity() + ";" + product.getPrice() + ";" +
                        product.getGenderType() + ";" + product.getSize());
            }
            writer.close();
            System.out.println("Products inventory updated and written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating and writing clothes inventory to file.");
            e.printStackTrace();
        }
    }
}