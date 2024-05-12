package ee.wtmn.ultimateguidetospringboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

}
