import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class UserApp {
    public static void main(String[] args) {
        // var
        Database db = new Database();
        int banyakFilm = db.dbGetBanyakFilm();
        Color white = new Color(255, 255, 255);
        JPanel movies[] = new JPanel[banyakFilm];
        JTextArea infoText[] = new JTextArea[banyakFilm];

        // layout
        GridLayout gl = new GridLayout(0, 4, 16, 16);
        GridLayout gl2 = new GridLayout(1, 1);

        // border
        Border b = BorderFactory.createEmptyBorder(36, 36, 36, 36);
        Border b2 = BorderFactory.createEmptyBorder(36, 6, 36, 6);

        // content
        JFrame jf = new JFrame("Jalaflix-11");
        JFrame logUser = new JFrame();
        JPanel jp1 = new JPanel(gl);
        JScrollPane jsp = new JScrollPane(jp1,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.getVerticalScrollBar().setUnitIncrement(12);
        jsp.getHorizontalScrollBar().setUnitIncrement(8);

        // prelim set window
        jf.setSize(800, 600);
        jp1.setSize(800, 600);

        jf.setLayout(gl2);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp1.setBorder(b);

        // logic
        for (int i = 0; i < movies.length; i++) {
            movies[i] = new JPanel();
            movies[i].setBorder(b2);
            infoText[i] = new JTextArea(db.dbGetJudul(i));
            infoText[i].setPreferredSize(new Dimension(200, 350));
            infoText[i].setLineWrap(true);
            infoText[i].setWrapStyleWord(true);
            infoText[i].setEditable(false);
            infoText[i].setFont(new Font("Arial", Font.BOLD, 24));
            movies[i].setPreferredSize(new Dimension(200, 350));
            movies[i].setBackground(white);
            movies[i].add(infoText[i]);
            jp1.add(movies[i]);
        }
        jf.add(jsp);

        jf.revalidate();
    }
}
