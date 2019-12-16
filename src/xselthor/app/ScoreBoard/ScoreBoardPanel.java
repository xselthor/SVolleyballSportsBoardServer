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

public class ScoreBoardPanel extends JPanel implements ActionListener {

    int fontSize;
    Timer timer=new Timer(1000, this);

    public ScoreBoardPanel() {
        timer.start();
    }


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
        g.drawString(scoreBoardData.getTeam1Name(), 120, 150);
        g.drawString(scoreBoardData.getTeam2Name(), 1400, 150);

        //g.setFont(h);
        g.drawString("SET", 850,280);
        g.drawString("CZAS GRY", 750,790);


        g.getFont();
        g.setColor(Color.white);

        g.setFont(getFont().deriveFont(300f));

        g.drawString(scoreBoardData.getSetNumber(), 850, 540);

        g.drawString(scoreBoardData.getTeam1WinningSet(), 120, 940);
        g.drawString(scoreBoardData.getTeam2WinningSet(), 1660, 940);

        g.setFont(getFont().deriveFont(600f));
        String te1 = String.format("%02d", scoreBoardData.getTeam1Points());
        String te2 = String.format("%02d", scoreBoardData.getTeam2Points());

        g.drawString(te1, 100,650);
        g.drawString(te2, 1200,650);

        // Czas gry
        g.setColor(new Color(255, 255, 255));
        g.setFont(getFont().deriveFont(220f));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String t1 = LocalTime.now().format(dtf);
        //String t2 = LocalTime.now().format(dtf);

        g.drawString(t1, 520, 1000);

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
