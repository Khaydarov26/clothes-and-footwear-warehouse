package service;

import dal.ProductSearchCriteriaImplementation;
import model.Product;

import java.io.FileNotFoundException;
import java.util.List;

public class ProductServiceImplementation implements ProductService{

    private final ProductSearchCriteriaImplementation productCriteria;

    public ProductServiceImplementation() throws FileNotFoundException {
        productCriteria = new ProductSearchCriteriaImplementation();
    }

    @Override
    public List<Product> findById(Long id) throws FileNotFoundException {
        return productCriteria.findById(id);
    }

    @Override
    public List<Product> findByName(String name) throws FileNotFoundException {
        return productCriteria.findByName(name);
    }

    @Override
    public List<Product> findByColor(String color) throws FileNotFoundException {
        return productCriteria.findByColor(color);
    }

    @Override
    public List<Product> findByQuantity(Long quantity) throws FileNotFoundException {
        return productCriteria.findByQuantity(quantity);
    }

    @Override
    public List<Product> findByPriceRange(double price) throws FileNotFoundException {
        return productCriteria.findByPriceRange(price);
    }

    @Override
    public List<Product> findByGenderType(String genderType) throws FileNotFoundException {
        return productCriteria.findByGenderType(genderType);
    }

    @Override
    public List<Product> findBySize(String size) throws FileNotFoundException {
        return productCriteria.findBySize(size);
    }
}
