package service;

import dal.ShoesDao;
import dal.ShoesDaoImplementation;
import model.Clothes;
import model.Shoes;

import java.io.FileNotFoundException;
import java.util.List;

public class ShoesServiceImplementation implements ShoesService{

    private final ShoesDao<Shoes> shoesDao;

    public ShoesServiceImplementation() throws FileNotFoundException {
        shoesDao = new ShoesDaoImplementation();
    }


    @Override
    public List<Shoes> findById(Long id) throws FileNotFoundException {
        return shoesDao.findById(id);
    }

    @Override
    public List<Shoes> findByName(String name) throws FileNotFoundException {
        return shoesDao.findByName(name);
    }

    @Override
    public List<Shoes> findByColor(String color) throws FileNotFoundException {
        return shoesDao.findByColor(color);
    }

    @Override
    public List<Shoes> findByQuantity(Long quantity) throws FileNotFoundException {
        return shoesDao.findByQuantity(quantity);
    }

    @Override
    public List<Shoes> findByPriceRange(double price) throws FileNotFoundException {
        return shoesDao.findByPriceRange(price);
    }

    @Override
    public List<Shoes> findByGenderType(String genderType) throws FileNotFoundException {
        return shoesDao.findByGenderType(genderType);
    }

    @Override
    public List<Shoes> findBySize(String size) throws FileNotFoundException {
        return shoesDao.findBySize(size);
    }

    @Override
    public List<Shoes> findByShoeType(String shoeType) {
        return shoesDao.findByShoeType(shoeType);
    }

    @Override
    public String addShoe(Shoes shoes) {
        return shoesDao.addShoe(shoes);
    }

    @Override
    public String deleteShoeById(Long id) {
        return shoesDao.deleteShoeById(id);
    }

    @Override
    public String updateShoeById(Long id, Shoes shoes) {
        return shoesDao.updateShoeById(id, shoes);
    }

    @Override
    public Double getTotalPriceOfShoeByName(String name) {
        return shoesDao.getTotalPriceOfShoeByName(name);
    }
}
