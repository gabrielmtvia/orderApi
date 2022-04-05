package orgexample.sdj3.rest.orderapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import orgexample.sdj3.rest.orderapi.model.User;
import orgexample.sdj3.rest.orderapi.repositoryordao.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping("/testusercontroller")
  @ResponseBody()
  public String welcome() {
    return "Test user controller";
  }
  // GET-ting all users
  @RequestMapping (value = "/users",
      method = RequestMethod.GET,
      produces = {//MediaType.APPLICATION_XML_VALUE,
          MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }


  // POSTing C -- Create order
  @RequestMapping (value = "/createUser",
      method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_XML_VALUE,
          MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public User createUser(@RequestBody User o) {
    System.out.println("[Backend - Server] Creating order: " + o.getId());
    return userRepository.save(o);
  }

  /* PUT/PATCH U -- Update
  @RequestMapping (value = "/users/{id}",
      method = RequestMethod.PUT,
      produces = {MediaType.APPLICATION_XML_VALUE,
          MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public User updateUser(@RequestBody User u) {
    System.out.println("[Backend - Server] Updating user: " + u.getId());
    return userRepository.update(u);
  }*/

}
