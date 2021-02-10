package chimbeev.testDB.controllers;

import chimbeev.testDB.dao.DatabaseDAOImpl;
import chimbeev.testDB.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("employee", dao.show(id));
        return "employers/show";
    }
    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        return "employers/new";
    }

    @PostMapping
    public String create (@ModelAttribute("employee") @Valid Employee employee, BindingResult result) throws SQLException {
        if (result.hasErrors()) return "employers/new";
        dao.add(employee);
        return "redirect:/employers";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) throws SQLException {
        model.addAttribute("employee", dao.show(id));
        return "employers/edit";
    }
    @PatchMapping("/{id}")
    public String update (@ModelAttribute("employee") @Valid Employee employee,
                          BindingResult result, @PathVariable("id") int id) throws SQLException {
        if (result.hasErrors()) return "employers/edit";
        dao.update(id, employee);
        return "redirect:/employers";
    }
    @DeleteMapping("/{id}")
    public String drop (@PathVariable("id") int id) throws SQLException {
        dao.drop(id);
        return "redirect:/employers";
    }
}
