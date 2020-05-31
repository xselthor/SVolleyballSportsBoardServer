package xselthor.app.ScoreBoard;

import org.apache.commons.lang3.time.StopWatch;

public class ScoreBoardStoper extends Thread {

    private static StopWatch stopWatch = new StopWatch();
    private ScoreBoardData scoreBoardData = new ScoreBoardData();
    private static String stoper;

    public static String getStoper() {
        return stoper;
    }

    public static void setStoper(String stoper) {
        ScoreBoardStoper.stoper = stopWatch.toString();
    }

    @Override
    public void run() {
        System.out.println("start");
        setStoper("00:00:00");
        while(true){
            if(scoreBoardData.getStoperState()=="start"){
                if(stopWatch.isStopped()) {
                    stopWatch.start();
                }
                scoreBoardData.setStoperState(" ");
            }

            if(scoreBoardData.getStoperState()=="stop"){
                if(stopWatch.isStarted()) {
                    stopWatch.stop();
                    stopWatch.reset();
                    setStoper("00:00:00");
                }
                scoreBoardData.setStoperState(" ");
            }

            if(scoreBoardData.getStoperState()=="pause" && !stopWatch.isSuspended() && !stopWatch.isStopped()){
                if(stopWatch.isStarted() || !stopWatch.isSuspended()) {
                    stopWatch.suspend();
                }
                scoreBoardData.setStoperState(" ");
            }

            if(scoreBoardData.getStoperState()=="resume" && stopWatch.isSuspended()){
                if(stopWatch.isSuspended()){
                    stopWatch.resume();
                }
                scoreBoardData.setStoperState(" ");
            }

            if(scoreBoardData.getStoperState()=="reset") {
                //if(stopWatch.isStarted()) {
                    stopWatch.reset();
                    scoreBoardData.setStoperState(" ");
                    stopWatch.start();
                //}
            }

            if(stopWatch.isStarted()){
                //System.out.println(stopWatch.getTime());
                setStoper(stopWatch.toString());
            }else{
                //System.out.println("stop");
                setStoper("");
            }
        }
    }
}
