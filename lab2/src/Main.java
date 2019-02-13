import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        GenericItem[] genericItems = {new FoodItem("item", 100f, new Date(), (short) 120), new TechicalItem("item", 100f, (short) 10)};
        for (GenericItem item : genericItems) {
            item.printAll();
        }

    }
}
