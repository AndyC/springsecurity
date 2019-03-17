package com.isbing.springsecurity.dao;

import com.isbing.springsecurity.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by songbing
 * Created time 2019/3/17 下午8:34
 */
@Repository
public interface PermissionRepository extends CrudRepository<Permission,String>{

    Page<Permission> findAll(Pageable pageable);


    Permission getById(String id);
}
