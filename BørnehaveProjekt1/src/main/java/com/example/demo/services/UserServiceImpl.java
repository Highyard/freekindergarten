package com.example.demo.services;

import com.example.demo.model.Child;
import com.example.demo.model.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepository();

    @Override
    public ArrayList<Child> fetchAllChildren() {

        userRepository.readFromfile();

        return userRepository.fetchChildren();
    }



    public boolean addBarn(Child child){

        userRepository.children.add(child);

        return  userRepository.saveTofile();

    }

}
