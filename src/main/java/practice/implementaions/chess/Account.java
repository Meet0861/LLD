package practice.implementaions.chess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {
    private String name;
    private String password;

    private String email;
    private String phoneNo;
}
