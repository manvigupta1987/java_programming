package DesignPatterns.InterviewQuestions;

import java.util.Date;

// Design a parking lot
// Questions that can be asked:
// 1. What detail should be in ticket ? --> Vehicle number, time of entry, Parking spot and unique id for tracking
// 2. Allocation of parking to user -->
//... 1. Are there different type of paking ? --> Small, Medium  Large
//... 2. How is parking spot decided?
//....3. What is the logic of generating price ?
// 3. Scale related discussion:
//...1. Number of parking slot in one parking lot --> #floor in parking lot * #parking slots per floor
//...2. Data size for parking slot in one parking lot --> #parking slot * #size of one parking slot



public class ParkingLot {
    public static void main(String[] args) {

    }
}

interface ParkingService {
    Ticket entry(VehicleType type);
    int exit(long ticketId);
}

interface SlotService {
    ParkingSlot allocate(VehicleType type);
    boolean unallocate(long ParkingSlotId);
}

interface PriceService {
    int calculatePrice(VehicleType type, Date timeIn, Date timeOut);
}


class Ticket {
    long id;
    Date entryTime, exitTime;
    String VehicleNumber;
    ParkingSlot slot;
}

class ParkingSlot {
    long id;
    VehicleType type;
    ParkingState state;
}

enum ParkingState {Occupied, Unoccupied};
enum VehicleType {Small, Medium, Large};