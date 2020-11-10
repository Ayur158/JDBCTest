package chimbeev.testDB.dao;

import chimbeev.testDB.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseDAO {
    List<Employee> index() throws SQLException;

    Employee show(int id) throws SQLException;

    void drop(int id) throws SQLException;

    void add(Employee employee) throws SQLException;

    void update(int id, Employee employee) throws SQLException;
}
