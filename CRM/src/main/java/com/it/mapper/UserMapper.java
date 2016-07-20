package com.it.mapper;
import com.it.pojo.User;
public interface UserMapper {

    User findByUsername(String username);

}
