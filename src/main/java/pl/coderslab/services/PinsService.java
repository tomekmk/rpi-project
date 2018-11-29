package pl.coderslab.services;

import com.pi4j.io.gpio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dal.repositories.DimmingDeviceRepo;
import pl.coderslab.dal.repositories.OnOffDeviceRepo;
import pl.coderslab.dal.repositories.PinRepo;
import pl.coderslab.domain.devices.RaspberryPin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PinsService {

    @Autowired
    PinRepo pinRepo;
    @Autowired
    OnOffDeviceRepo onOffDeviceRepo;
    @Autowired
    DimmingDeviceRepo dimmingDeviceRepo;

    Map<Integer, GpioPinOutput> initializedPins = new HashMap<>();

    public List<RaspberryPin> createAvailablePins() {
        for (int i = 0; i <= 16; i++)
            pinRepo.save(new RaspberryPin(i, true));

        for (int i = 21; i <= 29; i++)
            pinRepo.save(new RaspberryPin(i, true));

        return pinRepo.findAll();
    }

    public List<RaspberryPin> getAllPins() {
        return pinRepo.findAll();
    }

    public List<RaspberryPin> getAvailablePins() {
        return pinRepo.getAvailablePins();
    }

    public List<RaspberryPin> getUsedPins() {
        return pinRepo.getUsedPins();
    }

    public boolean isPinFree(Integer pinNumber) {
        return pinRepo.checkIsPinFree(pinNumber);
    }

    public void setOnOffPinStatus(Integer pinNumber, boolean value) {
        GpioPinDigitalOutput currentPin = (GpioPinDigitalOutput) this.initializedPins.get(pinNumber);
        currentPin.setState(value);
    }


    public void initRaspberryPins() {
        Map<Integer, GpioPinOutput> initializingPins = new HashMap<>();
        GpioController gpio = GpioFactory.getInstance();

        List<RaspberryPin> allPins = getUsedPins();

        for (RaspberryPin pin : allPins) {
            if (onOffDeviceRepo.findFirstByPin(pin.getPinNumber()) != null) {
                GpioPinDigitalOutput currentPin =
                        gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(pin.getPinNumber()), PinState.LOW);
                initializingPins.put(pin.getPinNumber(), currentPin);
            }

            if (dimmingDeviceRepo.findFirstByPin(pin.getPinNumber()) != null) {
                GpioPinPwmOutput currentPin =
                        gpio.provisionPwmOutputPin(RaspiPin.getPinByAddress(pin.getPinNumber()), 0);
                initializingPins.put(pin.getPinNumber(), currentPin);
            }
        }

        this.initializedPins = initializingPins;
    }
}
