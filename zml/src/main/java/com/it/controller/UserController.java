package com.it.controller;

import com.it.dto.DataTablesResult;
import com.it.exception.NotFoundException;
import com.it.pojo.User;
import com.it.pojo.UserLog;
import com.it.service.UserService;
import com.it.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Inject
    private UserService userService;

    /**
     * 修改密码
     */
    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String editPassword() {
        return "setting/password";
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public String editPassword(String password) {
        userService.changePassword(password);
        return "sucess";
    }

    /**
     * 验证原始密码是否正确（Ajax调用）
     *
     * @return
     */

    @RequestMapping(value = "/validate/password", method = RequestMethod.GET)
    @ResponseBody
    public String validateOldPassword(@RequestHeader("X-Requested-With") String xRequestdWith,
                                      String oldpassword) {
        if ("XMLHttpRequest".equals(xRequestdWith)) {
            User user = ShiroUtil.getCurrentUser();
            if (user.getPassword().equals(DigestUtils.md5Hex(oldpassword))) {
                return "true";
            }
            return "false";
        } else {
            throw new NotFoundException();

        }

    }


    /**
     * 显示当前登录用户的登录日志
     *
     * @return
     */
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String showUserLog() {
        return "setting/loglist";
    }

    /**
     * 使用DataTables显示数据
     *
     * @return
     */
    @RequestMapping(value = "/log/load", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult userLogLoad(HttpServletRequest request) {
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        List<UserLog> userLogList = userService.findCurrentUserLog(start, length);
        Long count = userService.findCurrentUserCount();
        return new DataTablesResult<>(draw, userLogList, count, count);
    }


}
