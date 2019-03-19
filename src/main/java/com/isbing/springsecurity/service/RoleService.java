package com.isbing.springsecurity.service;

import com.isbing.springsecurity.dao.RoleRepository;
import com.isbing.springsecurity.entity.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songbing
 * Created time 2019/3/18 下午9:15
 */
@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;


    public Page<Roles> getAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    public Roles create(Roles roles) {
        return roleRepository.save(roles);
    }



    public Roles update(Roles roles) {
        return roleRepository.save(roles);
    }

    public Roles getById(String id) {
        return roleRepository.getById(id);
    }


}
