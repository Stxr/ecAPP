package com.example.latte.delegates.bottom;

import com.example.latte.utils.timer.ITimerListener;

import java.util.LinkedHashMap;

/**
 * Created by stxr .
 * Date: 18-2-7
 * Time: 下午3:20
 * note:
 */
public final class ItemBuilder {
    //保证底部的tab有序
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }
    //简单builder模式
    public final ItemBuilder addItem(BottomTabBean bean, BottomItemDelegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean, BottomItemDelegate> build() {
        return ITEMS;
    }
}
