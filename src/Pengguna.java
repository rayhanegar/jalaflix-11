public class Pengguna {

    protected String kode, nama, telp, tier; // tier = reguler, gold, plat
    protected String[] akses;
    protected boolean status;
    protected String[] history = new String[10]; // maks 10 film dalam history

    Pengguna() {
    }

    Pengguna(String kode, String nama, String telp, String tier, boolean status) {
        this.kode = kode;
        this.nama = nama;
        this.telp = telp;
        this.tier = tier;
        this.status = status;
    }

    public void getFilm(String tier, Film[] arr) {
        String kelaz[] = new String[arr.length];
        for (int i = 0; i < kelaz.length; i++) {
            kelaz[i] = arr[i].getClass().toString().toLowerCase().replaceAll("class ", "");
        }
        if (tier.contains("reg")) {
            this.akses = new String[arr.length];
            for (int i = 0; i < akses.length; i++) {
                if (kelaz[i].contains("reg")) {
                    this.akses[i] = arr[i].getJudul();
                } else {
                    this.akses[i] = null;
                }
            }
        } else if (tier.contains("gold")) {
            this.akses = new String[arr.length];
            for (int i = 0; i < akses.length; i++) {
                if (kelaz[i].contains("reg") || kelaz[i].contains("baru")) {
                    this.akses[i] = arr[i].getJudul();
                } else {
                    this.akses[i] = null;
                }
            }
        } else if (tier.contains("plat")) {
            this.akses = new String[arr.length];
            for (int i = 0; i < akses.length; i++) {
                if (kelaz[i].contains("reg") || kelaz[i].contains("baru") || kelaz[i].contains("ori")) {
                    this.akses[i] = arr[i].getJudul();
                } else {
                    this.akses[i] = null;
                }
            }
        }

        for (String string : akses) {
            if (!(string == null)) {
                System.out.println(string);
            }
        }
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

    public void setTier(String tier){
        this.tier = tier;
    }

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }

    public void getFilm(){
        
    }
}

class Regular extends Pengguna {
    Regular() {
        super();
        this.tier = "reguler";
    }
}

class Gold extends Regular {
    Gold() {
        super();
        this.tier = "gold";
    }
}

class Platinum extends Gold {
    Platinum() {
        super();
        this.tier = "platinum";
    }
}
