package barbearia470.br.com.DAO;

import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.model.Servico;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jonascosta
 * @date 03/09/2017
 *
 */
public class ServicoDAO {

    public boolean editar(Servico servico) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE Servicos SET servico = ?, preco = ? WHERE idServico = ?");

            pst.setString(1, servico.getNome());
            pst.setBigDecimal(2, servico.getValor());
            pst.setInt(3, servico.getIdServico());

            pst.execute();
            conexao.desconectar();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Servico pegaServicoPorNome(String nomeServico) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT idServico, servico, preco FROM Servicos WHERE servico = ?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
                
                pst.setString(1, nomeServico);
                ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Double valor = rs.getDouble("preco");
                
                Servico servico = new Servico();
                servico.setIdServico(rs.getInt("idServico"));
                servico.setNome(rs.getString("servico"));
                servico.setValor(new BigDecimal(valor));
                
                
                return servico;

            }

            conexao.desconectar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;

    }

}
