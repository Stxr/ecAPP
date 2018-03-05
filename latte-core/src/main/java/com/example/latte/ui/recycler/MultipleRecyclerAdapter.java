package com.example.latte.ui.recycler;

import android.support.v7.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.latte.R;

import java.util.List;

/**
 * Created by stxr .
 * Date: 18-2-14
 * Time: 下午6:12
 * note:
 */
public class MultipleRecyclerAdapter
        extends BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>
        implements BaseMultiItemQuickAdapter.SpanSizeLookup{

    protected MultipleRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
    }

    public static MultipleRecyclerAdapter create(List<MultipleItemEntity> data) {
        return new MultipleRecyclerAdapter(data);
    }

    public static MultipleRecyclerAdapter create(DataConverter converter) {
        return new MultipleRecyclerAdapter(converter.convert());
    }

    private void init() {
        //设置不同的布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_banner);
        //设置宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }


    @Override
    protected void convert(MultipleViewHolder helper, MultipleItemEntity item) {

    }


    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getField(MultipleFields.SPAN_SIZE);
    }

}
