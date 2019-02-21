package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog =
            new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog =
            new ArrayList<GenericItem>();


    //добавляет товар в каталог
    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.containsKey(item.getId())){
            throw new ItemAlreadyExistsException();
        }
            catalog.put(item.getId(), item); // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList
    }


    // распечатывает товары из каталога на экране. Распечатку следует производить с использованием метода toString класса GenericItem.
    public void printItems() {
        for (GenericItem i : ALCatalog) {
            i.printAll();
        }
    }

    //производит поиск в каталоге по переданному id товара. Поиск следует производит в коллекции catalog типа HashMap
    public GenericItem findItemByID(int id) {

        //Если нет такого ID, возвращаем пустое значение
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    // производит поиск в каталоге по переданному id товара. Поиск следует производит в коллекции ALCatalog типа ArrayList
    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.getId() == id) return i;
        }
        return null;
    }


}
