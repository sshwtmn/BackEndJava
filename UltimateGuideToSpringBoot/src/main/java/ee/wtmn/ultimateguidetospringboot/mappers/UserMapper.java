package ee.wtmn.ultimateguidetospringboot.mappers;

import ee.wtmn.ultimateguidetospringboot.model.User;
import ee.wtmn.ultimateguidetospringboot.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

    List<User> toDto (List<User> users);
}
