import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Film db[] = new Film[36];
        int exit = 0;
        int response;

        System.out
                .println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out
                .println("+                                     JalaFlix                                            +");
        System.out
                .println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // FILM 5 TAHUN LAWAS
        db[0] = new Reguler("Captain Indonesia", "action",
                "Seorang pria dari amerika yang berjuang demi menyelamatkan amerika dari serangan alien", 1999, 13);
        db[1] = new Reguler("Waktu Zuhur", "Drama , Romance",
                "Kisah dimana seorang pria yang sedang mencari kekasihnya di waktu zuhur", 2012, 13);
        db[2] = new Reguler("Nurse Strange", "Action",
                "Seorang suster yang mengalami kecelakaan dan pergi ke sebuah gapura untuk mengatasi kecacatannya, pada akhirnya ia mendapatkan super power untuk membasmi kejahatan",
                2016, 13);
        db[3] = new Reguler("Kukira Kau Hotel", "Drama , Romance",
                "Kisah cinta seorang pria yang menemukan cinta sejatinya di hotel", 2011, 16);
        db[4] = new Reguler("Filosofi Teh", "Drama",
                "Kisah dimana seorang pria yang mabuk teh hingga menjadi seorang entrepreneur yang sukses", 2001, 13);
        db[5] = new Reguler("Kuntil-Bapak", "Horror",
                "Kisah dimana ada seorang pemuda yang tidak sengaja membangkitkan hantu yang bernama Kuntil-bapak",
                1998, 13);
        db[6] = new Reguler("Sepuluh Garis Biru", "Drama",
                "Kisah dimana ada seorang pemuda yang tidak sengaja membuat karya dengan 10 garis berwarna biru, yang membuatnya sukses",
                2012, 13);
        db[7] = new Reguler("My Smart Boss", "Drama",
                "Kisah dimana seorang wanita tua yang memiliki boss yang pintar sehingga membuat wanita itu sukses dunia akhirat",
                2017, 13);
        db[8] = new Reguler("Warteg DKI", "Drama",
                "Kisah dimana ada warteg yang berlokasi di Jakarta yang sedikit demi sedikit mulai terkenal di seluruh bagian Bimasakti",
                2012, 13);
        db[9] = new Reguler("Keluarga Beringin", "Drama , Romance",
                "Kisah dimana menceritakan keluarga beringin yang dimana anggota keluarganya di tebang untuk membuat furniture yang fantastis",
                2016, 13);
        db[10] = new Reguler("Pistol-dalla", "Action",
                "Kisah dimana bagaimana cara pahlawan kita, Gundalla membuat senjatanya", 2009, 16);
        db[11] = new Reguler("Injustic League", "Action",
                "Kisah dimana ada sekelompok pahlawan yang sudah letih menjadi pahlawan dan membunuh semua makhluk dimuka bumi ",
                2016, 13);

        // FILM TERBARU
        db[12] = new Baru("Atau-nur", "Horror",
                "Kisah yang melanjutkan kisah Danur yang dimana asih sudah berubah menjadi seorang hantu pria", 2018,
                13);
        db[13] = new Baru("Laskar Abu-Abu", "Drama, Action",
                "Kisah dimana sekelompok pemuda yang berusaha untuk sukses tetapi dengan cara yang salah, yaitu dengan menjadi penjual sabu yang sangat sukses",
                2019, 8);
        db[14] = new Baru("Mengembalikan Raden Saleh", "Action",
                "Kisah dimana seorang pencuri yang sudah tobat dalam hal mencuri dan ingin mengembalikan lukisan Raden Saleh",
                2020, 13);
        db[15] = new Baru("Prissonlangkung", "Horror",
                "Kisah dimana seorang pemuda yang melakukan investigasi dalam sebuah penjara dan bertemu dengan hantu yang disebut dengan PrissonLangkung",
                2018, 13);
        db[16] = new Baru("Good Boys", "Action",
                "Kisah dimana sekelompok pria paruh baya yang sudah taubat nasuha dan menjadi sekelompok orang yang akan menyelamatkan bumi dari serangan mafia intergalaksi",
                2019, 13);
        db[17] = new Baru("Jamal Potter", "Action",
                "Kisah dimana ada seorang pemuda yang berubah menjadi orang kafir dengan mempelajari ilmu sihir dan memiliki motivasi untuk melakukan muggen sukoyomi",
                2021, 13);
        db[18] = new Baru("Slow Furrious", "Action ",
                "Kisah dimana ada seorang mekanik yang ingin membuat sebuah mobil sebuah mobil yang lambat tetapi memiliki daya serang yang kuat untuk melindungi negaranya",
                2023, 13);
        db[19] = new Baru("Ready Player Two", "Science Fiction, Action",
                "Kisah dimana seorang pria paruh baya yang masuk kedalam game perang yang dimana dia harus menyelesaikan game tersebut",
                2022, 13);
        db[20] = new Baru("Outerstellar", "Science Fiction, Mystery",
                "Kisah dimana sekelompok pemuda gila yang sedang menjelajahi langit dan berperang dengan alien", 2020,
                13);
        db[21] = new Baru("Mission Not Impossible", "Action",
                "Kisah dimana ada seorang penembak jitu yang ingin menyelesaikan misi terakhirnya dengan menggunakan bantuan alien",
                2020, 13);
        db[22] = new Baru("The King of the Rings", "Fantady Fiction",
                "Kisah dimana seorang cyborg yang belajar untuk membuat cincin yang sangat OP untuk berkomunikasi dengan malaikat maut agar dapat membunuh orang yang ia mau atas bantuan malaikat maut",
                2023, 13);
        db[23] = new Baru("The light Knight", "Action",
                "Kisah dimana seorang pemuda yang sudah berjemur diatas teriknya matahari sehingga ia mampu mengontrol intentensitas cahaya matahari untuk berperang",
                2019, 13);

        // FILM ORIGINAL SERIES
        db[24] = new Original("Sawman", "Action, Anime",
                "Kisah dimana seorang pria dari planet mars yang memiliki misi untuk menebang semua pohon dibumi untuk membuat planet mars menjadi sebuah planet yang indah",
                2023, 13);
        db[25] = new Original("Two Kick Man", "Action",
                "Kisah dimana ada seorang pahlawan yang dapat mematikan lawannya hanya dengan dua tendangan maut", 2018,
                13);
        db[26] = new Original("Indonesia Revenger", "Action, Anime",
                "Kisah dimana ada sekelompok orang yang sangat kuat berasal dari Indonesia dan ingin menghancurkan Negara yang sudah menjajah Indonesia",
                2023, 13);
        db[27] = new Original("Dragon Cube", "Action, Anime",
                "Kisah dimana ada sekelompok pemuda yang sedang berkelana di dunia lain untuk menangkap semua naga untuk dijadikan sebuah kotak misterius yang dapat menghancurkan semua galaksi",
                2022, 13);
        db[28] = new Original("Spy x Penjabat", "Action, Drama, Anime",
                "Kisah dimana ada seorang perempuan yang menikah dengan orang penjabat untuk memata-matai koruptor di Indonesia",
                2021, 13);
        db[29] = new Original("Pablo Bagas", "Action, Drama",
                "Kisah Bandar narkoba dari Indonesia yang menjual narkobanya hanya kenegara lain yang dimana uang hasil jualannya akan diberikan kepada orang miskin di Indonesia",
                2018, 13);
        db[30] = new Original("My Villian Academia", "Action, Anime",
                "Kisah dimana ada anak pahlawan yang bersekolah di sekolah penjahat terbaik agar dapat membunuh bapaknya sendiri",
                2019, 13);
        db[31] = new Original("Angel Slayer", "Action, Anime",
                "Kisah dimana ada seorang reinkarnasi dari iblis yang ingin membalas dendamnya ke semua malaikat yang membunuh semmua temannya ketika ia sedang menjadi iblis",
                2022, 13);
        db[32] = new Original("Two Piece", "Action, Anime",
                "Kisah dimana seorang pemuda yang berkelana antar galaksi sekaligus mencari anggota kelompoknya untuk mencari  artifak kuno yang terpisah jauh antar satu sama lain",
                2019, 13);
        db[33] = new Original("White Clover", "Action, Anime",
                "Kisah petualang seorang pemuda gila yang memiliki bentuk tubuh seperti semanggi dan berwarna putih yang terus mencari orang yang telah mengutuk tubuhnya",
                2019, 13);
        db[34] = new Original("Deffend on Titan", "Action, Anime",
                "Kisah dimana sekelompok manusia kerdil yang berjuang untuk melindungi manusia raksasa", 2021, 13);
        db[35] = new Original("Attack on Dwarf", "Action, Anime",
                "Kisah dimana seluruh manusia raksasa yang melindungi kaumnya dari serangan manusia kerdil yang memiliki kekuatan dua kali manusia raksasa",
                2011, 17);

        do {
            Scanner sc = new Scanner(System.in);

            if (Pengguna.getCount() == 0) {
                System.out.println("Menu: ");
                System.out.println("1. Daftar Menjadi Pengguna");
                System.out.println("2. Keluar dari JalaFlix");
                System.out.print("Response [1/2]: ");
                response = sc.nextInt();
                if (response == 1) {
                    response = 4;
                } else {
                    response = 6;
                }

            } else {
                System.out.println("Menu: ");
                System.out.println("1. Tonton Film");
                System.out.println("2. Lihat History");
                System.out.println("3. lihat Detail Pengguna");
                System.out.println("4. Daftar Menjadi Pengguna");
                System.out.println("5. Upgrade Langganan");
                System.out.println("6. Keluar dari JalaFlix");
                System.out.print("Response [1/2/3/4/5/6]: ");
                response = sc.nextInt();
            }

            System.out.println();

            // Jika pengguna input 1 -> Tonton Film
            if (response == 1) {
                System.out.print("Masukkan index pengguna anda dalam dbPengguna: ");
                int index = sc.nextInt();
                if (Pengguna.dbPengguna[index] != null) {
                    Pengguna.dbPengguna[index].getFilm(Pengguna.dbPengguna[index].getTier(), db);
                    int response2;
                    do {
                        System.out.print("Tonton film nomor berapa: ");
                        response2 = sc.nextInt();
                        Pengguna.dbPengguna[index].watchFilm(response2);
                        System.out.println("Masih ingin menonton?");
                        System.out.println("1. Ya\n2. Tidak");
                        System.out.print("Response [1/2]: ");
                        response2 = sc.nextInt();
                        System.out.println();
                    } while (response2 == 1);
                } else {
                    System.out.println("Belum ada pengguna yang terdaftar dengan index tersebut.");
                    System.out.println("Silakan lakukan registrasi pengguna terlebih dahulu.");
                    System.out.println();
                }
            }

            // Jika pengguna input 2 -> Buka history
            else if (response == 2) {
                System.out.println("Masukkan index pengguna anda dalam dbPengguna: ");
                int index = sc.nextInt();
                Pengguna.dbPengguna[index].getHistory();
                System.out.println();
            }

            // Jika pengguna input 3 -> Tampilkan informasi akun
            else if (response == 3) {
                System.out.println("Masukkan index pengguna anda dalam dbPengguna: ");
                int index = sc.nextInt();
                Pengguna.dbPengguna[index].accInfo();
                System.out.println();
            }

            // Jika pengguna input 4 -> Daftarkan pengguna baru
            else if (response == 4) {
                Pengguna.createAcc();
                System.out.println();
            }

            else if (response == 5) {
                System.out.print("Masukkan index pengguna anda dalam dbPengguna: ");
                int index = sc.nextInt();
                if (Pengguna.dbPengguna[index] != null) {
                    Pengguna.dbPengguna[index].upgrade(Pengguna.dbPengguna[index].getKode(),
                            Pengguna.dbPengguna[index].getNama(), Pengguna.dbPengguna[index].getTelp());
                } else {
                    System.out.println("Belum ada pengguna yang terdaftar dengan index tersebut.");
                    System.out.println("Silakan lakukan registrasi pengguna terlebih dahulu.");
                    System.out.println();
                }
            }

            else if (response == 6) {
                System.out.println();
                System.out.println("Terima kasih telah menggunakan layanan JalaFlix!");
                exit = 1;
            }

        } while (exit == 0);
    }
}
