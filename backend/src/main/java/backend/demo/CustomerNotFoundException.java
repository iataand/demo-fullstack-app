package backend.demo;

public class CustomerNotFoundException extends RuntimeException {
  public CustomerNotFoundException(String id) {
    super("Could not find customer " + id);
  }
}
