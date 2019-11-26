package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ScoreBoardApp extends ScoreBoardData {
    public static void main(String[] args) {

        // enable anti-aliased text:
        System.setProperty("awt.useSystemAAFontSettings","on");

        ScoreBoardData scoreBoardData = new ScoreBoardData();
        scoreBoardData.getTeam1Points();
        scoreBoardData.setTeam1Name("Zasole");
        scoreBoardData.setTeam2Name("Oświęcim");
        scoreBoardData.setSetNumber(4);
        scoreBoardData.setTeam1WinningSet(2);
        scoreBoardData.setTeam2WinningSet(1);

        new ScoreBoardFrame();


/*      JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);

        JLabel label = new JLabel();
        label.setText("test test test");
        frame.getContentPane().add(label);
        frame.setVisible(true);*/

    }
}
