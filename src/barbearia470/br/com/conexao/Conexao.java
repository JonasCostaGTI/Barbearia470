package barbearia470.br.com.conexao;

/**
 * @author jonascosta
 * @date 27/08/2017
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    String dataBase = "BD_Barbearia470.db";
    String Jdbc = "jdbc:sqlite";
    String dbUrl = Jdbc + ":" + dataBase;

    public Connection conectar() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(dbUrl);
            //System.out.println("Conectou na base " + dbUrl);
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public void desconectar() {
        try {
            Connection conn = DriverManager.getConnection(dbUrl);
            //System.out.println("Desconectou  da base " + dbUrl);
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
