package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.domain.devices.RaspberryPin;

import java.util.List;

@Repository
public interface PinRepo extends JpaRepository<RaspberryPin, Long> {
    RaspberryPin findFirstByPinNumber(Integer pin);

    @Query("SELECT p FROM RaspberryPin p WHERE p.available = true")
    List<RaspberryPin> getAvailablePins();

    @Query("SELECT p FROM RaspberryPin p WHERE p.available = false ")
    List<RaspberryPin> getUsedPins();

    @Query("SELECT p.available FROM RaspberryPin p WHERE p.pinNumber = ?1")
    boolean checkIsPinFree(Integer pinNumber);
}
