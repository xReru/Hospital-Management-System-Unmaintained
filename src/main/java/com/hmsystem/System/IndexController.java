/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmsystem.System;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Janrell Quiaroro
 */
@Controller
public class IndexController {


    @GetMapping("/")
    public String indexpage(){
    return "index";
    }
    
}
