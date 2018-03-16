package beadando1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * beadando feladat szama: 2
 * link: http://swap.web.elte.hu/progtech/felad1.pdf
 * @author Burian Sándor
 */
public class Beadando1 {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("\u2622 Radioaktivitas jelenlegi merteke: " );
        try{
            String tmpInputName;
            Scanner sc = new Scanner(System.in); 
            System.out.println("Bemeneti fajl neve: ");
            tmpInputName = sc.next();
            simulate(readFile(tmpInputName));
	} catch (FileNotFoundException e) {
            System.err.println("The file cannot be opened.");
            e.printStackTrace();
        } catch (IOException e){
            System.err.println("IO ERROR");
            e.printStackTrace();
	} 
    }
    
    /**
     *
     * @param input
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static  simulationDataStructure readFile(String input)
    throws FileNotFoundException, IOException{
        try (Scanner sc = new Scanner(new File(input), StandardCharsets.UTF_8.name());){
            boolean tmpOpenableFileEncoding = false;
            
            int nrOfRows = 0;
            int nrOfPlants = -1;
            //Vector<plant> plantsOfFile;
            Vector<plant> plantsOfFile = new Vector();
            int nrOfDays = 0;
            
            while (sc.hasNextLine()){
                tmpOpenableFileEncoding = true;
                String currentLine = sc.nextLine();
                
                //
                System.out.println("currentLine:"+currentLine);
                //
                
                if(nrOfRows == 0 ){
                    nrOfPlants = Integer.parseInt(currentLine);
                    //plantsOfFile = new Vector();
                    ++nrOfRows;
                }else{
                    String[] res1 = currentLine.split(" ");
                    plant tmpPlant = new plant(res1[0], Integer.parseInt(res1[2]), whichType(res1[1]));
                    tmpPlant.logPlant();
                    //plantsOfFile.add(tmpPlant);
                    tmpPlant = null;
                    
                    if(nrOfRows == nrOfPlants){
                        nrOfDays = Integer.parseInt(sc.nextLine());
                    } else {
                        ++nrOfRows;
                    }
                }
                
                if(sc.hasNextLine()){
                    String nextLine = sc.nextLine();
                    
                    //System.out.println("currentLine\t"+currentLine);
                    System.out.println("nextLine:"+nextLine);
                    
                    //String[] res1 = currentLine.split(" ");
                    String[] res2 = nextLine.split(" ");
                    //
                    System.out.println("!LOG\tres2:");
                       for (String elem : res2) {         
                        System.out.println("elem = |" + elem+"|");
                       }  
                    //
                    plant tmpPlant = new plant(res2[0], Integer.parseInt(res2[2]), whichType(res2[1]));
                    tmpPlant.logPlant();
                    //System.out.println("!LOG\tplantsOfFile:"+plantsOfFile);
                    //plantsOfFile.add(tmpPlant);
                    tmpPlant = null;
                    System.gc();
                    
                    //System.out.println(Arrays.toString(res1));
                    //System.out.println(Arrays.toString(res2));
                    //System.out.println("-------");
                }
            }
            
            if(!tmpOpenableFileEncoding){
                System.out.println("FIGYELEM\t Hibás karakterkódolású file. Kérem UTF8 karakterkódolású filet használjon!");
                return null;
            }
            
            return new simulationDataStructure(plantsOfFile, nrOfPlants, nrOfDays);
	}
    }
        
    public static plantType whichType(String tmpType){
        if(tmpType.equals("a")){
            return plantType.PUFFANCS;
        } else if(tmpType.equals("d")){
            return plantType.DELTAFA;
        }
        return plantType.PARABOKOR;
    }
    
    public static void simulate(simulationDataStructure allData){
        System.out.println("SIMAULATE FV");
        System.out.println("LOG \t nrOfplants: " + allData.getNrOfPlants());
        System.out.println("LOG \t nrOfSimulationDays: " + allData.getNrOfSimulationDays());
        
        System.out.println("LOG \t plants: \t NÉV \t TÁP \t TIPUS \t ÉL");
        System.out.println("----\t---------\t-----\t-----\t-------\t---");
        for (int idx = 0; idx <  allData.getPlants().size(); idx++) {
            plant plantAt = allData.getPlants().elementAt(idx);
            System.out.print("LOG \t plant:\t" + plantAt.getName() +"\t"+ plantAt.getNutrients() +"\t"+ plantAt.getType() +"\t"+ plantAt.isAlive());
        }
        
    }
}
