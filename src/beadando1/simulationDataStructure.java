package beadando1;

import java.util.Vector;

/**
 *
 * @author Sándor
 */
public class simulationDataStructure {
    private Vector<plant> plants;
    private int nrOfPlants;
    private int nrOfSimulationDays;

    public simulationDataStructure(Vector<plant> plants, int nrOfPlants, int nrOfSimulationDays) {
        this.plants = plants;
        this.nrOfPlants = nrOfPlants;
        this.nrOfSimulationDays = nrOfSimulationDays;
        //
        //System.out.println("LOG@simulationDataStructure-constructor \tplants:"+  plants+"\tnrOfPlants:"+nrOfPlants+"\tnrOfSimulationDays:"+nrOfSimulationDays);
        //
    }

    public Vector<plant> getPlants() {
        return plants;
    }

    public int getNrOfPlants() {
        return nrOfPlants;
    }

    public int getNrOfSimulationDays() {
        return nrOfSimulationDays;
    }

    public void setPlants(Vector<plant> plants) {
        this.plants = plants;
    }

    public void setNrOfPlants(int nrOfPlants) {
        this.nrOfPlants = nrOfPlants;
    }

    public void setNrOfSimulationDays(int nrOfSimulationDays) {
        this.nrOfSimulationDays = nrOfSimulationDays;
    }
    
    
}
