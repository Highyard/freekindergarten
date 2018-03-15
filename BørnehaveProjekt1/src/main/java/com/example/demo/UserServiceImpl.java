package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepository();

    @Override
    public ArrayList<Child> fetchAllChildren() {
        return userRepository.fetchChildren();
    }

    public boolean addBarn(Child child){
        userRepository.saveTofile();
        return userRepository.children.add(child);
    }



}
