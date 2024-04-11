package service;

import dal.ClothesDao;
import dal.ClothesDaoImplementation;
import model.Clothes;

import java.io.FileNotFoundException;
import java.util.List;

public class ClothesServiceImplementation implements ClothesService{

    private final ClothesDao<Clothes> clothesDao;

    public ClothesServiceImplementation() throws FileNotFoundException {
        clothesDao = new ClothesDaoImplementation();
    }

    @Override
    public List<Clothes> findById(Long id) throws FileNotFoundException {
        return clothesDao.findById(id);
    }

    @Override
    public List<Clothes> findByName(String name) throws FileNotFoundException {
        return clothesDao.findByName(name);
    }

    @Override
    public List<Clothes> findByColor(String color) throws FileNotFoundException {
        return clothesDao.findByColor(color);
    }

    @Override
    public List<Clothes> findByQuantity(Long quantity) throws FileNotFoundException {
        return clothesDao.findByQuantity(quantity);
    }

    @Override
    public List<Clothes> findByPriceRange(double price) throws FileNotFoundException {
        return clothesDao.findByPriceRange(price);
    }

    @Override
    public List<Clothes> findByGenderType(String genderType) throws FileNotFoundException {
        return clothesDao.findByGenderType(genderType);
    }

    @Override
    public List<Clothes> findBySize(String size) throws FileNotFoundException {
        return clothesDao.findBySize(size);
    }

    @Override
    public List<Clothes> findByClotheType(String clotheType) {
        return clothesDao.findByClotheType(clotheType);
    }

    @Override
    public String addClothes(Clothes clothes) {
        return clothesDao.addClothes(clothes);
    }

    @Override
    public String deleteClothesById(Long id) {
        return clothesDao.deleteClothesById(id);
    }

    @Override
    public String updateClothesById(Long id, Clothes clothes) {
        return clothesDao.updateClothesById(id, clothes);
    }

    @Override
    public Double getTotalPriceOfClothesByName(String name) {
        return clothesDao.getTotalPriceOfClothesByName(name);
    }
}
