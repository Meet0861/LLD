package practice.implementaions.ParkingLot;

public class ParkingSlot {

    private int id;

    private VehicleType forVehicleType;

    public Vehicles getVehicleParked() {
        return vehicleParked;
    }

    public void setVehicleParked(Vehicles vehicleParked) {
        this.vehicleParked = vehicleParked;
    }

    private Vehicles vehicleParked;

    private int length;

    private int width;

    private boolean isBooked;

    public ParkingSlot(int id, VehicleType forVehicleType, int length, int width, boolean isBooked) {
        this.id = id;
        this.forVehicleType = forVehicleType;
        this.length = length;
        this.width = width;
        this.isBooked = isBooked;
    }

    public ParkingSlot(int id, VehicleType forVehicleType, Vehicles vehicleParked, int length, int width, boolean isBooked) {
        this.id = id;
        this.forVehicleType = forVehicleType;
        this.vehicleParked = vehicleParked;
        this.length = length;
        this.width = width;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getForVehicleType() {
        return forVehicleType;
    }

    public void setForVehicleType(VehicleType forVehicleType) {
        this.forVehicleType = forVehicleType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                ", forVehicleType=" + forVehicleType +
                ", length=" + length +
                ", width=" + width +
                ", isBooked=" + isBooked +
                '}';
    }
}
