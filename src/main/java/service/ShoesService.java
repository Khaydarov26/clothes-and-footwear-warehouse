package service;

import model.Shoes;

import java.io.FileNotFoundException;
import java.util.List;

public interface ShoesService{

    List<Shoes> findById(Long id) throws FileNotFoundException;
    List<Shoes> findByName(String name) throws FileNotFoundException;
    List<Shoes> findByColor(String color) throws FileNotFoundException;
    List<Shoes> findByQuantity(Long quantity) throws FileNotFoundException;
    List<Shoes> findByPriceRange(double price) throws FileNotFoundException;
    List<Shoes> findByGenderType(String genderType) throws FileNotFoundException;
    List<Shoes> findBySize(String size) throws FileNotFoundException;

    List<Shoes> findByShoeType(String shoeType);
}
