package model;

import constant.GenderType;
import constant.Size;

import java.util.Objects;

public class Shoes extends Product{
    private String shoeType;

    public String getShoeType() {
        return shoeType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Shoes shoes = (Shoes) object;
        return Objects.equals(getShoeType(), shoes.getShoeType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShoeType());
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "shoeType='" + shoeType + '\'' +
                '}';
    }

    public static class Builder {
        private String shoeType;
        private Product.Builder productBuilder;

        public Builder() {
            this.productBuilder = new Product.Builder();
        }

        public Builder shoeType(String shoeType) {
            this.shoeType = shoeType;
            return this;
        }

        public Builder id(Long id) {
            this.productBuilder.id(id);
            return this;
        }

        public Builder name(String name) {
            this.productBuilder.name(name);
            return this;
        }

        public Builder description(String description) {
            this.productBuilder.description(description);
            return this;
        }

        public Builder color(String color) {
            this.productBuilder.color(color);
            return this;
        }

        public Builder quantity(Long quantity) {
            this.productBuilder.quantity(quantity);
            return this;
        }

        public Builder price(double price) {
            this.productBuilder.price(price);
            return this;
        }

        public Builder genderType(GenderType genderType) {
            this.productBuilder.genderType(genderType);
            return this;
        }

        public Builder size(Size size) {
            this.productBuilder.size(size);
            return this;
        }

        public Shoes build() {
            Shoes shoes = new Shoes();
            // Set common properties using the parent builder methods
            Product product = productBuilder.build();
            shoes.setId(product.getId());
            shoes.setName(product.getName());
            shoes.setDescription(product.getDescription());
            shoes.setColor(product.getColor());
            shoes.setQuantity(product.getQuantity());
            shoes.setPrice(product.getPrice());
            shoes.setGenderType(product.getGenderType());
            shoes.setSize(product.getSize());
            shoes.shoeType = this.shoeType;
            return shoes;
        }
    }



}
