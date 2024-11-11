package oussama.it.account_service.Services;

import oussama.it.account_service.Entities.BanckAccount;

import java.util.List;

public interface BanckAccountServices {
    public List<BanckAccount> getAllBanckAccounts();
    public BanckAccount getBanckAccount(String id);
    public void addBanckAccount(BanckAccount banckAccount);
    public void deleteBanckAccount(String id);
    public void saveAllBanckAccounts(List<BanckAccount> banckAccounts);

}
