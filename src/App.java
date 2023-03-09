public class App {
    public static void main(String[] args) throws Exception {
        Movie m[] = new Movie[6];
        m[0] = new Reguler();
        m[1] = new Reguler();
        m[2] = new Baru();
        m[3] = new Baru();
        m[4] = new Original();
        m[5] = new Original();

        m[0].setJudul("apa");
        m[1].setJudul("kapan");
        m[2].setJudul("siapa");
        m[3].setJudul("bagaimana");
        m[4].setJudul("mengapa");
        m[5].setJudul("di mana");

        User u = new Regular();
        // System.out.println(u.getKasta());
        u.getMovie(u.getKasta(), m);
        System.out.println("---");

        User rich = new Gold();
        // System.out.println(rich.getKasta());
        rich.getMovie(rich.getKasta(), m);
        System.out.println("---");

        User bezos = new Platinum();
        // System.out.println(bezos.getKasta());
        bezos.getMovie(bezos.getKasta(), m);

    }
}
