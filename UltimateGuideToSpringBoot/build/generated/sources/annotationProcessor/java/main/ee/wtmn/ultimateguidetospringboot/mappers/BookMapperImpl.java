package ee.wtmn.ultimateguidetospringboot.mappers;

import ee.wtmn.ultimateguidetospringboot.dto.BookDto;
import ee.wtmn.ultimateguidetospringboot.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T22:46:56+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setName( book.getName() );

        return bookDto;
    }

    @Override
    public List<Book> toDto(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( books.size() );
        for ( Book book : books ) {
            list.add( book );
        }

        return list;
    }

    @Override
    public Book toEntity(BookDto dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( dto.getId() );
        book.setAuthor( dto.getAuthor() );
        book.setName( dto.getName() );

        return book;
    }
}
