package orgexample.sdj3.rest.orderapi.model;

public class Order0 {
  private Long id;
  private String description;
  private double amount;
  private boolean delivered;

  public Order0(Long id, String description, double amount, boolean delivered) {
    this.id = id;
    this.description = description;
    this.amount = amount;
    this.delivered = delivered;
  }

  public Order0() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public boolean isDelivered() {
    return delivered;
  }

  public void setDelivered(boolean delivered) {
    this.delivered = delivered;
  }
}
