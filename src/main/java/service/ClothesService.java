package service;

import model.Clothes;

import java.io.FileNotFoundException;
import java.util.List;

public interface ClothesService {

    List<Clothes> findById(Long id) throws FileNotFoundException;
    List<Clothes> findByName(String name) throws FileNotFoundException;
    List<Clothes> findByColor(String color) throws FileNotFoundException;
    List<Clothes> findByQuantity(Long quantity) throws FileNotFoundException;
    List<Clothes> findByPriceRange(double price) throws FileNotFoundException;
    List<Clothes> findByGenderType(String genderType) throws FileNotFoundException;
    List<Clothes> findBySize(String size) throws FileNotFoundException;

    List<Clothes> findByClotheType(String clotheType);
}
