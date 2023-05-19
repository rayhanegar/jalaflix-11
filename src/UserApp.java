import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

class Upgrade {
    public static JFrame upgradePage = new JFrame("Upgrade tier");

    Upgrade() {
        JLabel test = new JLabel("Halo dari upgrade page");
        JButton back = new JButton("go back");

        FlowLayout fl = new FlowLayout();

        upgradePage.setTitle("Upgrade akunmu!");
        upgradePage.setJMenuBar(Navbar.navbar);
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
                UserApp.mainApp.setJMenuBar(Navbar.navbar);
                UserApp.mainApp.setVisible(true);
                upgradePage.setVisible(false);
                UserApp.mainApp.repaint();
                UserApp.mainApp.revalidate();
            }
        });
    }
}

class History {
    public static JFrame historyPage = new JFrame("History page");

    History() {
        JLabel test = new JLabel("Halo dari history page");
        JButton back = new JButton("go back");

        FlowLayout fl = new FlowLayout();

        historyPage.setTitle("Baru saja ditonton");
        historyPage.setJMenuBar(Navbar.navbar);
        historyPage.setSize(800, 600);
        historyPage.setLayout(fl);
        historyPage.setVisible(false);
        historyPage.setResizable(true);
        historyPage.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        historyPage.add(test);
        historyPage.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserApp.mainApp.setJMenuBar(Navbar.navbar);
                UserApp.mainApp.setVisible(true);
                historyPage.setVisible(false);
                UserApp.mainApp.repaint();
                UserApp.mainApp.revalidate();
            }
        });
    }
}

class Navbar {
    public static JMenuBar navbar = new JMenuBar();
    public static JMenu account = new JMenu("Account");
    public static JMenuItem upgrade = new JMenuItem("Upgrade");
    public static JMenuItem history = new JMenuItem("History");
    public static JMenuItem logout = new JMenuItem("Logout");

    Navbar() {
        account.setFont(new Font("Arial", Font.PLAIN, 18));
        upgrade.setFont(new Font("Arial", Font.PLAIN, 18));
        history.setFont(new Font("Arial", Font.PLAIN, 18));
        logout.setFont(new Font("Arial", Font.PLAIN, 18));
        account.add(upgrade);
        account.add(history);
        account.add(logout);

        navbar.add(account);

        Navbar.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ngikngok) {
                int result = JOptionPane.showConfirmDialog(UserApp.mainApp, "apakah anda adus riil?", "riil adus kah?",
                        JOptionPane.YES_NO_OPTION);
                Navbar.logout.setSelected(true);
                if (result == JOptionPane.YES_OPTION) {
                    Login.logUser.setVisible(true);
                    UserApp.mainApp.setVisible(false);
                    Login.logUser.repaint();
                    Login.logUser.revalidate();
                } else if (result == JOptionPane.NO_OPTION) {
                    Navbar.logout.setSelected(false);
                }
            }
        });

        Navbar.upgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Upgrade.upgradePage.setJMenuBar(Navbar.navbar);
                Upgrade.upgradePage.setVisible(true);
                UserApp.mainApp.setVisible(false);
                Upgrade.upgradePage.repaint();
                Upgrade.upgradePage.revalidate();
            }
        });

        Navbar.history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                History.historyPage.setJMenuBar(Navbar.navbar);
                History.historyPage.setVisible(true);
                UserApp.mainApp.setVisible(false);
                History.historyPage.repaint();
                History.historyPage.revalidate();
            }
        });
    }

}

class Login {
    public static JFrame logUser = new JFrame("Login/Register");
    private static final String db = "user_database_jalaflix_11.txt";

    Login() {
        try {
            String init_data = "user01 password01 user02 password02";
            File dbUser = new File(db);
            if (dbUser.createNewFile()) {
                System.out.println("File successfully created");
                FileWriter fw = new FileWriter(db);
                fw.write(init_data);
                fw.close();
                System.out.println("Successfully written initial data");
            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.out.println("I/O error");
        }

        JLabel usernameLabel = new JLabel("username");
        JLabel passwordLabel = new JLabel("password");

        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(700, 36));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(700, 36));

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JButton logMeIn = new JButton("create and/or login");

        FlowLayout fl = new FlowLayout();

        logUser.setSize(800, 600);
        usernamePanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        passwordPanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        logMeIn.setPreferredSize(new Dimension(logUser.getWidth() - 200, 36));

        logUser.setSize(800, 600);
        logUser.setLayout(fl);
        logUser.setVisible(true);
        logUser.setResizable(true);
        logUser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        logUser.add(usernamePanel);
        logUser.add(passwordPanel);

        logUser.add(logMeIn);

        logMeIn.addActionListener(new ActionListener() {
            @Override
            /**
             * USERNAME HARUS SATU SUKU KATA, tapi kalau user input dua atau lebih, akan
             * diganti jadi underscore cek apabila text file berisi username dan password
             * kalau tidak ada, bikin baru kalau ada, masuk (tapi harus sesuai)
             */
            public void actionPerformed(ActionEvent e) {
                String temp, data = "";
                String usernameInput = usernameField.getText().replace(" ", "_");
                String passwordInput = new String(passwordField.getPassword());
                System.out.println(usernameInput + " " + passwordInput);
                if (usernameInput.equals("") || passwordInput.equals("")) {
                    System.out.println("Username atau password tidak boleh kosong");
                    return;
                }
                try {
                    FileInputStream fis = new FileInputStream(db);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    while ((temp = br.readLine()) != null) {
                        data = temp;
                    }
                    fis.getChannel().position(0);
                    br = new BufferedReader(new InputStreamReader(fis));
                    br.close();
                    // System.out.println(data); this works yay

                    String dbRaw[] = data.split(" ");
                    ArrayList<String> usernameAll = new ArrayList<>();
                    ArrayList<String> passwordAll = new ArrayList<>();
                    for (int i = 0; i < dbRaw.length; i += 2) {
                        dbRaw[i].replace("_", " ");
                        /**
                         * nanti kalau user ada bikin username dengan spasi (harusnya gabole), oleh
                         * program akan diubah menjadi underscore lalu dihapus lagi sehingga ada spasi
                         * yay
                         */
                        usernameAll.add(dbRaw[i]);
                    }
                    for (int j = 1; j < dbRaw.length; j += 2) {
                        passwordAll.add(dbRaw[j]);
                    }

                    int counter = 0;
                    for (int i = 0; i < dbRaw.length / 2; i++) {
                        if (usernameAll.get(i).equals(usernameInput)) {
                            counter++;
                        }
                    }

                    if (counter == 0) {
                        usernameAll.add(usernameInput);
                        passwordAll.add(passwordInput);
                        FileWriter fw = new FileWriter(db);
                        fw.write(data + " " + usernameInput + " " + passwordInput);
                        fw.close();
                        System.out.println("User berhasil ditambahkan");
                        // kosongkan field
                        usernameField.setText("");
                        passwordField.setText("");
                        // habis itu langsung masuk
                        UserApp.mainApp.setJMenuBar(Navbar.navbar);
                        UserApp.mainApp.setVisible(true);
                        logUser.setVisible(false);
                        UserApp.mainApp.repaint();
                        UserApp.mainApp.revalidate();
                        return;
                    } else {
                        for (int i = 0; i < dbRaw.length / 2; i++) {
                            if (usernameAll.get(i).equals(usernameInput)
                                    && passwordAll.get(i).equals(passwordInput)) {
                                System.out.println("User ada");
                                // kosongkan field
                                usernameField.setText("");
                                passwordField.setText("");
                                // habis itu langsung masuk
                                UserApp.mainApp.setJMenuBar(Navbar.navbar);
                                UserApp.mainApp.setVisible(true);
                                logUser.setVisible(false);
                                UserApp.mainApp.repaint();
                                UserApp.mainApp.revalidate();
                                return;
                            } else {
                                System.out.println("User tidak ada atau password salah");
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("I/O error");
                    ex.printStackTrace();
                }
            }
        });
    }
}

public class UserApp {
    public static JFrame mainApp = new JFrame("Jalaflix-11");

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

        // instance all pages
        new Login();
        new Navbar();
        new Upgrade();
        new History();

        // JButton logout = new JButton("Log out");
        JPanel movieHandler = new JPanel(gl);
        // JPanel navbar = new JPanel();
        JScrollPane jsp = new JScrollPane(movieHandler,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.getVerticalScrollBar().setUnitIncrement(12);
        jsp.getHorizontalScrollBar().setUnitIncrement(8);

        // navbar itu diinisialisasi di sini

        // border
        Border b = BorderFactory.createEmptyBorder(36, 36, 36, 36);
        Border b2 = BorderFactory.createEmptyBorder(0, 0, 36, 0);
        Border b3 = BorderFactory.createEmptyBorder(0, 12, 0, 0);

        // prelim set window
        mainApp.setSize(800, 600); // main program window

        movieHandler.setSize(800, 600); // isinya film
        // logout.setSize(mainApp.getWidth(), 100);

        // login doang

        // aplikasi utama
        mainApp.setVisible(false);
        mainApp.setResizable(true);
        mainApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // navbar.add(logout);
        movieHandler.setBorder(b);

        // urusan dengan yth. navbar
        Navbar.navbar.setBorder(b3);
        mainApp.setJMenuBar(Navbar.navbar);

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
            movieHandler.add(movies[i]);
        }
        // mainApp.add(navbar);
        mainApp.add(jsp);

        Login.logUser.repaint();
        mainApp.repaint();
        mainApp.revalidate();
    }
}
