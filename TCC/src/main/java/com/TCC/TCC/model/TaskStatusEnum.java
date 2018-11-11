package com.TCC.TCC.model;

public enum TaskStatusEnum {
    TODO(1), IN_PROGRESS(2), DONE(3);

    public int value;
    TaskStatusEnum(Integer value) {
        this.value = value;
    }
}