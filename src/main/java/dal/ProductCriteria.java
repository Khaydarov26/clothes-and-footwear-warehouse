package dal;

import constant.GenderType;
import constant.Size;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ProductCriteria implements SearchCriteria<Product> {
    private final Map<Long, Product> productMap;

    public ProductCriteria() throws FileNotFoundException {
        productMap = readProductInventory();
    }

    private Map<Long, Product> readProductInventory() throws FileNotFoundException {
        Map<Long, Product> products = new HashMap<>();
        try {
            File myObj = new File("ProductInventory.csv");
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
        Product product = productMap.get(id);
        if (product != null) {
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().equals(name)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByColor(String color) {
        List<Product> products = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getColor().equals(color)) {
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
            if (product.getGenderType().name().equals(genderType)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findBySize(String size) throws FileNotFoundException {
        List<Product> result = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getSize().name().equals(size)) {
                result.add(product);
            }
        }
        return result;
    }
}