import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserApp {
    public static void main(String[] args) {
        // var
        Database db = new Database();
        int banyakFilm = db.dbGetBanyakFilm();
        Color white = new Color(255, 255, 255);
        JPanel movies[] = new JPanel[banyakFilm];
        JTextArea infoText[] = new JTextArea[banyakFilm];

        // content and layout
        GridLayout gl = new GridLayout(0, 4, 16, 16);
        GridLayout gl2 = new GridLayout(2, 1);
        JFrame jf = new JFrame("Jalaflix-11");
        JFrame logUser = new JFrame("Login/Register");
        JLabel logUserL1 = new JLabel("di sini nanti ada fitur login. login = bikin akun baru biar gampang");
        JButton login = new JButton("login (button sementara)");
        JButton logout = new JButton("Log out");
        JPanel jp1 = new JPanel(gl);
        JPanel navbar = new JPanel();
        JScrollPane jsp = new JScrollPane(jp1,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.getVerticalScrollBar().setUnitIncrement(12);
        jsp.getHorizontalScrollBar().setUnitIncrement(8);

        // border
        Border b = BorderFactory.createEmptyBorder(36, 36, 36, 36);
        Border b2 = BorderFactory.createEmptyBorder(36, 6, 36, 6);

        // prelim set window
        jf.setSize(800, 600); // main program window
        logUser.setSize(800, 600);
        logUserL1.setSize(logUser.getWidth(), logUser.getHeight());
        login.setBounds(36, 36, 360, 36);
        jp1.setSize(800, 600); // isinya film
        logout.setSize(jf.getWidth(), 100);

        logUser.setLayout(null);
        logUser.setVisible(true);
        logUser.setResizable(true);
        logUser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logUserL1.setBorder(b);
        login.setBorder(b);
        logUser.add(login);
        logUser.add(logUserL1);

        jf.setLayout(gl2);
        jf.setVisible(false);
        jf.setResizable(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        navbar.add(logout);
        jp1.setBorder(b);

        // logic
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jf.setVisible(true);
                logUser.setVisible(false);
                jf.repaint();
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                logUser.setVisible(true);
                jf.setVisible(false);
                logUser.repaint();
            }
        });

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
        jf.add(navbar);
        jf.add(jsp);

        logUser.repaint();
        jf.repaint();
    }
}
