package com.isbing.springsecurity.controller;

import com.isbing.springsecurity.common.NoWapperResponse;
import com.isbing.springsecurity.entity.Menus;
import com.isbing.springsecurity.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by songbing
 * Created time 2019/3/17 上午11:27
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    //@PreAuthorize("hasAnyRole('ROLE_MENU_SEARCH')")
    @RequestMapping("/getAllByParentMenuIsNull")
    @ResponseBody
    public Page<Menus> getAllByParentMenuIsNull(Pageable pageable) {
        return menuService.getAllByParentMenuIsNull(pageable);
    }


    @RequestMapping("/getAllByParentMenuIsNotNull")
    @ResponseBody
    public Page<Menus> getAllByParentMenuIsNotNull(Pageable pageable) {
        return menuService.getAllByParentMenuIsNotNull(pageable);
    }

    @PostMapping("/create")
    @ResponseBody
    public Menus create(@RequestBody Menus menus) {
        menus.setCreateTime(new Date());
        return menuService.createUpdate(menus);
    }

    @GetMapping("/getById")
    @ResponseBody
    public Menus getById(@RequestParam(name = "id") String id) {
        return menuService.getById(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public Menus update(@RequestBody Menus menus) {
        return menuService.createUpdate(menus);
    }



    @GetMapping("/getByParentMenuId")
    @ResponseBody
    public List<Menus> getByParentMenuId(String menuId) {
        return menuService.getByParentMenuId(menuId);
    }
}
