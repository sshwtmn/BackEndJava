package ee.wtmn.ultimateguidetospringboot.mappers;

import ee.wtmn.ultimateguidetospringboot.dto.UserDto;
import ee.wtmn.ultimateguidetospringboot.model.User;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setEmail( user.getEmail() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );

        return user;
    }

    @Override
    public List<User> toDto(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( users.size() );
        for ( User user : users ) {
            list.add( user );
        }

        return list;
    }
}
