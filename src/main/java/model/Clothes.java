package model;

import constant.GenderType;
import constant.Size;

import java.util.Objects;

public class Clothes extends Product{

    private String clotheType;

    public String getClotheType() {
        return clotheType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Clothes clothes = (Clothes) object;
        return Objects.equals(getClotheType(), clothes.getClotheType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClotheType());
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", color='" + getColor() + '\'' +
                ", quantity=" + getQuantity() +
                ", price=" + getPrice() +
                ", genderType=" + getGenderType() +
                ", size=" + getSize() +
                ", clotheType='" + clotheType + '\'' +
                '}';
    }

    public static class Builder {
        private String clotheType;
        private final Product.Builder productBuilder;

        public Builder() {
            this.productBuilder = new Product.Builder();
        }

        public Clothes.Builder clotheType(String clotheType) {
            this.clotheType = clotheType;
            return this;
        }

        public Clothes.Builder id(Long id) {
            this.productBuilder.id(id);
            return this;
        }

        public Clothes.Builder name(String name) {
            this.productBuilder.name(name);
            return this;
        }

        public Clothes.Builder description(String description) {
            this.productBuilder.description(description);
            return this;
        }

        public Clothes.Builder color(String color) {
            this.productBuilder.color(color);
            return this;
        }

        public Clothes.Builder quantity(Long quantity) {
            this.productBuilder.quantity(quantity);
            return this;
        }

        public Clothes.Builder price(double price) {
            this.productBuilder.price(price);
            return this;
        }

        public Clothes.Builder genderType(GenderType genderType) {
            this.productBuilder.genderType(genderType);
            return this;
        }

        public Clothes.Builder size(Size size) {
            this.productBuilder.size(size);
            return this;
        }

        public Clothes build() {
            Clothes clothes = new Clothes();
            Product product = productBuilder.build();
            clothes.setId(product.getId());
            clothes.setName(product.getName());
            clothes.setDescription(product.getDescription());
            clothes.setColor(product.getColor());
            clothes.setQuantity(product.getQuantity());
            clothes.setPrice(product.getPrice());
            clothes.setGenderType(product.getGenderType());
            clothes.setSize(product.getSize());
            clothes.clotheType = this.clotheType;
            return clothes;
        }
    }
}
