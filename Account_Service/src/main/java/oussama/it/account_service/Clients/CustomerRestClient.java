package oussama.it.account_service.Clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import oussama.it.account_service.Entities.Customer;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("api/customers/getCustomer/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("api/customers/getCustomers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    List<Customer> getAllCustomers();


    default Customer getDefaultCustomer(Long id, Exception e){
        return Customer.builder()
                .id(id)
                .firstName("Source not available")
                .lastName("Source Not Available")
                .email("Source Not Available")
                .build();
    }

    default List<Customer> getDefaultCustomers(Exception e){
        return List.of();
    }

}
