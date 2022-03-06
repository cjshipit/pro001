package com.li.controller;

import com.li.bean.TblUserRecord;
import com.li.returnJson.Permission;
import com.li.returnJson.Permissions;
import com.li.returnJson.ReturnObject;
import com.li.returnJson.UserInfo;
import com.li.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Li
 * @Version: 1.0
 * @Creat:2022-02-16
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public Boolean test(){
        System.out.println("前端框架自带的一个验证规则，写不写无所谓");
        return true;
    }
    @ResponseBody
    @RequestMapping("/auth/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        System.out.println("login");
        System.out.println(password);
        TblUserRecord tblUserRecord = loginService.login(username,password);
        if(tblUserRecord == null){
            ReturnObject returnObject = new ReturnObject(tblUserRecord);
            return null ;
        }else {
            tblUserRecord.setToken(tblUserRecord.getUserName());
            //将用户数据写入到session中
            session.setAttribute("userRecord", tblUserRecord);
            ReturnObject returnObject = new ReturnObject(tblUserRecord);
            return returnObject;
        }
    }
    @ResponseBody
    @RequestMapping("/user/info")
    public Object getInfo(HttpSession session){
        TblUserRecord tblUserRecord = (TblUserRecord) session.getAttribute("userRecord");
        //获取模块信息
        String[] split = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        //创建权限集合对象
        Permissions permissions = new Permissions();
        //向权限集合对象中添加具体的权限
        //为了方便 权限信息再数据库中的存储方式为 1001-1003  （数字代表具体权限）
        List<Permission> permissionList = new ArrayList<>();
        for (String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        //设置返回值的result
        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(),permissions);
        return new ReturnObject(userInfo);
    }
    //推出功能  删掉用户的session就可以了
    @RequestMapping("/auth/logout")
    public void logOut(HttpSession session){
        System.out.println("logout");
        session.invalidate();
    }





}
