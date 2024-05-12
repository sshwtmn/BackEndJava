package ee.wtmn.ultimateguidetospringboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String name;
    @Column(name = "is_available")
    private boolean available;

    @ManyToOne
    private User user;
}
