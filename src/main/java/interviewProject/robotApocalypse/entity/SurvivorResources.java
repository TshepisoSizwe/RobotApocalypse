package interviewProject.robotApocalypse.entity;

import jakarta.persistence.*;

@Entity
public class SurvivorResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double water;
    private Integer food;
    private Integer medication;
    private Integer ammunition;

    public SurvivorResources() {
    }


    public SurvivorResources(Long id, Double water, Integer food, Integer medication, Integer ammunition) {
        this.id = id;
        this.water = water;
        this.food = food;
        this.medication = medication;
        this.ammunition = ammunition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getMedication() {
        return medication;
    }

    public void setMedication(Integer medication) {
        this.medication = medication;
    }

    public Integer getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Integer ammunition) {
        this.ammunition = ammunition;
    }

    @Override
    public String toString() {
        return "SurvivorResources{" +
                "id=" + id +
                ", water=" + water +
                ", food=" + food +
                ", medication=" + medication +
                ", ammunition=" + ammunition +
                '}';
    }
}
