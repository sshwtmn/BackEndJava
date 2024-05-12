package ee.wtmn.ultimateguidetospringboot.controller;
import ee.wtmn.ultimateguidetospringboot.model.Book;
import ee.wtmn.ultimateguidetospringboot.model.User;
import ee.wtmn.ultimateguidetospringboot.repository.UserRepo;
import ee.wtmn.ultimateguidetospringboot.service.BookService;
import ee.wtmn.ultimateguidetospringboot.service.UserService;
import ee.wtmn.ultimateguidetospringboot.mappers.BookMapper;
import ee.wtmn.ultimateguidetospringboot.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BookService bookService;
    private final UserMapper userMapper;
    private final BookMapper bookMapper;

    @GetMapping("/books/{email}")
    public List<Book> getBooksByUserEmail(@PathVariable String email){
        List<Book> books = userService.getAllByBooksByEmail(email);
        return bookMapper.toDto(books);
    }

    @GetMapping("/show")
    public List<User> showAllUsers(){
        List<User> users = userService.showAllUsers();
        return userMapper.toDto(users);
    }

    @DeleteMapping("/delete/{email}")
    public String deleteUserByEmail(@PathVariable String email){
        try {
            userService.deleteByEmail(email);
        }catch (Exception e){
            return e.getMessage();
        }
        return "The user successfully deleted";
    }

    @PostMapping("/create/{email}")
    public String createNewUser(@PathVariable String email){
        User user = new User();
        user.setEmail(email);
        try {
            userService.create(user);
            return userMapper.toDto(user).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
