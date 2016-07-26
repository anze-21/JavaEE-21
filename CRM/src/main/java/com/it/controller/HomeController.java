package com.it.controller;
import com.it.dto.FlashMessage;
import com.it.service.UserService;
import com.it.util.ServletUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {


    @Inject
    private UserService userService;

    /**
     * 去登录页面
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "login";
    }




    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}