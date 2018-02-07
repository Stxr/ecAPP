package com.example.latte.delegates;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.SupportActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.latte.activities.ProxyActivity;

import java.lang.reflect.Proxy;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;
import retrofit2.http.DELETE;

/**
 * Created by stxr .
 * Date: 17-12-21
 * Time: 下午12:38
 * note:
 */
public abstract class BaseDelegate extends SwipeBackFragment {
    private final SupportFragmentDelegate DELEGATE = new SupportFragmentDelegate(this);
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
        } else if (setLayout() instanceof View) { //如果是个View
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("setLayout() type must be int or view");
        }
        if (rootView != null) {
            //BUTTERKNIFE 绑定
            unbinder = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState, rootView);
        }
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DELEGATE.onAttach((Activity) context);
    }

    public final ProxyActivity getProxyActivity() {
        return (ProxyActivity) _mActivity;
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
