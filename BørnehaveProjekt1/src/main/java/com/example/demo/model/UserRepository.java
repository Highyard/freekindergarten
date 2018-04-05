package com.example.demo.model;

import com.example.demo.utilities.WriterReader;

import java.util.ArrayList;

public class UserRepository {

    public ArrayList<Child> children = new ArrayList<>();


    public ArrayList<Child> fetchChildren(){
        return children;
    }






    public boolean saveTofile(){
        WriterReader writerReader = new WriterReader();

        return writerReader.writeObjectTooFile(children);
    }

    public boolean readFromfile(){
        WriterReader writerReader = new WriterReader();

        children = writerReader.readObjectFromFile(WriterReader.filepath);

        return true;
    }


}
