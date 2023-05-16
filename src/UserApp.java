import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Upgrade {
    public static JFrame upgradePage = new JFrame("Upgrade tier");

    Upgrade() {
        JLabel test = new JLabel("Halo dari upgrade page");
        JButton back = new JButton("go back");

        FlowLayout fl = new FlowLayout();

        upgradePage.setSize(800, 600);
        upgradePage.setLayout(fl);
        upgradePage.setVisible(false);
        upgradePage.setResizable(true);
        upgradePage.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        upgradePage.add(test);
        upgradePage.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserApp.mainApp.setVisible(true);
                upgradePage.setVisible(false);
                UserApp.mainApp.repaint();
                UserApp.mainApp.revalidate();
            }
        });
    }
}

class History {
    public static JFrame HistoryPage = new JFrame("History page");

    History() {
        JLabel test = new JLabel("Halo dari history page");
        JButton back = new JButton("go back");

        FlowLayout fl = new FlowLayout();

        HistoryPage.setSize(800, 600);
        HistoryPage.setLayout(fl);
        HistoryPage.setVisible(false);
        HistoryPage.setResizable(true);
        HistoryPage.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        HistoryPage.add(test);
        HistoryPage.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserApp.mainApp.setVisible(true);
                HistoryPage.setVisible(false);
                UserApp.mainApp.repaint();
                UserApp.mainApp.revalidate();
            }
        });
    }
}

public class UserApp {
    public static JFrame mainApp = new JFrame("Jalaflix-11");
    public static JFrame logUser = new JFrame("Login/Register");

    public static void main(String[] args) {
        // var
        Database db = new Database();
        int banyakFilm = db.dbGetBanyakFilm();
        Color white = new Color(255, 255, 255);
        JPanel movies[] = new JPanel[banyakFilm];
        JTextArea infoText[] = new JTextArea[banyakFilm];

        // content and layout
        GridLayout gl = new GridLayout(0, 4, 16, 16);
        // GridLayout gl2 = new GridLayout(2, 1);

        JLabel logUserL1 = new JLabel("di sini nanti ada fitur login. login = bikin akun baru biar gampang");
        JButton login = new JButton("login (button sementara)");

        JMenu account = new JMenu("Account");
        JMenuItem upgrade = new JMenuItem("Upgrade");
        JMenuItem history = new JMenuItem("History");
        JMenuItem logout = new JMenuItem("Logout");
        account.setFont(new Font("Arial", Font.PLAIN, 18));
        upgrade.setFont(new Font("Arial", Font.PLAIN, 18));
        history.setFont(new Font("Arial", Font.PLAIN, 18));
        logout.setFont(new Font("Arial", Font.PLAIN, 18));
        account.add(upgrade);
        account.add(history);
        account.add(logout);
        JMenuBar navbar = new JMenuBar();
        navbar.add(account);

        // JButton logout = new JButton("Log out");
        JPanel movieHandler = new JPanel(gl);
        // JPanel navbar = new JPanel();
        JScrollPane jsp = new JScrollPane(movieHandler,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.getVerticalScrollBar().setUnitIncrement(12);
        jsp.getHorizontalScrollBar().setUnitIncrement(8);

        // border
        Border b = BorderFactory.createEmptyBorder(36, 36, 36, 36);
        Border b2 = BorderFactory.createEmptyBorder(0, 0, 36, 0);
        Border b3 = BorderFactory.createEmptyBorder(0, 12, 0, 0);

        // prelim set window
        mainApp.setSize(800, 600); // main program window
        logUser.setSize(800, 600);
        logUserL1.setSize(logUser.getWidth(), logUser.getHeight());
        login.setBounds(36, 36, 360, 36);
        movieHandler.setSize(800, 600); // isinya film
        // logout.setSize(mainApp.getWidth(), 100);

        // login doang
        logUser.setLayout(null);
        logUser.setVisible(true);
        logUser.setResizable(true);
        logUser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logUserL1.setBorder(b);
        login.setBorder(b);
        logUser.add(login);
        logUser.add(logUserL1);

        // aplikasi utama
        mainApp.setVisible(false);
        mainApp.setResizable(true);
        mainApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // navbar.add(logout);
        movieHandler.setBorder(b);

        // urusan dengan yth. navbar
        navbar.setBorder(b3);
        mainApp.setJMenuBar(navbar);

        // logic
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainApp.setVisible(true);
                logUser.setVisible(false);
                mainApp.repaint();
                mainApp.revalidate();
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ngikngok) {
                int result = JOptionPane.showConfirmDialog(mainApp, "apakah anda adus riil?", "riil adus kah?",
                        JOptionPane.YES_NO_OPTION);
                logout.setSelected(true);
                if (result == JOptionPane.YES_OPTION) {
                    logUser.setVisible(true);
                    mainApp.setVisible(false);
                    logUser.repaint();
                    logUser.revalidate();
                } else if (result == JOptionPane.NO_OPTION) {
                    logout.setSelected(false);
                }
            }
        });

        upgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Upgrade(); // instance it first
                Upgrade.upgradePage.setVisible(true);
                mainApp.setVisible(false);
                Upgrade.upgradePage.repaint();
                Upgrade.upgradePage.revalidate();
            }
        });

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new History(); // instance it first
                History.HistoryPage.setVisible(true);
                mainApp.setVisible(false);
                History.HistoryPage.repaint();
                History.HistoryPage.revalidate();
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
            movieHandler.add(movies[i]);
        }
        // mainApp.add(navbar);
        mainApp.add(jsp);

        logUser.repaint();
        mainApp.repaint();
        mainApp.revalidate();
    }
}
