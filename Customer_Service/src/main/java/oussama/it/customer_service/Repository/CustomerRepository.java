package oussama.it.customer_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oussama.it.customer_service.Entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
