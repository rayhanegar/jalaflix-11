import java.util.ArrayList;

public abstract class Pelanggan {
    static Pengguna[] dbPengguna;
    String kode, telp;
    protected String nama, tier; // tier = reguler, gold, plat
    protected Film[] akses;
    protected boolean statusActive; // active or no
    protected ArrayList<Film> history;// maks 10 film dalam history

    public abstract boolean isActive();

    public abstract void accInfo();

    public abstract void upgrade(String kode, String nama, String telp);

}
