package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.domain.devices.OnOffDevice;

import java.util.List;

@Repository
public interface OnOffDeviceRepo extends JpaRepository<OnOffDevice, Long> {

    List<OnOffDevice> findAll();

}


//markdown zapoznac //todo markdown