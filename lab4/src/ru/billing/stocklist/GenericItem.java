package ru.billing.stocklist;

public class GenericItem {
    private static int currentID = 0;

    private int ID; // ID товара
    private String name; // Наименование товара
    private float price; //Цена товара
    private GenericItem analog;
    protected Category category;

    public GenericItem(String name, float price, Category category) {
        setId();
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        setId();
        this.name = name;
        this.price = price;
        setAnalog(analog);
        this.category = Category.GENERAL;
    }

    public GenericItem() {
        setId();
        this.name = "default";
        this.price = 100;
        this.category = Category.GENERAL;
    }

    void printAll() {
        System.out.printf("ID: %d, Name: %s, price: %5.2f, Category: %s\n", ID, name, price, category);
    }

    public int getId() {
        return this.ID;
    }

    protected void setId() {
        this.ID = ++currentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }
}
