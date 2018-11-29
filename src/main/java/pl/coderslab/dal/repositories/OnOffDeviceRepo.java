package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.domain.devices.DeviceDetails;
import pl.coderslab.domain.devices.OnOffDevice;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface OnOffDeviceRepo extends JpaRepository<OnOffDevice, Long> {

    List<OnOffDevice> findAll();

    OnOffDevice findFirstById(Long id);
    OnOffDevice findFirstByPin(Integer pin);

//    @Query(value = "SELECT max(orderId) FROM on_off_devices", nativeQuery = true)
//    Integer findMaxId();
}


//markdown zapoznac //todo markdown