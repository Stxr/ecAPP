package com.example.latte.ui.launcher;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Created by stxr .
 * Date: 18-2-1
 * Time: 下午10:11
 * note:
 */
public class LauncherHolder implements Holder<Integer> {

    private AppCompatImageView mImageView;


    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        mImageView.setBackgroundResource(data);

    }
}
