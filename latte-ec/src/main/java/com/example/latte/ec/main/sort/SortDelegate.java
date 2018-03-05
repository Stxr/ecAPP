package com.example.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte.delegates.bottom.BottomItemDelegate;
import com.example.latte.ec.R;

/**
 * Created by stxr .
 * Date: 18-2-8
 * Time: 下午10:32
 * note:
 */
public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
