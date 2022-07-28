package test;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PruebaDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/claves?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            
            //Class.forName("com.mysql.ck.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","123456789");
            Statement sentencia = conexion.createStatement();
            var query = "SELECT Id_Persona, Nombre FROM personas";
            ResultSet  resultado= sentencia.executeQuery(query);
            
            while(resultado.next()){
                System.out.print("ID: "+resultado.getInt("Id_Persona"));
                System.out.println(" Nombre: "+resultado.getString("Nombre"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
