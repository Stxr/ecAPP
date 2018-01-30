package com.example.latte.delegates;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by stxr .
 * Date: 17-12-21
 * Time: 下午12:38
 * note:
 */
public abstract class BaseDelegate extends SwipeBackFragment {
    private Unbinder unbinder;

    //让子类来传入布局，可以是layout的id，可以是View，所以用Object
    //用抽象方法表示必须要继承
    public abstract Object setLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;

        if (setLayout() instanceof Integer) { //如果是layout的id
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        }else if(setLayout() instanceof View){ //如果是个View
            rootView = (View) setLayout();
        }
        if (rootView != null) {
            //BUTTERKNIFE 绑定
            unbinder = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState, rootView);
        }
        return rootView;
    }

    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
