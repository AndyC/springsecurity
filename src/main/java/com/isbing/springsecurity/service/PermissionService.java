package com.isbing.springsecurity.service;

import com.isbing.springsecurity.dao.PermissionRepository;
import com.isbing.springsecurity.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by songbing
 * Created time 2019/3/17 下午8:33
 */
@Service
public class PermissionService {

    @Resource
    private PermissionRepository permissionRepository;


    public Page<Permission> getAll(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    public Permission getById(String id) {
        return permissionRepository.getById(id);
    }

    public Permission create(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission update(Permission permission) {
        return permissionRepository.save(permission);
    }
}
