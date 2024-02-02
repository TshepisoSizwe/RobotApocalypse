package interviewProject.robotApocalypse.repository;

import interviewProject.robotApocalypse.entity.SurvivorResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorResourceRepository extends JpaRepository<SurvivorResources,Long> {
}
