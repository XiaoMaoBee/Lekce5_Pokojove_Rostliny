import com.engeto.ukol_lekce5.pokojove_rostliny.ListOfFlowers;
import com.engeto.ukol_lekce5.pokojove_rostliny.Plant;
import com.engeto.ukol_lekce5.pokojove_rostliny.PlantException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Plant kaktus = new Plant("Kaktus");
        Plant kopretina = new Plant("kopretina","bílá", LocalDate.now(),
                LocalDate.of(2021,3,5),0);

        try {
            System.out.println(kaktus.getWateringInfo(kaktus));
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        //Načtení ze souboru
        ListOfFlowers list = new ListOfFlowers();
        try {
            list.addAllFromFile("kvetiny.txt");
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }



    }
}