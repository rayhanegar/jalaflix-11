public class User {
    protected String kode, nama, telp, kasta; // kasta = reguler, gold, plat
    protected String[] akses;
    protected boolean status;
    protected String[] history = new String[10]; // maks 10 film dalam history

    User() {
    }

    User(String kode, String nama, String telp, boolean status) {
        this.kode = kode;
        this.nama = nama;
        this.telp = telp;
        this.status = status;
    }

    public void getMovie(String kasta, Movie[] arr) {
        String kelaz[] = new String[arr.length];
        for (int i = 0; i < kelaz.length; i++) {
            kelaz[i] = arr[i].getClass().toString().toLowerCase().replaceAll("class ", "");
        }
        if (kasta.contains("reg")) {
            this.akses = new String[arr.length];
            for (int i = 0; i < akses.length; i++) {
                if (kelaz[i].contains("reg")) {
                    this.akses[i] = arr[i].getJudul();
                } else {
                    this.akses[i] = null;
                }
            }
        } else if (kasta.contains("gold")) {
            this.akses = new String[arr.length];
            for (int i = 0; i < akses.length; i++) {
                if (kelaz[i].contains("reg") || kelaz[i].contains("baru")) {
                    this.akses[i] = arr[i].getJudul();
                } else {
                    this.akses[i] = null;
                }
            }
        } else if (kasta.contains("plat")) {
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

    public String getKasta() {
        return kasta;
    }

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }
}

class Regular extends User {
    Regular() {
        super();
        this.kasta = "reguler";
    }
}

class Gold extends Regular {
    Gold() {
        super();
        this.kasta = "gold";
    }
}

class Platinum extends Gold {
    Platinum() {
        super();
        this.kasta = "platinum";
    }
}
