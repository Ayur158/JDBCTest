package chimbeev.testDB.controllers;

import chimbeev.testDB.dao.DatabaseDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/employers")
public class EmployersController {
    private final DatabaseDAOImpl dao;

    @Autowired
    public EmployersController(DatabaseDAOImpl dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("employers", dao.index());
        return "employers/index";
    }
}
