package com.dht.mybatispagehelper.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Payment implements Serializable {
    //定义一个序列号
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String serial;
}
