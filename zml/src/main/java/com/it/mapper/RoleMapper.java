package com.it.mapper;
import com.it.pojo.Role;

import java.util.List;

public interface RoleMapper {

    Role findById(Integer id);


    List<Role> findAll();
}
