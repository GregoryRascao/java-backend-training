package projects.project4;

import projects.project4.device.Device;

import java.util.Objects;
//This is the first choice for validating the device
public class DeviceValidator {

    public void validateDevice(Device d) {
        if(Objects.isNull(d)) {
            throw new RuntimeException("Device is null");
        }
        // TODO: Add more validation logic here
    }
}
