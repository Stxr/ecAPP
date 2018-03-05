package com.example.latte.delegates.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.latte.R;
import com.example.latte.R2;
import com.example.latte.delegates.LatteDelegate;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by stxr .
 * Date: 18-2-7
 * Time: 下午2:38
 * note: 容器
 */
public abstract class BaseBottomDelegate extends LatteDelegate implements View.OnClickListener {
    //滑动界面
    private final ArrayList<BottomItemDelegate> ITEM_DELEGATES = new ArrayList<>();
    //滑动状态栏
    private final ArrayList<BottomTabBean> TAB_BEANS = new ArrayList<>();

    private LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();
    private int mCurrentDelegate = 0;
    private int mIndexDelegate = 0;
    private int mClickedColor = Color.RED;

    @BindView(R2.id.bottom_bar)
    LinearLayoutCompat mBottomBar;


    public abstract LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder);


    @Override
    public Object setLayout() {
        return R.layout.delegate_bottom;
    }

    public abstract int setIndexDelegate();

    @ColorInt
    public abstract int setClickedColor();
    @ColorInt
    public abstract int setDefaultColor();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexDelegate = setIndexDelegate();
        if (setClickedColor() != 0) {
            mClickedColor = setClickedColor();
        }
        final ItemBuilder builder = ItemBuilder.builder();
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = setItems(builder);
        ITEMS.putAll(items);
        for (Map.Entry<BottomTabBean, BottomItemDelegate> item : ITEMS.entrySet()) {
            final BottomTabBean key = item.getKey();
            final BottomItemDelegate value = item.getValue();
            TAB_BEANS.add(key);
            ITEM_DELEGATES.add(value);
        }
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        final int size = ITEMS.size();
        //初始化底部
        for(int i=0;i<size;i++) {
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_item_icon_text_layout, mBottomBar);
            //遍历4个按钮
            RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            //设置每个item click listener
            item.setTag(i);
            item.setOnClickListener(this);
            IconTextView itemIcon = (IconTextView) item.getChildAt(0);
            AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            BottomTabBean bean = TAB_BEANS.get(i);
//            BottomItemDelegate delegate =
            //初始化数据
            itemIcon.setText(bean.getICON());
            itemTitle.setText(bean.getTITLE());
            if (i == mIndexDelegate) {
                itemIcon.setTextColor(mClickedColor);
                itemTitle.setTextColor(mClickedColor);
            }
        }
        SupportFragment[] delegates = ITEM_DELEGATES.toArray(new SupportFragment[size]);
        loadMultipleRootFragment(R.id.bottom_bar_delegate_container,mIndexDelegate,delegates);
    }

    private void resetColor() {
        int count = mBottomBar.getChildCount();
        for(int i=0;i<count;i++) {
            final RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            IconTextView itemIcon = (IconTextView) item.getChildAt(0);
            AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            itemIcon.setTextColor(setDefaultColor());
            itemTitle.setTextColor(setDefaultColor());
        }
    }

    @Override
    public void onClick(View v) {
        final int tag = (int) v.getTag();
        resetColor();
        RelativeLayout item = (RelativeLayout) v;
        IconTextView itemIcon = (IconTextView) item.getChildAt(0);
        AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
        itemIcon.setTextColor(mClickedColor);
        itemTitle.setTextColor(mClickedColor);
        showHideFragment(ITEM_DELEGATES.get(tag), ITEM_DELEGATES.get(mCurrentDelegate));

        //注意先后顺序
        mCurrentDelegate = tag;

    }
}
