import java.util.*;

public class Results implements java.io.Serializable {
    private static final long serialVersionUID = 6529685098267757680L;
    private double time;
    private String competition;
    private int placement;
    private boolean isCompetition;
    private String discipline;
    private int resultId;
    Random rdm = new Random();
    private boolean isUnique = false;

    public Results(double time, String competition, int placement, boolean isCompetition, String discipline) {
        this.time = time;
        this.competition = competition;
        this.placement = placement;
        this.isCompetition = isCompetition;
        this.discipline = discipline;
        this.resultId = rdm.nextInt(100,1000);
    }

    public void setTime () {
        this.time = time;
    }

    public double getTime () {
        return time;
    }

    public void setCompetition () {
        this.competition = competition;
    }

    public String getCompetition () {
        return competition;
    }

    public void setPlacement () {
        this.placement = placement;
    }

    public int getPlacement () {
        return placement;
    }

    public void setDiscipline () {
        this.discipline = discipline;
    }

    public String getDiscipline () {
        return discipline;
    }

    public boolean setIsCompetition ( boolean isCompetition){
        this.isCompetition = isCompetition;
        return true;
    }

    public boolean getIsCompetition () {
        return isCompetition;
    }

    public void setIsUnique (boolean isUnique){
        this.isUnique = isUnique;
    }

    public boolean getIsUnique () {
        return isUnique;
    }

    public int getResultId(){
        return resultId;
    }

    public void setResultId(int resultId){
        this.resultId = resultId;
    }
}
