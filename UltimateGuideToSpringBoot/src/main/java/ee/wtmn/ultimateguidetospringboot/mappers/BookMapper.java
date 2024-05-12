package ee.wtmn.ultimateguidetospringboot.mappers;

import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);

    List<Book> toDto(List<Book> books);

    Book toEntity(BookDto dto);
}
