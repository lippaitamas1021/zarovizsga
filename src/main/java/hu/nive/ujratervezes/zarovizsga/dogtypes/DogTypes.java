package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private List<String> dogNames = new ArrayList<>();
    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("SELECT NAME FROM dog_types WHERE lower(country) = ? ORDER BY NAME");) {
            stmt.setString(1, country);
            return convertToNames(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public List<String> convertToNames(PreparedStatement stmt) {
        List<String> result = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    result.add(name.toLowerCase());
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        return result;
    }
}