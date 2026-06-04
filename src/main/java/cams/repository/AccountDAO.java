package cams.repository;

import cams.domain.Account;
import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    List<Account> findAll();
    Optional<Account> findById(long accountId);
}
