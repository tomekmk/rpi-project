package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dal.repositories.LocationRepo;
import pl.coderslab.domain.location.Location;
import pl.coderslab.web.dtos.LocationFormDTO;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class LocationService {

    @Autowired
    LocationRepo locationRepo;

    public List<Location> getAllLocations() {
        return locationRepo.findAllOrdered();
    }

    public void saveLocation(@Valid LocationFormDTO form) {
        Location location = new Location();
        location.setName(form.getName());
        location.setType(form.getType());
        location.setFloor(form.getFloor());
        locationRepo.save(location);
    }

    public Location getLocationById(Long id) {
        return locationRepo.findFirstById(id);
    }

//    public void editLocation();   //todo editing locations

}
