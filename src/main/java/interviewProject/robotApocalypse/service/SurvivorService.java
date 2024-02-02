package interviewProject.robotApocalypse.service;

import interviewProject.robotApocalypse.entity.Survivor;

import java.util.List;
import java.util.Optional;

public interface SurvivorService {

     List<Survivor> getAllSurvivors();
     Optional<Survivor> getSurvivorById(Long id);

      Optional<List<Survivor>> getSurvivorByInfectionStatus(boolean infected);

     Survivor saveSurvivor(Survivor survivor);

     Survivor updateSurvivor(Survivor survivor);

     void flagSurvivorAsInfected(Long id);

     double calculateInfectionPercentage();

     double calculateNonInfectedPercentage();


     void updateInfectionStatus(Long survivorId);
}
