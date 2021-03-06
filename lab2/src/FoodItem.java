import java.util.Date;

public class FoodItem extends GenericItem implements Cloneable {
    Date dateOfIncome; // дата производства
    short expires; // срок годности

    public FoodItem(String name, float price, FoodItem analog, Date dateOfIncome, short expires) {
        super(name, price, analog); // category?
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
                ID, name, price, category, dateOfIncome, expires);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FoodItem) {
            FoodItem obj1 = (FoodItem) obj;
            return super.equals(obj) && dateOfIncome == obj1.dateOfIncome && expires == obj1.expires;
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FoodItem foodItem = new FoodItem(name, price, (FoodItem) analog, dateOfIncome, expires);
        return foodItem;

    }
}
