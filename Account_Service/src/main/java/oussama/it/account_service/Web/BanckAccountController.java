package oussama.it.account_service.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oussama.it.account_service.Entities.BanckAccount;
import oussama.it.account_service.Repository.BanckAccountRepository;
import oussama.it.account_service.Services.BanckAccountServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/BanckAccount")
public class BanckAccountController {
    private final BanckAccountServices banckAccountServices;

    @GetMapping("/getAllBanckAccounts")
    public List<BanckAccount> getAllBanckAccounts() {
        return banckAccountServices.getAllBanckAccounts();
    }
    @GetMapping("/getBanckAccount/{id}")
    public BanckAccount getBanckAccount(@PathVariable String id) {
        return banckAccountServices.getBanckAccount(id);
    }

}