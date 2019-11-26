package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoreBoardPanelTeam1 extends JPanel implements ActionListener {

    Timer timer=new Timer(1000, this);
    Font h = new Font("Helvetica", Font.BOLD, 64);

    public ScoreBoardPanelTeam1() {
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ScoreBoardData scoreBoardData = new ScoreBoardData();

        setBackground(Color.DARK_GRAY);

        g.setFont(h);
        g.setColor(Color.white);

        g.drawString(scoreBoardData.getTeam1Name(), 100, 100);
        g.drawString(scoreBoardData.getTeam2Name(), 620, 100);

        //g.setFont(h);
        g.drawString("SET", 440,240);
        g.drawString("CZAS GRY", 340,540);


        g.getFont();
        g.setColor(Color.white);
        g.setFont(getFont().deriveFont(180f));

        g.drawString(scoreBoardData.getSetNumber(), 460, 380);

//        g.getFont();
//        g.setFont(getFont().deriveFont(380f));

        g.drawString(scoreBoardData.getTeam1WinningSet(), 70, 540);
        g.drawString(scoreBoardData.getTeam2WinningSet(), 830, 540);

        g.setFont(getFont().deriveFont(380f));
        g.drawString("12  34", 20,400);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String t1 = LocalTime.now().format(dtf);

        g.setColor(new Color(255, 255, 255));
        g.setFont(getFont().deriveFont(180f));
        g.drawString(t1, 140, 700);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            repaint();// this will call at every 1 second
        }
    }
}
