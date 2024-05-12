package ee.wtmn.ultimateguidetospringboot.repository;

import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findAllBooksByAvailableIsTrue();

    List<Book> findBookByAvailableIsTrue();

    List<Book> findBooksByUser(User user);
}
