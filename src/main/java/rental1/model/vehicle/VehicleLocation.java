package rental1.model.vehicle;

import rental1.model.common.Address;
import rental1.model.common.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleLocation {
    private String locationId;
    private Address address;
    private Coordinates coordinates;
}
