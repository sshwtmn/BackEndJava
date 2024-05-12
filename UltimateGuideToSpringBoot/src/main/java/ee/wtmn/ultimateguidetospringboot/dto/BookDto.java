package ee.wtmn.ultimateguidetospringboot.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class BookDto {
    private Long id;
    private String author;
    private String name;
}
