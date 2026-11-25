import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection{
    // variables de connection
    static String userName = "root";
    static String password = "";
    static String serverName = "127.0.0.1";
    static String portNumber = "3306";
    //        String portNumber = "8889"; // Port par défaut sur MAMP
    static String tableName = "personne";
    
    // il faut une base nommee testPersonne !
    static String dbName = "testpersonne";
    
    private static Connection connect;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        // chargement du driver jdbc
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // creation de la connection
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        String urlDB = "jdbc:mysql://" + serverName + ":";
        urlDB += portNumber + "/" + dbName;
        System.out.println(urlDB);
        connect = DriverManager.getConnection(urlDB, connectionProps);
        //Connection connect = DriverManager.getConnection("jdbc:mysql://db4free.net/testpersonne","scruzlara", "root2014");
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if (connect == null)
            new DBConnection();
        return connect;
    }
    
    public static void setNomDB(String nom){
        dbName = nom;
        try{
            new DBConnection();
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
