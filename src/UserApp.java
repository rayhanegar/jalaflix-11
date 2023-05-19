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
    private static int userCount = 0;

    Login() {
        logUser.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // read db
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

        // initiate all profiles in db to objects
        try {
            String temp = "", data = "";
            FileInputStream fis = new FileInputStream(db);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while ((temp = br.readLine()) != null) {
                data = temp;
            }
            fis.getChannel().position(0);
            br = new BufferedReader(new InputStreamReader(fis));
            br.close();

            /**
             * kode = 6*i
             * nama = 6*i+1
             * pass = 6*i+2
             * umur = 6*i+3
             * telp = 6*i+4
             * tier = 6*i+5
             * aktif = 6*i+6
             * i = index
             */

            // splitting....
            String dbRaw[] = data.split(" ");

            // instance the users every time program starts
            for (int i = 0; i < dbRaw.length / 7; i++) {
                Pengguna.dbPengguna[i] = new Pengguna(dbRaw[i + (6 * i)], dbRaw[i + (6 * i + 1)],
                        Integer.parseInt(dbRaw[i + (6 * i + 3)]), dbRaw[i + (6 * i + 4)], dbRaw[i + (6 * i + 5)],
                        Boolean.parseBoolean(dbRaw[i + (6 * i + 6)]));
            }
        } catch (Exception e) {
            System.out.println("I/O error atau instancec user tidak dibuat");
            e.printStackTrace();
        }

        String ages[] = { "0-7", "8-12", "13-17", "18-21", "21+" };

        JLabel usernameLabel = new JLabel("username");
        JLabel passwordLabel = new JLabel("password");
        JLabel ageLabel = new JLabel("umur*");
        JLabel phoneLabel = new JLabel("telepon*");
        JLabel info = new JLabel("*WAJIB DIISI (HANYA saat login)");
        JTextArea log = new JTextArea();

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JComboBox<String> ageField = new JComboBox<String>(ages);
        JTextField phoneField = new JTextField();

        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel agePanel = new JPanel();
        JPanel phonePanel = new JPanel();

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

        // FlowLayout fl = new FlowLayout();
        // GridLayout gl = new GridLayout(0, 1, 0, 16);
        // BorderLayout bl = new BorderLayout(8, 8);

        logUser.setSize(1200, 800);
        usernamePanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        passwordPanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        agePanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        phonePanel.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        logMeIn.setPreferredSize(new Dimension(200, 36));
        info.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        log.setPreferredSize(new Dimension(logUser.getWidth(), 36));
        log.setEditable(false);
        log.setFont(new Font("Arial", Font.PLAIN, 12));

        // logUser.setLayout();
        logUser.setVisible(true);
        logUser.setResizable(true);
        logUser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        logPanel.add(usernamePanel);
        logPanel.add(passwordPanel);
        logPanel.add(agePanel);
        logPanel.add(phonePanel);
        logPanel.add(logMeIn);
        logPanel.add(info);
        logPanel.add(log);

        logUser.add(logPanel);

        logMeIn.addActionListener(new ActionListener() {
            String kode = Integer.toString((int) (Math.random() * 1000000));

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
                int tempAgeInput = ageField.getSelectedIndex();
                int AgeInput = 0;
                String phoneInput = phoneField.getText();
                System.out.println(usernameInput + " " + passwordInput);

                switch (tempAgeInput) {
                    case 0:
                        AgeInput = 7;
                        break;
                    case 1:
                        AgeInput = 12;
                        break;
                    case 2:
                        AgeInput = 17;
                        break;
                    case 3:
                        AgeInput = 20;
                        break;
                    case 4:
                        AgeInput = 21;
                        break;
                    default:
                        ;
                }

                if (usernameInput.equals("") || passwordInput.equals("")) {
                    log.setText("Username atau password tidak boleh kosong");
                    System.out.println("Username atau password tidak boleh kosong");
                    return;
                }

                // hanya ngurus login
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
                    for (int i = 0; i < dbRaw.length / 7; i++) {
                        String temq = dbRaw[i + (6 * i + 1)].replace("_", " ");
                        /**
                         * nanti kalau user ada bikin username dengan spasi (harusnya gabole), oleh
                         * program akan diubah menjadi underscore lalu dihapus lagi sehingga ada spasi
                         * yay
                         */
                        usernameAll.add(temq);
                    }
                    for (int i = 0; i < dbRaw.length / 7; i++) {
                        passwordAll.add(dbRaw[i + (6 * i + 2)]);
                    }

                    System.out.println("debug");
                    for (int i = 0; i < usernameAll.size(); i++) {
                        System.out.println(usernameAll.get(i));
                        System.out.println(passwordAll.get(i));
                    }
                    System.out.println("debug end");

                    int counter = 0;
                    for (int i = 0; i < usernameAll.size(); i++) {
                        if (usernameAll.get(i).equals(usernameInput)) {
                            counter++;
                        }
                    }

                    // urusan dengan akun
                    if (counter == 0) {
                        // buat akun baru
                        if (phoneInput.equals("")) {
                            log.setText("Nomor telepon tidak boleh kosong saat pendaftaran");
                            System.out.println("Nomor telepon tidak boleh kosong saat pendaftaran");
                            return;
                        }
                        FileWriter fw = new FileWriter(db);
                        fw.write(data + kode + " " + usernameInput + " " + passwordInput + " " + AgeInput + " "
                                + phoneInput + " " + "reguler" + " " + true + " ");
                        fw.close();
                        System.out.println("User berhasil ditambahkan");

                        /**
                         * kode = 6*i
                         * nama = 6*i+1
                         * pass = 6*i+2
                         * umur = 6*i+3
                         * telp = 6*i+4
                         * tier = 6*i+5
                         * aktif = 6*i+6
                         * i = index
                         */

                        // kosongkan field
                        usernameField.setText("");
                        passwordField.setText("");
                        ageField.setSelectedIndex(0);
                        phoneField.setText("");

                        // bikin kelas pelanggan baru
                        Pengguna.dbPengguna[userCount] = new Pengguna(kode, usernameInput, AgeInput, phoneInput,
                                "reguler", true);
                        UserApp.currentUser = Pengguna.dbPengguna[userCount];
                        userCount++;

                        // habis itu langsung masuk
                        System.out.println("selamat bergabung, " + UserApp.currentUser.getNama());
                        UserApp.mainApp.setJMenuBar(Navbar.navbar);
                        UserApp.mainApp.setVisible(true);
                        logUser.setVisible(false);
                        UserApp.mainApp.repaint();
                        UserApp.mainApp.revalidate();
                        return;
                    } else {
                        for (int i = 0; i < usernameAll.size(); i++) {
                            if (usernameAll.get(i).equals(usernameInput)
                                    && passwordAll.get(i).equals(passwordInput)) {
                                for (int j = 0; j < Pengguna.dbPengguna.length; j++) {
                                    if (Pengguna.dbPengguna[j].getNama().equals(usernameInput)) {
                                        // set current user
                                        UserApp.currentUser = Pengguna.dbPengguna[j];
                                        break;
                                    }
                                }
                                System.out.println("User ada");

                                // kosongkan field
                                usernameField.setText("");
                                passwordField.setText("");
                                ageField.setSelectedIndex(0);
                                phoneField.setText("");

                                // habis itu langsung masuk
                                System.out.println("halo, " + UserApp.currentUser.getNama());
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
    public static Pengguna currentUser;

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

                // Membuat JPanel untuk menyimpan teks dan mengatur layout manager-nya menjadi
                // FlowLayout
                JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JLabel labelSelamatMenonton = new JLabel("Selamat menonton :)");
                labelSelamatMenonton.setFont(new Font("Arial", Font.BOLD, 18));
                topPanel.add(labelSelamatMenonton);

                // Menambahkan JPanel ke panel utama
                mainPanel.add(topPanel, BorderLayout.NORTH);

                // Menambahkan gambar ke dalam JLabel dan menempatkannya di tengah
                ImageIcon icon = new ImageIcon("JALAFLIX-11/jalaflix.png"); // Ganti dengan path sesuai dengan lokasi
                                                                            // gambar Anda
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
