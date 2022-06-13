package practice.implementaions.TheLedgerCo.models;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Customer extends User {

    public Customer(String name) {
        this.userName = name;
    }


}
