package pl.coderslab.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.domain.location.Location;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
    Location findFirstById(Long id);

    @Query("SELECT l FROM Location l ORDER BY l.floor ASC")
    List<Location> findAllOrdered();
}
