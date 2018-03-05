package com.example.latte.ui.recycler;

import com.example.latte.utils.file.FileUtil;

import java.util.LinkedHashMap;
import java.util.WeakHashMap;

/**
 * Created by stxr .
 * Date: 18-2-12
 * Time: 下午4:31
 * note:
 */
public class MultipleItemEntityBuilder {
    private static final LinkedHashMap<Object, Object> FIELDS = new LinkedHashMap<>();

    public MultipleItemEntityBuilder() {
        FIELDS.clear();

    }

    public final MultipleItemEntityBuilder setItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE, itemType);
        return this;
    }

    public final MultipleItemEntityBuilder setField(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }

    public final MultipleItemEntityBuilder setFields(WeakHashMap<?, ?> map) {
        FIELDS.putAll(map);
        return this;
    }

    public final MultipleItemEntity build() {
        return new MultipleItemEntity(FIELDS);
    }

}
