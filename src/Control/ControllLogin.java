package Control;

import Model.ModelLogin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class ControllLogin {
    public ModelLogin login(ModelLogin n) {
        ModelLogin p = null;
        try {
            String SQL = "SELECT * FROM tb_user WHERE id_user = ? AND password_user = ? AND role = ?";
            Connection connn = Conection.Connection.getConnection();
            PreparedStatement stat = connn.prepareStatement(SQL);
            stat.setString(1, n.getId_user());
            stat.setString(2, n.getPassword_user());
            stat.setString(3, n.getRole());
            ResultSet ress = stat.executeQuery();

            if (ress.next()) {
                JOptionPane.showMessageDialog(null, "Login berhasil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                p = new ModelLogin();
                p.setId_user(ress.getString("id_user"));
                p.setPassword_user(ress.getString("password_user"));
                p.setRole(ress.getString("role"));

                if ("Mahasiswa".equals(p.getRole()) || "Dosen".equals(p.getRole())) {
                    directToViewBukuUser();
                } else if ("Petugas".equals(p.getRole())) {
                    directToViewMenuHome();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal, id_user atau password_user salah", "Perhatian", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return p;
    }

    private void directToViewBukuUser() {
        System.out.println("directing to Buku User...");
        
    }

    private void directToViewMenuHome() {
        System.out.println("directing to Menu Home...");
        
    }
}
