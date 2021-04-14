package com.modules.testshiro.sys.controller;

import com.modules.testshiro.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * ClassName  SysUserController
 * Description    用户controller
 * Author F
 * Date   2021/4/14 11:00
 * Version    1.0
 */
@Controller
public class SysUserController {
    public String basePath = "sys/";

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return basePath + url;
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            SysUser sysUser = (SysUser) subject.getPrincipal();
            subject.getSession().setAttribute("sysUser", sysUser);
            return basePath + "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            return basePath + "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return basePath + "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return basePath + "login";
    }

    @RequestMapping("/unAuth")
    @ResponseBody
    public String unAuth(){
        return "未授权没有访问权限";
    }
}
