
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/srikanth?user=root&password=nsr@6321";
       // Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/foobar", "sa", null).load();
        try{
            try(Connection conn = DriverManager.getConnection(jdbcUrl)){
                System.out.println("Connected to "+conn.getMetaData().getDatabaseProductName());

            }
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
