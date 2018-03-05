package com.example.latte.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by stxr .
 * Date: 18-2-14
 * Time: 下午6:13
 * note:
 */
public class MultipleViewHolder extends BaseViewHolder {

    private MultipleViewHolder(View view) {
        super(view);
    }

    public static MultipleViewHolder creat(View view) {
        return new MultipleViewHolder(view);
    }
}
