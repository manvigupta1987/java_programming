package DesignPatterns;

// Behavioral Design Pattern
// State design pattern is used when the state of the object is changed based on its internal state.
// If we have to change behavior of an object based on its state, we can have a state variable in the Object and use if-else condition block to perform
// different actions based on the state. State pattern is used to provide a systematic and lose-coupled way to achieve this through Context and State implementations

//  Let’s say you’re in charge of designing a system that changes the input of an audio device. There are multiple inputs we can change to but the switch happens
//  in sequential order ( e.g. Bluetooth, Optical, Coaxial, RCA and USB). One input will always be selected.
public class State {
    public static void main(String[] args) {
        InputContext context = new InputContext();
        context.changeState();
        context.changeState();
        context.changeState();
        context.changeState();
        context.changeState();
    }
}

interface InputState {
    void changeInput(InputContext context);
}

class BluetoothState implements  InputState {
    private static final BluetoothState bluetoothState = new BluetoothState();

    private BluetoothState() { }

    public static BluetoothState getInstance ()
    {
        return bluetoothState;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to Optical");
        context.setState(OpticalState.getInstance());
    }
}

class OpticalState implements InputState {
    private static final OpticalState opticalState = new OpticalState();

    private OpticalState() { }

    public static OpticalState getInstance ()
    {
        return opticalState;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to Coaxial");
        context.setState(CoxialState.getInstance());
    }
}

class CoxialState implements InputState {
    private static final CoxialState coxialState = new CoxialState();

    private CoxialState() { }

    public static CoxialState getInstance ()
    {
        return coxialState;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to RCA");
        context.setState(RCAState.getInstance());
    }
}

 class RCAState implements InputState{
    private final static RCAState instance = new RCAState();
    //to prevent instantiation outside
    private RCAState(){}
    public static RCAState getInstance(){
        return instance;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to USB");
        context.setState(USBState.getInstance());
    }
}

 class USBState implements InputState {
    private final static USBState instance = new USBState();
    //to prevent instantiation outside
    private USBState(){}
    public static USBState getInstance(){
        return instance;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to Bluetooth");
        context.setState(BluetoothState.getInstance());
    }
}


class InputContext {
    InputState state;

    InputContext() {
        state = BluetoothState.getInstance();
    }

    public void setState(InputState state) {
        this.state = state;
    }

    public InputState getState() {
        return state;
    }

    public void changeState() {
        this.state.changeInput(this);
    }
}

