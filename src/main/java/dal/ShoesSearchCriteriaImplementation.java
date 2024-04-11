package dal;

import constant.GenderType;
import constant.Size;
import model.Product;
import model.Shoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ShoesSearchCriteriaImplementation implements ShoesSearchCriteria<Shoes>{

    private final Map<Long, Shoes> shoeMap;

    public ShoesSearchCriteriaImplementation() throws FileNotFoundException {
        shoeMap = readProductInventory();
    }

    private Map<Long, Shoes> readProductInventory() throws FileNotFoundException {
        Map<Long, Shoes> shoesMap = new HashMap<>();
        try {
            File myObj = new File("Shoes.csv");
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
            if (shoe.getName().equals(name)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByColor(String color) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getColor().equals(color)) {
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
            if (shoe.getGenderType().name().equals(genderType)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findBySize(String size) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getSize().name().equals(size)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

    @Override
    public List<Shoes> findByShoeType(String shoeType) {
        List<Shoes> shoes = new ArrayList<>();
        for (Shoes shoe : shoeMap.values()) {
            if (shoe.getShoeType().equals(shoeType)) {
                shoes.add(shoe);
            }
        }
        return shoes;
    }

}
