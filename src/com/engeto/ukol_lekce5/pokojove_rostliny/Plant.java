package com.engeto.ukol_lekce5.pokojove_rostliny;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate lastWatering;
    private int frequencyOfWatering;

    ///region CONSTRUCTORS

    public Plant(String name, String notes, LocalDate planted,
                 LocalDate lastWatering,int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.lastWatering = lastWatering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name,LocalDate planted,int frequencyOfWatering) {
        this(name,"",planted,LocalDate.now(),frequencyOfWatering);
    }
    public Plant(String name) {
        this(name,LocalDate.now(),7);
    }
    ///endregion


// neukáže obě chyby i když je splněna podmínka pro vyhození
    public String getWateringInfo(Plant plant) throws PlantException {

        if (plant.getFrequencyOfWatering() <= 0) {
            throw new PlantException("Next recommended watering is zero, " +
                    "or negative amount of days from the last watering");
        } else if (plant.getLastWatering().isBefore(plant.getPlanted())) {
            throw new PlantException("Last date of waterring is older than a plant date");
        }
        return "Flower: " + plant.getName() + ", Last watering: " + plant.getLastWatering() +
                ", Next watering: " + (plant.getLastWatering().plusDays(frequencyOfWatering));


    }


    ///region GETTERS/SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering(LocalDate lastWatering) {
        this.lastWatering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }


    ///endregion
}
