package com.example.latte.ec.main;

import android.graphics.Color;

import com.example.latte.delegates.bottom.BaseBottomDelegate;
import com.example.latte.delegates.bottom.BottomItemDelegate;
import com.example.latte.delegates.bottom.BottomTabBean;
import com.example.latte.delegates.bottom.ItemBuilder;
import com.example.latte.ec.main.index.IndexDelegate;
import com.example.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by stxr .
 * Date: 18-2-8
 * Time: 下午10:21
 * note:
 */
public class ECBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        builder.addItem(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        builder.addItem(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        builder.addItem(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        builder.addItem(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        builder.addItem(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }

    @Override
    public int setDefaultColor() {
        return Color.GRAY;
    }
}
