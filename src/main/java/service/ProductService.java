package service;

import model.Product;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProductService {
    List<Product> findById(Long id) throws FileNotFoundException;
    List<Product> findByName(String name) throws FileNotFoundException;
    List<Product> findByColor(String color) throws FileNotFoundException;
    List<Product> findByQuantity(Long quantity) throws FileNotFoundException;
    List<Product> findByPriceRange(double price) throws FileNotFoundException;
    List<Product> findByGenderType(String genderType) throws FileNotFoundException;
    List<Product> findBySize(String size) throws FileNotFoundException;
}