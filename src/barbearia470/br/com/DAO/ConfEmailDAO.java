package barbearia470.br.com.DAO;

import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.model.ConfiguracaoEmail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jonascosta
 * @date 23/10/2017
 *
 */
public class ConfEmailDAO {

    public boolean salvar(ConfiguracaoEmail confEmail) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ConfigEmail (email, senha, habilitaEnvio, diaSemana, horario) "
                    + "VALUES(?,?,?,?,?)");

            pst.setString(1, confEmail.getEmail());
            pst.setString(2, confEmail.getSenha());
            pst.setBoolean(3, confEmail.isHabilitaEnvio());
            pst.setString(4, confEmail.getDiaSemana());
            pst.setString(5, confEmail.getHorario());

            pst.execute();
            conexao.desconectar();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ConfiguracaoEmail pegaConfiguracao() {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT *FROM ConfigEmail";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                ConfiguracaoEmail configuracaoEmail = new ConfiguracaoEmail();
                configuracaoEmail.setId(rs.getInt("id"));
                configuracaoEmail.setEmail(rs.getString("email"));
                configuracaoEmail.setSenha(rs.getString("senha"));
                configuracaoEmail.setDiaSemana(rs.getString("diaSemana"));
                configuracaoEmail.setHabilitaEnvio(rs.getBoolean("habilitaEnvio"));
                configuracaoEmail.setHorario(rs.getString("horario"));

                return configuracaoEmail;

            }

            conexao.desconectar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;

    }

    public boolean editar(ConfiguracaoEmail configuracaoEmail) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE ConfigEmail SET email = ?, senha = ?, habilitaEnvio = ?, "
                    + "diaSemana = ?, horario = ?  WHERE id = ?");

            pst.setString(1, configuracaoEmail.getEmail());
            pst.setString(2, configuracaoEmail.getSenha());
            pst.setBoolean(3, configuracaoEmail.isHabilitaEnvio());
            pst.setString(4, configuracaoEmail.getDiaSemana());
            pst.setString(5, configuracaoEmail.getHorario());
            pst.setInt(6, configuracaoEmail.getId());
            

            pst.execute();
            conexao.desconectar();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
