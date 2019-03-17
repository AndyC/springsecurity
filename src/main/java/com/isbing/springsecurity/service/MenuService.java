package com.isbing.springsecurity.service;

import com.isbing.springsecurity.dao.MenuRepository;
import com.isbing.springsecurity.entity.Menus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by songbing
 * Created time 2019/3/17 上午11:28
 */
@Service
public class MenuService {

    @Resource
    private MenuRepository menuRepository;


    public Page<Menus> getAllByParentMenuIsNull(Pageable pageable) {
        return menuRepository.getAllByParentMenuIsNull(pageable);
    }

    public Menus createUpdate(Menus menus) {
        menus.setModifyTime(new Date());
        return menuRepository.save(menus);
    }

    public Menus getById(String id) {
        return menuRepository.getById(id);
    }

    public List<Menus> getByParentMenuId(String menuId) {
        return menuRepository.getByParentMenuId(menuId);
    }

    public Page<Menus> getAllByParentMenuIsNotNull(Pageable pageable) {
        return menuRepository.getAllByParentMenuIsNotNull(pageable);
    }
}
