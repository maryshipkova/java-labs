package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {
    Date dateOfIncome; // дата производства
    short expires; // срок годности

    public FoodItem(String name, float price, FoodItem analog,  Date dateOfIncome, short expires) {
        super(name, price,  analog); // category?
        this.category = Category.FOOD;
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        super(name, price, Category.FOOD);
        this.dateOfIncome = new Date();
        this.expires = expires;
    }

    public FoodItem(String name) {
        super(name, 100, Category.FOOD);
        this.dateOfIncome = new Date();
        this.expires = 7;
    }

    void printAll() {
        System.out.printf("ID: %d, Name: %s, price: %5.2f, Category: %s, Date: %s, Expires: %d\n",
                getId(), getName(), getPrice(), category, dateOfIncome, expires);
    }
}
