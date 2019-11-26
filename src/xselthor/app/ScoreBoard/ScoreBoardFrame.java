package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;


public class ScoreBoardFrame extends JFrame {
    public ScoreBoardFrame() throws HeadlessException {
        JFrame jFrame = new JFrame();

        //jFrame.setLayout(new FlowLayout());

        jFrame.setLocation(100,100);


        Color blackColor = new Color(0,0,0);


        jFrame.add(new ScoreBoardPanelTeam1());
        //jFrame.add(new ScoreBoardPanelTeam2());

        jFrame.setSize(1024,768);
        jFrame.setVisible(true);
    }


}
