package DesignPatterns.InterviewQuestions;

//-> make assumptions
//the parking lot has multiple levels, each level has multiple rows of spots
//	//the parking lot can park motorcycles, cars, and buses
//	//the parking lot chas motorcycle spots, compact spots, and large spots
//	//a motorcycle could park in any spots
//	//a car can park in either a single compact spot or a single large spot
//	//a bus can park in five large spots that are consecutive and within the same row, it cannot park in small spots

import java.util.ArrayList;

public class ParkingLotWithLevels {
    public static void main(String[] args) {

    }
}

enum VehicleSize {
    Motorcycle, Compact, Large;
}

class Level {
    int floor;
    ParkingSpot[] parkingSpots;
    int availableSpots;
    final int SPOTS_PER_ROW = 30;

    Level(int floorNum, int numberOfSpots) {
        this.floor = floorNum;
        availableSpots = numberOfSpots;
        parkingSpots = new ParkingSpot[numberOfSpots];

        int largeSpots = numberOfSpots / 4;
        int compactSpots = numberOfSpots / 4;
        int motorCycleSpots = numberOfSpots - (largeSpots + compactSpots);

        VehicleSize size;

        for (int i = 0; i < numberOfSpots; i++) {
            if (i < largeSpots) {
                size = VehicleSize.Large;
            } else if (i < (largeSpots + compactSpots)) {
                size = VehicleSize.Compact;
            } else {
                size = VehicleSize.Motorcycle;
            }
            int row = i / SPOTS_PER_ROW;
            parkingSpots[i] = new ParkingSpot(row, i, size, this);
        }
    }
    int availableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle( Vehicle vehicle) {
        if (availableSpots < vehicle.getSpotNeeded()) {
            return false;
        }

        int availableSpotStartingNumber = findAvailableSpots(vehicle);
        if (availableSpotStartingNumber > 0) {
            parkStartingAtSpot(availableSpotStartingNumber, vehicle);
            return true;
        }
        return false;
    }

    void parkStartingAtSpot(int availableSpotsStartingNumber, Vehicle vehicle) {
        for (int i = availableSpotsStartingNumber; i< availableSpotsStartingNumber + vehicle.getSpotNeeded(); i++) {
            parkingSpots[i].park(vehicle);
        }
        availableSpots -= vehicle.getSpotNeeded();
    }

    int findAvailableSpots(Vehicle vehicle) {
        int spots = 0;
        for (int i = 0; i< parkingSpots.length; i++) {
            ParkingSpot spot = parkingSpots[i];
            if (spot.canVehicleFitIn(vehicle)) {
                spots++;
            } else {
                spots = 0;
            }

            if (spots == vehicle.getSpotNeeded()) {
                return (i- (spots-1));
            }
        }
        return -1;
    }
}

class ParkingSpot {
    Level level;
    Vehicle vehicle;
    VehicleSize spotSize;
    int spotNumber;
    int row;

    ParkingSpot(int row, int spotNumber, VehicleSize spotSize, Level level) {
        this.level = level;
        this.row = row;
        this.spotSize = spotSize;
        this.spotNumber = spotNumber;
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canVehicleFitIn(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public void park(Vehicle vehicle) {
        vehicle.parkInSpots(this);
    }
}

abstract class Vehicle {
    int licensePlate;
    ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    int spotNeeded;
    VehicleSize size;

    public int getLicensePlate() {
        return licensePlate;
    }

    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getSpotNeeded() {
        return spotNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    void parkInSpots(ParkingSpot s) {
        parkingSpots.add(s);
    }

    void clearSpots() {
        parkingSpots = null;
    }

    abstract boolean canFitInSpot(ParkingSpot spot);
}

class Bus extends Vehicle {
    Bus() {
        spotNeeded = 5;
        size = VehicleSize.Large;
    }

    @Override
    boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }
}

class MotorCycle extends Vehicle {
    MotorCycle() {
        spotNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    @Override
    boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Motorcycle || spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Large;
    }
}

class Car extends Vehicle {
    Car() {
        spotNeeded = 1;
        size = VehicleSize.Compact;
    }

    @Override
    boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Large;
    }
}

