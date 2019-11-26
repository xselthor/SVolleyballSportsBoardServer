package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardFrame extends JFrame {
    public ScoreBoardFrame() throws HeadlessException {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1024,768);

        ScoreBoardPanelTeam1 scoreBoardPanelTeam1 = new ScoreBoardPanelTeam1();
        Color blackColor = new Color(0,0,0);

        //jFrame.setBackground();

        jFrame.add(scoreBoardPanelTeam1);


        jFrame.setVisible(true);
    }
}
