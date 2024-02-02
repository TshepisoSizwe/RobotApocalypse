package interviewProject.robotApocalypse.service;

import interviewProject.robotApocalypse.entity.Survivor;

import java.util.List;
import java.util.Optional;

public interface SurvivorService {

    public List<Survivor> getAllSurvivors();
    public Optional<Survivor> getSurvivorById(Long id);

    public  Optional<List<Survivor>> getSurvivorByInfectionStatus(boolean infected);

    public Survivor saveSurvivor(Survivor survivor);

    public Survivor updateSurvivor(Survivor survivor);

    public void flagSurvivorAsInfected(Long id);

    public double calculateInfectionPercentage();

    public double calculateNonInfectedPercentage();


    public void updateInfectionStatus(Long survivorId);
}
