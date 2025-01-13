package Control;

import Model.ModelKembali;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class ControlKembali {
    public ModelKembali Update(ModelKembali k) {
        if (k.getTanggalkembali() == null || k.getTanggalkembali().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tanggal kembali tidak boleh kosong!", "Pesan", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        try {
            Connection c = Conection.Connection.getConnection();
            String sql = "UPDATE tb_peminjaman SET tanggal_kembali = ?, status = ? WHERE no_pinjam = ?";
            PreparedStatement stat = c.prepareStatement(sql);
            stat.setDate(1, java.sql.Date.valueOf(k.getTanggalkembali()));
            stat.setString(2, k.getStatus());
            stat.setString(3, k.getNopinjam());
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil di ubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di ubah", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
}