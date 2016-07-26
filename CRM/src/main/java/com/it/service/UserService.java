package com.it.service;
import com.it.mapper.RoleMapper;
import com.it.mapper.UserLogMapper;
import com.it.mapper.UserMapper;
import com.it.pojo.User;
import com.it.pojo.UserLog;
import com.it.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class UserService {
    @Inject
    private UserMapper userMapper;
    @Inject
    private UserLogMapper userLogMapper;
    @Inject
    private RoleMapper roleMapper;
    //创建用户的登录日志
  public void saveUserLoggin(String ip){
      UserLog userLog =new UserLog();
      userLog.setLoginip(ip);
      userLog.setLogintime(DateTime.now().toString("yyyy-MM-dd HH:mm"));
      userLog.setUserid(ShiroUtil.getCurrentUserID());
      userLogMapper.save(userLog);
  }
    //修改用户密码

    public void changePassword(String password){
       User user =ShiroUtil.getCurrentUser();
        user.setPassword(DigestUtils.md5Hex(password));
        userMapper.updateUser(user);
    }
    //获取当前用的登录日志
    public List<UserLog> findCUrrentUserLog(String start,String length){
       Map<String,Object> param =new HashMap<>();
        param.put("userId",ShiroUtil.getCurrentUserID());
        param.put("start",start);
        param.put("length",length);
        return  null;
    }




    //获取当前用户的日志数量
    //


}