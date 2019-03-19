package com.isbing.springsecurity.entity;

import com.google.common.collect.Sets;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by songbing
 * Created time 2019/3/19 下午10:34
 */
@Data
@Entity
public class Users extends BaseEntity{
    private String userName;

    private String nickName;

    private Integer status;

    private String password;

    // 用户 - 角色
    @ManyToMany(fetch= FetchType.EAGER)
    private Set<Roles> role = new LinkedHashSet<Roles>();

    // 用户 - 菜单
    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Menus> menus = new LinkedHashSet<Menus>();//菜单

}
