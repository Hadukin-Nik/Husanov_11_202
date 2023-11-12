package com.example.demotivators.dao_s;

import com.example.demotivators.entities.Mem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import static com.example.demotivators.helper_s.HelperForDAO_s.howManyUsers;

public class MemesDAO {
    public static void InsertMem(Mem mem) {
        int id = howManyUsers("memes");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {

            Statement st = conn.createStatement();
            java.sql.Date sqlDate = new java.sql.Date(mem.getCreationDate().getTime());

            st.executeQuery("INSERT INTO public.memes(\n" +
                            "        \"Mem_id\", \"User_id\", \"Picture\", \"CreationDate\", \"UpdateDate\", \"CommentsAllowed\", \"Description\")" +
                    "VALUES ("+ id + ", " + mem.getUser_id() + ", \'" +
                    mem.getPicture() + "\', \'" + (sqlDate) + "\', \'" +
                    (sqlDate)+ "\', \'" +
                    mem.isCommentsAllowed() + "\', \'" + mem.getDescription() + "\' " + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
