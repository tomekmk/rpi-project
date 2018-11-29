package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.domain.devices.DeviceDetails;

import java.util.Collection;

@Repository
@Transactional
public interface DeviceRepo<T extends DeviceDetails> extends JpaRepository<T, Long> {

}