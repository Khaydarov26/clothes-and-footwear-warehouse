package model;

import constant.GenderType;
import constant.Size;

import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private String description;
    private String color;
    private Long quantity;
    private double price;
    private GenderType genderType;
    private Size size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", genderType=" + genderType +
                ", size=" + size +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getColor(), getQuantity(), getPrice(), getGenderType(), getSize());
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private String color;
        private Long quantity;
        private double price;
        private GenderType genderType;
        private Size size;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder genderType(GenderType genderType) {
            this.genderType = genderType;
            return this;
        }

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(this.id);
            product.setName(this.name);
            product.setDescription(this.description);
            product.setColor(this.color);
            product.setQuantity(this.quantity);
            product.setPrice(this.price);
            product.setGenderType(this.genderType);
            product.setSize(this.size);
            return product;
        }
    }
}
