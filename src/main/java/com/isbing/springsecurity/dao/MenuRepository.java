package com.isbing.springsecurity.dao;

import com.isbing.springsecurity.entity.Menus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songbing
 * Created time 2019/3/17 上午11:28
 */
@Repository
public interface MenuRepository extends CrudRepository<Menus,String> {

    Page<Menus> getAllByParentMenuIsNull(Pageable pageable);

    Menus getById(String id);

    List<Menus> getByParentMenuId(String parentMenuId);

    Page<Menus> getAllByParentMenuIsNotNull(Pageable pageable);
}
