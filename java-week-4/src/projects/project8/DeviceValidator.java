package projects.project8;

import projects.project8.device.Device;

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
