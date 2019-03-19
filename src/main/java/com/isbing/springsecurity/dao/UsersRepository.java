package com.isbing.springsecurity.dao;

import com.isbing.springsecurity.entity.Permission;
import com.isbing.springsecurity.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by songbing
 * Created time 2019/3/19 下午10:44
 */
@Repository
public interface UsersRepository extends CrudRepository<Users,String>{

    Page<Users> findAll(Pageable pageable);


    Users getById(String id);


}
