package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            path.toFile().deleteOnExit();
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public long getFileSize() {
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path.toFile()));
            stream.writeObject(entry);
            stream.close();
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path.toFile()));
            Entry entry = (Entry)stream.readObject();
            stream.close();
            return entry;
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    public void remove() {
        try {
            Files.delete(path);
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
}