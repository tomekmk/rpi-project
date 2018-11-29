package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.domain.devices.DimmingDevice;
import pl.coderslab.domain.devices.OnOffDevice;

import java.util.List;

@Repository
@Transactional
public interface DimmingDeviceRepo extends JpaRepository<DimmingDevice, Long> {

    List<DimmingDevice> findAll();

    DimmingDevice findFirstById(Long id);
    DimmingDevice findFirstByPin(Integer pin);
}