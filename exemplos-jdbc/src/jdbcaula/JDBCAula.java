package jdbcaula;
/*
    @Roger
*/

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBCAula {
    
    static void inserir(Connection cnn) throws SQLException{
        String sql = "INSERT INTO contato (nome,endereco,email,data_nascimento) values (?,?,?,?)";
        PreparedStatement inserir = cnn.prepareStatement(sql);
        inserir.setString(1, "Roger");
        inserir.setString(2, "Faculdade - META");
        inserir.setString(3, "fulano@gmail.com");
        inserir.setDate(4, data(19,05,1990));
        inserir.execute();
    }
    static void deletar(Connection cnn, int id) throws SQLException{
        String sql = "DELETE FROM contato WHERE id=?";
        PreparedStatement deletar = cnn.prepareStatement(sql);
        deletar.setInt(1, id);
        deletar.execute();
    }
    static void atualizar(Connection cnn, String id) throws SQLException{
        String sql = "UPDATE contaos set name=?,endereco=?,email=?,data_nascimento=? WHERE id ="+id;
        PreparedStatement atualiza = cnn.prepareStatement(sql);
        atualiza.setString(1, "Roger2");
        atualiza.setString(2, "Renascer");
        atualiza.setString(3, "ciclano@gmail.com");
        atualiza.setDate(4, data(19,05,1991));
        atualiza.execute();
    }
    static Date data(int dia, int mes, int ano){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,ano);
        calendar.set(Calendar.MONTH,mes);
        calendar.set(Calendar.DAY_OF_MONTH,dia);
        return new Date(calendar.getTimeInMillis());
    }
    static void selecionar(Connection cnnn) throws SQLException{
        String sql = "SELECT * FROM contato";
        PreparedStatement select = cnnn.prepareStatement(sql);
        ResultSet rSet = select.executeQuery();
        while (rSet.next()) {
            System.out.println("ID: "+rSet.getString("id"));
            System.out.println("NOME: "+rSet.getString("nome"));
            System.out.println("ENDEREÇO: "+rSet.getString("endereco"));
            System.out.println("DATA DE NASCIMENTO: "+rSet.getString("data_nascimento"));
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String conexao = "valor";
        try {
            Connection mysql = DriverManager.getConnection(
                    "jdbc:mysql://localhost/agenda",
                    "root",
                    "");
                    System.out.println("Conectado!");
        } catch (SQLException e) {
            System.out.println("Erro: "+e.getMessage());
        }
       }    
    
}
