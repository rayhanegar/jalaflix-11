import java.util.ArrayList;

public class Pengguna {

    protected String kode, nama, telp, tier; // tier = reguler, gold, plat
    protected Film[] akses;
    protected boolean status; // active or no
    protected ArrayList<Film> history = new ArrayList<>(); // maks 10 film dalam history

    Pengguna() {
    }

    Pengguna(String kode, String nama, String telp, String tier, boolean status) {
        this.kode = kode;
        this.nama = nama;
        this.telp = telp;
        this.tier = tier;
        this.status = status;
    }

    public void getFilm(String tier, Film[] db) { // param: tier = user.getTier(), film array dari database

    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTier() {
        return tier;
    }

    private void setTier(String tier) {
        this.tier = tier;
    }

    public void getHistory() {
        System.out.println("|===================================================================================================================================|");
        System.out.println("|                                                    Your Watch History                                                             |");
        System.out.println("|===================================================================================================================================|");
        System.out.println("| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------|");
        int j = 1;
        for(Film i : history){
            System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n",j++, i.getJudul(), i.getGenre(), i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(),45)),i.getTahun(), i.getRating());
        }
        System.out.println("|===================================================================================================================================|");
        System.out.println();
    }

    public void setHistory(Film recent) {
        if(history.size()>=10){
            history.remove(0);
        }
        history.add(recent);
    }

    public void getFilm() {
        // Method ini di override di tiap-tiap subclass
    }

    public void watchFilm(int i) {
        System.out.printf("Now playing: \"%s\"\n",akses[i].getJudul());
        setHistory(akses[i]);
        System.out.printf("Adding \"%s\" to your watch history!\n",akses[i].getJudul());
        System.out.println();
    }
}

class Regular extends Pengguna {
    Regular() {
        super();
        this.tier = "reguler";
    }

    @Override
    public void getFilm(String tier, Film[] db){
        akses = new Film[db.length];
        for (int i = 0; i < db.length; i++) {
            if (db[i].getClass().toString().contains("Reg")) {
                akses[i] = db[i];
            }
        }
        System.out.println("|===================================================================================================================================|");
        System.out.println("|                                            Films Available for You to Watch                                                       |");
        System.out.println("|===================================================================================================================================|");
        System.out.println("| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------|");

        int j = 1;

        for (Film i : akses){
            if(i !=null){
                System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n",j++, i.getJudul(), i.getGenre(), i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(),45)),i.getTahun(), i.getRating());
            }
        }

        System.out.println("|===================================================================================================================================|");
        System.out.println();
    }
}

class Gold extends Pengguna {
    Gold() {
        super();
        this.tier = "gold";
    }
    @Override
    public void getFilm(String tier, Film[] db){
        akses = new Film[db.length];
        for (int i = 0; i < db.length; i++) {
            if (db[i].getClass().toString().contains("Reg")||db[i].getClass().toString().contains("Baru")) {
                akses[i] = db[i];
            }
        }

        System.out.println("|===================================================================================================================================|");
        System.out.println("|                                            Films Available for You to Watch                                                       |");
        System.out.println("|===================================================================================================================================|");
        System.out.println("| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------|");


        int j = 1;

        for (Film i : akses){
            if(i!=null){
                System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n",j++, i.getJudul(), i.getGenre(), i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(),45)),i.getTahun(), i.getRating());
            }
        }
        System.out.println("|===================================================================================================================================|");
        System.out.println();
    }
}

class Platinum extends Pengguna {
    Platinum() {
        super();
        this.tier = "platinum";
    }
    @Override
    public void getFilm(String tier, Film[] db){

        akses = db;
        System.out.println("|===================================================================================================================================|");
        System.out.println("|                                            Films Available for You to Watch                                                       |");
        System.out.println("|===================================================================================================================================|");
        System.out.println("| No.  |              Title             |            Genre          |                    Synopsis                   | Year | Rating |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------|");

        int j = 1;

        for (Film i : db){
            System.out.printf("| %-4d | %-30s | %-25s | %-45s | %-4d | %-6d |\n",j++, i.getJudul(), i.getGenre(), i.getSinopsis().substring(0, Math.min(i.getSinopsis().length(),45)),i.getTahun(), i.getRating());
        }

        System.out.println("|===================================================================================================================================|");
        System.out.println();
    }
}
