package com.isbing.springsecurity.controller;

import com.isbing.springsecurity.entity.Permission;
import com.isbing.springsecurity.service.PermissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by songbing
 * Created time 2019/3/17 下午8:31
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @RequestMapping("/getAll")
    @ResponseBody
    public Page<Permission> getAll(Pageable pageable) {
        return permissionService.getAll(pageable);
    }



    @RequestMapping("/getById")
    @ResponseBody
    public Permission getById(@RequestParam("id") String id) {
        return permissionService.getById(id);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Permission create(@RequestBody Permission permission) {
        return permissionService.create(permission);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Permission update(@RequestBody Permission permission) {
        return permissionService.update(permission);
    }
}
