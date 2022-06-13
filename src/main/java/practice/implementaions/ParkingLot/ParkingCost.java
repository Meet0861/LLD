package practice.implementaions.ParkingLot;

public class ParkingCost implements ParkingCostStrategy{


    @Override
    public int getCost(int parkHours) {
        if(parkHours<=2)
            return 10;
        else
            return (parkHours-2)*10 + 10;
    }
}
