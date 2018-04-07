package beadando1;
/**
 * A növény tulajdonságait tartalmazó növény típus.
 * @author Sándor
 */
public class plant {
    private String name;
    private int nutrients;
    private boolean alive;
    private plantType type;

    /**
     * Létrehozza a növyént a paraméter értékeivel és egy true életjellel.
     * @param name String
     * @param nutrients int
     * @param type plantType
     * @see plantType
     */
    public plant(String name, int nutrients, plantType type) {
        this.name = name;
        this.nutrients = nutrients;
        this.alive = true;
        this.type = type;
        
    }
    
    /**
     * Az aktuális növény tulajdonságainak kiíratáshoz.
     */
    public void logPlant(){
        System.out.println("\t \t name:"+this.name+"\tnutrients:"+this.nutrients+"\talive:"+this.alive+"\tplant_type:"+this.type);
    }

    /**
     * A növéyn típusa.
     * @param type plantType
     * @see plantType
     */
    public void setType(plantType type) {
        this.type = type;
    }

    /**
     * A növény típusát adja vissza.
     * @return plantType típust
     */
    public plantType getType() {
        return type;
    }

    /**
     * A növény nevét adja vissza
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * A növény tárolt tápanyag tartalékát adja vissza
     * @return int
     */
    public int getNutrients() {
        return nutrients;
    }

    /**
     * A növény életjeleit adja vissza, ha él még akkor igaz.  
     * @return boolean
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * A növény nevét állítja be
     * @param name String 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A növény tápanyagát állítja be
     * @param nutrients int
     */
    public void setNutrients(int nutrients) {
        this.nutrients = nutrients;
    }

    /**
     * A növény életjeleit állítja át.<br>
     * Alapértelmezett jel: true
     * @param alive boolean
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
