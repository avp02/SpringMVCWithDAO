package avp.com.spring_mvc_dao.controllers;

import avp.com.spring_mvc_dao.dao.PersonDao;
import avp.com.spring_mvc_dao.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }

//    @GetMapping("/new") // можно так
//    public String newPerson(Model model) {
//        model.addAttribute("person", new Person());
//        return "people/new";
//    }

    @GetMapping("/new") // меньше кода
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person) {
        personDao.save(person);
        return "redirect:/people";
    }

}
