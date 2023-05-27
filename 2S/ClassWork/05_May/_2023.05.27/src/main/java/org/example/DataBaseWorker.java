package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseWorker {
    private List<User> dataBase;
    private String pathToAnswers;
    private long counOfAnswers;
    public DataBaseWorker(DataBase db, String pathToAnswers) {
        dataBase = db.getUsers();
        this.pathToAnswers = pathToAnswers;
    }


    public void command(String command) {
        if(dataBase == null) throw  new RuntimeException();
        String[] line = command.split("/");
        String format = null;
        for(var buf : line) {
            if(buf.contains("&")) {
                try {
                    format = (buf.split("&"))[1].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Please add format to end of the line");
                }
            }
        }

        if(format == null) {
            System.out.println("Please add format to end of the line");
        }
        line = (String[]) Arrays.stream(line).filter(v -> {return v.length() > 0;}).toArray(String[] ::new);
        List<User> ans = new ArrayList<>();
        for(int i = 0; i < line.length; i++) {
            String com = line[i];
            if(com.contains("&")) {
                if(i == 0) {
                    if(com.contains("?")) {
                        String filter = com.split("\\?")[1].split("=")[0];
                        String whatIn = com.split("\\?")[1].split("=")[1].split("&")[0];
                        StringBuilder buf = new StringBuilder(filter);
                        buf.setCharAt(0, (char)(filter.charAt(0) - 32));
                        filter = buf.toString();

                        String finalFilter = filter;
                        ans = dataBase.stream().filter(t -> {return isGood(t, finalFilter, whatIn);}).toList();
                    } else {
                        ans = dataBase;
                    }
                } else if(i == 1) {
                    String whatIn = com.split("\\?")[1].split("=")[1].split("&")[0];

                    ans = dataBase.stream().filter(t -> {return isGood(t, whatIn);}).toList();
                }
            }
        }
        switch (format) {
            case "console":
                printConsole(ans);
                break;
            case "MD":
                printMD(ans);
                break;
            case "HTML":
                printHTML(ans);
                break;
            default:
                printConsole(ans);
        }

        counOfAnswers ++;
    }

    private boolean isGood(User a, String filter, String whatIn) {
        try {
            String myData = User.class.getMethod("get" + filter).invoke(a, User.class.getMethod("get" + filter).getParameterTypes()).toString();
            return myData.equals(whatIn);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isGood(User a, String whatIn) {
        try {
            Method[] methods = User.class.getMethods();

            for(int i = 0; i < methods.length; i++) {
                if(!methods[i].getName().contains("get")) continue;
                if((methods[i].invoke(a).toString()).contains(whatIn)) {
                    return true;
                }
            }

            return false;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void printConsole(List<User> ans) {
        for(var i : ans) {
            System.out.println(i);
        }
    }

    private void printMD(List<User> ans) {
        FileWriter fw;
        try {
            fw = new FileWriter(new File(pathToAnswers + "/answer" + counOfAnswers + ".md"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(var user : ans) {
            try {
                fw.write("### " + user.getName());
                fw.write("\n");
                fw.write( "** city: "+ user.getCity());
                fw.write("\n");
                fw.write("** BIO " + user.getBIO());
                fw.write("\n");
                fw.write("** Favourite color " + user.getFavouriteColor());
                fw.write("\n");
                fw.write("** Future profession " + user.getFutureProfession());
                fw.write("\n");
                fw.write("** Main interest " + user.getMainInterest());
                fw.write("\n");
                fw.write("** Birth date " + user.getBirthDate());
                fw.write("\n");
                fw.write("** " + (user.getHavePet() ? "Having pet" : "Don't have a pet"));
                fw.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printHTML(List<User> ans) {
        FileWriter fw;
        try {
            fw = new FileWriter(new File(pathToAnswers + "/answer" + counOfAnswers + ".html"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(var user : ans) {
            try {
                fw.write(asHTML("name", user.getName()));
                fw.write("\n");
                fw.write( asHTML("city", user.getCity()));
                fw.write("\n");
                fw.write(asHTML("bio", user.getBIO()));
                fw.write("\n");
                fw.write(asHTML("favouriteColor", user.getFavouriteColor()));
                fw.write("\n");
                fw.write(asHTML("futureProfession", user.getFutureProfession()));
                fw.write("\n");
                fw.write(asHTML("mainInterest", user.getMainInterest()));
                fw.write("\n");
                fw.write(asHTML("birthDate", String.valueOf(user.getBirthDate())));
                fw.write("\n");
                fw.write(asHTML ("havingAPet", user.getHavePet() ? "Having pet" : "Don't have a pet"));
                fw.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String asHTML(String type, String data) {
        return "<" + type + "> " + data + " </" + type + ">";
    }
}
