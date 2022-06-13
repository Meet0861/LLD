package rental1.service;

import rental1.exceptions.AccountDoesNotExistsException;
import rental1.model.account.Account;
import rental1.model.account.AccountType;
import rental1.repository.AccountRepository;
import rental1.repository.AccountRepositoryFactory;

public class AccountServiceImpl implements AccountService {

    @Override
    public Account createAccount(Account account, AccountType accountType) {
        AccountRepository accountRepository =
                AccountRepositoryFactory.getAccountRepository(accountType);
        return accountRepository.createAccount(account);
    }

    public void resetPassword(String userId, String password,
                              AccountType accountType) throws AccountDoesNotExistsException {
        AccountRepository accountRepository =
                AccountRepositoryFactory.getAccountRepository(accountType);
        accountRepository.resetPassword(userId, password);
    }
}
