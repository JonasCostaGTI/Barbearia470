package barbearia470.br.com.DAO;

import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jonascosta
 * @date 30/08/2017
 *
 */
public class ProdutoDAO {

    public boolean editar(Produto produto) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE Produtos SET nome = ?, preco = ? WHERE idProdutos = ?");

            pst.setString(1, produto.getNome());
            pst.setBigDecimal(2, produto.getPreco());
            pst.setInt(3, produto.getProdutoId());

            pst.execute();
            conexao.desconectar();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public double pegaValorPorId(int idProduto) {
        Double valor = 0.0;

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "select *from Produtos where idProdutos = '" + idProduto + "' ";

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {

                valor = rs.getDouble("preco");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        conexao.desconectar();

        return valor;
    }
}
