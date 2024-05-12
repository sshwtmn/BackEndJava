package ee.wtmn.ultimateguidetospringboot.controller;

import ee.wtmn.ultimateguidetospringboot.dto.BookDto;
import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.service.BookService;
import ee.wtmn.ultimateguidetospringboot.service.UserService;
import ee.wtmn.ultimateguidetospringboot.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final UserService userService;
    private final BookMapper bookMapper;

    @PostMapping("/create")
    public String createNewBook(@RequestBody Book book){
        Book savedBook;
        try {
            savedBook = bookService.create(book);
        }catch (Exception e){
            return e.getMessage();
        }
        return bookMapper.toDto(savedBook).toString();
    }

    @GetMapping("/take")
    public String takeBook(@RequestParam Long id, @RequestParam String email){
        try {
            bookService.takeBook(id, email);
        }catch (Exception e){
            return e.getMessage();
        }
        return "The book was successfully taken";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam Long id, @RequestParam String email){
        try {
            bookService.returnTakenBooks(id, email);
        }catch (Exception e){
            return e.getMessage();
        }
        return "The book was successfully returned";
    }

    @GetMapping("/show")
    public List<Book> showAllAvailableBooks(){
        List<Book> books = bookService.findAllAvailableBooks();
        return bookMapper.toDto(books);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable Long id){
        try {
            bookService.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }
        return "The book was successfully deleted";
    }





}
