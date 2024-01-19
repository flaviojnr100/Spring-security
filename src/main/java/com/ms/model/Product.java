package com.ms.model;

public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;

    private boolean availability;

    public Product() {
    }

    public Product(int id, String name, double price, int amount, boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
