package ru.billing.client;

import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ItemCatalog cat = new ItemCatalog();

        for (int i = 0; i < 15; i++) {
            cat.addItem(new GenericItem());
        }

        long begin = new Date().getTime();

        for (int i = 0; i < 100000; i++)
            cat.findItemByID(10);

        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();

        for (int i = 0; i < 100000; i++)
            cat.findItemByIDAL(10);

        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));


        //2

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(cat);
        cat.printItems();
    }
}
