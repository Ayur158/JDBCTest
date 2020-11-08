package chimbeev.testDB;


import chimbeev.testDB.dao.DatabaseDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<String> list;
        DatabaseDAOImpl dao = new DatabaseDAOImpl();
        dao.add("Tom", "Cat", "Male", "1999-11-10", "USA", "TomKillJerry@gmail.com");
        list = dao.index();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
