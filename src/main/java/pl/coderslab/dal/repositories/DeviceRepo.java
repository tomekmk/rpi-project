package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.domain.devices.DeviceDetails;

@Repository
public interface DeviceRepo<T extends DeviceDetails> extends JpaRepository<T, Long> {

}


//markdown zapoznac