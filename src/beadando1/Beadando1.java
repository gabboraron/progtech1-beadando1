package beadando1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Főprogram<br><br>
 * Egyéb:<br>
 * beadando feladat szama: 2 <br>
 * link: http://swap.web.elte.hu/progtech/felad1.pdf
 * @author Burian Sándor
 */
public class Beadando1 {
    /**
     * Főprogram<br>
     * Beolvassa a bemeneti adatokat, majd szimulálja a folyamatot.<br>
     * Lekezelt hibák: FileNotFoundException, IOException
     * @param args String <br> A bementi fájl neve, a fájl kötelezően utf8-bom nélküli kódolású kell legyen!
     * 
     */
    public static void main(String[] args) {
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
     * Beolvassa a fájl tartalmát, és tárolja egy simulationDataStructure objektumban.<br>
     * Működése röviden:<br>
     * A fájl felépítését kihasználva beolvassa és eltárolja egy vectorban a növényeket, és a simulationDataStructure típusban hozzáadja a szimulálandó napook számát, ill a növények számát.<br>
     * Lekezelt hibák: nem megfelelő karakterkódolású fájl esete
     * @param input String <br> A bementi fájl neve, a fájl kötelezően utf8-bom nélküli kódolású kell legyen!
     * @return Egy simulationDataStructure felélpítésű objektumot.
     * @see simulationDataStructure
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
                
                String currentLine = "";
                switch(nrOfRows){
                    case 0 : 
                        currentLine = sc.nextLine();
                        nrOfPlants = Integer.parseInt(currentLine);
                        ++nrOfRows;
                        break;
                    case 1 :                        
                        for (int idx = 0; idx < nrOfPlants; idx++) {
                            currentLine = sc.nextLine();
                            //System.out.println("LOG \t \t plant:"+currentLine);
                            String[] res1 = currentLine.split(" ");
                            plant tmpPlant = new plant(res1[0], Integer.parseInt(res1[2]), whichType(res1[1]));
                            //tmpPlant.logPlant();
                            plantsOfFile.add(tmpPlant);
                        }
                        ++nrOfRows;
                        break;
                    case 2 :
                        currentLine = sc.nextLine();
                        nrOfDays = Integer.parseInt(currentLine);
                        ++nrOfRows;
                        break;
                }
                
                //System.out.println("LOG \t nrOfRows:"+nrOfRows+"\t nrOfPlants:"+nrOfPlants+"\t nrOfDays:"+nrOfDays);
            }
            
            if(!tmpOpenableFileEncoding){
                System.out.println("FIGYELEM\t Hibás karakterkódolású file. Kérem UTF8 karakterkódolású filet használjon!");
                return null;
            }
            
            return new simulationDataStructure(plantsOfFile, nrOfPlants, nrOfDays);
	}
    }
        
    /**
     * Visszadja a bemeneti rövidítésnek megfelelő növénytípus felsorolás beli elemét a feladatkiírásban szereplő adatok alapján:<br>
     *  a – puffancs, d – deltafa,  p – parabokor<br>
     * Rosszul lekezelt esetek: Minden "a"tól és "d"től különböző értékre parabokort ad, így egy hibás fájl esetén hibás működést eredményezhet!
     * @param tmpType String, a növény típusának rövidítése.
     * @return a növény növénytípusának megfelelő elemet a plantType enumból.
     * @see plantType
     */
    public static plantType whichType(String tmpType){
        if(tmpType.equals("a")){
            return plantType.PUFFANCS;
        } else if(tmpType.equals("d")){
            return plantType.DELTAFA;
        }
        return plantType.PARABOKOR;
    }
    
    /**
     * A szimulációt végző függvény, a feladat kiírásban szereplő módon értelmezendő.
     * @param allData simulationDataStructure típusú objektum
     * @see simulationDataStructure
     */
    public static void simulate(simulationDataStructure allData){
//        System.out.println("LOG@simulate");
//        System.out.println("LOG \t nrOfplants: " + allData.getNrOfPlants());
//        System.out.println("LOG \t nrOfSimulationDays: " + allData.getNrOfSimulationDays());
//        
//        System.out.println("LOG \t plants: \t NÉV \t TÁP \t TIPUS \t ÉL");
//        System.out.println("----\t---------\t-----\t-----\t-------\t---");
//        for (int idx = 0; idx <  allData.getPlants().size(); idx++) {
//            plant plantAt = allData.getPlants().elementAt(idx);
//            System.out.println("LOG \t \t" + plantAt.getName() +"\t"+ plantAt.getNutrients() +"\t"+ plantAt.getType() +"\t"+ plantAt.isAlive());
//        }
        int emission = 0;
        int tmpAlphaEmissionClaim = 0;
        int tmpDeltaEmissionClaim = 0;
        boolean isAlphaEmission = false;
        boolean isDeltaEmission = false;
        boolean isEmissionFreeDay = true;
        
        //System.out.println("NAP \t \u2622 \t NÖVÉNYEK" );
        System.out.println("NAP \t SUGÁRZÁS \t NÖVÉNYEK" );
        for (int jdx = 0; jdx < allData.getNrOfSimulationDays(); jdx++ ){
            System.out.print(jdx+1+"   \t ");
            if(isAlphaEmission){
                System.out.println("Alpha");
            } else if(isDeltaEmission){
                System.out.println("Delta");
            } else {
                System.out.println("NINCS");
            }
            
            for (int idx = 0; idx < allData.getPlants().size(); idx++) {
                //Ha még él a növény
                if(allData.getPlants().elementAt(idx).isAlive()){
                    
                //PUFFANCS
                if(allData.getPlants().elementAt(idx).getType().equals(plantType.PUFFANCS)){
                    //sugárzás mentes napon a  tápanyag  eggyel  csökken
                    if(isEmissionFreeDay){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() - 1);
                    }

                    //Alfa sugárzás hatására a tápanyag mennyisége kettővel nő
                    if(isAlphaEmission){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() + 2);
                    }

                    //delta  sugárzás  esetén  a  tápanyag  kettővel  csökken
                    if(isDeltaEmission){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() - 2);
                    }

                    //Minden esetben  10 értékben  növeli  az  alfa sugárzás  bekövetkezését
                    tmpAlphaEmissionClaim +=10;

                    //elpusztul,  ha a  tápanyag  mennyisége  10  fölé emelkedik
                    if(allData.getPlants().elementAt(idx).getNutrients()>10){
                        allData.getPlants().elementAt(idx).setAlive(false);
                    }
                    if(allData.getPlants().elementAt(idx).getNutrients() <= 0){
                        allData.getPlants().elementAt(idx).setAlive(false);
                    }
                }

                //DELTAFA
                if(allData.getPlants().elementAt(idx).getType().equals(plantType.DELTAFA)){
                    //sugárzás nélküli napon  a  tápanyag  eggyel  csökken
                    if(isEmissionFreeDay){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() - 1);
                    }

                    //Alfa sugárzás hatására a tápanyag mennyisége hárommal csökken
                    if(isAlphaEmission){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() - 3);
                    }

                    //delta  sugárzás  hatására  a  tápanyag  néggyel  nő
                    if(isDeltaEmission){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() + 4);
                    }

                    //Ha a tápanyag mennyisége 5-nél kisebb, akkor 4 értékben növeli a delta sugárzás bekövetkezését
                    if(allData.getPlants().elementAt(idx).getNutrients() < 5){
                        tmpDeltaEmissionClaim +=4;
                    }
                    //ha 5 és 10 közé esik, akkor 1 értékben növeli a delta sugárzás bekövetkezését
                    if((allData.getPlants().elementAt(idx).getNutrients() < 10) && (allData.getPlants().elementAt(idx).getNutrients() > 5)){
                        tmpDeltaEmissionClaim +=1;
                    }
                    //ha 10-nél több, akkor nem befolyásolja a másnapi sugárzást

                    if(allData.getPlants().elementAt(idx).getNutrients() <= 0){
                        allData.getPlants().elementAt(idx).setAlive(false);
                    }
                }

                //PARABOKOR
                if(allData.getPlants().elementAt(idx).getType().equals(plantType.PARABOKOR)){
                    //Akár  alfa,  akár  delta  sugárzás  hatására  a  tápanyag  mennyisége  eggyel  nő. 
                    if(isAlphaEmission || isDeltaEmission){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() + 1);
                    }

                    //Sugárzásnélküli napon a tápanyag eggyel csökken
                    if(isEmissionFreeDay){
                        allData.getPlants().elementAt(idx).setNutrients(allData.getPlants().elementAt(idx).getNutrients() - 1);
                    }
                    //A másnapi sugárzást nem befolyásolja
                    
                    if(allData.getPlants().elementAt(idx).getNutrients() <= 0){
                        allData.getPlants().elementAt(idx).setAlive(false);
                    }
                }

                allData.getPlants().elementAt(idx).logPlant();
                }
            }
            
            //A másnapi  sugárzás alakulása:  
            //ha az alfa sugárzásra beérkezett igények összege legalább hárommal meghaladja a delta sugárzás igényeinek összegét, akkor alfa sugárzás lesz;
            //ha a delta sugárzásra igaz ugyanez, akkor delta sugárzás lesz; 
            //ha a két igény  közti  eltérés háromnál kisebb, akkor nincs sugárzás
            if(Math.abs(tmpAlphaEmissionClaim-tmpDeltaEmissionClaim) >= 3){
                //System.out.println("LOG \t |A-D|>=3");
                if(tmpAlphaEmissionClaim>tmpDeltaEmissionClaim){
                    //System.out.println("LOG \t A");
                    isAlphaEmission = true;
                    isEmissionFreeDay = false;
                    isDeltaEmission = false;
                } else {
                    //System.out.println("LOG \t D");  
                    isDeltaEmission = true;
                    isAlphaEmission = false;
                    isEmissionFreeDay = false;
                }
            } else {
                //System.out.println("LOG \t NOE");
                isEmissionFreeDay =  true;
                isDeltaEmission = false;
                isAlphaEmission = false;
            }
            tmpAlphaEmissionClaim = 0;
            tmpDeltaEmissionClaim = 0;
        }
    }
}