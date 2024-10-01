/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmsystem.System;

/**
 *
 * @author Janrell Quiaroro
 */
public class AdLogin {
    private String admin_username;
    private String admin_password;
    
public AdLogin() {
    super();
    }
 
public AdLogin(String admin_username, String admin_password) {
    super();
    this.admin_username = admin_username;
    this.admin_password = admin_password;
    }
//Getters
public String getUsername() {
    return admin_username;
    }
public String getPassword() {
    return admin_password;
    }
//Setters
public void setUsername(String admin_username) {
    this.admin_username = admin_username;
    }
public void setPassword(String admin_password) {
    this.admin_password = admin_password;
 }
}
