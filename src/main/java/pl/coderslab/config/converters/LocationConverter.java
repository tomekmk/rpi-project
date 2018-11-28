package pl.coderslab.config.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.dal.repositories.LocationRepo;
import pl.coderslab.domain.location.Location;

@Component
public class LocationConverter implements Converter<String, Location> {

    @Autowired
    private LocationRepo locationRepo;

    @Override
    public Location convert(String id) {
        return locationRepo.findFirstById(Long.parseLong(id));
    }
}