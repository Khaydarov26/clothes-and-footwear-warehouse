package service;

import dal.ShoesSearchCriteria;
import dal.ShoesSearchCriteriaImplementation;
import model.Shoes;

import java.io.FileNotFoundException;
import java.util.List;

public class ShoesServiceImplementation implements ShoesService{

    private final ShoesSearchCriteria<Shoes> shoesSearchCriteria;

    public ShoesServiceImplementation() throws FileNotFoundException {
        shoesSearchCriteria = new ShoesSearchCriteriaImplementation();
    }


    @Override
    public List<Shoes> findById(Long id) throws FileNotFoundException {
        return shoesSearchCriteria.findById(id);
    }

    @Override
    public List<Shoes> findByName(String name) throws FileNotFoundException {
        return shoesSearchCriteria.findByName(name);
    }

    @Override
    public List<Shoes> findByColor(String color) throws FileNotFoundException {
        return shoesSearchCriteria.findByColor(color);
    }

    @Override
    public List<Shoes> findByQuantity(Long quantity) throws FileNotFoundException {
        return shoesSearchCriteria.findByQuantity(quantity);
    }

    @Override
    public List<Shoes> findByPriceRange(double price) throws FileNotFoundException {
        return shoesSearchCriteria.findByPriceRange(price);
    }

    @Override
    public List<Shoes> findByGenderType(String genderType) throws FileNotFoundException {
        return shoesSearchCriteria.findByGenderType(genderType);
    }

    @Override
    public List<Shoes> findBySize(String size) throws FileNotFoundException {
        return shoesSearchCriteria.findBySize(size);
    }

    @Override
    public List<Shoes> findByShoeType(String shoeType) {
        return shoesSearchCriteria.findByShoeType(shoeType);
    }
}
