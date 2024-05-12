package ee.wtmn.ultimateguidetospringboot.service;

import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.model.TakenBooks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book create(Book book);

    TakenBooks takeBook(Long id, String email);

    TakenBooks returnTakenBooks(Long bookId, String email);

    List<Book> findAllAvailableBooks();

    void deleteById(Long id);

}
