package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.sync.Bank;
import ru.sync.WorkThread;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws ItemAlreadyExistsException, CatalogLoadException {

        ItemCatalog cat = new ItemCatalog();

        for (int i = 0; i < 15; i++) {
            cat.addItem(new GenericItem());
        }

        long begin = new Date().getTime();

        for (int i = 0; i < 1000000; i++)
            cat.findItemByID(10);

        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();

        for (int i = 0; i < 1000000; i++)
            cat.findItemByIDAL(10);

        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        //4-1

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(cat);
        cat.printItems();


        //4-2
        Bank bankMain = new Bank();
        WorkThread threadOne  = new WorkThread(bankMain, 100, 2000);
        threadOne.setName("work thread one");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        WorkThread threadTwo  = new WorkThread(bankMain, 50, 300);
        threadTwo.setName("work thread two");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();
        System.out.println(Thread.currentThread().getName());
    }
}
