package orgexample.sdj3.rest.orderapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import orgexample.sdj3.rest.orderapi.model.Order0;
import orgexample.sdj3.rest.orderapi.repositoryordao.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {
  private OrderRepository orderRepository;

  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  // after running the APP, try typing in to the web browser: "http://localhost:8080/home"
  @RequestMapping("/home")
  @ResponseBody()
  public String welcome() {
    return "Welcome to the world of RESTful APIs!";
  }

  //GET-ting an order given the id

  //  @RequestMapping (value = "/orders/{id}",
  //      method = RequestMethod.GET,
  //      produces = {MediaType.APPLICATION_JSON_VALUE,
  //          MediaType.APPLICATION_XML_VALUE})
  //
  //  @ResponseBody
  //  public Order0 getOrderById(@PathVariable("id") Long id) {
  //    return orderRepository.findById(id);
  //  }

  // GET-ting all orders
  @RequestMapping (value = "/orders",
                  method = RequestMethod.GET,
                  produces = {//MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public List<Order0> getAllOrders() {
    return orderRepository.findAll();
  }


  // POSTing C -- Create order
  @RequestMapping (value = "/createOrder",
      method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_XML_VALUE,
                  MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public Order0 createOrder(@RequestBody Order0 o) {
    System.out.println("[Backend - Server] Creating order: " + o.getId());
    return orderRepository.save(o);
  }

  // PUT/PATCH U -- Update
  @RequestMapping (value = "/orders/{id}",
      method = RequestMethod.PUT,
      produces = {MediaType.APPLICATION_XML_VALUE,
          MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public Order0 updateOrder(@RequestBody Order0 o) {
    System.out.println("All orders: " + orderRepository.findAll().toString());
    System.out.println("[Backend - Server] Updating order: " + o.getId());
    return orderRepository.update(o);
  }
}
