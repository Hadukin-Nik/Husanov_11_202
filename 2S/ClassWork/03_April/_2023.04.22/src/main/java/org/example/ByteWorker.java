package org.example;

import java.util.ArrayList;
import java.util.List;

public class ByteWorker {
    private List<Byte> ready;
    private int cell;

    public ByteWorker() {
        ready = new ArrayList<>();
        ready.add((byte) 0);
        cell = 0;
    }

    public void add(Byte ch, int len) {
        int two = 256;
        for(int i = 0; i < len; i++) {
            ready.add((byte) (ready.get(i / len) | (ch & two)));
            cell ++;
            two /= 2;
            if(cell % 8 == 0) {
                ready.add((byte) 0);
            }
        }
    }

    public List<Byte> getList() {
        return ready;
    }
}
