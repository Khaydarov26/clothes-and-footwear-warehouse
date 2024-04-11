package dal;

import model.Shoes;

import java.io.FileNotFoundException;
import java.util.List;

public interface ShoesSearchCriteria<S extends Shoes> {

    List<S> findById(Long id) throws FileNotFoundException;
    List<S> findByName(String name) throws FileNotFoundException;
    List<S> findByColor(String color) throws FileNotFoundException;
    List<S> findByQuantity(Long quantity) throws FileNotFoundException;
    List<S> findByPriceRange(double price) throws FileNotFoundException;
    List<S> findByGenderType(String genderType) throws FileNotFoundException;
    List<S> findBySize(String size) throws FileNotFoundException;
    List<S> findByShoeType(String shoeType);
}
