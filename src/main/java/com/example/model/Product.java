package com.example.model;

import com.opencsv.bean.CsvBindByName;

/*

// This class works with all the other implementations.  

public class Product {

    private String name;

    private String description;

    private String category;

    private String tags;

    // float is 32 bits (7 decimals) - double is 64 bits (15 decimals)
    private float price;

    private String imageUrl;

    public Product(String name, String description, String category, String tags, float price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        // exclude the long text in the description and imageUrl fields
        return "Product [name=" + name + ", category=" + category + ", tags=" + tags + ", price=" + price + "]";
    }

}
*/

public class Product {

    // This is the Open CSV Pojo Class.  

    // Nombre,Descripcion,Categoria,Etiquetas,Precio,URL FOTO

    // You have to match the column names since the field names don't match csv headers.
    // You can also use position in place of column.  Position starts at 0.  
    // You cannot mix and match column and position.  

    @CsvBindByName(column="Nombre")
    private String name;

    @CsvBindByName(column="Descripcion")
    private String description;

    @CsvBindByName(column="Categoria")
    private String category;

    @CsvBindByName(column="Etiquetas")
    private String tags;

    @CsvBindByName(column="Precio")
    private float price;

    @CsvBindByName(column="URL FOTO")
    private String imageUrl;

    // need empty constructor for opencsv to work
    public Product() {
    }

    public Product(String name, String description, String category, String tags, float price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        // exclude the long text in the description and imageUrl fields
        return "Product [name=" + name + ", category=" + category + ", tags=" + tags + ", price=" + price + "]";
    }

}