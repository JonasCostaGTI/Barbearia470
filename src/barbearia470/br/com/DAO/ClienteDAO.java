package barbearia470.br.com.DAO;

import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jonascosta
 * @date 03/10/2017
 *
 */
public class ClienteDAO {

    public boolean salvar(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO Clientes (nome, sobreNome, email, telefone, dataNascimento, notificacao) "
                    + "VALUES(?,?,?,?,?,?)");

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSobre_nome());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getData_nascimento());
            pst.setBoolean(6, cliente.isEnviar_notificacao());

            pst.execute();
            conexao.desconectar();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean excluir(int idCliente) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM Clientes WHERE id = ?");

            pst.setInt(1, idCliente);

            pst.execute();
            conexao.desconectar();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public boolean editar(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE Clientes SET nome = ?, "
                    + "sobreNome = ? , email = ?, telefone = ?, dataNascimento = ?, notificacao = ? "
                    + "WHERE id = ?");

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSobre_nome());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getData_nascimento());
            pst.setBoolean(6, cliente.isEnviar_notificacao());
            pst.setInt(7, cliente.getId());
            

            pst.execute();
            conexao.desconectar();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
