package controller;

import model.Shoes;
import service.ShoesService;
import service.ShoesServiceImplementation;

import java.io.FileNotFoundException;
import java.util.List;

public class ShoesController {
    private final ShoesService shoesService;

    public ShoesController() throws FileNotFoundException {
        shoesService = new ShoesServiceImplementation();
    }

    public List<Shoes> findById(Long id) {
        try {
            return shoesService.findById(id);
        } catch (FileNotFoundException e) {
            System.out.println("Shoe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Shoes> findByName(String name) {
        try {
            return shoesService.findByName(name);
        } catch (FileNotFoundException e) {
            System.out.println("Shoe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Shoes> findByColor(String color) {
        try {
            return shoesService.findByColor(color);
        } catch (FileNotFoundException e) {
            System.out.println("Shoe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Shoes> findByQuantity(Long quantity) {
        try {
            return shoesService.findByQuantity(quantity);
        } catch (FileNotFoundException e) {
            System.out.println("Shoe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Shoes> findByPriceRange(double price) {
        try {
            return shoesService.findByPriceRange(price);
        } catch (FileNotFoundException e) {
            System.out.println("Shoe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Shoes> findByGenderType(String genderType) {
        try {
            return shoesService.findByGenderType(genderType);
        } catch (FileNotFoundException e) {
            System.out.println("Shoe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Shoes> findBySize(String size) {
        try {
            return shoesService.findBySize(size);
        } catch (FileNotFoundException e) {
            System.out.println("Shoe inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Shoes> findByShoeType(String shoeType) {
        return shoesService.findByShoeType(shoeType);
    }
}
