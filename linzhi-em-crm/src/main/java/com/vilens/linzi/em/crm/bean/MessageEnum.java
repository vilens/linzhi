package com.vilens.linzi.em.crm.bean;

public enum MessageEnum {
    error(0), success(1), warn(2), notice(3), auth(1001);

    private int value;

    private MessageEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
