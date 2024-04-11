package dal;

import constant.GenderType;
import constant.Size;
import model.Clothes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ClothesSearchCriteriaImplementation implements ClothesSearchCriteria<Clothes> {

    private final Map<Long, Clothes> clothesMap;

    public ClothesSearchCriteriaImplementation() throws FileNotFoundException {
        clothesMap = readClothesInventory();
    }

    private Map<Long, Clothes> readClothesInventory() throws FileNotFoundException {
        Map<Long, Clothes> clothesMap = new HashMap<>();
        try {
            File myObj = new File("Clothes.csv");
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
            if (cloth.getName().equals(name)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByColor(String color) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getColor().equals(color)) {
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
            if (cloth.getGenderType().name().equals(genderType)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findBySize(String size) throws FileNotFoundException {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getSize().name().equals(size)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }

    @Override
    public List<Clothes> findByClotheType(String clotheType) {
        List<Clothes> clothes = new ArrayList<>();
        for (Clothes cloth : clothesMap.values()) {
            if (cloth.getClotheType().equals(clotheType)) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }
}
