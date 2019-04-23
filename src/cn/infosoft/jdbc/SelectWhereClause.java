package cn.infosoft.jdbc;

import java.sql.*;

public class SelectWhereClause {
        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL ="jdbc:mysql://localhost:3306/jdbc_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "admin";

        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try{
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection
                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected database successfully...");

                //STEP 4: Execute a query
                System.out.println("Creating statement...");
                stmt = conn.createStatement();

                // Extract records without any condition.
                System.out.println("Fetching records without condition...");
                String sql = "SELECT id, first, last, age FROM student";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    //Retrieve by column name
                    int id  = rs.getInt("id");
                    int age = rs.getInt("age");
                    String first = rs.getString("first");
                    String last = rs.getString("last");

                    //Display values
                    System.out.print("ID: " + id);
                    System.out.print(", Age: " + age);
                    System.out.print(", First: " + first);
                    System.out.println(", Last: " + last);
                }

                // Select all records having ID equal or greater than 101
                System.out.println("Fetching records with condition...");
                sql = "SELECT id, first, last, age FROM student" +
                        " WHERE id >= 103 ";
                rs = stmt.executeQuery(sql);

                while(rs.next()){
                    //Retrieve by column name
                    int id  = rs.getInt("id");
                    int age = rs.getInt("age");
                    String first = rs.getString("first");
                    String last = rs.getString("last");

                    //Display values
                    System.out.print("ID: " + id);
                    System.out.print(", Age: " + age);
                    System.out.print(", First: " + first);
                    System.out.println(", Last: " + last);
                }
                rs.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException se){
                }// do nothing
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
            System.out.println("Goodbye!");
        }//end main
}