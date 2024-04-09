package model;

import java.util.Objects;

public class Shoes extends Product<Shoes> {
    private String shoeType;

    public String getShoeType() {
        return shoeType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Shoes shoes = (Shoes) object;
        return Objects.equals(getShoeType(), shoes.getShoeType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getShoeType());
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "shoeType='" + shoeType + '\'' +
                '}';
    }

    @SuppressWarnings("unchecked")
    public Shoes setShoeType(String shoeType) {
        this.shoeType = shoeType;
        return this;
    }

    public Shoes(Builder builder) {
        super(builder);
        this.shoeType = builder.shoeType;
    }

    public static class Builder extends Product.Builder<Builder, Shoes> {
        private String shoeType;

        public Builder shoeType(String shoeType) {
            this.shoeType = shoeType;
            return this;
        }

        @Override
        public Shoes build() {
            return new Shoes(this);
        }
    }
}
