package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardFrame extends JFrame {
    public ScoreBoardFrame() throws HeadlessException {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1024,768);
        ScoreBoardPanel scoreBoardPanel = new ScoreBoardPanel();
        jFrame.add(scoreBoardPanel);
        jFrame.setVisible(true);
    }
}
