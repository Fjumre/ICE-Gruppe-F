import java.util.ArrayList;
import java.util.List;

public class CancerProgram extends Main{

    int ID;
    String name;
    String symptoms;
    Float chance;
    List<CancerInfo> showSymptoms= new ArrayList<>();
    List<CancerInfo> showCancer = new ArrayList<>();



    public CancerProgram(int ID, String name, String symptoms, Float chance, List<CancerInfo> showCancer) {
        this.ID = ID;
        this.name = name;
        this.chance = chance;
        this.symptoms = symptoms;
        this.showCancer = showCancer;
    }

    public List<CancerInfo> getShowCancer(){
        return showCancer;
    }
    public String getName() {
        return name;
    }

    public Float getChance() {
        return chance;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public int getID() {
        return ID;
    }
}