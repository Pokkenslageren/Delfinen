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

    public Results(double time, String competition, int placement, boolean isCompetition, String discipline) {
        this.time = time;
        this.competition = competition;
        this.placement = placement;
        this.isCompetition = isCompetition;
        this.discipline = discipline;
        this.resultId = rdm.nextInt(100,1000);
    }

    public double getTime () {
        return time;
    }

    public String getCompetition () {
        return competition;
    }

    public int getPlacement () {
        return placement;
    }

    public String getDiscipline () {
        return discipline;
    }

    public int getResultId(){
        return resultId;
    }
}
