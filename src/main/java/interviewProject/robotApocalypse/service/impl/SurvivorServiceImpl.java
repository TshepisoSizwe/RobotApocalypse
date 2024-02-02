package interviewProject.robotApocalypse.service.impl;

import interviewProject.robotApocalypse.entity.Survivor;
import interviewProject.robotApocalypse.entity.SurvivorResources;
import interviewProject.robotApocalypse.repository.SurvivorRepository;
import interviewProject.robotApocalypse.repository.SurvivorResourceRepository;
import interviewProject.robotApocalypse.service.SurvivorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurvivorServiceImpl implements SurvivorService {

    @Autowired
    private SurvivorRepository survivorRepository;

    @Autowired
    private SurvivorResourceRepository survivorResourceRepository;


    @Override
    public List<Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    @Override
    public Optional<Survivor> getSurvivorById(Long id) {
        return survivorRepository.findById(id);
    }

    @Transactional
    @Override
    public Survivor saveSurvivor(Survivor survivor) {


        SurvivorResources survivorResources = survivor.getSurvivorResources();
        survivorResourceRepository.save(survivorResources);

        return survivorRepository.save(survivor);
    }

    @Override
    public Survivor updateSurvivor(Survivor survivorDetails) {

        Survivor updateSurvivor = new Survivor();

        updateSurvivor.setLongitude(survivorDetails.getLongitude());
        updateSurvivor.setLatitude(survivorDetails.getLatitude());

        return survivorRepository.save(updateSurvivor);
    }

    @Override
    public void flagSurvivorAsInfected(Long id) {
        Optional<Survivor> infectedSurvivor = survivorRepository.findById(id);

        infectedSurvivor.ifPresent(survivor -> {
            survivor.setInfected(true);
            survivorRepository.save(survivor);
        });
    }

    @Override
    public Optional<List<Survivor>> getSurvivorByInfectionStatus(boolean infected) {
        return survivorRepository.findByInfected(infected);
    }

    @Override
    public double calculateInfectionPercentage() {
        long totalSurvivors = survivorRepository.count();
        long infectedSurvivors = survivorRepository.countByInfected(true);

        if(totalSurvivors == 0){
            return 0.0;
        }

        return ((double) infectedSurvivors / totalSurvivors) * 100;
    }

    @Override
    public double calculateNonInfectedPercentage() {
        long totalSurvivors = survivorRepository.count();
        long nonInfectedSurvivors = survivorRepository.countByInfectedFalse();

        if(totalSurvivors == 0){
            return 0.0;
        }

        return ((double) nonInfectedSurvivors / totalSurvivors) * 100;
    }

    public void updateInfectionStatus(Long survivorId) {
        Survivor survivor = survivorRepository.findById(survivorId).orElse(null);
        if (survivor != null) {
            List<Survivor> nearbySurvivors = survivorRepository.findByLatitudeAndLongitude(survivor.getLatitude(), survivor.getLongitude());
            int infectedCount = (int) nearbySurvivors.stream().filter(Survivor::isInfected).count();

            if (infectedCount >= 3) {

                for (Survivor nearbySurvivor : nearbySurvivors) {
                    if (!nearbySurvivor.isInfected()) {
                        nearbySurvivor.setInfected(true);
                        survivorRepository.save(nearbySurvivor);
                        break;
                    }
                }
            }
        }
    }
}
