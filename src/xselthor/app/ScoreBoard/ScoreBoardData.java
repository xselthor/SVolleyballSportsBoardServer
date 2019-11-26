package xselthor.app.ScoreBoard;

public class ScoreBoardData {
    private int team1Points;
    private int team2Points;
    private int team1WinningSet;
    private int team2WinningSet;
    private int setNumber;
    private String team1Name;
    private String team2Name;


    public int getTeam1Points() {
        return team1Points;
    }

    public void setTeam1Points(int team1Points) {
        this.team1Points = team1Points;
    }

    public void Team1PointsUP() {
        this.team1Points = this.team1Points++;
    }

    public void Team1PointsDown() {
        this.team1Points = this.team1Points--;
    }

    public int getTeam2Points() {
        return team2Points;
    }

    public void Team2PointsUP() {
        this.team2Points = this.team2Points++;
    }

    public void Team2PointsDown() {
        this.team2Points = this.team2Points--;
    }

    public void setTeam2Points(int team2Points) {
        this.team2Points = team2Points;
    }

    public int getTeam1WinningSet() {
        return team1WinningSet;
    }

    public void setTeam1WinningSet(int team1WinningSet) {
        this.team1WinningSet = team1WinningSet;
    }

    public void setTeam1WinningSetUp(){
        this.team1WinningSet = this.team1WinningSet++;
    }

    public void setTeam1WinningSetDown(){
        this.team1WinningSet = this.team1WinningSet--;
    }

    public int getTeam2WinningSet() {
        return team2WinningSet;
    }

    public void setTeam2WinningSet(int team2WinningSet) {
        this.team2WinningSet = team2WinningSet;
    }

    public void setTeam2WinningSetUp() {
        this.team2WinningSet = this.team2WinningSet++;
    }

    public void setTeam2WinningSetDown() {
        this.team2WinningSet = this.team2WinningSet--;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public void setSetNumberUp() {
        this.setNumber = this.setNumber++;
    }

    public void setSetNumberDown() {
        this.setNumber = this.setNumber--;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }
}
