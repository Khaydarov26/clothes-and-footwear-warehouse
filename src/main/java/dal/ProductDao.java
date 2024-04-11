package dal;

import model.Clothes;
import model.Product;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProductDao<P extends Product> {
    Class<P> getProduct();
    List<P> findById(Long id) throws FileNotFoundException;
    List<P> findByName(String name) throws FileNotFoundException;
    List<P> findByColor(String color) throws FileNotFoundException;
    List<P> findByQuantity(Long quantity) throws FileNotFoundException;
    List<P> findByPriceRange(double price) throws FileNotFoundException;
    List<P> findByGenderType(String genderType) throws FileNotFoundException;
    List<P> findBySize(String size) throws FileNotFoundException;
    String addProducts(Product product);
    String deleteProductsById(Long id);
    String updateProductsById(Long id, Product product);
    Double getTotalPriceOfProductsByName(String name);
}
