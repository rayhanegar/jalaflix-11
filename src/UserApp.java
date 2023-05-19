import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

// jdk-18.0.2

class Upgrade {
    public static JFrame upgradePage = new JFrame("Upgrade Tier");

    Upgrade() {
        JButton back = new JButton("go back");
        FlowLayout fl = new FlowLayout();

        upgradePage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        upgradePage.setTitle("Upgrade akunmu!");
        upgradePage.setJMenuBar(Navbar.navbar);
        upgradePage.setSize(1200, 800);
        upgradePage.setLayout(fl);
        upgradePage.setVisible(false);
        upgradePage.setResizable(true);
        upgradePage.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // Create panel for tier

        // Create panel for current tier information

        // Di dalem panel tier: gambar tier, nama tier, deskripsi, harga, sama tombol
        // Tombol -> masuk ke dalam detail panel, yang lain setVisible(false)
        // Di dalem detail panel, ada button for pay
        // click pay -> new window

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

        historyPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        historyPage.setTitle("Baru saja ditonton");
        historyPage.setJMenuBar(Navbar.navbar);
        historyPage.setSize(1200, 800);
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
    public static JPanel logPanel = new JPanel();

    private static final String db = "user_database_jalaflix_11.txt";

    Login() {
        logUser.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
        JLabel ageLabel = new JLabel("umur");
        JLabel phoneLabel = new JLabel("telepon");

        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel agePanel = new JPanel();
        JPanel phonePanel = new JPanel();

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField ageField = new JTextField();
        JTextField phoneField = new JTextField();

        usernameField.setPreferredSize(new Dimension(350, 36));
        passwordField.setPreferredSize(new Dimension(350, 36));
        ageField.setPreferredSize(new Dimension(350, 36));
        phoneField.setPreferredSize(new Dimension(350, 36));

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        agePanel.add(ageLabel);
        agePanel.add(ageField);

        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);

        JButton logMeIn = new JButton("create and/or login");

        FlowLayout fl = new FlowLayout();
        GridLayout gl = new GridLayout(0, 1, 0, 16);
        BorderLayout bl = new BorderLayout(8, 8);

        logUser.setSize(1200, 800);
        usernamePanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        passwordPanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        agePanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        phonePanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        logMeIn.setPreferredSize(new Dimension(200, 36));

        // logUser.setLayout();
        logUser.setVisible(true);
        logUser.setResizable(true);
        logUser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        logPanel.add(usernamePanel);
        logPanel.add(passwordPanel);
        logPanel.add(agePanel);
        logPanel.add(phonePanel);
        logPanel.add(logMeIn);

        logUser.add(logPanel);

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
        mainApp.setSize(1200, 800); // main program window

        movieHandler.setSize(1200, 800); // isinya film
        // logout.setSize(mainApp.getWidth(), 100);

        // login doang

        // aplikasi utama
        mainApp.setVisible(false);
        mainApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
            infoText[i].setPreferredSize(new Dimension(160, 250));
            infoText[i].setLineWrap(true);
            infoText[i].setWrapStyleWord(true);
            infoText[i].setEditable(false);
            infoText[i].setFont(new Font("Arial", Font.BOLD, 24));
        
            JTextArea sinopsisText = new JTextArea(db.dbGetSinopsis(i));
            sinopsisText.setPreferredSize(new Dimension(200, 200));
            sinopsisText.setLineWrap(true);
            sinopsisText.setWrapStyleWord(true);
            sinopsisText.setEditable(false);
            sinopsisText.setFont(new Font("Arial", Font.PLAIN, 12));
        
            movies[i].setPreferredSize(new Dimension(200, 500));
            movies[i].setBackground(white);
        
            JButton tombolTonton = new JButton("Tonton");
            tombolTonton.setActionCommand(String.valueOf(i));
        
            movies[i].setLayout(new BoxLayout(movies[i], BoxLayout.Y_AXIS));
            movies[i].add(infoText[i]);
            movies[i].add(sinopsisText);
            movies[i].add(Box.createVerticalGlue());
            movies[i].add(tombolTonton);
        
            movieHandler.add(movies[i]);
        
            tombolTonton.addActionListener((ActionEvent e) -> {
                int filmIndex = Integer.parseInt(e.getActionCommand());
                String judulFilm = db.dbGetJudul(filmIndex);
            
                JFrame newFrame = new JFrame(judulFilm);
                newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Mengatur JFrame menjadi fullscreen
            
                // Membuat panel utama dengan layout manager BorderLayout
                JPanel mainPanel = new JPanel(new BorderLayout());
            
                // Membuat JPanel untuk menyimpan teks dan mengatur layout manager-nya menjadi FlowLayout
                JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JLabel labelSelamatMenonton = new JLabel("Selamat menonton :)");
                labelSelamatMenonton.setFont(new Font("Arial", Font.BOLD, 18));
                topPanel.add(labelSelamatMenonton);
            
                // Menambahkan JPanel ke panel utama
                mainPanel.add(topPanel, BorderLayout.NORTH);
            
                // Menambahkan gambar ke dalam JLabel dan menempatkannya di tengah
                ImageIcon icon = new ImageIcon("JALAFLIX-11/jalaflix.png"); // Ganti dengan path sesuai dengan lokasi gambar Anda
                JLabel labelGambar = new JLabel(icon);
                labelGambar.setHorizontalAlignment(JLabel.CENTER);
                mainPanel.add(labelGambar, BorderLayout.CENTER);
            
                newFrame.getContentPane().add(mainPanel); // Menambahkan panel utama ke dalam content pane JFrame
            
                newFrame.setVisible(true);
            });
            
            
            
            
        }
        
        // mainApp.add(navbar);
        mainApp.add(jsp);

        Login.logUser.repaint();
        mainApp.repaint();
        mainApp.revalidate();
    }
}
