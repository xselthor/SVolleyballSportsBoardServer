package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(20,20,100,100);
    }
}
