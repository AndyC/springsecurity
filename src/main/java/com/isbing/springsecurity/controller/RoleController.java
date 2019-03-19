package com.isbing.springsecurity.controller;

import com.isbing.springsecurity.entity.Roles;
import com.isbing.springsecurity.service.RoleService;
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
 * Created time 2019/3/18 下午9:15
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/getAll")
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Roles> getAll(Pageable pageable) {
        return roleService.getAll(pageable);
    }

    @RequestMapping("/getById")
    @ResponseBody
    @Transactional(readOnly = true)
    public Roles getById(@RequestParam("id") String id) {
        return roleService.getById(id);
    }

    @RequestMapping("/create")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Roles create(@RequestBody Roles roles) {
        return roleService.create(roles);
    }

    @RequestMapping("/update")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Roles update(@RequestBody Roles roles) {
        return roleService.update(roles);
    }

}
