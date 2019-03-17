package com.isbing.springsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by songbing
 * Created time 2019/3/17 下午8:28
 */
@Entity
@Data
public class Permission extends BaseEntity{

    private String permName;

    private String permCode;

    //菜单
    @ManyToOne
    private Menus menus;

    public boolean equals(Object o){
        if(!(o instanceof Permission)){
            return false;
        }
        return((Permission) o).getId()==getId();
    }

}
