package practice.implementaions.ParkingLot;

public class testParkingLotService {

    public static void main(String[] args){
        String ticket;
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.createParkingLot("PR1234", 1, 10);
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.TOTAL, 0).size());
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.TOTAL, 1).size());
        parkingLotService.addParkingSlot(VehicleType.BIKE, 1, 5, 5);
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.AVAILABLE, 1).size());
        System.out.println("Got Ticket: " +parkingLotService.parkVehicle(VehicleType.TRUCK, "reg-no", " RED", "PR1234" ));
        ticket = parkingLotService.parkVehicle(VehicleType.CAR, "ABC12", " WHITE", "PR1234" );
        System.out.println("Got Ticket: " + ticket);
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.AVAILABLE, 1).size());
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.TOTAL, 1).size());
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.BOOKED, 1).size());
        parkingLotService.unParkVehicle(ticket, "ABC12", 3, new ParkingCost());
        System.out.println("vehicle unparked");
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.AVAILABLE, 1).size());
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.TOTAL, 1).size());
        System.out.println("Total parking slots: " +parkingLotService.getParkingSlotsByFloor(Slots.BOOKED, 1).size());
        System.out.print(parkingLotService.getParkingSlotsByLotAndVehicleType(Slots.AVAILABLE, "PR1234", VehicleType.BIKE));
    }
}
