import java.util.Date;

public class Main {

    public static void main(String[] args) {
        FoodItem foodAnalog = new FoodItem("doshirak");
        GenericItem[] genericItems = {
                new FoodItem("cup noodle", 100f, foodAnalog, new Date(), (short) 120),
                new TechicalItem("item", 100f, (short) 10)
        };
        for (GenericItem item : genericItems) {
            item.printAll();
        }


        // 2

        Integer intArr[] = {10, 20, 15};
        Float floarArr[] = new Float[5];
        for (int i = 0; i < 5; i++) {
            floarArr[i] = (float) i;
        }

        WorkArray insWorkArrayInt = new WorkArray<Integer>(intArr);
        WorkArray insWorkArrayFloat = new WorkArray<Float>(floarArr);

        System.out.println(insWorkArrayInt.sum());
        System.out.println(insWorkArrayFloat.sum());


        // 3

        String line = "Конфеты ’Маска’;45;120";
        String[] item_fld = line.split(";");
        FoodItem foodItem = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
        foodItem.printAll();
    }
}
