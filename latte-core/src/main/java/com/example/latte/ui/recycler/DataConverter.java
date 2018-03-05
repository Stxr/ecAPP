package com.example.latte.ui.recycler;

import java.util.ArrayList;

/**
 * Created by stxr .
 * Date: 18-2-11
 * Time: 下午11:23
 * note:
 */
public abstract class DataConverter {
    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String jsonData) {
        this.mJsonData = jsonData;
        return this;
    }

    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS NULL");
        }
        return mJsonData;
    }
}
