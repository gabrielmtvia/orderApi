package orgexample.sdj3.rest.orderapi.service;

import org.springframework.stereotype.Service;
import orgexample.sdj3.rest.orderapi.model.User;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User getUserById(long id);
    List<User> getAllUsers();
    String deleteUser(long id);
    User updateUser(User user);
    User getUserByEmail(String email);
}
