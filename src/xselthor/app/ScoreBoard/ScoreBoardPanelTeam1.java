package xselthor.app.ScoreBoard;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoreBoardPanelTeam1 extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        setBackground(Color.DARK_GRAY);

        g.getFont();
        Font sizedFont = getFont().deriveFont(380f);
        g.setFont(sizedFont);
        g.setColor(Color.white);

        g.drawString("12  34", 20,400);
    }

    @Override
    public Font getFont() {
        //return super.getFont();
        try {
            InputStream is = ScoreBoardPanelTeam1.class.getResourceAsStream("SCOREBOARD.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font;
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(ScoreBoardPanelTeam1.class.getName()).log(Level.SEVERE, null, ex);
            return super.getFont();
        }
    }
}
