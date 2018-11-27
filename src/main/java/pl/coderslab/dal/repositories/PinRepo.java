package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.domain.devices.UsedPins;

@Repository
public interface PinRepo extends JpaRepository<UsedPins, Long> {
    UsedPins findFirstByPinNumber(Integer pin);
}
