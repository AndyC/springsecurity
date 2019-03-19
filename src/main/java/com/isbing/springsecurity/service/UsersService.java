package com.isbing.springsecurity.service;

import com.isbing.springsecurity.dao.UsersRepository;
import com.isbing.springsecurity.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by songbing
 * Created time 2019/3/19 下午10:43
 */
@Service
public class UsersService {

    @Resource
    private UsersRepository usersRepository;


    public Page<Users> getAll(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }


    public Users getById(String id) {
        return usersRepository.getById(id);
    }

    public void deleteById(String id) {
        usersRepository.deleteById(id);
    }

    public Users createUpdate(Users users) {
        users.setModifyTime(new Date());
        return this.usersRepository.save(users);
    }
}
