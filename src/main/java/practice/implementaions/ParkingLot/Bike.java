package practice.implementaions.ParkingLot;

public class Bike implements Vehicles{

    private String vehicleNo, vehicleColour;
    private VehicleType vehicleType;

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }

    @Override
    public void setType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public void setColour(String colour) {
        this.vehicleColour = colour;
    }

    @Override
    public String getColour() {
        return vehicleColour;
    }

    @Override
    public void setNumber(String vehicleNumber) {
        this.vehicleNo = vehicleNumber;
    }

    @Override
    public String getNumber() {
        return vehicleNo;
    }
}
