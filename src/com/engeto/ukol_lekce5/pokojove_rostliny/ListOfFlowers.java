package com.engeto.ukol_lekce5.pokojove_rostliny;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfFlowers {
    private List<Plant> flowerList = new ArrayList<>();



    public void addAllFromFile(String filename) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
//                String line = scanner.nextLine();
//                String[] items = line.split("\t");


            }
        } catch (FileNotFoundException e) {
            throw new PlantException(e.getLocalizedMessage());
        }
    }


    public void addFlower(Plant plant) {
        flowerList.add(plant);
    }

    public String getPlantFromList(List<Plant> list, int index) {
        return list.get(index).getName();
    }
    public void removeFromList(List<Plant> list, Plant flower) {
        list.remove(flower);
    }

    public List<Plant> getFlowerList() {
        return flowerList;
    }
}
