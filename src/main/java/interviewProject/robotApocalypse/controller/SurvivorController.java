package interviewProject.robotApocalypse.controller;

import interviewProject.robotApocalypse.ExceptionsFolder.ResourceNotFoundException;
import interviewProject.robotApocalypse.entity.Survivor;
import interviewProject.robotApocalypse.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/survivors")
public class SurvivorController {

    @Autowired
    private SurvivorService survivorService;

    private static final String SUCCESS = "Success";

    @GetMapping("/")
    public String getDefaultContext()
    {
        return SUCCESS;
    }

    @GetMapping("/all-survivors")
    public List<Survivor> getAllSurvivors() throws ResourceNotFoundException {
        try{
            return survivorService.getAllSurvivors();
        }catch (Exception ex){
            throw new ResourceNotFoundException("Could not process Request, check if provided details are correct");
        }

    }

    @GetMapping("/survivor/{id}")
    public ResponseEntity<Optional<Survivor>> getSurvivorById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Survivor> survivor = survivorService.getSurvivorById(id);

            if (survivor.isPresent()) {
                return ResponseEntity.ok().body(survivor);
            }else{
                throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct " );
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/save-survivor")
    public ResponseEntity<Survivor> insertSurvivor(@RequestBody Survivor survivor) throws ResourceNotFoundException {
        try{

            survivorService.saveSurvivor(survivor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){

            throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct" );

        }
    }

    @PutMapping("/survivor/{id}/location")
    public ResponseEntity<Survivor> updateSurvivorLocation(@PathVariable(value = "id")Long id,
                                                           @Validated @RequestBody Survivor survivorDetails){
        try{
            Survivor survivor = survivorService.getSurvivorById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Could not process request,check to see if provided details are correct "));

            survivor.setLongitude(survivorDetails.getLongitude());
            survivor.setLatitude(survivorDetails.getLatitude());

            survivorService.saveSurvivor(survivor);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/survivor/{id}/flag-survivor")
    public ResponseEntity<Object> flagSurvivorAsInfected(@PathVariable(value = "id")Long id) throws ResourceNotFoundException {
        try{
            survivorService.flagSurvivorAsInfected(id);
            return ResponseEntity.ok().build();
        }catch (Exception ex){

            throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct");

        }
    }

    @GetMapping("/survivors/infected")
    public ResponseEntity<Optional<List<Survivor>>> getInfectedSurvivor() {
        try {

            Optional<List<Survivor>> infectedSurvivors = survivorService.getSurvivorByInfectionStatus(true);


            if (infectedSurvivors.isPresent()) {
                return ResponseEntity.ok().body(infectedSurvivors);
            }else{
                throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct");

            }
        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/survivors/uninfected")
    public ResponseEntity<Optional<List<Survivor>>> getUnInfectedSurvivor() {
        try {

            Optional<List<Survivor>> infectedSurvivors = survivorService.getSurvivorByInfectionStatus(false);


            if (infectedSurvivors.isPresent()) {
                return ResponseEntity.ok().body(infectedSurvivors);
            }else{
                throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct");

            }
        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/infected-percentage")
    public ResponseEntity<Double> getInfectionPercentage() throws ResourceNotFoundException {
        try{
            double infectionPercentage = survivorService.calculateInfectionPercentage();
            return ResponseEntity.ok(infectionPercentage);
        }catch (Exception ex){
            throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct");
        }
    }

    @GetMapping("/non-infected-percentage")
    public ResponseEntity<Double> getNonInfectionPercentage() throws ResourceNotFoundException {
        try{
            double nonInfectionPercentage = survivorService.calculateNonInfectedPercentage();
            return ResponseEntity.ok(nonInfectionPercentage);
        }catch (Exception ex){
            throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct");
        }
    }

    @PutMapping("/{survivorId}/updateInfectionStatus")
    public ResponseEntity<String> updateInfectionStatus(@PathVariable Long survivorId) throws ResourceNotFoundException {
        try{
            survivorService.updateInfectionStatus(survivorId);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            throw new ResourceNotFoundException("Could not process request,check to see if provided details are correct");
        }
    }



}
