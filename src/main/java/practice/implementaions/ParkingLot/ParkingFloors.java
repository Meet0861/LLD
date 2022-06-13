package practice.implementaions.ParkingLot;

import java.util.List;

public class ParkingFloors {

    private int id;

    private List<ParkingSlot> parkingSlotList;

    public ParkingFloors() {
    }

    public ParkingFloors(int id, List<ParkingSlot> parkingSlotList) {
        this.id = id;
        this.parkingSlotList = parkingSlotList;
    }

    public int getId() {
        return id;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }
}
