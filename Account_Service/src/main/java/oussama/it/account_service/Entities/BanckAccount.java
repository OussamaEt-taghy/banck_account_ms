package oussama.it.account_service.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import oussama.it.account_service.Enums.AccountType;

import java.time.LocalDate;
@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class BanckAccount {
    @Id
    private String id;
    private double solde;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long coustmerId;
    @Transient
    private Customer customer;
}
