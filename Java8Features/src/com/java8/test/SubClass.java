package com.java8.test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

class SuperClass {  
    public void start() throws IOException{
        //throw new IOException("Not able to open file");
    }
}

public class SubClass extends SuperClass{  
    public void start() throws IOException{
        //throw new Exception("Not able to start");
    }
}



