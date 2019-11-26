package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardApp extends ScoreBoardData {
    public static void main(String[] args) {

        ScoreBoardData scoreBoardData = new ScoreBoardData();

        scoreBoardData.getTeam1Points();

        ScoreBoardFrame frame = new ScoreBoardFrame();



/*        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);


        JLabel label = new JLabel();

        label.setText("test test test");

        frame.getContentPane().add(label);

        frame.setVisible(true);*/

    }
}
