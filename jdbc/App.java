import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try {
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String jdbcURL = "jdbc:mysql://localhost:3306/laporan_masyarakat";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM masyarakat";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String kolom1 = resultSet.getString("nama");
                String kolom2 = resultSet.getString("nik");
                System.out.println(kolom1 + " | " + kolom2);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
