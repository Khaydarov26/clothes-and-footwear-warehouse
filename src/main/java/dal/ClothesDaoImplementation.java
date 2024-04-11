package dal;

import constant.GenderType;
import constant.Size;
import model.Clothes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ClothesDaoImplementation implements ClothesDao<Clothes> {

    private final Map<Long, Clothes> clothesMap;

    public ClothesDaoImplementation() throws FileNotFoundException {
        clothesMap = readClothesInventory();
    }

    private Map<Long, Clothes> readClothesInventory() throws FileNotFoundException {
        Map<Long, Clothes> clothesMap = new HashMap<>();
        try {
            File myObj = new File("src/main/resources/Clothes.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("id;name;description;color;quantity;price;genderType;size;clotheType")) {
                    continue;
                }
                String[] values = data.split(";");

                Clothes clothes = new Clothes.Builder()
                        .id(Long.parseLong(values[0]))
                        .name(values[1])
                        .description(values[2])
                        .color(values[3])
                        .quantity(Long.parseLong(values[4]))
                        .price(Double.parseDouble(values[5]))
                        .genderType(GenderType.valueOf(values[6]))
                        .size(Size.valueOf(values[7]))
                        .clotheType(values[8])
                        .build();

                clothesMap.put(clothes.getId(), clothes);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Clothes inventory file not found.");
            throw e;
        } catch (Exception e) {
            System.out.println("An error occurred while reading clothes inventory.");
            e.printStackTrace();
        }
        return clothesMap;
    }

    @Override
    public List<Clothes> findById(Long id) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getId().equals(id)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByName(String name) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getName().equalsIgnoreCase(name)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByColor(String color) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getColor().equalsIgnoreCase(color)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByQuantity(Long quantity) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getQuantity().equals(quantity)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByPriceRange(double price) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getPrice() == price) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByGenderType(String genderType) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getGenderType().name().equalsIgnoreCase(genderType)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findBySize(String size) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getSize().name().equalsIgnoreCase(size)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByClotheType(String clotheType) {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getClotheType().equalsIgnoreCase(clotheType)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public String addClothes(Clothes clothes) {
        clothesMap.put(clothes.getId(), clothes);
        appendToFile(clothes);
        return "Clothes added successfully.";
    }

    @Override
    public String deleteClothesById(Long id) {
        if (clothesMap.containsKey(id)) {
            clothesMap.remove(id);
            updateFile();
            return "Clothes with ID " + id + " deleted successfully.";
        } else {
            return "Clothes with ID " + id + " not found.";
        }
    }

    @Override
    public String updateClothesById(Long id, Clothes updatedClothes) {
        if (clothesMap.containsKey(id)) {
            clothesMap.put(id, updatedClothes);
            updateFile();
            return "Clothes updated successfully.";
        } else {
            return "Clothes with ID " + id + " not found.";
        }
    }

    @Override
    public Double getTotalPriceOfClothesByName(String name) {
        double totalPrice = 0;
        for (Clothes clothes : clothesMap.values()) {
            if (clothes.getName().equalsIgnoreCase(name)) {
                totalPrice += clothes.getPrice() * clothes.getQuantity();
            }
        }
        return totalPrice;
    }

    private void appendToFile(Clothes clothes) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Clothes.csv", true); // true for append mode
            writer.write(clothes.getId() + ";" + clothes.getName() + ";" + clothes.getDescription() + ";" +
                    clothes.getColor() + ";" + clothes.getQuantity() + ";" + clothes.getPrice() + ";" +
                    clothes.getGenderType() + ";" + clothes.getSize() + ";" + clothes.getClotheType() + "\n");
            writer.close();
            System.out.println("Clothes appended to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending clothes to file.");
            e.printStackTrace();
        }
    }

    private void updateFile() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Clothes.csv");
            writer.write("id;name;description;color;quantity;price;genderType;size;clotheType\n");
            for (Clothes clothes : clothesMap.values()) {
                writer.write(clothes.getId() + ";" + clothes.getName() + ";" + clothes.getDescription() + ";" +
                        clothes.getColor() + ";" + clothes.getQuantity() + ";" + clothes.getPrice() + ";" +
                        clothes.getGenderType() + ";" + clothes.getSize() + ";" + clothes.getClotheType() + "\n");
            }
            writer.close();
            System.out.println("Clothes inventory updated and written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating and writing clothes inventory to file.");
            e.printStackTrace();
        }
    }
}
