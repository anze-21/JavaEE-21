package com.it.mapper;
import com.it.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {

User findByUsername(String username);
    void updateUser(User user);
    List<User> findByParam(Map<String,Object> params);

}
