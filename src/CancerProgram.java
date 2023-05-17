import java.util.List;

public class CancerProgram {

    private int id;
    private String name;
    private String symptoms;
    private String chance;

    public CancerProgram(int id, String name, String symptoms, String chance) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.chance = chance;
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

    public String getChance() {

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
    public CancerProgram findCancerByChance(String chance, List<CancerProgram> cancerProgramList) {
        for (CancerProgram cp : cancerProgramList) {
            if (cp.getChance().equals(chance)) {
                return cp;
            }
        }
        return null;
    }
    public CancerProgram findCancerBySymptoms(String symptoms, List<CancerProgram> cancerProgramList) {
        for (CancerProgram cp : cancerProgramList) {
            if (cp.getSymptoms().equals(symptoms)) {
                return cp;
            }
        }
        return null;
    }

}