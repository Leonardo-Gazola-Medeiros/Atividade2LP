package leo.atividade2.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorH2 {

    public String namedatabase = "test";
    private String url = "jdbc:h2:./test";
    private String user = "sa";
    private String password = "";

    public Connection fileconnection(){
        try {
            Class.forName("org.h2.Driver");
            Connection connectData = DriverManager.getConnection(url,user,password);
            System.out.println("Conectado com Sucesso!");
            return connectData;
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            return null;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;

        }

    }


}
