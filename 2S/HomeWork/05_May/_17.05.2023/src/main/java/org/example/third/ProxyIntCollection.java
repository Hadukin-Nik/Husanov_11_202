package org.example.third;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProxyIntCollection {
    private ArrayList<Integer> main;
    private Queue<Integer> buffer;

    public ProxyIntCollection() {
        main = new ArrayList<>();
        buffer = new LinkedList<>();
    }

    public void add(int elem) {
        buffer.add(elem);
    }

    public void delete(int id) {
        if(main.size() <= id) {
            int j = id - main.size();
            while(j > 0) {
                main.add(buffer.poll());
                j--;
            }
        } else {
            main.remove(id);
        }
    }

    public int get(int id) {
        if(main.size() <= id) {
            int j = id - main.size() + 1;
            while(j > 0) {
                main.add(buffer.poll());
                j--;
            }
            return main.get(id);
        } else {
            return main.get(id);
        }
    }

    public int size() {
        return main.size() + buffer.size();
    }
}
