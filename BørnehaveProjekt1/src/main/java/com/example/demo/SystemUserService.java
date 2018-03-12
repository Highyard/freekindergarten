package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SystemUserService implements SystemUserServiceImpl {



    @Override
    public SystemUser getUser(String username, String password) {

        SystemUser user = instantiateObject();
        if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
            System.out.println("succes");
            return user;
        }

        return null;
    }


    SystemUser instantiateObject() {
        return new SystemUser(1, "test", "test");
    }


}
