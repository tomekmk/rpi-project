package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dal.repositories.DeviceRepo;
import pl.coderslab.dal.repositories.OnOffDeviceRepo;
import pl.coderslab.domain.devices.DeviceDetails;
import pl.coderslab.domain.devices.DimmingDevice;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ViewService {

    @Autowired
    OnOffDeviceRepo onOffDeviceRepo;
    @Autowired
    DeviceRepo<DimmingDevice> dimmingDeviceRepo;

    public List<DeviceDetails> getAllDevicesOrdered() {
        List<DeviceDetails> devices = new ArrayList<>();

        devices.addAll(onOffDeviceRepo.findAll());
//        devices.addAll(dimmingDeviceRepo.findAll());

//        devices.sort((a,b) -> a.getOrderId() - b.getOrderId());   //todo sortowanie

        return devices;
    }

}
