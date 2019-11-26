package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardPanelTeam2 extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        setSize(200,200);
        Color blackColor = new Color(0,0,0);


        g.drawRect(20,200,100,100);

        setBackground(Color.DARK_GRAY);

        Font font = new Font("Dialog", Font.BOLD, 64);
        g.setFont(font);


        g.setColor(Color.white);
        g.drawString("Witamy 2", 400,100);
    }
}
