public interface UserMethods {
    public static void createAcc() {
    };

    public abstract void getFilm(String tier, Film[] db);

    public abstract void getHistory();

    public abstract void setHistory(Film recent);

    public abstract void watchFilm(int i);
}
