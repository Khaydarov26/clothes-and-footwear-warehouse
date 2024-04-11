import constant.GenderType;
import constant.Size;
import controller.ClothesController;
import controller.ProductController;
import controller.ShoesController;
import model.Clothes;
import model.Product;
import model.Shoes;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Clothes and Footwear Warehouse Management System\n"
                + "\nDeveloper:"
                + "\nName: Sukhrob Khaydarov"
                + "\nEmail: suhrob_khaydarov@student.itpu.uz\n"
                + "\nVersion: 1.0"
                + "\nJava Version: 11"
                + "\nDate: 11-April-2024\n"
                + "\nAvailable Commands:"
                + "\n1. Product Search Menu"
                + "\n2. Shoes Search Menu"
                + "\n3. Clothes Search Menu"
        );

        boolean setQuit = false;

        while (!setQuit) {

            Scanner in = new Scanner(System.in);

            System.out.println("\nEnter a command to select a Menu:\n" +
                    "1. Product Menu\n" +
                    "2. Shoes Menu\n" +
                    "3. Clothes Menu\n" +
                    "(or 'quit' to exit): ");

            String userInput = in.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                setQuit = true;
            } else {
                try {
                    int selection = Integer.parseInt(userInput);
                    switch (selection) {
                        case 1:

                            ProductController productController = new ProductController();

                            System.out.println("Product Search Menu:\n" +
                                    "1. Find by ID\n" +
                                    "2. Find by Name\n" +
                                    "3. Find by Color\n" +
                                    "4. Find by Quantity\n" +
                                    "5. Find by Price Range\n" +
                                    "6. Find by Gender Type\n" +
                                    "7. Find by Size\n" +
                                    "8. Add, Delete, Update and getTotalPriceOfProductByName\n" +
                                    "9. Go Back\n" +
                                    "Enter your search option: ");
                            int searchOption = Integer.parseInt(in.nextLine());
                            handleProductSearchCall(productController, searchOption, in);
                            break;

                        case 2:

                            ShoesController shoesController = new ShoesController();

                            System.out.println("Shoes Search Menu:\n" +
                                    "1. Find by ID\n" +
                                    "2. Find by Name\n" +
                                    "3. Find by Color\n" +
                                    "4. Find by Quantity\n" +
                                    "5. Find by Price Range\n" +
                                    "6. Find by Gender Type\n" +
                                    "7. Find by Size\n" +
                                    "8. Find by ShoeType\n" +
                                    "9. Add, Delete, Update and getTotalPriceOfShoeByName\n" +
                                    "10. Go Back\n" +
                                    "Enter your search option: ");

                            int searchOptionForShoe = Integer.parseInt(in.nextLine());
                            handleShoesOperations(shoesController,searchOptionForShoe, in);
                            break;

                        case 3:
                            ClothesController clothesController = new ClothesController();
                            System.out.println("Clothes Search Menu:\n" +
                                    "1. Find by ID\n" +
                                    "2. Find by Name\n" +
                                    "3. Find by Color\n" +
                                    "4. Find by Quantity\n" +
                                    "5. Find by Price Range\n" +
                                    "6. Find by Gender Type\n" +
                                    "7. Find by Size\n" +
                                    "8. Find by ClotheType\n" +
                                    "9. Add, Delete, Update and getTotalPriceOfClotheByName\n" +
                                    "10. Go Back\n" +
                                    "Enter your search option: ");
                            int searchOptionForClothes = Integer.parseInt(in.nextLine());
                            handleClothesSearchCall(clothesController, searchOptionForClothes, in);
                            break;
                        default:
                            System.out.println("Invalid selection. Please enter 1, 2, or 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                } catch (FileNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        System.out.println("Exiting program...");
    }

    public static void handleProductSearchCall(ProductController productController, int searchOption, Scanner in) {
        switch (searchOption) {
            case 1:
                System.out.println("Enter product ID: ");
                long id = Long.parseLong(in.nextLine());
                List<Product> productsById = productController.findById(id);
                productsById.forEach(product -> System.out.println(product.toString()));
                break;
            case 2:
                System.out.println("Enter product name: ");
                String name = in.nextLine();
                List<Product> productsByName = productController.findByName(name);
                if (!productsByName.isEmpty()) {
                    productsByName.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No product found with name:" + name);
                }
                break;
            case 3:
                System.out.println("Enter product color: ");
                String color = in.nextLine();
                List<Product> productsByColor = productController.findByColor(color);
                if (!productsByColor.isEmpty()) {
                    productsByColor.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No product found with color:" + color);
                }
                break;
            case 4:
                System.out.println("Enter product quantity: ");
                Long quantity = Long.parseLong(in.nextLine());
                List<Product> productsByQuantity = productController.findByQuantity(quantity);
                if (!productsByQuantity.isEmpty()) {
                    productsByQuantity.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No product found with quantity:" + quantity);
                }
                break;
            case 5:
                System.out.println("Enter product price: ");
                double price = Double.parseDouble(in.nextLine());
                List<Product> productsByPrice = productController.findByPriceRange(price);
                if (!productsByPrice.isEmpty()) {
                    productsByPrice.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No product found with price:" + price);
                }
                break;
            case 6:
                System.out.println("Enter product gender type: ");
                String genderType = in.nextLine();
                List<Product> productsByGenderType = productController.findByGenderType(genderType);
                if (!productsByGenderType.isEmpty()) {
                    productsByGenderType.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No product found with gender type:" + genderType);
                }
                break;
            case 7:
                System.out.println("Enter product size: ");
                String size = in.nextLine();
                List<Product> productsBySize = productController.findBySize(size);
                if (!productsBySize.isEmpty()) {
                    productsBySize.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No product found with size:" + size);
                }
                break;
            case 8:
                System.out.println("Select option:");
                System.out.println("1. Add Product");
                System.out.println("2. Delete Product by ID");
                System.out.println("3. Update Product by ID");
                System.out.println("4. Get Total Price of Product by Name");
                int productOption = Integer.parseInt(in.nextLine());
                switch (productOption) {
                    case 1:
                        System.out.println("Enter product ID: ");
                        long productId = Long.parseLong(in.nextLine());
                        System.out.println("Enter product name: ");
                        String productName = in.nextLine();
                        System.out.println("Enter product description: ");
                        String productDescription = in.nextLine();
                        System.out.println("Enter product color: ");
                        String productColor = in.nextLine();
                        System.out.println("Enter product quantity: ");
                        long productQuantity = Long.parseLong(in.nextLine());
                        System.out.println("Enter product price: ");
                        double productPrice = Double.parseDouble(in.nextLine());
                        System.out.println("Enter product gender type: ");
                        String productGenderType = in.nextLine();
                        System.out.println("Enter product size: ");
                        String productSize = in.nextLine();
                        Product newProduct = new Product.Builder()
                                .id(productId)
                                .name(productName)
                                .description(productDescription)
                                .color(productColor)
                                .quantity(productQuantity)
                                .price(productPrice)
                                .genderType(GenderType.valueOf(productGenderType))
                                .size(Size.valueOf(productSize))
                                .build();
                        System.out.println(productController.addProduct(newProduct));
                        break;
                    case 2:
                        System.out.println("Enter product ID to delete: ");
                        long deleteProductId = Long.parseLong(in.nextLine());
                        System.out.println(productController.deleteProductById(deleteProductId));
                        break;
                    case 3:
                        System.out.println("Enter product ID to update: ");
                        long updateProductId = Long.parseLong(in.nextLine());
                        System.out.println("Enter new product name: ");
                        String updatedProductName = in.nextLine();
                        System.out.println("Enter new product description: ");
                        String updatedProductDescription = in.nextLine();
                        System.out.println("Enter new product color: ");
                        String updatedProductColor = in.nextLine();
                        System.out.println("Enter new product quantity: ");
                        long updatedProductQuantity = Long.parseLong(in.nextLine());
                        System.out.println("Enter new product price: ");
                        double updatedProductPrice = Double.parseDouble(in.nextLine());
                        System.out.println("Enter new product gender type: ");
                        String updatedProductGenderType = in.nextLine();
                        System.out.println("Enter new product size: ");
                        String updatedProductSize = in.nextLine();
                        Product updatedProduct = new Product.Builder()
                                .id(updateProductId)
                                .name(updatedProductName)
                                .description(updatedProductDescription)
                                .color(updatedProductColor)
                                .quantity(updatedProductQuantity)
                                .price(updatedProductPrice)
                                .genderType(GenderType.valueOf(updatedProductGenderType))
                                .size(Size.valueOf(updatedProductSize))
                                .build();
                        System.out.println(productController.updateProductById(updateProductId, updatedProduct));
                        break;
                    case 4:
                        System.out.println("Enter product name to get total price: ");
                        String productNameForTotalPrice = in.nextLine();
                        System.out.println("Total price of " + productNameForTotalPrice + " products: " + productController.getTotalPriceOfProductByName(productNameForTotalPrice));
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
                break;

            default:
                System.out.println("Invalid search option. Please enter a number between 1 and 7.");
        }
    }

    public static void handleShoesOperations(ShoesController shoesController, int searchOption, Scanner in) {
        switch (searchOption) {
            case 1:
                System.out.println("Enter shoe ID: ");
                long id = Long.parseLong(in.nextLine());
                List<Shoes> shoesById = shoesController.findById(id);
                shoesById.forEach(product -> System.out.println(product.toString()));
                break;
            case 2:
                System.out.println("Enter shoe name: ");
                String name = in.nextLine();
                List<Shoes> shoesByName = shoesController.findByName(name);
                if (!shoesByName.isEmpty()) {
                    shoesByName.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No shoe found with name:" + name);
                }
                break;
            case 3:
                System.out.println("Enter shoe color: ");
                String color = in.nextLine();
                List<Shoes> shoesByColor = shoesController.findByColor(color);
                if (!shoesByColor.isEmpty()) {
                    shoesByColor.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No shoe found with color:" + color);
                }
                break;
            case 4:
                System.out.println("Enter shoe quantity: ");
                Long quantity = Long.parseLong(in.nextLine());
                List<Shoes> shoesByQuantity = shoesController.findByQuantity(quantity);
                if (!shoesByQuantity.isEmpty()) {
                    shoesByQuantity.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No shoe found with quantity:" + quantity);
                }
                break;
            case 5:
                System.out.println("Enter shoe price: ");
                double price = Double.parseDouble(in.nextLine());
                List<Shoes> productsByPrice = shoesController.findByPriceRange(price);
                if (!productsByPrice.isEmpty()) {
                    productsByPrice.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No shoe found with price:" + price);
                }
                break;
            case 6:
                System.out.println("Enter shoe gender type: ");
                String genderType = in.nextLine();
                List<Shoes> shoesByGenderType = shoesController.findByGenderType(genderType);
                if (!shoesByGenderType.isEmpty()) {
                    shoesByGenderType.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No shoe found with gender type:" + genderType);
                }
                break;
            case 7:
                System.out.println("Enter shoe size: ");
                String size = in.nextLine();
                List<Shoes> shoesBySize = shoesController.findBySize(size);
                if (!shoesBySize.isEmpty()) {
                    shoesBySize.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No shoe found with size:" + size);
                }
                break;
            case 8:
                System.out.println("Enter shoe type: ");
                String shoeType = in.nextLine();
                List<Shoes> shoesByType = shoesController.findByShoeType(shoeType);
                if (!shoesByType.isEmpty()) {
                    shoesByType.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No shoe found with shoeType:" + shoeType);
                }
                break;
            case 9:
                System.out.println("Select option:");
                System.out.println("1. Add Shoe");
                System.out.println("2. Delete Shoe by ID");
                System.out.println("3. Update Shoe by ID");
                System.out.println("4. Get Total Price of Shoe by Name");
                int shoeOption = Integer.parseInt(in.nextLine());
                switch (shoeOption) {
                    case 1:
                        System.out.println("Enter shoe ID: ");
                        long shoeId = Long.parseLong(in.nextLine());
                        System.out.println("Enter shoe name: ");
                        String shoeName = in.nextLine();
                        System.out.println("Enter shoe description: ");
                        String shoeDescription = in.nextLine();
                        System.out.println("Enter shoe color: ");
                        String shoeColor = in.nextLine();
                        System.out.println("Enter shoe quantity: ");
                        long shoeQuantity = Long.parseLong(in.nextLine());
                        System.out.println("Enter shoe price: ");
                        double shoePrice = Double.parseDouble(in.nextLine());
                        System.out.println("Enter shoe gender type: ");
                        String shoeGenderType = in.nextLine();
                        System.out.println("Enter shoe size: ");
                        String shoeSize = in.nextLine();
                        System.out.println("Enter shoe type: ");
                        String shoeType1 = in.nextLine();
                        Shoes newShoe = new Shoes.Builder()
                                .id(shoeId)
                                .name(shoeName)
                                .description(shoeDescription)
                                .color(shoeColor)
                                .quantity(shoeQuantity)
                                .price(shoePrice)
                                .genderType(GenderType.valueOf(shoeGenderType))
                                .size(Size.valueOf(shoeSize))
                                .shoeType(shoeType1)
                                .build();
                        System.out.println(shoesController.addShoes(newShoe));
                        break;
                    case 2:
                        System.out.println("Enter shoe ID to delete: ");
                        long deleteShoeId = Long.parseLong(in.nextLine());
                        System.out.println(shoesController.deleteShoesById(deleteShoeId));
                        break;
                    case 3:
                        System.out.println("Enter shoe ID to update: ");
                        long updateShoeId = Long.parseLong(in.nextLine());
                        System.out.println("Enter new shoe name: ");
                        String updatedShoeName = in.nextLine();
                        System.out.println("Enter new shoe description: ");
                        String updatedShoeDescription = in.nextLine();
                        System.out.println("Enter new shoe color: ");
                        String updatedShoeColor = in.nextLine();
                        System.out.println("Enter new shoe quantity: ");
                        long updatedShoeQuantity = Long.parseLong(in.nextLine());
                        System.out.println("Enter new shoe price: ");
                        double updatedShoePrice = Double.parseDouble(in.nextLine());
                        System.out.println("Enter new shoe gender type: ");
                        String updatedShoeGenderType = in.nextLine();
                        System.out.println("Enter new shoe size: ");
                        String updatedShoeSize = in.nextLine();
                        System.out.println("Enter new shoe type: ");
                        String updatedShoeType = in.nextLine();
                        Shoes updatedShoe = new Shoes.Builder()
                            .id(updateShoeId)
                            .name(updatedShoeName)
                            .description(updatedShoeDescription)
                            .color(updatedShoeColor)
                            .quantity(updatedShoeQuantity)
                            .price(updatedShoePrice)
                            .genderType(GenderType.valueOf(updatedShoeGenderType))
                            .size(Size.valueOf(updatedShoeSize))
                            .shoeType(updatedShoeType)
                            .build();
                                System.out.println(shoesController.updateShoesById(updateShoeId, updatedShoe));
                        break;
                    case 4:
                        System.out.println("Enter shoe name to get total price: ");
                        String shoeNameForTotalPrice = in.nextLine();
                        System.out.println("Total price of " + shoeNameForTotalPrice + " shoes: " + shoesController.getTotalPriceOfShoesByName(shoeNameForTotalPrice));
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
                break;

                default:
                System.out.println("Invalid search option. Please enter a number between 1 and 9.");
        }
    }

    public static void handleClothesSearchCall(ClothesController clothesController, int searchOption, Scanner in) {
        switch (searchOption) {
            case 1:
                System.out.println("Enter clothes ID: ");
                long id = Long.parseLong(in.nextLine());
                List<Clothes> clothesById = clothesController.findById(id);
                clothesById.forEach(product -> System.out.println(product.toString()));
                break;
            case 2:
                System.out.println("Enter clothes name: ");
                String name = in.nextLine();
                List<Clothes> clothesByName = clothesController.findByName(name);
                if (!clothesByName.isEmpty()) {
                    clothesByName.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No clothes found with name:" + name);
                }
                break;
            case 3:
                System.out.println("Enter clothes color: ");
                String color = in.nextLine();
                List<Clothes> clothesByColor = clothesController.findByColor(color);
                if (!clothesByColor.isEmpty()) {
                    clothesByColor.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No clothes found with color:" + color);
                }
                break;
            case 4:
                System.out.println("Enter clothes quantity: ");
                Long quantity = Long.parseLong(in.nextLine());
                List<Clothes> clothesByQuantity = clothesController.findByQuantity(quantity);
                if (!clothesByQuantity.isEmpty()) {
                    clothesByQuantity.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No clothes found with quantity:" + quantity);
                }
                break;
            case 5:
                System.out.println("Enter clothes price: ");
                double price = Double.parseDouble(in.nextLine());
                List<Clothes> clothesByPrice = clothesController.findByPriceRange(price);
                if (!clothesByPrice.isEmpty()) {
                    clothesByPrice.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No clothes found with price:" + price);
                }
                break;
            case 6:
                System.out.println("Enter clothes gender type: ");
                String genderType = in.nextLine();
                List<Clothes> clothesByGenderType = clothesController.findByGenderType(genderType);
                if (!clothesByGenderType.isEmpty()) {
                    clothesByGenderType.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No clothes found with gender type:" + genderType);
                }
                break;
            case 7:
                System.out.println("Enter clothes size: ");
                String size = in.nextLine();
                List<Clothes> clothesBySize = clothesController.findBySize(size);
                if (!clothesBySize.isEmpty()) {
                    clothesBySize.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No clothes found with size:" + size);
                }
                break;
            case 8:
                System.out.println("Enter clothes type: ");
                String clothesType = in.nextLine();
                List<Clothes> clothesByType = clothesController.findByClotheType(clothesType);
                if (!clothesByType.isEmpty()) {
                    clothesByType.forEach(product -> System.out.println(product.toString()));
                } else {
                    System.out.println("Error: No clothes found with clothesType:" + clothesType);
                }
                break;
            case 9:
                System.out.println("Select option:");
                System.out.println("1. Add Clothes");
                System.out.println("2. Delete Clothes by ID");
                System.out.println("3. Update Clothes by ID");
                System.out.println("4. Get Total Price of Clothes by Name");
                int clothesOption = Integer.parseInt(in.nextLine());
                switch (clothesOption) {
                    case 1:
                        System.out.println("Enter clothes ID: ");
                        long clothesId = Long.parseLong(in.nextLine());
                        System.out.println("Enter clothes name: ");
                        String clothesName = in.nextLine();
                        System.out.println("Enter clothes description: ");
                        String clothesDescription = in.nextLine();
                        System.out.println("Enter clothes color: ");
                        String clothesColor = in.nextLine();
                        System.out.println("Enter clothes quantity: ");
                        long clothesQuantity = Long.parseLong(in.nextLine());
                        System.out.println("Enter clothes price: ");
                        double clothesPrice = Double.parseDouble(in.nextLine());
                        System.out.println("Enter clothes gender type: ");
                        String clothesGenderType = in.nextLine();
                        System.out.println("Enter clothes size: ");
                        String clothesSize = in.nextLine();
                        System.out.println("Enter clothes type: ");
                        String clothesType1 = in.nextLine();
                        Clothes newClothes = new Clothes.Builder()
                                .id(clothesId)
                                .name(clothesName)
                                .description(clothesDescription)
                                .color(clothesColor)
                                .quantity(clothesQuantity)
                                .price(clothesPrice)
                                .genderType(GenderType.valueOf(clothesGenderType))
                                .size(Size.valueOf(clothesSize))
                                .clotheType(clothesType1)
                                .build();
                        System.out.println(clothesController.addClothes(newClothes));
                        break;
                    case 2:
                        System.out.println("Enter clothes ID to delete: ");
                        long deleteClothesId = Long.parseLong(in.nextLine());
                        System.out.println(clothesController.deleteClothesById(deleteClothesId));
                        break;
                    case 3:
                        System.out.println("Enter clothes ID to update: ");
                        long updateClothesId = Long.parseLong(in.nextLine());
                        System.out.println("Enter new clothes name: ");
                        String updatedClothesName = in.nextLine();
                        System.out.println("Enter new clothes description: ");
                        String updatedClothesDescription = in.nextLine();
                        System.out.println("Enter new clothes color: ");
                        String updatedClothesColor = in.nextLine();
                        System.out.println("Enter new clothes quantity: ");
                        long updatedClothesQuantity = Long.parseLong(in.nextLine());
                        System.out.println("Enter new clothes price: ");
                        double updatedClothesPrice = Double.parseDouble(in.nextLine());
                        System.out.println("Enter new clothes gender type: ");
                        String updatedClothesGenderType = in.nextLine();
                        System.out.println("Enter new clothes size: ");
                        String updatedClothesSize = in.nextLine();
                        System.out.println("Enter new clothes type: ");
                        String updatedClothesType = in.nextLine();
                        Clothes updatedClothes = new Clothes.Builder()
                                .id(updateClothesId)
                                .name(updatedClothesName)
                                .description(updatedClothesDescription)
                                .color(updatedClothesColor)
                                .quantity(updatedClothesQuantity)
                                .price(updatedClothesPrice)
                                .genderType(GenderType.valueOf(updatedClothesGenderType))
                                .size(Size.valueOf(updatedClothesSize))
                                .clotheType(updatedClothesType)
                                .build();
                        System.out.println(clothesController.updateClothesById(updateClothesId, updatedClothes));
                        break;
                    case 4:
                        System.out.println("Enter clothes name to get total price: ");
                        String clothesNameForTotalPrice = in.nextLine();
                        System.out.println("Total price of " + clothesNameForTotalPrice + " clothes: " + clothesController.getTotalPriceOfClothesByName(clothesNameForTotalPrice));
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
                break;

            default:
                System.out.println("Invalid search option. Please enter a number between 1 and 8.");
        }
    }

}
