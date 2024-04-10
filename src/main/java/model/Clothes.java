package model;

import java.util.Objects;

public class Clothes {
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
                "clotheType='" + clotheType + '\'' +
                '}';
    }

    public static class Builder {
        private String clotheType;

        public Builder clotheType(String clotheType) {
            this.clotheType = clotheType;
            return this;
        }

        public Clothes build() {
            Clothes clothes = new Clothes();
            clothes.clotheType = this.clotheType;
            return clothes;
        }
    }
}
