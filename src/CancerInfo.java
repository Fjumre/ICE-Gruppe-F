public class CancerInfo {

    int ID;
    String name;
    String symptoms;
    Float chance;
    public CancerInfo(int ID, String name, String symptoms, Float chance) {
        this.ID = ID;
        this.name = name;
        this.symptoms = symptoms;
        this.chance = chance;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms(){
        return symptoms;
    }

    public Float getChance() {
        return chance;
    }
}