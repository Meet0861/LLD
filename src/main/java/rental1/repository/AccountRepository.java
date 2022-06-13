package rental1.repository;

import rental1.exceptions.AccountDoesNotExistsException;
import rental1.model.account.Account;

public interface AccountRepository {
    Account createAccount(Account account);

    void resetPassword(String userId, String password) throws AccountDoesNotExistsException;
}
