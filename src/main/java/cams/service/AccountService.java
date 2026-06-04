package cams.service;

import cams.domain.Account;
import java.util.List;

public interface AccountService {
    List<Account> allAccounts();
    List<Account> platinumTier();
    double calculateLiquidityPosition();
}
