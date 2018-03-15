package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class WriterReader {

    public static final String filepath = "/Users/Josef/Desktop/Tom mappe projekt/BørnehaveProjekt1/src/main/resources/templates/backup.txt";


    public void writeObjectTooFile (ArrayList<Child> children){

        try {

            //create the writer
            FileOutputStream fileOut = new FileOutputStream(filepath);

            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(children);
            System.out.println("object blev gemt");
            objectOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Child> readObjectFromFile (String filepath){

        try {
            FileInputStream filein = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(filein);

            ArrayList<Child> obj = (ArrayList<Child>) objectIn.readObject();

            System.out.println("Objektet er indlæst korrekt fra filen");

            objectIn.close();

            return obj;



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }



    public void writer(ArrayList<Child> children){

        try {
            FileWriter fileWriter = new FileWriter(filepath);
            Writer output = new BufferedWriter(fileWriter);

            output.write(children);
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


