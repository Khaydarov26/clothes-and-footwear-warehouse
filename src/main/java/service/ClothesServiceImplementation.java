package service;

import dal.ClothesSearchCriteria;
import dal.ClothesSearchCriteriaImplementation;
import model.Clothes;

import java.io.FileNotFoundException;
import java.util.List;

public class ClothesServiceImplementation implements ClothesService{

    private final ClothesSearchCriteria<Clothes> clothesClothesSearchCriteria;

    public ClothesServiceImplementation() throws FileNotFoundException {
        clothesClothesSearchCriteria = new ClothesSearchCriteriaImplementation();
    }


    @Override
    public List<Clothes> findById(Long id) throws FileNotFoundException {
        return clothesClothesSearchCriteria.findById(id);
    }

    @Override
    public List<Clothes> findByName(String name) throws FileNotFoundException {
        return clothesClothesSearchCriteria.findByName(name);
    }

    @Override
    public List<Clothes> findByColor(String color) throws FileNotFoundException {
        return clothesClothesSearchCriteria.findByColor(color);
    }

    @Override
    public List<Clothes> findByQuantity(Long quantity) throws FileNotFoundException {
        return clothesClothesSearchCriteria.findByQuantity(quantity);
    }

    @Override
    public List<Clothes> findByPriceRange(double price) throws FileNotFoundException {
        return clothesClothesSearchCriteria.findByPriceRange(price);
    }

    @Override
    public List<Clothes> findByGenderType(String genderType) throws FileNotFoundException {
        return clothesClothesSearchCriteria.findByGenderType(genderType);
    }

    @Override
    public List<Clothes> findBySize(String size) throws FileNotFoundException {
        return clothesClothesSearchCriteria.findBySize(size);
    }

    @Override
    public List<Clothes> findByClotheType(String clotheType) {
        return clothesClothesSearchCriteria.findByClotheType(clotheType);
    }
}
