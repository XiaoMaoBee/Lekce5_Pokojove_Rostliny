package com.engeto.ukol_lekce5.pokojove_rostliny;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfFlowers {
    private List<Plant> flowerList = new ArrayList<>();


    public void addAllFromFile(String filename) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
               // System.out.println(scanner.nextLine());
               String line = scanner.nextLine();
               String[] items = line.split("\t");
               Plant plant = new Plant(
                       items[0],
                       items[1],
                       LocalDate.parse(items[4]),
                       LocalDate.parse(items[3]),
                       Integer.parseInt(items[2])
               );

               flowerList.add(plant);
            }
        } catch (FileNotFoundException | DateTimeParseException | NumberFormatException e) {
            throw new PlantException(e.getLocalizedMessage());
        }
    }

    public void addFlower(Plant plant) {
        flowerList.add(plant);
    }

    public String getPlantFromList(int index) {
        return flowerList.get(index).getName();
    }
    public void removeFromList(Plant flower) {
        flowerList.remove(flower);
    }

    public void removeFlowerOnIndex(int index) {
        flowerList.remove(index);
    }

    public List<Plant> getFlowerList() {
        return flowerList;
    }
}
