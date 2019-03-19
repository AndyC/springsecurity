package com.isbing.springsecurity.dao;

import com.isbing.springsecurity.entity.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by songbing
 * Created time 2019/3/18 下午9:16
 */
@Repository
public interface RoleRepository extends CrudRepository<Roles,String>{

    Page<Roles> findAll(Pageable pageable);

    Roles getById(String id);


}
