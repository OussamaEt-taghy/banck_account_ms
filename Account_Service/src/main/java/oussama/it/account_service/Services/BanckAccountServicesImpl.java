package oussama.it.account_service.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oussama.it.account_service.Clients.CustomerRestClient;
import oussama.it.account_service.Entities.BanckAccount;
import oussama.it.account_service.Entities.Customer;
import oussama.it.account_service.Repository.BanckAccountRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BanckAccountServicesImpl implements BanckAccountServices{

    private final BanckAccountRepository banckAccountRepository;

    private final CustomerRestClient customerRestClient;

    public BanckAccountServicesImpl(BanckAccountRepository banckAccountRepository, CustomerRestClient customerRestClient) {
        this.banckAccountRepository = banckAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public List<BanckAccount> getAllBanckAccounts() {
        List<BanckAccount> banckAccounts = banckAccountRepository.findAll();

        // Vérification avant d'accéder à l'ID du client
        banckAccounts.forEach(banckAccount -> {
            if (banckAccount.getCustomer() != null && banckAccount.getCustomer().getId() != null) {
                banckAccount.setCustomer(customerRestClient.findCustomerById(banckAccount.getCustomer().getId()));
            } else {
                System.out.println("Customer is null for account ID: " + banckAccount.getId());
            }
        });

        return banckAccounts;
    }

    @Override
    public BanckAccount getBanckAccount(String id) {
        BanckAccount banckAccount = banckAccountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with ID: " + id));

        if (banckAccount.getCustomer() != null && banckAccount.getCustomer().getId() != null) {
            Customer customer = customerRestClient.findCustomerById(banckAccount.getCustomer().getId());
            banckAccount.setCustomer(customer);
        } else {
            System.out.println("Customer is null for account ID: " + banckAccount.getId());
        }

        return banckAccount;
    }

    @Override
    public void addBanckAccount(BanckAccount banckAccount) {
        banckAccountRepository.save(banckAccount);

    }
    @Override
    public void deleteBanckAccount(String id) {
        banckAccountRepository.deleteById(id);

    }

    @Override
    public void saveAllBanckAccounts(List<BanckAccount> banckAccounts) {
        banckAccountRepository.saveAll(banckAccounts);
    }
}
