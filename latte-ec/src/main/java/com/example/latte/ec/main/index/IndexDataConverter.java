package com.example.latte.ec.main.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.latte.ui.recycler.DataConverter;
import com.example.latte.ui.recycler.ItemType;
import com.example.latte.ui.recycler.MultipleFields;
import com.example.latte.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

/**
 * Created by stxr .
 * Date: 18-2-12
 * Time: 下午4:54
 * note:
 */
public class IndexDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {
        //得到data数组中的东西
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        int size = dataArray.size();
        for(int i=0;i<size;i++) {
            JSONObject object = dataArray.getJSONObject(i);

            String imageUrl = object.getString("imageUrl");
            String text = object.getString("text");
            int spanSize = object.getInteger("spanSize");
            int id = object.getInteger("goodsId");

            JSONArray banners = object.getJSONArray("banners");

            ArrayList<String> bannerImages = new ArrayList<>();


            //判断json数据的类型
            int type = 0;
            if (imageUrl == null && text != null) {
                type = ItemType.TEXT;
            } else if (imageUrl != null && text == null){
                type = ItemType.IMAGE;
            } else if (imageUrl != null) {
                type = ItemType.IMAGE_TEXT;
            } else if (banners != null) {
                type = ItemType.BANNER;
            }


            int bannerSize = bannerImages.size();
            for(int j=0;j<bannerSize;j++) {
                bannerImages.add(banners.getString(j));
            }

            MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, type)
                    .setField(MultipleFields.SPAN_SIZE, spanSize)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.TEXT, text)
                    .setField(MultipleFields.IMAGE_URL, imageUrl)
                    .setField(MultipleFields.BANNERS, bannerImages)
                    .build();
            ENTITIES.add(entity);
        }
        return ENTITIES;
    }
}
