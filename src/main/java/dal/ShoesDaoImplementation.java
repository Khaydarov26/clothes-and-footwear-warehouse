package dal;

import constant.GenderType;
import constant.Size;
import model.Clothes;
import model.Shoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ShoesDaoImplementation implements ShoesDao<Shoes> {

    private final Map<Long, Shoes> shoeMap;

    public ShoesDaoImplementation() throws FileNotFoundException {
        shoeMap = readProductInventory();
    }

    private Map<Long, Shoes> readProductInventory() throws FileNotFoundException {
        Map<Long, Shoes> shoesMap = new HashMap<>();
        try {
            File myObj = new File("src/main/resources/Shoes.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("id;name;description;color;quantity;price;genderType;size;shoeType")) {
                    continue;
                }
                String[] values = data.split(";");

                Shoes shoes = new Shoes.Builder()
                        .id(Long.parseLong(values[0]))
                        .name(values[1])
                        .description(values[2])
                        .color(values[3])
                        .quantity(Long.parseLong(values[4]))
                        .price(Double.parseDouble(values[5]))
                        .genderType(GenderType.valueOf(values[6]))
                        .size(Size.valueOf(values[7]))
                        .shoeType(values[8])
                        .build();


                shoesMap.put(shoes.getId(), shoes);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            throw e;
        } catch (Exception e) {
            System.out.println("An error occurred while reading product inventory.");
            e.printStackTrace();
        }
        return shoesMap;
    }

    @Override
    public List<Shoes> findById(Long id) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getId().equals(id)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByName(String name) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getName().equalsIgnoreCase(name)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByColor(String color) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getColor().equalsIgnoreCase(color)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByQuantity(Long quantity) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getQuantity().equals(quantity)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByPriceRange(double price) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getPrice()==price) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByGenderType(String genderType) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getGenderType().name().equalsIgnoreCase(genderType)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findBySize(String size) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getSize().name().equalsIgnoreCase(size)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByShoeType(String shoeType) {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getShoeType().equalsIgnoreCase(shoeType)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public String addShoe(Shoes shoes) {
        shoeMap.put(shoes.getId(), shoes);
        appendToFile(shoes);
        return "Shoe added successfully.";
    }

    @Override
    public String deleteShoeById(Long id) {
        if (shoeMap.containsKey(id)) {
            shoeMap.remove(id);
            updateFile();
            return "Shoe deleted successfully.";
        } else {
            return "Shoe with ID " + id + " not found.";
        }
    }

    @Override
    public String updateShoeById(Long id, Shoes shoes) {
        if (shoeMap.containsKey(id)) {
            shoeMap.put(id, shoes);
            updateFile();
            return "Shoe updated successfully.";
        } else {
            return "Shoe with ID " + id + " not found.";
        }
    }

    @Override
    public Double getTotalPriceOfShoeByName(String name) {
        double totalPrice = 0;
        for (Shoes shoes : shoeMap.values()) {
            if (shoes.getName().equalsIgnoreCase(name)) {
                totalPrice += shoes.getPrice() * shoes.getQuantity();
            }
        }
        return totalPrice;
    }

    private void appendToFile(Shoes shoes) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Shoes.csv", true); // true for append mode
            writer.write(shoes.getId() + ";" + shoes.getName() + ";" + shoes.getDescription() + ";" +
                    shoes.getColor() + ";" + shoes.getQuantity() + ";" + shoes.getPrice() + ";" +
                    shoes.getGenderType() + ";" + shoes.getSize() + ";" + shoes.getShoeType() + "\n");
            writer.close();
            System.out.println("Shoe appended to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending shoe to file.");
            e.printStackTrace();
        }
    }

    private void updateFile() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Shoes.csv");
            writer.write("id;name;description;color;quantity;price;genderType;size;shoeType\n");
            for (Shoes shoes : shoeMap.values()) {
                writer.write(shoes.getId() + ";" + shoes.getName() + ";" + shoes.getDescription() + ";" +
                        shoes.getColor() + ";" + shoes.getQuantity() + ";" + shoes.getPrice() + ";" +
                        shoes.getGenderType() + ";" + shoes.getSize() + ";" + shoes.getShoeType() + "\n");
            }
            writer.close();
            System.out.println("Shoes inventory updated and written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating and writing shoes inventory to file.");
            e.printStackTrace();
        }
    }

}
