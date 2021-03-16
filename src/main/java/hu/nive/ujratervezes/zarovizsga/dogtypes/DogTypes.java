package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
    }

    public List<String> getDogsByCountry(String country) {
        return null;
    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create connection");
        }
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id FROM dog_types WHERE country = HUNGARY"))
        {
            List<String> dogs = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                dogs.add(name);
            }
            System.out.println(dogs);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not select", se);
        }
    }
}
