package by.mysite.controllers;

import by.mysite.model.entities.Book;
import by.mysite.model.entities.BookInLibrary;
import by.mysite.model.repositories.BookRepository;
import by.mysite.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private LibraryRepository libraryRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping("/addBook/{id}")
    public ModelAndView addBook(@PathVariable int id) {
        return new ModelAndView("add-book", "book", new BookInLibrary(id));
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute(name = "book") BookInLibrary bookInLibrary) {
        Book book = new Book(bookInLibrary.getTitle(), bookInLibrary.getPages());
        book.setLibrary(libraryRepository.findById(bookInLibrary.getLibrary_id()).get());
        bookRepository.save(book);
        return "redirect:/view/" + bookInLibrary.getLibrary_id();
    }
}
