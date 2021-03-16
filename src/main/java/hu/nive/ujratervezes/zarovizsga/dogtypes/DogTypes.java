package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private List<String> dogNames = new ArrayList<>();
    private MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select name from dog_types where country = ?");) {
            stmt.setString(1, country);
            try (
                    ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    dogNames.add(name);
                }
                return dogNames;
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Can not select dog");
        }
    }
}