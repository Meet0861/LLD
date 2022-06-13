package practice.implementaions.Splitwise;


import practice.implementaions.Splitwise.enums.Command;
import practice.implementaions.Splitwise.enums.ExpenseType;
import practice.implementaions.Splitwise.exceptions.ExpenseTypeNotFoundException;
import practice.implementaions.Splitwise.exceptions.UserNotFoundException;
import practice.implementaions.Splitwise.models.ExactSplit;
import practice.implementaions.Splitwise.models.Split;
import practice.implementaions.Splitwise.repositories.ExpenseRepository;
import practice.implementaions.Splitwise.services.ExpenseService;

import java.util.ArrayList;
import java.util.List;

import static practice.implementaions.Splitwise.enums.Command.EXPENSE;
import static practice.implementaions.Splitwise.enums.Command.SHOW;

public class Driver {
    public static void main(String[] args) throws UserNotFoundException, ExpenseTypeNotFoundException {
        ExpenseService expenseService = new ExpenseService();
        ExpenseRepository expenseRepository = new ExpenseRepository();
        expenseService.createUser("Meet", "meetahuja1680@gmial.com", "9501377828");
        expenseService.createUser("Ahuja", "meetahuja1680@gmial.com", "9501377828");
        expenseService.createUser("Manmeet", "meetahuja1680@gmial.com", "9501377828");
        List<Command> commands = new ArrayList<>();
        commands.add(SHOW);
        commands.add(EXPENSE);
        commands.add(SHOW);


        for (Command command : commands) {
            switch (command) {
                case SHOW:
                    expenseService.showBalance();
                    break;
                case EXPENSE:
                    Integer userId2 = 2;
                    Integer userId3 = 3;
                    Integer paidBy = 1;
                    Double amount = 1000.0;
                    int noOfUsers = 1;
                    List<Split> splits = new ArrayList<>();
                    ExpenseType expenseType = ExpenseType.EXACT;
                    switch (expenseType) {
                        case EXACT:
                            splits.add(new ExactSplit(expenseRepository.getUserById(userId2), 250));
                            splits.add(new ExactSplit(expenseRepository.getUserById(userId3), 750));
                            expenseService.createExpense(expenseType, amount, paidBy, splits, null);
                            break;
                    }
                    break;
            }
        }
    }
}
