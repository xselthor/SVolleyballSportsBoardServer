package xselthor.app.ScoreBoard;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScoreBoardFonts {

    Font customFont;

    public void setFont(){
        try {
            //create the font to use. Specify the size!

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("SCOREBOARD.ttf")).deriveFont(12f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(customFont);
            //register the font
            //ge.registerFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }

    }
}
