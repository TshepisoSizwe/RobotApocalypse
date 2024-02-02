package interviewProject.robotApocalypse.entity;

import jakarta.persistence.*;



@Entity
public class Survivor  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private Integer age;
    private String gender;
    private Double longitude;
    private Double latitude;

    private boolean infected;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private SurvivorResources survivorResources;

    public Survivor() {
    }


    public Survivor(Long ID, String name, Integer age, String gender, Double longitude, Double latitude,SurvivorResources survivorResources) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.longitude = longitude;
        this.latitude = latitude;
        this.survivorResources = survivorResources;
        this.infected = false;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public SurvivorResources getSurvivorResources() {
        return survivorResources;
    }

    public void setInventory(SurvivorResources survivorResources) {
        this.survivorResources = survivorResources;
    }

    @Override
    public String toString() {
        return "Survivor{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }


}
