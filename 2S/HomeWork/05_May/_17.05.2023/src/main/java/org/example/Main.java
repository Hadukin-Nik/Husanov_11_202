package org.example;

import org.example.firstTask.Factory;
import org.example.second.Prototype;

public class Main {
    public static void main(String[] args) {
        Prototype p = new Prototype();
        Factory f = new Factory();
        f.setCopiedFile("https://stackoverflow.com/questions/2237803/can-i-obtain-method-parameter-name-using-java-reflection");
        f.downloadByLink("https://stackoverflow.com/questions/2237803/can-i-obtain-method-parameter-name-using-java-reflection", "src/main/ans.txt");

        Factory c = (Factory) p.copyMachine(f);
        System.out.println(c.getCopiedFile());
    }
}