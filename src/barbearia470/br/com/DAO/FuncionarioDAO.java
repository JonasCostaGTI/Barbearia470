package barbearia470.br.com.DAO;

import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jonascosta
 * @date 01/09/2017
 *
 */
public class FuncionarioDAO {

    public boolean salvar(Funcionario funcionario) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO Funcionarios (nome, telefone, cpf, cnpj, email, dataContratado, dataDispensado, ativo) "
                    + "VALUES(?,?,?,?,?,?,?,?)");

            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getTelefone());
            pst.setString(3, funcionario.getCPF());
            pst.setString(4, funcionario.getCNPJ());
            pst.setString(5, funcionario.getEmail());
            pst.setString(6, funcionario.getDataContratado());
            pst.setString(7, funcionario.getDataDispensado());
            pst.setBoolean(8, funcionario.isAtivo());

            pst.execute();
            conexao.desconectar();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean editar(Funcionario funcionario) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE Funcionarios SET nome = ?, "
                    + "telefone = ? , cpf = ?, cnpj = ?, email = ?, dataContratado = ?, dataDispensado = ?, ativo = ?"
                    + "WHERE funincionarioID = ?");

            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getTelefone());
            pst.setString(3, funcionario.getCPF());
            pst.setString(4, funcionario.getCNPJ());
            pst.setString(5, funcionario.getEmail());
            pst.setString(6, funcionario.getDataContratado());
            pst.setString(7, funcionario.getDataDispensado());
            pst.setBoolean(8, funcionario.isAtivo());
            pst.setInt(9, funcionario.getFuncionarioId());

            pst.execute();
            conexao.desconectar();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean excluir(int id) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM funcionarios WHERE funincionarioID = ?");

            pst.setInt(1, id);

            pst.execute();
            conexao.desconectar();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Funcionario pegaFuncionarioPorNome(String nomeFuncionario) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT funincionarioID, nome, telefone, cpf, email, dataContratado, dataDispensado, ativo FROM Funcionarios WHERE nome = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, nomeFuncionario);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarioId(rs.getInt("funincionarioID"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCPF(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataDispensado(rs.getString("dataDispensado"));
                funcionario.setDataContratado(rs.getString("dataContratado"));

                return funcionario;

            }

            conexao.desconectar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;

    }

}
