import java.util.ArrayList;

public abstract class Pelanggan {
    static Pengguna[] dbPengguna;
    String kode, telp;
    protected String nama, tier; // tier = reguler, gold, plat
    protected Film[] akses;
    protected boolean statusActive; // active or no
    protected ArrayList<Film> history;// maks 10 film dalam history

    public static void createAcc() {
    };

    public abstract void getFilm(String tier, Film[] db);

    public abstract void getHistory();

    public abstract void setHistory(Film recent);

    public abstract void watchFilm(int i);

    public abstract boolean isActive();

    public abstract void accInfo();

    public abstract void upgrade(String kode, String nama, String telp);

}
