package ee.wtmn.ultimateguidetospringboot.service;


import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getByEmail(String email);

    User create(User user);

    void deleteByEmail(String email);

    List<User> showAllUsers();

    List<Book> getAllByBooksByEmail(String email);


}
