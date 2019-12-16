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
        scoreBoardData.setTeam1Name("Zasole");
        scoreBoardData.setTeam2Name("Oświęcim");
        scoreBoardData.setSetNumber(0);
        scoreBoardData.setTeam1WinningSet(0);
        scoreBoardData.setTeam2WinningSet(0);

        new ScoreBoardFrame();

        try (ServerSocket listener = new ServerSocket(59010)){
            System.out.println("Server is running...");

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

                String command = in.nextLine();

                while (in.hasNextLine()) {
                    command = in.nextLine();
                    //out.println(command.toUpperCase());

                    if(command.startsWith("Team1PointsUP")){
                        scoreBoardData.Team1PointsUP();
                    }else if(command.startsWith("Team1PointsDown")){
                        scoreBoardData.Team1PointsDown();
                    }else if(command.startsWith("Team2PointsUP")){
                        scoreBoardData.Team2PointsUP();
                    }else if(command.startsWith("Team2PointsDown")){
                        scoreBoardData.Team2PointsDown();
                    }else if(command.startsWith("Team1WinningSetUp")){
                        scoreBoardData.Team1WinningSetUp();
                    }else if(command.startsWith("Team1WinningSetDown")){
                        scoreBoardData.Team1WinningSetDown();
                    }else if(command.startsWith("Team2WinningSetUp")){
                        scoreBoardData.Team2WinningSetUp();
                    }else if(command.startsWith("Team2WinningSetDown")){
                        scoreBoardData.Team2WinningSetDown();
                    }else if(command.startsWith("SetNumberUp")){
                        scoreBoardData.SetNumberUp();
                    }else if(command.startsWith("SetNumberDown")){
                        scoreBoardData.SetNumberDown();
                    }else if(command.startsWith("Team1SetName")){
                        scoreBoardData.setTeam1Name(command.replaceFirst("^Team1SetName:", ""));
                    }else if(command.startsWith("Team2SetName")){
                        scoreBoardData.setTeam2Name(command.replaceFirst("^Team2SetName:", ""));
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


