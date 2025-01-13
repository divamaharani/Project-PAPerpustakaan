package Control;

import Model.ModelUserData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControlUserData {
    
    public ModelUserData tambah(ModelUserData m){
        try {
            Connection c = Conection.Connection.getConnection();
            PreparedStatement stat = c.prepareStatement("INSERT INTO tb_user (id_user, password_user, nama_user, jenis_kelamin_user, no_hp_user, email_user, alamat_user, tanggal_lahir_user, role)VALUES(?,?,?,?,?,?,?,?,?)");
            stat.setString(1, m.getId_user());
            stat.setString(2, m.getPassword());
            stat.setString(3, m.getNama_user());
            stat.setString(4, m.getJenis_kelamin_user());
            stat.setString(5, m.getNo_hp_user());
            stat.setString(6, m.getEmail_user());
            stat.setString(7, m.getAlamat_user());
            stat.setDate(8, java.sql.Date.valueOf(m.getTanggal_lahir_user()));
            stat.setString(9, m.getRole());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 001 Data gagal di simpan "+e,"Pesan",JOptionPane.WARNING_MESSAGE);
        }        
        return null;
    }
    
     //update
    public ModelUserData update (ModelUserData m, String a){
        try {
            Connection c = Conection.Connection.getConnection();
            PreparedStatement stat = c.prepareStatement("UPDATE tb_user SET id_user = ?, password_user = ?, nama_user = ?, jenis_kelamin_user = ?, no_hp_user = ?, email_user = ?, alamat_user = ?, tanggal_lahir_user = ?, role = ? WHERE id_user = ?");
            stat.setString(1, m.getId_user());
            stat.setString(2, m.getPassword());
            stat.setString(3, m.getNama_user());
            stat.setString(4, m.getJenis_kelamin_user());
            stat.setString(5, m.getNo_hp_user());
            stat.setString(6, m.getEmail_user());
            stat.setString(7, m.getAlamat_user());
            stat.setDate(8, java.sql.Date.valueOf(m.getTanggal_lahir_user()));
            stat.setString(9, m.getRole());
            stat.setString(10, a);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di ubah","Pesan",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 002 Data gagal di ubah","Pesan",JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
            
     //delete
     public ModelUserData delete(String a){
        
         try {
            Connection c = Conection.Connection.getConnection();
            String SQL = "DELETE FROM tb_user WHERE id_user = ?";
            PreparedStatement stat = c.prepareStatement(SQL);
            stat.setString(1, a);
            int rowsDeleted = stat.executeUpdate();

            if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error 003 Data tidak ditemukan", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {            
            JOptionPane.showMessageDialog(null, "Error 004 Data gagal dihapus: " + e.getMessage(), "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return null;         
     }
     
//     private java.sql.Date convertStringToDate(String dateString) {
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date parsed = format.parse(dateString);
//            return new java.sql.Date(parsed.getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
