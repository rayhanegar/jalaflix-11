public class App {
    public static void main(String[] args) throws Exception {
        Film m[] = new Film[6];
        m[0] = new Reguler();
        m[1] = new Reguler();
        m[2] = new Baru(); // test
        m[3] = new Baru(); // ini perubahan
        m[4] = new Original(); // dari hugo
        m[5] = new Original();

        m[0].setJudul("apa");
        m[1].setJudul("kapan"); // P
        m[2].setJudul("siapa");
        m[3].setJudul("bagaimana"); // aku tambahin komen di sini
        m[4].setJudul("mengapa");
        m[5].setJudul("di mana");// ini dri hasan

        // Why is gitHub so hard maneee

        User u = new Regular();
        // System.out.println(u.getKasta());
        u.getFilm(u.getKasta(), m);
        System.out.println("---");

        User rich = new Gold();
        // System.out.println(rich.getKasta());
        rich.getFilm(rich.getKasta(), m);
        System.out.println("---");

        User bezos = new Platinum();
        // System.out.println(bezos.getKasta());
        bezos.getFilm(bezos.getKasta(), m);

    }
}
