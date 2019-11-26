package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class ScoreBoardFrame extends JFrame {
    public ScoreBoardFrame() throws HeadlessException {
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new FlowLayout());
        jFrame.setLocation(100,100);
        jFrame.setSize(1024,768);

        //ScoreBoardPanelTeam1 scoreBoardPanelTeam1 = new ScoreBoardPanelTeam1();
        //ScoreBoardPanelTeam2 scoreBoardPanelTeam2 = new ScoreBoardPanelTeam2();

        Color blackColor = new Color(0,0,0);

        //jFrame.setBackground();

        jFrame.add(new ScoreBoardPanelTeam1());
        jFrame.add(new ScoreBoardPanelTeam2());

        jFrame.setVisible(true);
    }
}
