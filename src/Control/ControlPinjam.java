package Control;


import Model.ModelPinjam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class ControlPinjam {
    public ModelPinjam simpan(ModelPinjam m) {
    Connection connn = null;
    PreparedStatement stat = null;
    try {
        connn = Conection.Connection.getConnection();
        stat = connn.prepareStatement("INSERT INTO tb_peminjaman (no_pinjam, tanggal_pinjam, id_user, kode_buku) values(?,?,?,?)");
        stat.setString(1, m.getNopinjam());
        stat.setDate(2, java.sql.Date.valueOf(m.getTanggalpinjam()));
        stat.setString(3, m.getIduser());
        stat.setString(4, m.getKodebuku());
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        e.printStackTrace(); // Cetak stack trace untuk debugging
        JOptionPane.showMessageDialog(null, "Data Harus Berupa Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } finally {
        // Pastikan untuk menutup PreparedStatement dan Connection
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connn != null) {
            try {
                connn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return null;
}

    
}
