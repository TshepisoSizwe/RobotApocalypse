package interviewProject.robotApocalypse.repository;

import interviewProject.robotApocalypse.entity.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor,Long> {
        Optional<List<Survivor>> findByInfected(boolean infected);

        long countByInfected(boolean infected);

        long countByInfectedFalse();

        @Query("SELECT s FROM Survivor s WHERE s.latitude = :latitude AND s.longitude = :longitude")
        List<Survivor> findByLatitudeAndLongitude(@Param("latitude") double latitude, @Param("longitude") double longitude);
}
