package barbearia470.br.com.DAO;

import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jonascosta
 * @date 04/09/2017
 *
 */
public class VendaDAO {

    public double pegaValorVendaEdicao(int idVendaEdicao) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT totalVenda FROM Vendas WHERE idVenda = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, idVendaEdicao);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Double valor = rs.getDouble("totalVenda");
                return valor;

            }

            conexao.desconectar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return 0;
    }

    public boolean salvar(Venda venda) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO Vendas (idFuncionario, nomeFuncionario, data, quantidadeBebidas, "
                    + "quantidadeProdutos, idServico, nomeServico, totalVenda, pagamento, hora, "
                    + "qtd_agua, qtd_chope, qtd_refri, qtd_cerveja, qtd_oleo, qtd_pomada, qtd_gel, qtd_cera, "
                    + "totalBebidas, totalProdutos, totalServico, desconto, outros, descricaoOutros, valorOutros) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, venda.getIdFuncionario());
            pst.setString(2, venda.getNomeFuncionario());
            pst.setString(3, venda.getDia());
            pst.setInt(4, venda.getQuantidadeBebidas());
            pst.setInt(5, venda.getQuantidadeProdutos());
            pst.setInt(6, venda.getIdServico());
            pst.setString(7, venda.getNomeServico());
            pst.setBigDecimal(8, venda.getTotalVenda());
            pst.setString(9, venda.getPagamento());
            pst.setString(10, venda.getHora());
            pst.setInt(11, venda.getQtd_agua());
            pst.setInt(12, venda.getQtd_chope());
            pst.setInt(13, venda.getQtd_refri());
            pst.setInt(14, venda.getQtd_cerveja());
            pst.setInt(15, venda.getQtd_oleo());
            pst.setInt(16, venda.getQtd_pomada());
            pst.setInt(17, venda.getQtd_gel());
            pst.setInt(18, venda.getQtd_cera());
            pst.setBigDecimal(19, venda.getTotalBebidas());
            pst.setBigDecimal(20, venda.getTotalProduto());
            pst.setBigDecimal(21, venda.getTotalServico());
            pst.setBigDecimal(22, venda.getDesconto());
            pst.setBoolean(23, venda.isOutros());
            pst.setString(24, venda.getDescricaoOutros());
            pst.setBigDecimal(25, venda.getValorOutros());

            pst.execute();
            conexao.desconectar();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean editar(Venda venda) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE Vendas SET idFuncionario = ?, nomeFuncionario = ?, "
                    + "data = ?, quantidadeBebidas = ?, quantidadeProdutos = ?, idServico = ?, nomeServico = ?,"
                    + "totalVenda = ?, pagamento = ?, hora = ?, qtd_agua = ?, qtd_chope = ?,"
                    + "qtd_refri = ?, qtd_cerveja = ?, qtd_oleo = ?, qtd_pomada = ?, qtd_gel = ?, qtd_cera = ?, "
                    + "totalBebidas = ?, totalProdutos = ?, totalServico = ?, desconto = ?, outros = ?, descricaoOutros = ?, "
                    + "valorOutros = ? WHERE idVenda = ?");

            pst.setInt(1, venda.getIdFuncionario());
            pst.setString(2, venda.getNomeFuncionario());
            pst.setString(3, venda.getDia());
            pst.setInt(4, venda.getQuantidadeBebidas());
            pst.setInt(5, venda.getQuantidadeProdutos());
            pst.setInt(6, venda.getIdServico());
            pst.setString(7, venda.getNomeServico());
            pst.setBigDecimal(8, venda.getTotalVenda());
            pst.setString(9, venda.getPagamento());
            pst.setString(10, venda.getHora());
            pst.setInt(11, venda.getQtd_agua());
            pst.setInt(12, venda.getQtd_chope());
            pst.setInt(13, venda.getQtd_refri());
            pst.setInt(14, venda.getQtd_cerveja());
            pst.setInt(15, venda.getQtd_oleo());
            pst.setInt(16, venda.getQtd_pomada());
            pst.setInt(17, venda.getQtd_gel());
            pst.setInt(18, venda.getQtd_cera());
            pst.setBigDecimal(19, venda.getTotalBebidas());
            pst.setBigDecimal(20, venda.getTotalProduto());
            pst.setBigDecimal(21, venda.getTotalServico());
            pst.setBigDecimal(22, venda.getDesconto());
            pst.setBoolean(23, venda.isOutros());
            pst.setString(24, venda.getDescricaoOutros());
            pst.setBigDecimal(25, venda.getValorOutros());
            
            pst.setInt(26, venda.getIdVenda());

            pst.execute();
            conexao.desconectar();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean excluir(int idVenda) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM Vendas WHERE idVenda = ?");

            pst.setInt(1, idVenda);

            pst.execute();
            conexao.desconectar();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

}
