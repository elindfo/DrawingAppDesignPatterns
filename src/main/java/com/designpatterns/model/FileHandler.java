package com.designpatterns.model;

import com.designpatterns.model.shapes.Shape;

import java.io.*;
import java.util.List;

public class FileHandler {

    public static void serialize(File file, List<Shape> shapes) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(shapes);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static List<Shape> deserialize(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream(file);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        List<Shape> shapes = (List<Shape>) objectInputStream.readObject();
        objectInputStream.close();
        return shapes;
    }
}
