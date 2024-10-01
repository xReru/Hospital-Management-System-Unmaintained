/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmsystem.System;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Janrell Quiaroro
 */
@Controller
public class LoginController{
    @GetMapping("/Admin")
    public String Admin_login(){
        return "admin_login";
    }
    
    @GetMapping("/admin")
    public String admin_login(){
        return "admin_login";
    }
    @GetMapping("Logout")
    public String logout(){
        return "admin_login";
    }
    
    @PostMapping("/Admin")
    public String login(@ModelAttribute(name="adminForm") AdLogin login, Model model) {
        String uname = login.getUsername();
        String pass = login.getPassword();
        if(uname.equals("admin") && pass.equals("admin")) {
            model.addAttribute("uname", uname);
            model.addAttribute("pass", pass);
        return "Admin/index";
        }
        model.addAttribute("error", "<center>Incorrect Username & Password</center>");
    return "/admin_login";
    }
}
