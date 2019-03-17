package com.isbing.springsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by songbing
 * Created time 2019/3/17 上午11:30
 */
@Entity
@Data
public class Menus  extends BaseEntity {
    //菜单名称
    private String name;
    //图标
    private String ico;
    //地址
    private String url;
    //父菜单
    @ManyToOne
    private Menus parentMenu;

    public boolean equals(Object o){
        if(!(o instanceof Menus)){
            return false;
        }
        return((Menus) o).getId()==getId();
    }

}

