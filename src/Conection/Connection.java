
package Conection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {
    
    public static java.sql.Connection getConnection(){
        java.sql.Connection conn= null;
        try{
            String url = "jdbc:mysql://localhost:3306/db_perpus";
            String id_user= "root";
            String password_user="";
            conn = DriverManager.getConnection(url, id_user,password_user);
            System.out.println("Koneksi Berhasil");
            
        }catch (SQLException e){
            System.out.println("Koneksi Gagal"+e);
        }
        return conn;
    }
    public static void main(String[] args) {
        getConnection();
    }
   
}
