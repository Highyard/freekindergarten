package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    ArrayList<Child> children = new ArrayList<>();

    public UserServiceImpl(){
        children.add(new Child(0, "Thomas", "Larsen", "Mor: 21525583", "1202171092", new Date(1990/12/12), "- Han kan ikke lide rejer"));
        children.add(new Child(1, "Mikkel", "Bekker", "Far: 34221134", "0809169238", new Date(1990/12/12), "- Han drikker lidt sprit (pas på!)"));
        children.add(new Child(2, "Bjarne", "Nielsen", "\"ingen\"", "0909179238", new Date(1990/12/12), "- Han elsker kylling"));

    }



    @Override
    public ArrayList<Child> fetchAllChildren() {
        return children;
    }





    public boolean addBarn(Child child){

        return children.add(child);
    }

}
