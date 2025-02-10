package backend.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerController {
  private final CustomerRepository repository;

  CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/customers")
  List<Customer> all() {
    return repository.findAll();
  }

  @GetMapping("/customers/{id}")
  Customer one(@PathVariable String id) {
    Optional<Customer> customer = repository.findById(id);
    return customer.orElseThrow(() -> new CustomerNotFoundException(id));
  }

  @PostMapping("/customers")
  Customer newCustomer(@RequestBody Customer newCustomer) {
    return repository.save(newCustomer);
  }

  // Use this endopoint send a post request with a JSON List
  // You can use the test.json file:
  /*
   * 'curl -X POST localhost:8080/customers/list -H \
   * 'Content-type:application/json' -d @test.json'
   */
  @PostMapping("/customers/list")
  List<Customer> newCustomers(@RequestBody List<Customer> newCustomers) {
    return repository.saveAll(newCustomers);
  }

  @DeleteMapping("/customers/{id}")
  void deleteCustomer(@PathVariable String id) {
    repository.deleteById(id);
  }
}
