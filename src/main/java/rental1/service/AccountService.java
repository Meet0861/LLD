package rental1.service;

import rental1.exceptions.AccountDoesNotExistsException;
import rental1.model.account.Account;
import rental1.model.account.AccountType;

public interface AccountService {
    Account createAccount(Account account, AccountType accountType);

    void resetPassword(String userId, String password,
                       AccountType accountType) throws AccountDoesNotExistsException;
}
