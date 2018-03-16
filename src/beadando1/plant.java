package beadando1;
public class plant {
    private String name;
    private int nutrients;
    private boolean alive;
    private plantType type;

    public plant(String name, int nutrients, plantType type) {
        this.name = name;
        this.nutrients = nutrients;
        this.alive = true;
        this.type = type;
        
    }
    
    public void logPlant(){
        System.out.println("\t \t name:"+this.name+"\tnutrients:"+this.nutrients+"\talive:"+this.alive+"\tplant_type:"+this.type);
    }

    public void setType(plantType type) {
        this.type = type;
    }

    public plantType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getNutrients() {
        return nutrients;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNutrients(int nutrients) {
        this.nutrients = nutrients;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
