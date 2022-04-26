public class NBAstat implements Comparable <NBAstat> {

    //name,FGA,FGM,FT%,3PT%,PTS,REB,AST,ST,BLK,TO
    private String playerName;
    private int fieldGoalsAttempted;
    private int fieldGoalMade;
    private double freeThrowPercentage;
    private double threePointPercentage;
    private int Points;
    private int Rebounds;
    private int Assists;
    private int Steals;
    private int Blocks;
    private int Turnovers;

    // default constructor
    public NBAstat() {
        this.playerName = "none";
        this.fieldGoalMade = 0;
        this.fieldGoalsAttempted = 0;
        this.freeThrowPercentage = 0;
        this.threePointPercentage = 0;
        this.Points = 0;
        this.Rebounds = 0;
        this.Assists = 0;
        this.Steals = 0;
        this.Blocks = 0;
        this.Turnovers = 0;
    }

    // constructor
    public NBAstat(String playerName, int fieldGoalsAttempted, int fieldGoalMade, double freeThrowPercentage, double threePointPercentage, int Points, int Rebounds, int Assists, int Steals, int Blocks, int Turnovers) {

        this.playerName = playerName;
        this.fieldGoalMade = fieldGoalMade;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.freeThrowPercentage = freeThrowPercentage;
        this.threePointPercentage = threePointPercentage;
        this.Points = Points;
        this.Rebounds = Rebounds;
        this.Assists = Assists;
        this.Steals = Steals;
        this.Blocks = Blocks;
        this.Turnovers = Turnovers;
    }

    public NBAstat(NBAstat nbAstat) {
    }

    // String interface for

    public String toString(NBAstat player) { // To string method
        String Info = "";
        // for (NBAstat player : NBAplayers {
        Info = player.getPlayerName() + ", Rebounds: "+ player.getRebounds() + ", Total Points: " + player.getPoints() + ", Field Goal Percentage: " + player.getfieldGoalPercentage();
        // }
        return Info;
    }

    protected String getPlayerName() {
        return this.playerName;
    }

    public double getfieldGoalPercentage() { // calculate field goal percentage based on made and attempted shots
        if (this.fieldGoalsAttempted != 0) {
            double fieldGoalPercentage = (double) this.fieldGoalMade / this.fieldGoalsAttempted;
            return fieldGoalPercentage;
        }
        else {
            return 0;
        }
    }
    public int getPoints() { // display points
        return this.Points;
    }
    public int getRebounds() { // display rebounds
        return this.Rebounds;
    }

    @Override
    public int compareTo(NBAstat player) {
        return Double.compare(getfieldGoalPercentage(), player.getfieldGoalPercentage());
    }



}


