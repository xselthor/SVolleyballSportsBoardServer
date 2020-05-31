package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoreBoardPanel extends JPanel implements ActionListener {

    int fontSize;
    Timer timer=new Timer(1000, this);

    public ScoreBoardPanel() {
        timer.start();
    }
    ScoreBoardStoper scoreBoardStoper = new ScoreBoardStoper();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Font h = new Font("Helvetica", Font.BOLD, 80);

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Window w = SwingUtilities.getWindowAncestor(this);
        float sizeMod = (w.getSize().width*10)/100;
        //System.out.println(sizeMod);
        //System.out.println(percent);

        ScoreBoardData scoreBoardData = new ScoreBoardData();

        //System.out.println();

        setBackground(Color.DARK_GRAY);
        //setBackground(Color.black);
        g.setFont(h);
        g.setColor(Color.white);

       // screenSize.width;
        g.drawString(scoreBoardData.getTeam1Name(), 80, 100);
        g.drawString(scoreBoardData.getTeam2Name(), 800, 100);

        //g.setFont(h);
        g.drawString("SET", 570,240);
        g.drawString("CZAS GRY", 450,540);

        g.getFont();
        g.setColor(Color.white);

        g.setFont(getFont().deriveFont(200f));

        g.drawString(scoreBoardData.getSetNumber(), 600, 420);

        g.drawString(scoreBoardData.getTeam1WinningSet(), 120, 640);
        g.drawString(scoreBoardData.getTeam2WinningSet(), 1060, 640);

        g.setFont(getFont().deriveFont(400f));
        String te1 = String.format("%02d", scoreBoardData.getTeam1Points());
        String te2 = String.format("%02d", scoreBoardData.getTeam2Points());

        g.drawString(te1, 80,450);
        g.drawString(te2, 800,450);

        // Czas gry
        g.setColor(new Color(255, 255, 255));
        g.setFont(getFont().deriveFont(160f));

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        //String t1 = LocalTime.now().format(dtf);

        String t1 = scoreBoardStoper.getStoper().substring(0,8);


        g.drawString(t1, 320, 690);

    }

    @Override
    public Font getFont() {
        //return super.getFont();
        try {
            InputStream is = ScoreBoardPanel.class.getResourceAsStream("SCOREBOARD.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font;
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(ScoreBoardPanel.class.getName()).log(Level.SEVERE, null, ex);
            return super.getFont();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            repaint();// this will call at every 1 second
        }
    }
}
