package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImplementation;

import java.io.FileNotFoundException;
import java.util.List;

public class ProductController {
    private final ProductService productService;

    public ProductController() throws FileNotFoundException {
        productService = new ProductServiceImplementation();
    }

    public List<Product> findById(Long id) {
        try {
            return productService.findById(id);
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findByName(String name) {
        try {
            return productService.findByName(name);
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findByColor(String color) {
        try {
            return productService.findByColor(color);
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findByQuantity(Long quantity) {
        try {
            return productService.findByQuantity(quantity);
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findByPriceRange(double price) {
        try {
            return productService.findByPriceRange(price);
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findByGenderType(String genderType) {
        try {
            return productService.findByGenderType(genderType);
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findBySize(String size) {
        try {
            return productService.findBySize(size);
        } catch (FileNotFoundException e) {
            System.out.println("Product inventory file not found.");
            e.printStackTrace();
            return null;
        }
    }

    public String addProduct(Product product) {
        try {
            return productService.addProduct(product);
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String deleteProductById(Long id) {
        try {
            return productService.deleteProductById(id);
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String updateProductById(Long id, Product product) {
        try {
            return productService.updateProductById(id, product);
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Double getTotalPriceOfProductByName(String name) {
        try {
            return productService.getTotalPriceOfProductByName(name);
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

