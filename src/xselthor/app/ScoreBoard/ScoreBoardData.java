package xselthor.app.ScoreBoard;

public class ScoreBoardData {
    private static int team1Points;
    private static int team2Points;
    private static int team1WinningSet;
    private static int team2WinningSet;
    private static int setNumber;
    private static String team1Name;
    private static String team2Name;
    private static String t2; // reset czasu
    private static int windowSizeX;
    private static int windowSizeY;
    private static String StoperState;

    public void setStoperState(String stoperState) {
        StoperState = stoperState;
    }

    public static String getT2() {
        return t2;
    }

    public static void setT2(String t2) {
        ScoreBoardData.t2 = t2;
    }

    public static int getWindowSizeX() {
        return windowSizeX;
    }

    public static void setWindowSizeX(int windowSizeX) {
        ScoreBoardData.windowSizeX = windowSizeX;
    }

    public static int getWindowSizeY() {
        return windowSizeY;
    }

    public static void setWindowSizeY(int windowSizeY) {
        ScoreBoardData.windowSizeY = windowSizeY;
    }

    public int getTeam1Points() {
        return team1Points;
    }

    public void setTeam1Points(int team1Points) {
        this.team1Points = team1Points;
    }

    public void Team1PointsUP() {

        this.team1Points++;
    }

    public void Team1PointsDown() {
        this.team1Points--;
    }

    public int getTeam2Points() {
        return this.team2Points;
    }

    public void Team2PointsUP() {

        this.team2Points++;
    }

    public void Team2PointsDown() {
        this.team2Points--;
    }

    public void setTeam2Points(int team2Points) {
        this.team2Points = team2Points;
    }

    public String getTeam1WinningSet() {

        String team1WinningSet = String.valueOf(this.team1WinningSet);
        return team1WinningSet;

    }

    public void setTeam1WinningSet(int team1WinningSet) {
        this.team1WinningSet = team1WinningSet;
    }

    public void Team1WinningSetUp() {
        this.team1WinningSet++;
    }

    public void Team1WinningSetDown() {

        this.team1WinningSet--;
    }

    public String getTeam2WinningSet() {

        String team2WinningSet = String.valueOf(this.team2WinningSet);
        return team2WinningSet;

    }

    public void setTeam2WinningSet(int team2WinningSet) {
        this.team2WinningSet = team2WinningSet;
    }

    public void Team2WinningSetUp() {
        this.team2WinningSet++;
    }

    public void Team2WinningSetDown() {

        this.team2WinningSet--;
    }

    public String getSetNumber() {
        String setNumber = String.valueOf(this.setNumber);
        return setNumber;

    }

    public void setSetNumber(int setNumber) {

        this.setNumber = setNumber;
    }

    public void SetNumberUp() {

        this.setNumber++;
    }

    public void SetNumberDown() {

        this.setNumber--;
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

    public static String getStoperState() {
        return StoperState;
    }
}
