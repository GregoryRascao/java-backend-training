package projects.project8;

import projects.project8.device.Device;

import java.util.ArrayList;
import java.util.List;

public class Room {

    List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        //This is the third choice for validating the device
        if (device != null) {
            this.devices.add(device);
        }
        else {
            System.out.println("Device was null");
        }
    }

    public void removeDevice(Device device) {
        //This is the third choice for validating the device
        if (device == null) {
            System.out.println("Device was null");
        }
        else if(!this.devices.contains(device)) {
            System.out.println("Device does not exist in this room");
        }
        else {
            this.devices.remove(device);
        }
    }

    public String reportMostConsumingDevices() {
        //TODO traverse the list and return the top 3 most consuming ones
        return "";
    }
}
