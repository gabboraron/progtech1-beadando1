package beadando1;

import java.util.Vector;

/**
 * A szimuláció futtatásához szükséges segédobjektum.
 * @author Sándor
 */
public class simulationDataStructure {
    private Vector<plant> plants;
    private int nrOfPlants;
    private int nrOfSimulationDays;

    /**
     * Létrehozza az objektumot.
     * Értékei:
     * @param plants egy növény típusú Vector, ebben tároljuk a bemeneti fájl növényeit
     * @param nrOfPlants A növények száma, a program gyorsaságához segítséget nyújt, illetve beolvasáskora fájl első eleme.
     * @param nrOfSimulationDays A szimulálandó napok száma.
     * @see plant
     */
    public simulationDataStructure(Vector<plant> plants, int nrOfPlants, int nrOfSimulationDays) {
        this.plants = plants;
        this.nrOfPlants = nrOfPlants;
        this.nrOfSimulationDays = nrOfSimulationDays;
        //
        //System.out.println("LOG@simulationDataStructure-constructor \tplants:"+  plants+"\tnrOfPlants:"+nrOfPlants+"\tnrOfSimulationDays:"+nrOfSimulationDays);
        //
    }

    /**
     * 
     * @return Egy növény típusú Vector a tárolt növényekkel.
     * @see plant
     */
    public Vector<plant> getPlants() {
        return plants;
    }

    /**
     * 
     * @return int A növéynek számát.
     */
    public int getNrOfPlants() {
        return nrOfPlants;
    }

    /**
     * 
     * @return int A szimuláció napjainak száma.
     */
    public int getNrOfSimulationDays() {
        return nrOfSimulationDays;
    }

    /**
     * Ezzel lehet feltölteni a növényeket az objektumba.<br>
     * Figyelem! Nem hozzáad, hanem felülírja a meglévőket!
     * @param plants Egy növény típusú Vector
     * @see plant
     */
    public void setPlants(Vector<plant> plants) {
        this.plants = plants;
    }

    /**
     * A növények számának feltöltésére az objektumba.
     * @param nrOfPlants int 
     */
    public void setNrOfPlants(int nrOfPlants) {
        this.nrOfPlants = nrOfPlants;
    }

    /**
     * A szimuláció napjainak számát tölti be az objektumba.
     * @param nrOfSimulationDays int
     */
    public void setNrOfSimulationDays(int nrOfSimulationDays) {
        this.nrOfSimulationDays = nrOfSimulationDays;
    }
    
    
}
