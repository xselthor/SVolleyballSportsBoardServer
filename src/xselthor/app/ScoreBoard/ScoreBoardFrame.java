package xselthor.app.ScoreBoard;

import javax.swing.*;
import java.awt.*;


public class ScoreBoardFrame extends JFrame {
    public ScoreBoardFrame() throws HeadlessException {

        ScoreBoardData scoreBoardData = new ScoreBoardData();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        jFrame.setLocation(0,0);
        jFrame.setSize(screenSize.width,screenSize.height);

        jFrame.setUndecorated(true);
        //jFrame.setLayout(new FlowLayout());

        Color blackColor = new Color(0,0,0);

        ScoreBoardPanel pane =new ScoreBoardPanel();
        pane.setBorder(BorderFactory.createLineBorder(Color.black));

        jFrame.getContentPane().add(pane);
        jFrame.setVisible(true);

        Dimension windowSize = jFrame.getSize();
        scoreBoardData.setWindowSizeX(windowSize.width);
        scoreBoardData.setWindowSizeY(windowSize.height);
    }



}
