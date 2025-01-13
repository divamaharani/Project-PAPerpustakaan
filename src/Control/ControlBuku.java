
package Control;

import Model.ModelBuku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class ControlBuku {
    public ModelBuku tambah(ModelBuku m){
        try {
            Connection conn = Conection.Connection.getConnection();
            PreparedStatement stat = conn.prepareStatement("INSERT INTO tb_buku (kode_buku, judul_buku, jenis_buku, pengarang, penerbit, tahun, stok_buku, rak_buku)VALUES(?,?,?,?,?,?,?,?)");
            stat.setString(1, m.getKode_buku());
            stat.setString(2, m.getJudul_buku());
            stat.setString(3, m.getJenis_buku());
            stat.setString(4, m.getPengarang());
            stat.setString(5, m.getPenerbit());
            stat.setString(6, m.getTahun());
            stat.setString(7, m.getStok_buku());
            stat.setString(8, m.getRak_buku());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di simpan"+e,"Pesan",JOptionPane.WARNING_MESSAGE);
        }        
        return null;
    }
    
     //update
    public ModelBuku update (ModelBuku m, String a){
        try {
            Connection c = Conection.Connection.getConnection();
            PreparedStatement stat = c.prepareStatement("update tb_buku set judul_buku = '" +m.getJudul_buku()+
                    "', jenis_buku = '" +m.getJenis_buku()+ "', pengarang = '" +m.getPengarang()+ "', penerbit = '" +m.getPenerbit()+ "', tahun= '" +m.getTahun()+
                    "', stok_buku= '" +m.getStok_buku()+ "', rak_buku= '" +m.getRak_buku()+ "' where kode_buku = '" +a+ "'");
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di ubah","Pesan",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal di ubah","Pesan",JOptionPane.WARNING_MESSAGE);
            }
        
        return null;
    }
            
     //delete
     public ModelBuku delete(String a){
        
         try {
            Connection c = Conection.Connection.getConnection();
            String SQL = "DELETE FROM tb_buku WHERE kode_buku = ?";
            PreparedStatement stat = c.prepareStatement(SQL);
            stat.setString(1, a);
            int rowsDeleted = stat.executeUpdate();

            if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {            
            JOptionPane.showMessageDialog(null, "Data gagal dihapus: " + e.getMessage(), "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return null;         
     }
     
     
}
