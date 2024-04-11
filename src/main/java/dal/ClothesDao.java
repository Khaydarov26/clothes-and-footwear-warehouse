package dal;

import model.Clothes;

import java.io.FileNotFoundException;
import java.util.List;

public interface ClothesDao<C extends Clothes>  {

    List<C> findById(Long id) throws FileNotFoundException;
    List<C> findByName(String name) throws FileNotFoundException;
    List<C> findByColor(String color) throws FileNotFoundException;
    List<C> findByQuantity(Long quantity) throws FileNotFoundException;
    List<C> findByPriceRange(double price) throws FileNotFoundException;
    List<C> findByGenderType(String genderType) throws FileNotFoundException;
    List<C> findBySize(String size) throws FileNotFoundException;
    List<C> findByClotheType(String clotheType);
    String addClothes(Clothes clothes);
    String deleteClothesById(Long id);
    String updateClothesById(Long id, Clothes clothes);
    Double getTotalPriceOfClothesByName(String name);
}
