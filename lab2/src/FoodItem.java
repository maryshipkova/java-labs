import java.util.Date;

public class FoodItem extends GenericItem {
    Date dateOfIncome; // дата производства
    short expires; // срок годности

    FoodItem(String name, float price, Date dateOfIncome, short expires) {
        super(name, price);
        this.category = Category.FOOD;
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;

    }

    void printAll() {
        System.out.printf("ID: %d, Name: %s, price: %5.2f, Category: %s, Date: %s, Expires: %d\n",
                ID, name, price, category, dateOfIncome, expires);
    }
}
