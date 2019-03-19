package com.isbing.springsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by songbing
 * Created time 2019/3/18 下午8:55
 */
@Data
@Entity
public class Roles extends BaseEntity{

    private String roleName;
    private String roleCode;

    @ManyToMany(fetch= FetchType.EAGER)
    private Set<Permission> permission = new LinkedHashSet<Permission>();//权限

    public boolean equals(Object o){
        if(!(o instanceof Roles)){
            return false;
        }
        return((Roles) o).getId()==getId();
    }

}
