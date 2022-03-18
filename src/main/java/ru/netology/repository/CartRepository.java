package ru.netology.repository;

import ru.netology.domain.PurchaseItem;

public class CartRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void save(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length); // items - откуда, 0-с какого индекса, tmp-куда, 0-в какой индекс, items.legth - сколько
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() { return items;}

    public void removeById(int id) {
        int legth = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[legth];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
