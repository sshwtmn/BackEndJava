package ee.wtmn.ultimateguidetospringboot.repository;

import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.model.TakenBooks;
import ee.wtmn.ultimateguidetospringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface TakenBooksRepo extends JpaRepository<TakenBooks, Long> {

    Optional<TakenBooks> findTakenBooksByUserAndBookAndEndDateIsNull(User user, Book book);

    List<TakenBooks> findAllByUser(User user);
}

