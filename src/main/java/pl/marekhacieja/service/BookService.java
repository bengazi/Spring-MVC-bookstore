package pl.marekhacieja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.marekhacieja.model.Book;
import pl.marekhacieja.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addAttributeBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
    }

}
