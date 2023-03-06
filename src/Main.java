import com.engeto.ukol_lekce5.pokojove_rostliny.ListOfFlowers;
import com.engeto.ukol_lekce5.pokojove_rostliny.Plant;
import com.engeto.ukol_lekce5.pokojove_rostliny.PlantException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Plant kaktus = new Plant("Kaktus");
        Plant kopretina = new Plant("kopretina","bílá", LocalDate.of(2022,4,5),
                LocalDate.now(),5);

        //13.Watering info
        try {
            System.out.println(kaktus.getWateringInfo(kaktus));
            System.out.println(kopretina.getWateringInfo(kopretina));
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }



        //12.Načtení ze souboru
        ListOfFlowers list = new ListOfFlowers();
        try {
            list.addAllFromFile("kvetiny.txt");
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }



        //13.System.out.println(list.getFlowerList());
        System.out.println("\n--- Watering plan for flowers:\n");
        for ( int i = 0; i < list.getFlowerList().size(); i++) {
            Plant plant = list.getFlowerList().get(i);
            try {
            System.out.println(plant.getWateringInfo(plant));
            } catch (PlantException e) {
                System.err.println(e.getLocalizedMessage());
            }
        }

        //14.Add flowers to list
        list.addFlower(kaktus);
        list.addFlower(kopretina);

        System.out.println("\n--- 14.Add flowers to list");
        System.out.println("\n" + list.getFlowerList());

        //14.Remove flowers from list
        list.removeFromList(kaktus);
        list.removeFlowerOnIndex(0);

        System.out.println("\n--- 14.Remove flowers from list");
        System.out.println("\n" + list.getFlowerList());

    }

}