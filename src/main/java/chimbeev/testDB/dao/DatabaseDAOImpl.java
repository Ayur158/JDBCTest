package chimbeev.testDB.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseDAOImpl implements DatabaseDAO {

    private final Connection connection;

    @Autowired
    public DatabaseDAOImpl() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb",
                "postgres", "12q123wa");
    }

    @Override
    public List<String> index() throws SQLException {
        List<String> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from employee");
        while (resultSet.next()) {
            list.add(resultSet.getString(1) + " "
                    + resultSet.getString(2) + " "
                    + resultSet.getString(3) + " "
                    + resultSet.getString(4) + " "
                    + resultSet.getString(5) + " "
                    + resultSet.getString(6) + " "
                    + resultSet.getString(7)
            );
        }
        return list;
    }

    @Override
    public String show(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  employee where id=" + id);
        resultSet.next();
        String employee = resultSet.getString(1) + " "
                + resultSet.getString(2) + " "
                + resultSet.getString(3) + " "
                + resultSet.getString(4) + " "
                + resultSet.getString(5) + " "
                + resultSet.getString(6) + " "
                + resultSet.getString(7);
        return employee;
    }

    @Override
    public void drop(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM  employee where id=" + id);
    }

    @Override
    public void add(String name, String lastName, String gender, String date, String countryOfBirth, String email) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into employee (first_name, last_name, gender, email, date_of_birth, country_of_birth) " +
                "values ('" + name + "', '" + lastName + "', '" + gender + "', '" + email + "', '" + date + "', '" + countryOfBirth + "')");
    }
}
