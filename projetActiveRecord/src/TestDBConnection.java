import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class TestDBConnection {

    /**
     * Test d'
     * Cas : l
     */
    @Test
    public void testDuplication() throws SQLException, ClassNotFoundException {
        Connection i = DBConnection.getConnection();
        Connection i2 = DBConnection.getConnection();
        boolean c = i==i2;

        assertEquals(c,true );
    }
    @Test
    public void testChangementBD() throws SQLException, ClassNotFoundException {
        String nom=null;
        Connection i = DBConnection.getConnection();
        DBConnection.setNomDB("test");
        i=DBConnection.getConnection();

        String SQLPrep = "SELECT * FROM Personne;";
        PreparedStatement prep1 = i.prepareStatement(SQLPrep);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
        if (rs.next()) {
            nom = rs.getString("nom");
        }

        assertEquals(nom,null);
    }
}
