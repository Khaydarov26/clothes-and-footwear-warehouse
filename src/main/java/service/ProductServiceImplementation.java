package service;

import dal.ProductDaoImplementation;
import model.Clothes;
import model.Product;

import java.io.FileNotFoundException;
import java.util.List;

public class ProductServiceImplementation implements ProductService{

    private final ProductDaoImplementation productDao;

    public ProductServiceImplementation() throws FileNotFoundException {
        productDao = new ProductDaoImplementation();
    }

    @Override
    public List<Product> findById(Long id) throws FileNotFoundException {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findByName(String name) throws FileNotFoundException {
        return productDao.findByName(name);
    }

    @Override
    public List<Product> findByColor(String color) throws FileNotFoundException {
        return productDao.findByColor(color);
    }

    @Override
    public List<Product> findByQuantity(Long quantity) throws FileNotFoundException {
        return productDao.findByQuantity(quantity);
    }

    @Override
    public List<Product> findByPriceRange(double price) throws FileNotFoundException {
        return productDao.findByPriceRange(price);
    }

    @Override
    public List<Product> findByGenderType(String genderType) throws FileNotFoundException {
        return productDao.findByGenderType(genderType);
    }

    @Override
    public List<Product> findBySize(String size) throws FileNotFoundException {
        return productDao.findBySize(size);
    }

    @Override
    public String addProduct(Product product) {
        return productDao.addProducts(product);
    }

    @Override
    public String deleteProductById(Long id) {
        return productDao.deleteProductsById(id);
    }

    @Override
    public String updateProductById(Long id, Product product) {
        return productDao.updateProductsById(id, product);
    }

    @Override
    public Double getTotalPriceOfProductByName(String name) {
        return productDao.getTotalPriceOfProductsByName(name);
    }
}
