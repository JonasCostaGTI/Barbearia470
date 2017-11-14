package barbearia470.br.com.DAO;

import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.model.Relatorio;
import java.math.RoundingMode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author jonascosta
 * @date 11/09/2017
 *
 */
public class RelatorioDAO {

    public Relatorio totalVendaNoDia(String dia) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT  sum(totalVenda) as soma ,"
                + "SUM(CASE WHEN totalBebidas != '0' THEN totalBebidas ELSE 0 END) as totalBebidas, "
                + "SUM(CASE WHEN totalProdutos != '0' THEN totalProdutos ELSE 0 END) as totalProdutos, "
                + "SUM(CASE WHEN totalServico != '0' THEN totalServico ELSE 0 END) as totalServicos, "
                + "SUM(CASE WHEN valorOutros != '0' THEN valorOutros ELSE 0 END) as totalOutros,"
                + "SUM(CASE WHEN pagamento = 'Dinheiro' THEN 1 ELSE 0 END) as dinheiro, "
                + "SUM(CASE WHEN pagamento = 'Cartão' THEN 1 ELSE 0 END) as cartao, "
                + "SUM(CASE WHEN nomeServico = 'Corte' THEN 1 ELSE 0 END) as cabelo, "
                + "SUM(CASE WHEN nomeServico = 'Barba' THEN 1 ELSE 0 END) as barba, "
                + "SUM(CASE WHEN nomeServico = 'Degrade' THEN 1 ELSE 0 END) as degrade, "
                + "SUM(CASE WHEN nomeServico = 'Maquina' THEN 1 ELSE 0 END) as maquina, "
                + "SUM(CASE WHEN nomeServico = 'Corte e Barba' THEN 1 ELSE 0 END) as cabeloBarba, "
                + "SUM(CASE WHEN pagamento = 'Dinheiro' THEN totalVenda ELSE 0 END) as totalDinheiro, "
                + "SUM(CASE WHEN pagamento = 'Cartão' THEN totalVenda ELSE 0 END) as totalCartao, "
                + "SUM(quantidadeBebidas) as quantidadeBebidas, "
                + "SUM(quantidadeProdutos) as quantidadeProdutos, "
                + "SUM(outros) as quantidadeOutros, "
                + "count(*) as atendimentos "
                + "FROM vendas "
                + "WHERE data  = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, dia);

            ResultSet rs = pst.executeQuery();

            Relatorio relatorioPorDia = new Relatorio();
            if (rs.next()) {
                
                if(rs.getBigDecimal("soma") == null){
                    relatorioPorDia = null;
                    return relatorioPorDia;
                }
                
                relatorioPorDia.setSoma(rs.getBigDecimal("soma").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setBebidas(rs.getInt("quantidadeBebidas"));
                relatorioPorDia.setProdutos(rs.getInt("quantidadeProdutos"));
                relatorioPorDia.setOutros(rs.getInt("quantidadeOutros"));
                relatorioPorDia.setAtendimentos(rs.getInt("atendimentos"));
                relatorioPorDia.setDinheiro(rs.getInt("dinheiro"));
                relatorioPorDia.setCartao(rs.getInt("cartao"));
                relatorioPorDia.setBarba(rs.getInt("barba"));
                relatorioPorDia.setCabelo(rs.getInt("cabelo"));
                relatorioPorDia.setBarbaCabelo(rs.getInt("cabeloBarba"));
                relatorioPorDia.setDegrade(rs.getInt("degrade"));
                relatorioPorDia.setMaquina(rs.getInt("maquina"));
                relatorioPorDia.setTotalBebidas(rs.getBigDecimal("totalBebidas").setScale(2, RoundingMode.DOWN));

                relatorioPorDia.setTotalProdutos(rs.getBigDecimal("totalProdutos").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalServico(rs.getBigDecimal("totalServicos").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalOutros(rs.getBigDecimal("totalOutros").setScale(2, RoundingMode.DOWN));

                relatorioPorDia.setTotalDinheiro(rs.getBigDecimal("totalDinheiro").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalCartao(rs.getBigDecimal("totalCartao").setScale(2, RoundingMode.DOWN));

                
                return relatorioPorDia;
                
            }

            conexao.desconectar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public Relatorio totalVendaPeriodo(Relatorio relatorio) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT  data, nomeFuncionario, hora, sum(totalVenda) as totalDia, "
                + "SUM(CASE WHEN totalBebidas != '' THEN totalBebidas ELSE 0 END) as totalBebidas, "
                + "SUM(CASE WHEN totalProdutos != '' THEN totalProdutos ELSE 0 END) as totalProdutos,  "
                + "SUM(CASE WHEN totalServico != '' THEN totalServico ELSE 0 END) as totalServicos,  "
                + "SUM(CASE WHEN pagamento = 'Dinheiro' THEN 1 ELSE 0 END) as dinheiro, "
                + "SUM(CASE WHEN pagamento = 'Cartão' THEN 1 ELSE 0 END) as cartao, "
                + "SUM(CASE WHEN nomeServico = 'Corte' THEN 1 ELSE 0 END) as cabelo, "
                + "SUM(CASE WHEN nomeServico = 'Barba' THEN 1 ELSE 0 END) as barba, "
                + "SUM(CASE WHEN nomeServico = 'Corte e Barba' THEN 1 ELSE 0 END) as cabeloBarba, "
                + "SUM(CASE WHEN pagamento = 'Dinheiro' THEN totalVenda ELSE 0 END) as totalDinheiro, "
                + "SUM(CASE WHEN pagamento = 'Cartão' THEN totalVenda ELSE 0 END) as totalCartao, "
                + "SUM(quantidadeBebidas) as quantidadeBebidas, SUM(quantidadeProdutos) as quantidadeProdutos, "
                + "count(*) as atendimentos FROM vendas "
                + "WHERE data BETWEEN ? AND ? AND idFuncionario = ? GROUP BY data;";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, relatorio.getDataInicial());
            pst.setString(2, relatorio.getDataFinal());
            pst.setInt(3, relatorio.getBarbeiroId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Relatorio relatorioPorDia = new Relatorio();

                relatorioPorDia.setData(rs.getString("data"));
                relatorioPorDia.setNomeBarbeiro(rs.getString("nomeFuncionario"));
                relatorioPorDia.setHora(rs.getString("hora"));
                relatorioPorDia.setSoma(rs.getBigDecimal("totalDia").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setBebidas(rs.getInt("quantidadeBebidas"));
                relatorioPorDia.setProdutos(rs.getInt("quantidadeProdutos"));
                relatorioPorDia.setTotalServico(rs.getBigDecimal("totalServicos").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setDinheiro(rs.getInt("dinheiro"));
                relatorioPorDia.setCartao(rs.getInt("cartao"));
                relatorioPorDia.setCabelo(rs.getInt("cabelo"));
                relatorioPorDia.setBarba(rs.getInt("barba"));
                relatorioPorDia.setBarbaCabelo(rs.getInt("cabeloBarba"));

                relatorioPorDia.setTotalDinheiro(rs.getBigDecimal("totalDinheiro").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalCartao(rs.getBigDecimal("totalCartao").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalBebidas(rs.getBigDecimal("totalBebidas").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalProdutos(rs.getBigDecimal("totalProdutos").setScale(2, RoundingMode.DOWN));

                relatorioPorDia.setAtendimentos(rs.getInt("atendimentos"));

                return relatorioPorDia;

            }

            conexao.desconectar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public Relatorio totalVendaPeriodo2(Relatorio relatorio) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT  nomeFuncionario, sum(totalVenda) as totalPeriodo, "
                + "SUM(CASE WHEN totalBebidas != '' THEN totalBebidas ELSE 0 END) as totalBebidas, "
                + "SUM(CASE WHEN totalProdutos != '' THEN totalProdutos ELSE 0 END) as totalProdutos, "
                + "SUM(CASE WHEN totalServico != '' THEN totalServico ELSE 0 END) as totalServicos, "
                + "SUM(CASE WHEN valorOutros != '' THEN valorOutros ELSE 0 END) as totalOutros, "
                + "SUM(CASE WHEN pagamento = 'Dinheiro' THEN totalVenda ELSE 0 END) as totalDinheiro, "
                + "SUM(CASE WHEN pagamento = 'Cartão' THEN totalVenda ELSE 0 END) as totalCartao "
                + "FROM vendas "
                + "WHERE data BETWEEN ? AND ? AND idFuncionario = ?;";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, relatorio.getDataInicial());
            pst.setString(2, relatorio.getDataFinal());
            pst.setInt(3, relatorio.getBarbeiroId());
            ResultSet rs = pst.executeQuery();

            Relatorio relatorioPorDia = new Relatorio();
            while (rs.next()) {
                if(rs.getBigDecimal("totalPeriodo") == null){
                    relatorioPorDia = null;
                    return relatorioPorDia;
                }

                relatorioPorDia.setNomeBarbeiro(rs.getString("nomeFuncionario"));
                relatorioPorDia.setSoma(rs.getBigDecimal("totalPeriodo").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalBebidas(rs.getBigDecimal("totalBebidas").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalProdutos(rs.getBigDecimal("totalProdutos").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalServico(rs.getBigDecimal("totalServicos").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalOutros(rs.getBigDecimal("totalOutros").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalDinheiro(rs.getBigDecimal("totalDinheiro").setScale(2, RoundingMode.DOWN));
                relatorioPorDia.setTotalCartao(rs.getBigDecimal("totalCartao").setScale(2, RoundingMode.DOWN));

                return relatorioPorDia;

            }

            conexao.desconectar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
