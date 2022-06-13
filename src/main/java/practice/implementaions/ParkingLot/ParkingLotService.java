package practice.implementaions.ParkingLot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingLotService {

    private static Map<Integer, List<ParkingSlot>> parkingSlotsByFloorMap;
    private static Map<String, Map<Integer, List<ParkingSlot>>> parkingSlotsAndFloorMapByParkingLot;


    public ParkingLotService() {
        parkingSlotsByFloorMap = new ConcurrentHashMap<>();
        parkingSlotsAndFloorMapByParkingLot = new ConcurrentHashMap<>();
    }

    public void createParkingLot(String id, int noOfFloors, int noOfSlotsPerFloor){
        for(int i =1; i<=noOfFloors; i++){
            ParkingFloors parkingFloor = new ParkingFloors();
            List<ParkingSlot> parkingSlotList = new ArrayList<>();
            for(int j=1;j<=noOfSlotsPerFloor; j++){
                ParkingSlot parkingLot = new ParkingSlot(j, VehicleType.CAR, 10, 10, false);
                parkingSlotList.add(parkingLot);
            }
            parkingFloor.setId(i);
            parkingFloor.setParkingSlotList(parkingSlotList);
            parkingSlotsByFloorMap.put(i, parkingSlotList);
        }
        parkingSlotsAndFloorMapByParkingLot.put(id, parkingSlotsByFloorMap);
    }

    public void addParkingSlot(VehicleType vehicleType, int floorId, int length, int width){
        List<ParkingSlot> parkingSlotList = parkingSlotsByFloorMap.get(floorId);
        ParkingSlot parkingSlot = new ParkingSlot(parkingSlotList.size()+1, vehicleType, length, width, false);
        parkingSlotList.add(parkingSlot);
        parkingSlotsByFloorMap.put(floorId, parkingSlotList);
    }

    public String parkVehicle(VehicleType vehicleType, String regNo, String colour, String parkingLotId){
        String ticket;
        for (Map.Entry<Integer, List<ParkingSlot>> entry : parkingSlotsByFloorMap.entrySet()) {
            Integer floor = entry.getKey();
            List<ParkingSlot> parkingSlotList = entry.getValue();
            Vehicles vehicle = null;
            switch (vehicleType){
                case CAR:
                    vehicle = new Car();
                    vehicle.setColour(colour);
                    vehicle.setNumber(regNo);
                    vehicle.setType(VehicleType.CAR);
                    break;
                case BIKE:
                    vehicle = new Bike();
                    vehicle.setColour(colour);
                    vehicle.setNumber(regNo);
                    break;
                case TRUCK:
                    vehicle = new Truck();
                    vehicle.setColour(colour);
                    vehicle.setNumber(regNo);
                    break;
            }

            Optional<ParkingSlot> availableParkingSlot = parkingSlotList.stream()
                    .filter(x -> x.getForVehicleType() == vehicleType && !x.isBooked())
                    .findAny();
            if (availableParkingSlot.isPresent()) {
                ticket = generateTicket(parkingLotId, floor, availableParkingSlot.get().getId());
                availableParkingSlot.get().setBooked(true);
                availableParkingSlot.get().setVehicleParked(vehicle);
                return ticket;
            }
        }
        return "PARKING SLOT NOT AVAILABLE";
    }

    public String generateTicket(String parkingLotId, int floorNo, int slotNo){
        String ticket = parkingLotId + "_" + floorNo + "_" + slotNo;
        return ticket;
    }

    public int unParkVehicle(String ticketId, String vehichleNo, int noOfHours, ParkingCostStrategy parkingCostStrategy){
        int floor, slotNo;
        try {
            String[] s = ticketId.split("_");
            String parkingLot = s[0];
            floor = Integer.parseInt(s[1]);
            slotNo = Integer.parseInt(s[2]);
        }catch (NumberFormatException ex){
            System.out.println("INVALID TICKET");
            return -1;
        }
        Optional<ParkingSlot> first = parkingSlotsByFloorMap.get(floor).stream().filter(x -> x.getId() == slotNo).findFirst();
        if(first.isPresent() && first.get().getVehicleParked().getNumber().equals(vehichleNo) && first.get().isBooked()) {
            int cost = generateCost(noOfHours, parkingCostStrategy);
            first.get().setBooked(false);
            return cost;
        } else {
            System.out.println("INVALID TICKET");
            return -1;
        }
    }

    private int generateCost(int noOfHours, ParkingCostStrategy parkingCostStrategy) {
        return parkingCostStrategy.getCost(noOfHours);
    }

    public List<ParkingSlot> getParkingSlotsByFloor(Slots slotType, int floor){
        List<ParkingSlot> parkingSlotList = parkingSlotsByFloorMap.get(floor);
        if(Objects.isNull(parkingSlotList) ) parkingSlotList = new ArrayList<>();
        switch (slotType){
            case AVAILABLE:
                return parkingSlotList.stream()
                        .filter(x -> !x.isBooked())
                        .collect(Collectors.toList());
            case BOOKED:
                return parkingSlotList.stream()
                        .filter(ParkingSlot::isBooked)
                        .collect(Collectors.toList());
            case TOTAL:
                return parkingSlotList;
        }
        System.out.println("INVALID SLOT TYPE, PLEASE FIND BELOW LIST OF ALL SLOTS");
        return parkingSlotList;
    }

    public List<ParkingSlot> getParkingSlotsByFloorAndVehicleType(Slots slotType, int floor, VehicleType vehicleType){
        List<ParkingSlot> parkingSlotList = parkingSlotsByFloorMap.get(floor);
        if(Objects.isNull(parkingSlotList) ) parkingSlotList = new ArrayList<>();
        switch (slotType){
            case AVAILABLE:
                return parkingSlotList.stream()
                        .filter(x -> x.getForVehicleType() == vehicleType && !x.isBooked())
                        .collect(Collectors.toList());
            case BOOKED:
                return parkingSlotList.stream()
                        .filter(x -> x.getForVehicleType() == vehicleType && x.isBooked())
                        .collect(Collectors.toList());
            case TOTAL:
                return parkingSlotList.stream().filter(x->x.getForVehicleType() == vehicleType)
                        .collect(Collectors.toList());
        }
        return parkingSlotList;
    }

    public Map<Integer, List<ParkingSlot>> getParkingSlotsByLotAndVehicleType(Slots slotType, String parkingLot, VehicleType vehicleType){
        Map<Integer, List<ParkingSlot>> parkingSlotListByFloorMap = parkingSlotsAndFloorMapByParkingLot.get(parkingLot);

        if(Objects.isNull(parkingSlotListByFloorMap) ) {
            parkingSlotListByFloorMap = new HashMap<>();
            return parkingSlotListByFloorMap;
        }
        Map<Integer, List<ParkingSlot>> parkingSlotListByFloorMapBySlotType = new HashMap<>();
        for (Map.Entry<Integer, List<ParkingSlot>> entry : parkingSlotListByFloorMap.entrySet()) {
            Integer floor = entry.getKey();
            List<ParkingSlot> parkingSlotList = entry.getValue();
            List<ParkingSlot> requiredParkingSlotsList;
            switch (slotType){
                case AVAILABLE:
                    requiredParkingSlotsList = parkingSlotList.stream()
                            .filter(x -> x.getForVehicleType() == vehicleType && !x.isBooked())
                            .collect(Collectors.toList());
                    parkingSlotListByFloorMapBySlotType.put(floor, requiredParkingSlotsList);
                case BOOKED:
                    requiredParkingSlotsList = parkingSlotList.stream()
                            .filter(x -> x.getForVehicleType() == vehicleType && x.isBooked())
                            .collect(Collectors.toList());
                parkingSlotListByFloorMapBySlotType.put(floor, requiredParkingSlotsList);
                case TOTAL:
                    requiredParkingSlotsList =  parkingSlotList.stream().filter(x->x.getForVehicleType() == vehicleType)
                            .collect(Collectors.toList());
                parkingSlotListByFloorMapBySlotType.put(floor, requiredParkingSlotsList);
            }
        }
         return parkingSlotListByFloorMapBySlotType;
    }
}
