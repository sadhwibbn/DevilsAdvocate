package com.app.devilsadvocate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Srinivas on 9/9/2015.
 */
public class TestSqlConnection
{

    public static void main(String[] args)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Connection conn = DriverManager.getConnection(url, "postgres", "poocha");

            String sql = "SELECT * FROM \"Users\"";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString("Email"));
            }

            st.close();
            rs.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
