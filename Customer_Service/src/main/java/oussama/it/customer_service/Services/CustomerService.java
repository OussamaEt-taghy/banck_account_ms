package oussama.it.customer_service.Services;

import oussama.it.customer_service.Entities.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public Customer getCustomer(Long id);
    public void saveAll(List<Customer> customers);

}
