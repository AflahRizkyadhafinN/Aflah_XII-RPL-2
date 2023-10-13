// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

// public class App {
//     public static void main(String[] args) throws Exception {
//         try {
//             String jdblURL = "http://127.0.0.1:3306/laporan_masyarakat";
//             String usernamedb = "root";
//             String password = "";
//             Connection connection = DriverManager.getConnection(jdblURL, usernamedb, password);

//             Statement statement = connection.createStatement();
//             String sqlQuery = "SELECT * FROM masyarakat";
//             ResultSet resultSet = statement.executeQuery(sqlQuery);

//             while (resultSet.next()) {
//                 String nama = resultSet.getString("nama");
//                 String username = resultSet.getString("username");
//                 System.out.println(nama + " : " + username);
//             }
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/laporan_masyarakat";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM nama_tabel";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String kolom1 = resultSet.getString("nama_kolom1");
                int kolom2 = resultSet.getInt("nama_kolom2");
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
