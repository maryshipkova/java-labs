public class GenericItem {
    private static int idCounter = 0;

    public int ID; // ID товара
    public String name; // Наименование товара
    public float price; //Цена товара
    protected Category category;

    GenericItem(String name, float price) {
        this.ID = getId();
        this.name = name;
        this.price = price;
        this.category = Category.GENERAL;
    }

    void printAll() {
        System.out.printf("ID: %d, Name: %s, price: %5.2f, Category: %s\n", ID, name, price, category);
    }

    protected int getId() {
        return ++idCounter;
    }

}
