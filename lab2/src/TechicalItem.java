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
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TechicalItem) {
            TechicalItem obj1 = (TechicalItem) obj;
            return super.equals(obj) && warrantyTime == obj1.warrantyTime;
        }
        return false;
    }
}
