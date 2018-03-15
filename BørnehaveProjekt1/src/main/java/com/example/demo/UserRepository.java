package com.example.demo;

import java.util.ArrayList;
import java.util.Date;

public class UserRepository {

    ArrayList<Child> children = new ArrayList<>();


    public ArrayList<Child> fetchChildren(){
        return children;
    }


    public void saveTofile(){
        WriterReader writerReader = new WriterReader();
        writerReader.writer(children);
    }

    public void readFromfile(){
        WriterReader writerReader = new WriterReader();
        writerReader.readObjectFromFile(WriterReader.filepath);
    }


}
