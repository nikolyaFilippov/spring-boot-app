package by.mysite.controllers;

import by.mysite.model.entities.Library;
import by.mysite.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LibraryController {

    private LibraryRepository libraryRepository;

    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Library> libraries = libraryRepository.findAll();
        model.addAttribute("libraries", libraries);
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Library library = libraryRepository.findById(id).get();
        model.addAttribute("library", library);
        return "library";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        libraryRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("add-library", "library", new Library());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "library") Library library) {
        libraryRepository.save(library);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") int id) {
        Library lib = libraryRepository.findById(id).get();
        return new ModelAndView("upd-library", "library", lib);
    }
}
