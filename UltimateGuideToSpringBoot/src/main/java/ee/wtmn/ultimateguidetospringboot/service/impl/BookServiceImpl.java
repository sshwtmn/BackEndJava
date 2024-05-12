package ee.wtmn.ultimateguidetospringboot.service.impl;

import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.exception.LibraryException;
import ee.wtmn.ultimateguidetospringboot.model.TakenBooks;
import ee.wtmn.ultimateguidetospringboot.model.User;
import ee.wtmn.ultimateguidetospringboot.repository.BookRepo;
import ee.wtmn.ultimateguidetospringboot.repository.TakenBooksRepo;
import ee.wtmn.ultimateguidetospringboot.repository.UserRepo;
import ee.wtmn.ultimateguidetospringboot.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;
    private UserRepo userRepo;
    private TakenBooksRepo takenBooksRepo;




    @Override
    public Book create(Book book) {
        if (bookRepo.exists(Example.of(book))){
            throw new LibraryException("This book is already exits");
        }
        book.setAvailable(true);
        return bookRepo.save(book);
    }

    public TakenBooks takeBook(Long bookId, String email) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        if (bookOptional.isEmpty()) throw new LibraryException("wrong book id");

        Book book = bookOptional.get();

        if (!book.isAvailable()) throw new LibraryException("this book is taken");

        Optional<User> userOptional = userRepo.findUserByEmail(email);

        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            User newUser = new User();
            newUser.setEmail(email);
            user = userRepo.save(newUser);
        }
        TakenBooks takenBooks = new TakenBooks(null, LocalDate.now(), null, user, book);
        TakenBooks savedTakenBooks = takenBooksRepo.save(takenBooks);

        book.setAvailable(false);
        book.setUser(user);

        bookRepo.save(book);

        return savedTakenBooks;
    }

    public TakenBooks returnTakenBooks(Long bookId, String email) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        if (bookOptional.isEmpty()) throw new LibraryException("Wrong book id");
        Book book = bookOptional.get();

        Optional<User> userOptional = userRepo.findUserByEmail(email);
        if (userOptional.isEmpty()) throw new LibraryException("Wrong user id");
        User user = userOptional.get();

        Optional<TakenBooks> takenBooksByUserAndBook = takenBooksRepo.
                findTakenBooksByUserAndBookAndEndDateIsNull(user, book);
        if (takenBooksByUserAndBook.isEmpty())
            throw new LibraryException("Such record does not exist");

        TakenBooks takenBooks = takenBooksByUserAndBook.get();

        book.setUser(null);
        book.setAvailable(true);

        takenBooks.setEndDate(LocalDate.now());

        takenBooksRepo.save(takenBooks);
        bookRepo.save(book);

        return takenBooks;
    }
    public List<Book> findAllAvailableBooks() {
        return bookRepo.findBookByAvailableIsTrue();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isEmpty()) {
            throw new LibraryException("Wrong book id");
        }
        Book book = optionalBook.get();
        bookRepo.delete(book);
    }

}
