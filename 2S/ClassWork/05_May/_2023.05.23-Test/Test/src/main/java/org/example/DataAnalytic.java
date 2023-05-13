package org.example;

import java.io.*;
import java.util.*;

public class DataAnalytic {
    private List<BirthData> dataList;

    public DataAnalytic(String filePath) {
        dataList = new ArrayList<>();

        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(sc.hasNextLine()) {
            String[] db = (sc.nextLine().split(" "));
            Object[] data = Arrays.stream(db).filter(s -> {return !s.equals("");}).toArray();
            if(data.length >= 5) {
                dataList.add(new BirthData(data[0].equals("M"), Integer.parseInt((String) data[4]), data[5].equals("1"), Integer.parseInt((String) data[15]), Integer.parseInt((String) data[16])));
            }
        }
    }

    public Map<Integer, Double> getYearsOfEducationByChildrens() {
        Map<Integer, Double> ans = new HashMap<>();

        Map<Integer, Integer> countOfChildrenCountOfWomen = new HashMap<>();
        Set<Integer> k = new HashSet<>();
        for(var i : dataList) {
            if(countOfChildrenCountOfWomen.get(i.getCountOfChildren()) == null) {
                countOfChildrenCountOfWomen.put(i.getCountOfChildren(), 1);
                ans.put(i.getCountOfChildren(), (double) i.getYearsOfEducation());
            } else {
                countOfChildrenCountOfWomen.put(i.getCountOfChildren(), countOfChildrenCountOfWomen.get(i.getCountOfChildren()) + 1);
                ans.put(i.getCountOfChildren(), (double) i.getYearsOfEducation() + ans.get(i.getCountOfChildren()));
            }

            k.add(i.getCountOfChildren());
        }


        for(var i: k) {
            ans.put(i, ans.get(i) * 1.0 / countOfChildrenCountOfWomen.get(i));
        }

        return ans;
    }

    public boolean isIdeaTrue() {
        int timeOfMarried = 0;
        int timeOfNotMarried = 0;

        int countOfMarried = 0;
        int countOfNonMarried = 0;

        for(var i : dataList) {
            if(i.isMarried()) {
                timeOfMarried += i.getTimeOfPregnancy();
                countOfMarried ++;
            } else {
                timeOfNotMarried += i.getTimeOfPregnancy();
                countOfNonMarried ++;
            }
        }

        return timeOfMarried * 1.0 / countOfMarried < timeOfNotMarried * 1.0 / countOfNonMarried;
    }

    public void createNewDataSet(String filePath) {
        File file = new File(filePath);
        DataOutputStream dos;

        try {
            dos = new DataOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(var i : dataList) {
            byte b = (byte) ((byte) ((i.isMale() ? 1 : 0) << 1) | (i.isMarried() ? 1 : 0));
            try {
                dos.writeByte(b);
                dos.writeInt(i.getTimeOfPregnancy());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<BirthData> getDataFromNewDataSet(String filePath) {
        List<BirthData> ans = new ArrayList<>();

        File file = new File(filePath);
        DataInputStream dis;

        try {
            dis = new DataInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(var i : dataList) {
            byte a;
            int time;
            try {
                a = dis.readByte();
                time = dis.readInt();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            boolean isMale = ((a >> 1) == 1);
            boolean isMarried = ((a & (1)) == 1);

            ans.add(new BirthData(isMale, isMarried, time));
        }

        return ans;
    }
}
