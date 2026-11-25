import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personne{
    private int id;
    private String nom, prenom;
    
    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.id = -1;
    }
    
    public static ArrayList<Personne> findAll() throws SQLException, ClassNotFoundException{
        Connection connect = DBConnection.getConnection();
        
        String SQLPrep = "SELECT * FROM Personne;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
        
        ArrayList<Personne> personnes = new ArrayList<>();
        
        // s'il y a un resultat
        while (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int id = rs.getInt("id");
            
            Personne p = new Personne(nom, prenom);
            p.setId(id);
            
            personnes.add(p);
        }
        
        return personnes;
    }
    
    public static Personne findById(int id) throws SQLException, ClassNotFoundException{
        Connection connect = DBConnection.getConnection();
        
        String SQLPrep = "SELECT * FROM Personne WHERE id=?;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.setInt(1, id);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
        
        Personne p = null;
        
        // s'il y a un resultat
        if (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            
            p = new Personne(nom, prenom);
            p.setId(id);
        }
        
        return p;
    }
    
    public static ArrayList<Personne> findByName(String name) throws SQLException, ClassNotFoundException{
        Connection connect = DBConnection.getConnection();
        
        String SQLPrep = "SELECT * FROM Personne WHERE nom=?;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.setString(1, name);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
        
        ArrayList<Personne> personnes = new ArrayList<>();
        
        // s'il y a un resultat
        while (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int id = rs.getInt("id");
            
            Personne p = new Personne(nom, prenom);
            p.setId(id);
            
            personnes.add(p);
        }
        
        return personnes;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getPrenom(){
        return prenom;
    }
}
