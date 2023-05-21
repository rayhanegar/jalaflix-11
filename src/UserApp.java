import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

// jdk-18.0.2
// temp alt version

class Upgrade extends JFrame {
    public static JFrame upgradePage = new JFrame("Upgrade Tier");
    private JPanel upgradePanel;
    private JButton jbBack;
    private JPanel jpHeading;
    private JLabel jlHeading;
    private JPanel jpTierOptions;
    private JPanel jpReg;
    private JLabel jlRegHeading;
    private JPanel jpGold;
    private JLabel jlGoldHeading;
    private JPanel jpPlat;
    private JLabel jlRegDesc;
    private JLabel jlGoldDesc;
    private JLabel jlPlatHeading;
    private JLabel jlPlatDesc;
    private JButton jbReg;
    private JButton jbGold;
    private JButton jbPlat;
    private static String[] info = new String[2];

    Upgrade() {

        upgradePage.setContentPane(upgradePanel);
        upgradePage.setSize(1200, 800);
        upgradePage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        upgradePage.setVisible(false);
        upgradePage.setTitle("Upgrade Tier");
        upgradePage.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        upgradePage.setJMenuBar(Navbar.navbar);

        jbReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info[0] = "Regular";
                info[1] = "Rp30,000.00";
                new PaymentPage(info[0], info[1]);
            }
        });

        jbGold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info[0] = "Gold";
                info[1] = "Rp50,000.00";
                new PaymentPage(info[0], info[1]);
            }
        });

        jbPlat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info[0] = "Platinum";
                info[1] = "Rp80,000.00";
                new PaymentPage(info[0], info[1]);
            }
        });

        jbBack.addActionListener(new ActionListener() {
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

class PaymentPage extends JFrame {

    static JFrame paymentPage = new JFrame();
    private JPanel paymentPanel;
    private JPanel jpHeading;
    private JButton jbBack;
    private JLabel jlHeading;
    private JPanel jpInfoPayment;
    private JLabel jlTransactionDetail;
    private JLabel jlTier;
    private JLabel jlMasaLangganan;
    private JLabel jlBiaya;
    private JLabel jlMetode;
    private JPanel jpQris;
    private JLabel jlIdTransaksi;
    private JLabel jlQris;
    private JButton jbConfirm;

    PaymentPage(String tier, String harga) {
        paymentPage.setContentPane(paymentPanel);
        paymentPage.setVisible(true);
        paymentPage.setExtendedState(MAXIMIZED_BOTH);
        paymentPage.setSize(1200, 800);
        paymentPage.setTitle("Payment Page");
        paymentPage.setDefaultCloseOperation(HIDE_ON_CLOSE);
        String idBayar = Integer.toString((int) (Math.random() * Math.pow(10, 6)));
        jlIdTransaksi.setText(jlIdTransaksi.getText() + idBayar);
        jlTier.setText(jlTier.getText() + tier);
        jlBiaya.setText(jlBiaya.getText() + harga);

        // Add logic for jbConfirm (Change member's tier, etc.)
        jbConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jbBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Upgrade.upgradePage.setJMenuBar(Navbar.navbar);
                Upgrade.upgradePage.setVisible(true);
                PaymentPage.paymentPage.setVisible(false);
                Upgrade.upgradePage.repaint();
                Upgrade.upgradePage.revalidate();
            }
        });
    }
}

class History {
    public static JFrame historyPage = new JFrame("History page");
    public static JPanel historyPanel = new JPanel();
    public static JPanel historyInfoPanel = new JPanel();
    private static JLabel movieHistoryLabel[];
    private static JPanel movieHistoryPanel[];
    private static Film historyBucket[];
    private static final int MAX_BUCKET_ITEM = 8;
    private static Border b = BorderFactory.createEmptyBorder(36, 36, 36, 36);
    private static GridLayout gl = new GridLayout(0, 4, 16, 16);
    private static Border parent = BorderFactory.createEmptyBorder(12, 36, 36, 36);

    History() {
        movieHistoryLabel = new JLabel[MAX_BUCKET_ITEM];
        movieHistoryPanel = new JPanel[MAX_BUCKET_ITEM];
        historyBucket = new Film[MAX_BUCKET_ITEM];

        JLabel test = new JLabel("Sepuluh film yang baru saja Anda tonton!");
        JButton back = new JButton("go back");
        test.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        test.setFont(new Font("Segoe UI", Font.BOLD, 18));

        historyPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        historyPage.setTitle("Baru saja ditonton");
        historyPage.setJMenuBar(Navbar.navbar);
        historyPage.setSize(1200, 800);

        historyPage.getContentPane().setLayout(new BoxLayout(historyPage.getContentPane(), BoxLayout.Y_AXIS));
        historyPage.setVisible(false);
        historyPage.setResizable(true);
        historyPage.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // historyInfoPanel.setBounds(36, 36, 1920, 1080);
        historyInfoPanel.setBorder(b);
        historyInfoPanel.setLayout(new BoxLayout(historyInfoPanel, BoxLayout.Y_AXIS));
        historyInfoPanel.add(back);
        historyInfoPanel.add(test);
        // historyInfoPanel.setBackground(Color.BLUE);

        historyPage.add(historyInfoPanel);

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

    public static void paintMovieHistory(Pengguna currentUser) {
        historyBucket = currentUser.getRecentHistory();
        historyPanel.removeAll();
        historyPanel.setLayout(gl);
        historyPanel.setBorder(parent);
        for (int i = 0; i < historyBucket.length; i++) {
            if (historyBucket[i] != null) {
                movieHistoryPanel[i] = new JPanel();
                movieHistoryPanel[i].setBorder(b);
                movieHistoryLabel[i] = new JLabel(historyBucket[i].getJudul());
                movieHistoryLabel[i].setFont(new Font("Segoe UI", Font.BOLD, 24));
                movieHistoryPanel[i].setLayout(new BoxLayout(movieHistoryPanel[i], BoxLayout.Y_AXIS));
                movieHistoryLabel[i].setPreferredSize(new Dimension(250, 24));
                movieHistoryPanel[i].setPreferredSize(new Dimension(250, 48));
                movieHistoryPanel[i].setBackground(Color.WHITE);
                movieHistoryPanel[i].add(movieHistoryLabel[i]);
                historyPanel.setPreferredSize(new Dimension(1920, 100));
                historyPanel.add(movieHistoryPanel[i]);
            }
        }

        // historyPanel.setBackground(Color.RED);

        historyPage.add(historyPanel);
    }

}

class Navbar {
    public static JMenuBar navbar = new JMenuBar();
    public static JMenu account = new JMenu("Account");
    public static JMenuItem upgrade = new JMenuItem("Upgrade");
    public static JMenuItem history = new JMenuItem("History");
    public static JMenuItem logout = new JMenuItem("Logout");

    Navbar() {
        account.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        upgrade.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        history.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        logout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
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
                History.paintMovieHistory(UserApp.currentUser);
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
        // read db
        try {
            String init_data = "000000 dummy dummy 0 0000 reguler true ";
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

        JPanel dummy = new JPanel();
        dummy.setPreferredSize(new Dimension(1920, 60));

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

        usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ageLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        phoneLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        info.setFont(new Font("Segoe UI", Font.BOLD, 14));
        log.setFont(new Font("Segoe UI", Font.BOLD, 14));
        usernameField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        passwordField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ageField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        phoneField.setFont(new Font("Segoe UI", Font.BOLD, 14));

        usernameLabel.setPreferredSize(new Dimension(100, 36));
        passwordLabel.setPreferredSize(new Dimension(100, 36));
        ageLabel.setPreferredSize(new Dimension(100, 36));
        phoneLabel.setPreferredSize(new Dimension(100, 36));

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
        logMeIn.setFont(new Font("Segoe UI", Font.BOLD, 14));

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

        // logUser.setLayout();
        logUser.setExtendedState(JFrame.MAXIMIZED_BOTH);
        logUser.setVisible(true);
        logUser.setResizable(true);
        logUser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        logPanel.add(dummy);

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
                        System.out.println("user ke-" + userCount);
                        userCount++;

                        // habis itu langsung masuk
                        loginTransition(0);
                        return;
                    } else {
                        for (int i = 0; i < usernameAll.size(); i++) {
                            if (usernameAll.get(i).equals(usernameInput)
                                    && passwordAll.get(i).equals(passwordInput)) {
                                for (int j = 0; j < Pengguna.dbPengguna.length; j++) {
                                    if (Pengguna.dbPengguna[j].getNama().equals(usernameInput)) {
                                        // set current user
                                        UserApp.currentUser = Pengguna.dbPengguna[j];
                                        System.out.println("user ke-" + j);
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
                                loginTransition(1);
                                return;
                            } else {
                                log.setText("User tidak ada atau password salah");
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

    public void loginTransition(int i) {
        switch (i) {
            case 0:
                System.out.println("selamat bergabung, " + UserApp.currentUser.getNama());
                break;
            case 1:
                System.out.println("halo, " + UserApp.currentUser.getNama());
                break;
            default:
                ;
        }

        UserApp.tierCurrentUser = UserApp.currentUser.getTier();
        System.out.println(UserApp.tierCurrentUser);
        MainPage.arrangeAllMoviePanels(UserApp.tierCurrentUser);

        UserApp.mainApp.setJMenuBar(Navbar.navbar);
        UserApp.mainApp.setVisible(true);
        logUser.setVisible(false);
        UserApp.mainApp.repaint();
        UserApp.mainApp.revalidate();
    }
}

class MainPage {
    private static Database db = new Database();
    private static int banyakFilm = db.dbGetBanyakFilm();
    private static Color white = new Color(255, 255, 255);
    private static JPanel movies[] = new JPanel[banyakFilm];
    private static JTextArea infoText[] = new JTextArea[banyakFilm];
    private static GridLayout gl = new GridLayout(0, 4, 16, 16);
    public static JPanel movieHandler = new JPanel(gl);
    private static Border b = BorderFactory.createEmptyBorder(36, 36, 36, 36);
    private static Border b2 = BorderFactory.createEmptyBorder(36, 36, 36, 36);
    private static Border b3 = BorderFactory.createEmptyBorder(0, 12, 0, 0);

    MainPage() {
        // prelim set window
        UserApp.mainApp.setSize(1200, 800); // main program window

        movieHandler.setSize(1200, 800); // isinya film

        // aplikasi utama
        UserApp.mainApp.setVisible(false);
        UserApp.mainApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        UserApp.mainApp.setResizable(true);
        UserApp.mainApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // navbar.add(logout);
        movieHandler.setBorder(b);

        // urusan dengan yth. navbar
        Navbar.navbar.setBorder(b3);
        UserApp.mainApp.setJMenuBar(Navbar.navbar);

        // logic
        // arrangeAllMoviePanels("platinum");

        // mainApp.add(navbar);

        // Login.logUser.repaint();
        // UserApp.mainApp.repaint();
        // UserApp.mainApp.revalidate();
    }

    public static void arrangeAllMoviePanels(String tier) {
        movieHandler.removeAll();
        int limitor = db.dbGetTierLimitor(tier);
        System.out.println(limitor);
        for (int i = 0; i < limitor; i++) {
            movies[i] = new JPanel();
            movies[i].setBorder(b2);
            infoText[i] = new JTextArea(db.dbGetJudul(i));
            infoText[i].setPreferredSize(new Dimension(200, 12));
            infoText[i].setLineWrap(true);
            infoText[i].setWrapStyleWord(true);
            infoText[i].setEditable(false);
            infoText[i].setFont(new Font("Segoe UI", Font.BOLD, 24));

            JTextArea sinopsisText = new JTextArea(db.dbGetSinopsis(i));
            sinopsisText.setPreferredSize(new Dimension(200, 24));
            sinopsisText.setLineWrap(true);
            sinopsisText.setWrapStyleWord(true);
            sinopsisText.setEditable(false);
            sinopsisText.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            movies[i].setPreferredSize(new Dimension(200, 360));
            movies[i].setBackground(white);

            JButton tombolTonton = new JButton("Tonton");
            tombolTonton.setFont(new Font("Segoe UI", Font.BOLD, 18));
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

                // masukkan film ke history pengguna
                UserApp.currentUser.setIndexHistory(filmIndex);

                JButton back = new JButton("go back");

                JFrame newFrame = new JFrame(judulFilm);
                newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Mengatur JFrame menjadi fullscreen
                newFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                // Membuat panel utama dengan layout manager BorderLayout
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

                // Membuat JPanel untuk menyimpan teks dan mengatur layout manager-nya menjadi
                // FlowLayout
                JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JLabel labelSelamatMenonton = new JLabel("Selamat menonton :)");
                labelSelamatMenonton.setFont(new Font("Segoe UI", Font.BOLD, 18));
                back.setSize(new Dimension(120, 36));
                topPanel.add(back);
                topPanel.add(labelSelamatMenonton);

                // Menambahkan JPanel ke panel utama
                mainPanel.add(topPanel);

                // Menambahkan gambar ke dalam JLabel dan menempatkannya di tengah
                JLabel labelGambar = new JLabel();
                ImageIcon icon = new ImageIcon("/resources/jalaflix.png");
                icon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH));
                labelGambar.setIcon(icon);
                labelGambar.setHorizontalAlignment(JLabel.CENTER);
                labelGambar.setBackground(Color.BLUE);
                mainPanel.add(labelGambar);

                // tombol untuk kembali dari nonton film

                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UserApp.mainApp.setJMenuBar(Navbar.navbar);
                        UserApp.mainApp.setVisible(true);
                        mainPanel.setVisible(false);
                        UserApp.mainApp.repaint();
                        UserApp.mainApp.revalidate();
                    }
                });

                newFrame.getContentPane().add(mainPanel); // Menambahkan panel utama ke dalam content pane JFrame
                newFrame.setVisible(true);
                newFrame.repaint();
                newFrame.revalidate();
            });
        }
        UserApp.jsp.revalidate();
        UserApp.jsp.repaint();
        UserApp.mainApp.revalidate();
        UserApp.mainApp.repaint();
        UserApp.jsp.getVerticalScrollBar().setValue(UserApp.jsp.getVerticalScrollBar().getMinimum());
    }
}

public class UserApp {
    public static JFrame mainApp = new JFrame("Jalaflix-11");
    public static Pengguna currentUser;
    public static String tierCurrentUser;
    public static JScrollPane jsp = new JScrollPane(MainPage.movieHandler,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public static void main(String[] args) {
        // instance all pages
        new Login();
        new Navbar();
        new MainPage();
        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMinimum());
        jsp.getVerticalScrollBar().setUnitIncrement(16);
        jsp.getHorizontalScrollBar().setUnitIncrement(12);
        mainApp.add(jsp);

        new Upgrade();
        new History();
        System.out.println("Semua page berhasil terinstansiasikan");
    }
}
