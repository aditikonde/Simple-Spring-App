package spirng.mvcframework.Simple.Spring.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spirng.mvcframework.Simple.Spring.App.repositories.AuthorRepository;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/authors") // points to the url to hit on the browser
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";  // points to the view or html location to be rendered
    }
}
