package model;

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

        public Builder shoeType(String shoeType) {
            this.shoeType = shoeType;
            return this;
        }

        public Shoes build() {
            Shoes shoes = new Shoes();
            shoes.shoeType = this.shoeType;
            return shoes;
        }
    }
}
