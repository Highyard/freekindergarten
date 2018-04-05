package com.example.demo.services;

import com.example.demo.model.SystemUser;

public interface SystemUserServiceImpl {

    SystemUser getUser(String username, String password);


}
