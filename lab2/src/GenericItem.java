public class GenericItem {
    private static int currentID = 0;

    public int ID; // ID товара
    public String name; // Наименование товара
    public float price; //Цена товара
    public GenericItem analog;
    protected Category category;

    public GenericItem(String name, float price, Category category) {
        this.ID = getId();
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.ID = getId();
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.category = Category.GENERAL;
    }

    public GenericItem() {
        this.ID = getId();
        this.name = "default";
        this.price = 100;
        this.category = Category.GENERAL;
    }

    void printAll() {
        System.out.printf("ID: %d, Name: %s, price: %5.2f, Category: %s\n", ID, name, price, category);
    }

    protected int getId() {
        return ++currentID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GenericItem) {
            GenericItem obj1 = (GenericItem) obj;
            return ID == obj1.ID && name == obj1.name && category == obj1.category;
        }
        return false;
    }

}
