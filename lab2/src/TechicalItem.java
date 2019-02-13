public class TechicalItem extends GenericItem {
    short warrantyTime; // гарантийный срок (суток)

    TechicalItem(String name, float price, short warrantyTime) {
        super(name, price, Category.PRINT);
        this.warrantyTime = warrantyTime;
    }

    void printAll() {
        System.out.printf("ID: %d, Name: %s, price: %5.2f, Category: %s, WarrantyTime: %d\n",
                ID, name, price, category, warrantyTime);
    }
}
