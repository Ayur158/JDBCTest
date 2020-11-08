package chimbeev.testDB.dao;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseDAO {
    List<String> index() throws SQLException;

    String show(int id) throws SQLException;

    void drop(int id) throws SQLException;

    void add(String name, String lastName, String gender, String date, String countryOfBirth, String email) throws SQLException;
}
