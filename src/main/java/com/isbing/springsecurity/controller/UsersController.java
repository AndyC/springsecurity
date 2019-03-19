package com.isbing.springsecurity.controller;

import com.isbing.springsecurity.entity.Users;
import com.isbing.springsecurity.service.UsersService;
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
 * Created time 2019/3/19 下午10:42
 */
@RequestMapping("/users")
@Controller
public class UsersController {

    @Resource
    private UsersService usersService;



    @RequestMapping("/getAll")
    @ResponseBody
    public Page<Users> getAll(Pageable pageable) {
        return this.usersService.getAll(pageable);
    }

    @RequestMapping("/getById")
    @ResponseBody
    public Users getById(@RequestParam("id") String id) {
        return this.usersService.getById(id);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public void deleteById(@RequestParam("id") String id) {
        usersService.deleteById(id);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Users create(@RequestBody Users users) {
        users.setStatus(1);
        return this.usersService.createUpdate(users);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Users updateStaff(@RequestBody Users users) {
        return this.usersService.createUpdate(users);
    }

//    @RequestMapping("/searchAll")
//    @ResponseBody
//    public Page<Users> searchAll(Pageable pageable, String sort, String sortField) {
//        return usersService.searchAll(pageable, sort, sortField);
//    }


}
