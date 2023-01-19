import javax.swing.plaf.synth.SynthToolTipUI;
import java.sql.*;
import java.util.ArrayList;

public class Start {
    static final String DB_NAME = "newdb";
    static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    static final String USER = "root";
    static final String PASSWORD = "060891";

    public static void main(String[] args) {

        ArrayList<String> surnames = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT last_name, first_name FROM students");

            while(resultSet.next ()){
                System.out.println ("NAME: " + resultSet.getString("first_name"));
                surnames.add (resultSet.getString("last_name"));
            }

            System.out.println ("SURNAMES : " + surnames);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
