import java.util.*;
import java.util.Scanner;

class UmurNegatifException extends Exception {
    public UmurNegatifException(String errorMessage) {
        Pengguna.check = 0;
        System.out.println(errorMessage);
    }
}

public class Pengguna extends Pelanggan implements UserMethods {
    public static Pengguna[] dbPengguna = new Pengguna[100];
    static int check = 0;
    private static int count = 0;
    private String kode, telp;
    private int umur;
    protected String nama, tier; // tier = reguler, gold, plat
    protected Film[] akses;
    protected boolean statusActive; // active or no
    protected Queue<Film> history; // maks 10 film dalam history

    Pengguna() {
    }

    Pengguna(String kode, String nama, int umur, String telp, String tier, boolean statusActive) {
        this.kode = kode;
        this.nama = nama;
        this.umur = umur;
        this.telp = telp;
        this.tier = tier;
        this.statusActive = statusActive;
        history = new LinkedList<>();
    }

    public static int getCount() {
        return count;
    }

    public static void createAcc() {
        Scanner sc = new Scanner(System.in);
        String kode = Integer.toString((int) (Math.random() * 1000000));
        System.out.println("Pendaftaran akun baru JalaFlix");
        System.out.print("Nama      : ");
        String nama = sc.nextLine();
        int umur = 0;
        while (check == 0) {
            System.out.print("Umur      : ");
            try {
                umur = Integer.parseInt(sc.nextLine().replaceAll("[^0-9\\-]", "0"));
                if (umur < 0) {
                    throw new UmurNegatifException("[ERROR] Umur tidak boleh negatif. Silahkan input ulang.");
                } else {
                    break;
                }
            } catch (UmurNegatifException u) {
                continue;
            }
        }

        System.out.print("Telepon   : ");

        String telp = sc
                .nextLine();
        System.out.println("Silakan pilih Tier keanggotaan JalaFlix");
        System.out.println(
                "1. Regular (Rp30,000.00/bulan)\n2. Gold (Rp50,000.00/bulan)\n3. Platinum (Rp80,000.00/bulan)");
        System.out.print("Pilihan Tier[1/2/3]: ");
        int response = Integer.parseInt(sc.nextLine().replaceAll("[^0-9]", "0"));
        System.out.println();

        String tier;
        switch (response) {
            case 1:
                tier = "reguler";
                dbPengguna[count++] = new Regular();
                break;
            case 2:
                tier = "gold";
                dbPengguna[count++] = new Gold();
                break;
            default:
                tier = "platinum";
                dbPengguna[count++] = new Platinum();

        }

        dbPengguna[count - 1].setKode(kode);
        dbPengguna[count - 1].setNama(nama);
        dbPengguna[count - 1].setUmur(umur);
        dbPengguna[count - 1].setTelp(telp);
        dbPengguna[count - 1].setTier(tier);
        dbPengguna[count - 1].setstatusActive(true);

        System.out.println("Selamat status keanggotaan anda sudah aktif!");
        System.out.printf("Gunakan dbPengguna[%d] sebagai metode akses akun ini.\n", count - 1);
        System.out.println();
    }

    public void getFilm(String tier, Film[] db) { // param: tier = user.getTier(), film array
                                                  // dari database
    }

    public String getKode() {
        return kode;
    }

    private void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    private void setUmur(int umur) {
        this.umur = umur;
    }

    public String getUmur() {
        return telp;
    }

    private void setTelp(String telp) {
        this.telp = telp;
    }

    public boolean getStatusActive() {
        return statusActive;
    }

    public void setstatusActive(boolean statusActive) {
        this.statusActive = statusActive;
    }

    public String getTier() {
        return tier;
    }

    private void setTier(String tier) {
        this.tier = tier;
    }

    public void getHistory() {
        System.out.println();
        System.out.println(
                "|===================================================================================================================================|");
        System.out.println(
                "|                                                    Your Watch History                                                             |");
        System.out.println(
                "|===================================================================================================================================|");
        System.out.printf("| Name: %-123s |\n", this.nama);
        System.out.printf("| Tier: %-123s |\n", this.tier);
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(
                "| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");
        int j = 1;
        for (Film i : history) {
            System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n", j++, i.getJudul(), i.getGenre(),
                    i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(), 45)), i.getTahun(), i.getRating());
        }
        System.out.println(
                "|===================================================================================================================================|");
        System.out.println();
    }

    // dont use setHistory(Film recent) cuz its deprecated and i cant be bothered to put jdocs
    public void setHistory(Film recent) {
        if (history.size() >= 10) {
            history.remove(0);
        }
        history.add(recent);
    }

    private static int historyLimitCounter = 0;

    public void setIndexHistory(int i) {

        if (historyLimitCounter < 8) {
            this.history.add(Database.db[i]);
            historyLimitCounter++;
        } else {
            this.history.add(Database.db[i]);
            this.history.poll();
        }
    }

    public Film[] getRecentHistory() {
        Film temp[] = new Film[this.history.size()];
        this.history.toArray(temp);
        return temp;
    }

    public int getHistoryCount() {
        return history.size();
    }

    public void watchFilm(int i) {
        if (akses != null) {
            if (akses[i] != null) {
                System.out.printf("Now playing: \"%s\"\n", akses[i - 1].getJudul());
                setHistory(akses[i - 1]);
                System.out.printf("Adding \"%s\" to your watch history!\n", akses[i - 1].getJudul());
                System.out.println();
            } else {
                System.out.println("Maaf, tidak ada data tersedia untuk film ini.");
                return;
            }
        } else {
            System.out.println("Whoops! Anda tidak bisa mengakses film ini.");
        }
    }

    public boolean isActive() {
        return (statusActive);
    }

    public void bayar() { // Buat bayar tagihan, bakal set statusActive ke true jika pembayaran berhasil
        Scanner sc = new Scanner(System.in);
        if (statusActive) {
            System.out.println("Status akun anda untuk bulan ini sudah aktif!");
            return;
        }
        String nominal = "Rp00,000.00";

        switch (tier) {
            case "Regular" -> nominal = "Rp30,000.00";
            case "Gold" -> nominal = "Rp50,000.00";
            case "Platinum" -> nominal = "Rp80,000.00";
        }

        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
        System.out.printf("Pelanggan %s,\n", this.nama);
        System.out.println(
                "Lakukan pembayaran subscription untuk bulan ini terlebih dahulu dengan detail pembayaran sebagai berikut:");
        System.out.println("ID Pelanggan    : " + this.getKode());
        System.out.println("Tier pelanggan  : " + tier);
        System.out.println("Nominal Bayar   : " + nominal);
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
        System.out.println("Nomor rekening Virtual Account: 14000212323 (Bank Mandiri)");
        System.out.print("Lanjut bayar [ya/tidak]: ");
        String response = sc.next();
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------");

        if (response.equals("ya")) {
            this.statusActive = true;
            System.out.println();
            System.out.println("Pembayaran anda terkonfirmasi!");
            System.out.println("Nama: " + this.nama);
            System.out.println("ID  : " + this.getKode());
            System.out.println("Tier: " + this.tier);
            System.out.println("Nikmati katalog film-film pilihan JalaFlix selama 30 hari ke depan.");
            System.out.println();
        } else {
            this.statusActive = false;
            System.out.println("Mohon maaf, pembayaran anda tidak dapat kami proses.");
            System.out.println("Silakan ulangi pembayaran atau hubungi Customer Service kami di (0341) 333-4444");
            System.out.println();
        }
    }

    public void accInfo() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
        System.out.println("Informasi akun dengan ID " + this.kode);
        System.out.println("Nama            : " + nama);
        System.out.println("Umur            : " + umur);
        System.out.println("Tier            : " + tier);
        System.out.println("Telepon         : " + telp);
        System.out.println("Status Aktif    : " + statusActive);
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
    }

    public void upgrade(String kode, String nama, String telp) {
        Scanner sc = new Scanner(System.in);

        String tempKode = kode, tempNama = nama, tempTelp = telp;

        System.out.println();

        System.out.println("Tier apa yang anda ingin pilih?");
        System.out.print("1. Regular\n2. Gold\n3. Platinum\n");
        System.out.print("Pilihan Tier[1/2/3]: ");
        int response = sc.nextInt();
        System.out.println();

        switch (response) {
            case 1:
                tier = "reguler";
                break;
            case 2:
                tier = "gold";
                break;
            case 3:
                tier = "platinum";
                break;
            default:
                tier = "platinum";
        }

        String nominal = "Rp00,000.00";

        switch (tier) {
            case "reguler" -> nominal = "Rp30,000.00";
            case "gold" -> nominal = "Rp50,000.00";
            case "platinum" -> nominal = "Rp80,000.00";
        }

        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
        System.out.printf("Pelanggan %s,\n", this.nama);
        System.out.println(
                "Lakukan pembayaran subscription untuk bulan ini terlebih dahulu dengan detail pembayaran sebagai berikut:");
        System.out.println("ID Pelanggan    : " + this.getKode());
        System.out.println("Tier pelanggan  : " + tier);
        System.out.println("Nominal Bayar   : " + nominal);
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
        System.out.println("Nomor rekening Virtual Account: 14000212323 (Bank Mandiri)");
        System.out.printf("Lanjut bayar [ya/tidak]: ");
        String response2 = sc.next();
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------");

        if (response2.equals("ya")) {
            switch (response) {
                case 1:
                    tier = "reguler";
                    dbPengguna[count++] = new Regular();
                    break;
                case 2:
                    tier = "gold";
                    dbPengguna[count++] = new Gold();
                    break;
                default:
                    tier = "platinum";
                    dbPengguna[count++] = new Platinum();
            }

            dbPengguna[count - 1].setKode(tempKode);
            dbPengguna[count - 1].setNama(tempNama);
            dbPengguna[count - 1].setTelp(tempTelp);
            dbPengguna[count - 1].setTier(tier);
            dbPengguna[count - 1].setstatusActive(true);

            System.out.println("Selamat status keanggotaan anda sudah aktif!");
            System.out.printf("Gunakan dbPengguna[%d] sebagai metode akses akun ini.\n", count - 1);
            System.out.println();
        } else {
            this.statusActive = false;
            System.out.println("Mohon maaf, pembayaran anda tidak dapat kami proses.");
            System.out.println("Silakan ulangi pembayaran atau hubungi Customer Service kami di (0341) 333-4444");
            System.out.println();
        }
    }
}

class Regular extends Pengguna {
    Regular() {
        super();
        this.tier = "reguler";
    }

    @Override
    public void getFilm(String tier, Film[] db) {
        if (!statusActive) {
            super.bayar();
            if (!statusActive) {
                return;
            }
        }
        akses = new Film[db.length];
        for (int i = 0; i < db.length; i++) {
            if (db[i].getClass().toString().contains("Reg")) {
                akses[i] = db[i];
            }
        }
        System.out.println(
                "|===================================================================================================================================|");
        System.out.println(
                "|                                            Films Available for You to Watch                                                       |");
        System.out.println(
                "|===================================================================================================================================|");
        System.out.printf("| Name: %-123s |\n", this.nama);
        System.out.printf("| Tier: %-123s |\n", this.tier);
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(
                "| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");

        int j = 1;

        for (Film i : akses) {
            if (i != null && i.getTahun() > 1800) {
                System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n", j++, i.getJudul(), i.getGenre(),
                        i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(), 42)).concat("..."),
                        i.getTahun(),
                        i.getRating());
            }

        }

        System.out.println(
                "|===================================================================================================================================|");
        System.out.println();
    }
}

class Gold extends Pengguna {
    Gold() {
        super();
        this.tier = "gold";
    }

    @Override
    public void getFilm(String tier, Film[] db) {
        if (!statusActive) {
            super.bayar();
            if (!statusActive) {
                return;
            }
        }
        akses = new Film[db.length];
        for (int i = 0; i < db.length; i++) {
            if ((db[i].getClass().toString().contains("Reg")
                    || db[i].getClass().toString().contains("Baru"))) {
                akses[i] = db[i];
            }
        }

        System.out.println(
                "|===================================================================================================================================|");
        System.out.println(
                "|                                            Films Available for You to Watch                                                       |");
        System.out.println(
                "|===================================================================================================================================|");
        System.out.printf("| Name: %-123s |\n", this.nama);
        System.out.printf("| Tier: %-123s |\n", this.tier);
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(
                "| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");

        int j = 1;

        for (Film i : akses) {
            if (i != null && i.getTahun() > 1800) {
                System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n", j++, i.getJudul(), i.getGenre(),
                        i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(), 42)).concat("..."),
                        i.getTahun(),
                        i.getRating());
            }
        }
        System.out.println(
                "|===================================================================================================================================|");
        System.out.println();
    }
}

class Platinum extends Pengguna {
    Platinum() {
        super();
        this.tier = "platinum";
    }

    @Override
    public void getFilm(String tier, Film[] db) {

        if (!statusActive) {
            super.bayar();
            if (!statusActive) {
                return;
            }
        }

        akses = db;
        System.out.println(
                "|===================================================================================================================================|");
        System.out.println(
                "|                                            Films Available for You to Watch                                                       |");
        System.out.println(
                "|===================================================================================================================================|");
        System.out.printf("| Name: %-123s |\n", this.nama);
        System.out.printf("| Tier: %-123s |\n", this.tier);
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(
                "| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println(
                "|-----------------------------------------------------------------------------------------------------------------------------------|");

        int j = 1;

        for (Film i : db) {
            if (i.getTahun() > 1800) {
                System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n", j++, i.getJudul(), i.getGenre(),
                        i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(), 42)).concat("..."),
                        i.getTahun(),
                        i.getRating());
            }
        }

        System.out.println(
                "|===================================================================================================================================|");
        System.out.println();

    }
}
