    package xselthor.app.ScoreBoard;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScoreBoardApp extends ScoreBoardData {

    public static void main(String[] args) throws IOException {

        // enable anti-aliased text:
        System.setProperty("awt.useSystemAAFontSettings","on");
        ScoreBoardData scoreBoardData = new ScoreBoardData();
        scoreBoardData.getTeam1Points();
        scoreBoardData.setTeam1Name("Gospodarze");
        scoreBoardData.setTeam2Name("Goście");
        scoreBoardData.setSetNumber(0);
        scoreBoardData.setTeam1WinningSet(0);
        scoreBoardData.setTeam2WinningSet(0);

        new ScoreBoardFrame();

        try (ServerSocket listener = new ServerSocket(59011)){
            System.out.println("Server is running...");
            ScoreBoardStoper stoper = new ScoreBoardStoper();
            stoper.start();
            ExecutorService pool = Executors.newFixedThreadPool(10);

            while (true){
                pool.execute(new Capitalizer(listener.accept()));
            }
        }

        /*
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        JLabel label = new JLabel();
        label.setText("test test test");
        frame.getContentPane().add(label);
        frame.setVisible(true);
        */

    }

    private static class Capitalizer implements Runnable {
        private Socket socket;
        Capitalizer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Connected: "+ socket);
            ScoreBoardData scoreBoardData = new ScoreBoardData();

            try {
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String command;
                //System.out.println("|"+command.toUpperCase()+"|");

                while (in.hasNextLine()) {
                    command = in.nextLine();
                    //command = command.substring(3);

                    if(command.contains("Team1PointsUP")){
                        scoreBoardData.Team1PointsUP();
                        out.println("t1 UP");
                        System.out.println("t1 UP");
                    }else if(command.contains("Team1PointsDown")){
                        scoreBoardData.Team1PointsDown();
                        out.println("t1 Down");
                        System.out.println("t1 Down");
                    }else if(command.contains("Team2PointsUP")){
                        scoreBoardData.Team2PointsUP();
                        out.println("Team2PointsUP");
                        System.out.println("Team2PointsUP");
                    }else if(command.contains("Team2PointsDown")){
                        scoreBoardData.Team2PointsDown();
                        out.println("Team2PointsDown");
                        System.out.println("Team2PointsDown");
                    }else if(command.contains("Team1WinningSetUp")){
                        scoreBoardData.Team1WinningSetUp();
                        out.println("Team1WinningSetUp");
                        System.out.println("Team1WinningSetUp");
                    }else if(command.contains("Team1WinningSetDown")){
                        scoreBoardData.Team1WinningSetDown();
                        out.println("Team1WinningSetDown");
                        System.out.println("Team1WinningSetDown");
                    }else if(command.contains("Team2WinningSetUp")){
                        scoreBoardData.Team2WinningSetUp();
                        out.println("Team2WinningSetUp");
                        System.out.println("Team2WinningSetUp");
                    }else if(command.contains("Team2WinningSetDown")){
                        scoreBoardData.Team2WinningSetDown();
                        out.println("Team2WinningSetDown");
                        System.out.println("Team2WinningSetDown");
                    }else if(command.contains("SetNumberUp")){
                        scoreBoardData.SetNumberUp();
                        out.println("SetNumberUp");
                        System.out.println("SetNumberUp");
                    }else if(command.contains("SetNumberDown")){
                        scoreBoardData.SetNumberDown();
                        out.println("SetNumberDown");
                        System.out.println("SetNumberDown");
                    }else if(command.contains("SetT1Name")){
                        scoreBoardData.setTeam1Name(command.substring(13));
                        out.println("Team1SetName");
                        System.out.println("Team1SetName"+command);
                    }else if(command.contains("SetT2Name")){
                        scoreBoardData.setTeam2Name(command.substring(13));
                        out.println("Team1SetName");
                        System.out.println("Team1SetName"+command);
                    }else if(command.contains("StopWatchStart")){
                        scoreBoardData.setStoperState("start");
                    }else if(command.contains("StopWatchStop")){
                        scoreBoardData.setStoperState("stop");
                    }else if(command.contains("StopWatchPause")){
                        scoreBoardData.setStoperState("pause");
                    }else if(command.contains("StopWatchResume")){
                        scoreBoardData.setStoperState("resume");
                    }else if(command.contains("StopWatchReset")){
                        scoreBoardData.setStoperState("reset");
                        System.out.println("reset");
                    }else {
                        System.out.println(command);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: "+  socket);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {}
                System.out.println("User left server : "+ socket);
            }
        }
    }
}


