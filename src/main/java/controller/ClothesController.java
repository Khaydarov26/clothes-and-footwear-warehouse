package controller;

import model.Clothes;
import service.ClothesService;
import service.ClothesServiceImplementation;

import java.io.FileNotFoundException;
import java.util.List;

public class ClothesController {
    private final ClothesService clothesService;

    public ClothesController() throws FileNotFoundException {
        clothesService = new ClothesServiceImplementation();
    }

    public List<Clothes> findById(Long id) {
        try {
            return clothesService.findById(id);
        } catch (FileNotFoundException e) {
            System.out.println("Clothe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Clothes> findByName(String name) {
        try {
            return clothesService.findByName(name);
        } catch (FileNotFoundException e) {
            System.out.println("Clothe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Clothes> findByColor(String color) {
        try {
            return clothesService.findByColor(color);
        } catch (FileNotFoundException e) {
            System.out.println("Clothe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Clothes> findByQuantity(Long quantity) {
        try {
            return clothesService.findByQuantity(quantity);
        } catch (FileNotFoundException e) {
            System.out.println("Clothe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Clothes> findByPriceRange(double price) {
        try {
            return clothesService.findByPriceRange(price);
        } catch (FileNotFoundException e) {
            System.out.println("Clothe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Clothes> findByGenderType(String genderType) {
        try {
            return clothesService.findByGenderType(genderType);
        } catch (FileNotFoundException e) {
            System.out.println("Clothe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Clothes> findBySize(String size) {
        try {
            return clothesService.findBySize(size);
        } catch (FileNotFoundException e) {
            System.out.println("Clothe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Clothes> findByClotheType(String shoeType) {
        return clothesService.findByClotheType(shoeType);
    }
}
