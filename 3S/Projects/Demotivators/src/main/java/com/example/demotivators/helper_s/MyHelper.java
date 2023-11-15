package com.example.demotivators.helper_s;

import com.example.demotivators.entities.Mem;
import com.example.demotivators.entities.MemWithUser;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

public class MyHelper {
    public static Cookie getSpecificCookie(Cookie[] cookies, String name) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(name))
                return cookies[i];

        }

        return(null);
    }

    public static String getAStringBeforePattern(String root_buf, String scheme) {
        StringBuilder sb = new StringBuilder();

        String root = "";
        for(int i = 0; i < root_buf.length(); i++) {

            int j = 0;
            boolean ok = true;
            while(j < scheme.length() && j + i < root_buf.length()) {
                if(root_buf.charAt(j + i) != scheme.charAt(j)) break;
                if(j + 1 == scheme.length()) ok = false;

                j++;
            }

            if(!ok) {
                root = sb.toString();
            } else {
                sb.append(root_buf.charAt(i));
            }
        }

        return root;
    }

    public static String getAStringAfterPattern(String root_buf, String scheme) {
        StringBuilder sb = new StringBuilder();

        String root = "";
        for(int i = 0; i < root_buf.length(); i++) {
            int j = 0;
            boolean ok = true;

            while(j < scheme.length() && i + j < root_buf.length()) {
                if(root_buf.charAt(j + i) != scheme.charAt(j)) break;
                if(j + 1 == scheme.length()) ok = false;

                j++;
            }

            if(!ok) {
                while(i + j < root_buf.length()) {
                    sb.append(root_buf.charAt(i + j));
                    j++;
                }

                return sb.toString();
            }
        }

        return root;
    }


    public static List<MemWithUser> toAltMem(List<Mem> mems) {
        List<MemWithUser> ans = new ArrayList<>();

        for (var i : mems) {
            ans.add(new MemWithUser(i));
        }
        return ans;
    }
}
