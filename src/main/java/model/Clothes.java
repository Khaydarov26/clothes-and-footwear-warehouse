package model;

import java.util.Objects;

public class Clothes extends Product<Clothes> {
    private String clotheType;

    public String getClotheType() {
        return clotheType;
    }

    public void setClotheType(String clotheType) {
        this.clotheType = clotheType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Clothes clothes = (Clothes) object;
        return Objects.equals(getClotheType(), clothes.getClotheType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getClotheType());
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "clotheType='" + clotheType + '\'' +
                '}';
    }

    public Clothes(Builder builder) {
        super(builder);
        this.clotheType = builder.clotheType;
    }

    public static class Builder extends Product.Builder<Builder, Clothes> {
        private String clotheType;

        public Builder clotheType(String clotheType) {
            this.clotheType = clotheType;
            return this;
        }

        @Override
        public Clothes build() {
            return new Clothes(this);
        }
    }
}
