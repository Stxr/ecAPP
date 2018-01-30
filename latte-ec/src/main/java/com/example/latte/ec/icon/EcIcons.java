package com.example.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by stxr .
 * Date: 17-12-19
 * Time: 上午11:23
 * note:
 */
public enum  EcIcons implements Icon {
    icon_scan('\ue602'),
    icon_ali_pay('\ue606')
    ;
    private char character;
    @Override
    public String key() {
        return name().replace('_', '-');
    }

    private EcIcons(char character) {
        this.character = character;
    }

    @Override
    public char character() {
        return character;
    }
}
