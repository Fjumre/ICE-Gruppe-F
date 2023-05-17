import java.util.List;

public class CancerProgram {

    private int id;
    private String name;
    private String symptoms;
    private float chance;

    public CancerProgram(int id, String name, String symptoms, float chance) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.chance = chance;
    }

    public CancerProgram(String id, String name, String symptoms, String chance) {
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public String getSymptoms() {

        return symptoms;
    }

    public float getChance() {

        return chance;
    }

    public CancerProgram findCancerByName(String name, List<CancerProgram> cancerProgramList) {
        for (CancerProgram cp : cancerProgramList) {
            if (cp.getName().equals(name)) {
                return cp;
            }
        }
        return null;
    }

}