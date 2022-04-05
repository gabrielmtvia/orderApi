package orgexample.sdj3.rest.orderapi.repositoryordao;

import org.springframework.stereotype.Repository;
import orgexample.sdj3.rest.orderapi.model.Order0;

import java.util.*;

// DAO***
@Repository // notify the Spring framework that it is a Java bean
public class OrderRepository {
  // N/B will use SOLID later
  private static final Map<Long, Order0> orderMap = new HashMap<Long, Order0>();

  // assuming that our data is persistent in the DB
  static {
    initDataSource();
    }

  private static void initDataSource() {
    Order0 o1 = new Order0(1L, "Exotic Sandwich for lunch", 55.00, true);
    Order0 o2 = new Order0(2L, "Regular pizza with Pepperoni", 23.00, false);
    Order0 o3 = new Order0(3L, "Pizza without pineapple", 35.00, false);

    orderMap.put(o1.getId(), o1);
    orderMap.put(o2.getId(), o2);
    orderMap.put(o3.getId(), o3);
  }

  // [C]rud operation: R-GET
  public Order0 findById(Long id) {
    System.out.println("1L = " + id);
    return orderMap.get(id);
  }

  // find all
  public List<Order0> findAll() {
    java.util.Collection<Order0> c = orderMap.values();
    List<Order0> order0List = new ArrayList<Order0>();
    order0List.addAll(c);
    return order0List;
  }

  // POST-ing C -- Create
  public Order0 save (Order0 order0) {
    orderMap.put(order0.getId(), order0);
    return order0;
  }

  // PUTTING U -- UPDATE
  public Order0 update(Order0 o) {
    // simply save the object
    orderMap.put(o.getId(), o);
    return o;
  }

  //

}
