package rental1.model.reservation;

import rental1.model.common.Address;
import rental1.model.common.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalLocation {
    private String id;
    private Address address;
    private Coordinates coordinates;
}
