package ee.wtmn.ultimateguidetospringboot.service.impl;

import ee.wtmn.ultimateguidetospringboot.exception.LibraryException;
import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.model.User;
import ee.wtmn.ultimateguidetospringboot.repository.BookRepo;
import ee.wtmn.ultimateguidetospringboot.repository.UserRepo;
import ee.wtmn.ultimateguidetospringboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private BookRepo bookRepo;

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User create(User user) {
        if (userRepo.existsUserByEmail(user.getEmail())){
            throw new LibraryException("This user is already exists");
        }
        return userRepo.save(user);
    }

    @Override
    public void deleteByEmail(String email) {
    Optional<User> userOptional = userRepo.findUserByEmail(email);
    if (userOptional.isEmpty()) throw new LibraryException("Wrong email");
    User user = userOptional.get();
    List<Book> books = bookRepo.findBooksByUser(user);
    for (Book book : books){
        book.setUser(null);
        book.setAvailable(true);
        bookRepo.save(book);
    }
    userRepo.delete(user);
    }

    @Override
    public List<User> showAllUsers() {
        return userRepo.findAll();
    }


    @Override
    public List<Book> getAllByBooksByEmail(String email) {
        Optional<User> userOptional = userRepo.findUserByEmail(email);
        if (userOptional.isEmpty()){
            return Collections.emptyList();
        }
        return bookRepo.findBooksByUser(userOptional.get());
    }
}
