package oussama.it.account_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import oussama.it.account_service.Clients.CustomerRestClient;
import oussama.it.account_service.Entities.BanckAccount;
import oussama.it.account_service.Entities.Customer;
import oussama.it.account_service.Enums.AccountType;
import oussama.it.account_service.Repository.BanckAccountRepository;
import oussama.it.account_service.Services.BanckAccountServices;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BanckAccountRepository banckAccountRepository, CustomerRestClient customerRestClient) {
        return args -> {
            List<Customer> allCustomers = customerRestClient.getAllCustomers();
            System.out.println("Nombre de clients récupérés: " + allCustomers.size()); // Log pour vérifier
            allCustomers.forEach(customer -> {
                for(AccountType accountType : AccountType.values()) {
                    BanckAccount banckAccount = BanckAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .solde(Math.random()*80000)
                            .type(accountType)
                            .coustmerId(customer.getId())
                            .createAt(LocalDate.now())
                            .currency("MAD")
                            .build();

                    banckAccountRepository.save(banckAccount);
                    System.out.println("Compte ajouté : " + banckAccount); // Log pour vérifier chaque ajout
                }
            });

            /*List<BanckAccount> banckAccountList = List.of(
                    BanckAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .solde(1500.50)
                            .createAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .currency("MAD")
                            .coustmerId(1L)
                            .build(),
                    BanckAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .solde(2000.50)
                            .createAt(LocalDate.now())
                            .type(AccountType.SAVING_ACCOUNT)
                            .coustmerId(2L)
                            .currency("MAD")
                            .build()

            );
            banckAccountServices.saveAllBanckAccounts(banckAccountList);*/

        };

    }
}
