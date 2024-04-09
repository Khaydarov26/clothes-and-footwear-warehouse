package model;

import builders.ObjBuilder;
import constant.GenderType;
import constant.Size;

import java.util.Objects;

public abstract class Product<T extends Product<T>> {
    private Long id;
    private String name;
    private String description;

    private String color;
    private Long quantity;
    private double price;
    private GenderType genderType;
    private Size size;

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

    public Product(Builder<? extends ObjBuilder<?>, ? extends Product> b_) {
        super();
        this.name = b_.name;
        this.price = b_.price;
    }

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unchecked")
    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public String getDescription() {
        return description;
    }

    @SuppressWarnings("unchecked")
    public T setDescription(String description) {
        this.description = description;
        return (T) this;
    }

    public double getPrice() {
        return price;
    }

    @SuppressWarnings("unchecked")
    public T setPrice(double price) {
        this.price = price;
        return (T) this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product<?> product = (Product<?>) object;
        return Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getColor(), product.getColor()) && Objects.equals(getQuantity(), product.getQuantity()) && getGenderType() == product.getGenderType() && getSize() == product.getSize();
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



    public static abstract class Builder<SELF extends Builder<SELF, T>, T> implements ObjBuilder<T> {
        private double price;
        private String name;
        private String description;
        private String color;
        private Long quantity;
        private GenderType genderType;
        private Size size;

        public SELF price(double price_) {
            price = price_;
            return (SELF) this;
        }

        public SELF name(String name_) {
            name = name_;
            return (SELF) this;
        }

        public SELF description(String description_) {
            description = description_;
            return (SELF) this;
        }

        public SELF color(String color_) {
            color = color_;
            return (SELF) this;
        }

        public SELF quantity(Long quantity_) {
            quantity = quantity_;
            return (SELF) this;
        }

        public SELF genderType(GenderType genderType_) {
            genderType = genderType_;
            return (SELF) this;
        }

        public SELF size(Size size_) {
            size = size_;
            return (SELF) this;
        }
    }
}
