public class Database {
    private static final int banyakFilm = 36;
    public static Film db[] = new Film[banyakFilm];

    String ac = Genre.ACTION.getGenre();
    String dr = Genre.DRAMA.getGenre();
    String rm = Genre.ROMANCE.getGenre();
    String ho = Genre.HORROR.getGenre();
    String si = Genre.SCIFI.getGenre();
    String my = Genre.MYSTERY.getGenre();
    String ff = Genre.FANFIC.getGenre();
    String jp = Genre.ANIME.getGenre();

    public int dbGetBanyakFilm() {
        return banyakFilm;
    }

    public String dbGetJudul(int index) {
        return db[index].getJudul();
    }

    public String dbGetSinopsis(int index) {
        return db[index].getSinopsis();
    }

    /**
     * Seleksi berdasarkan tier pengguna
     * 1. Untuk tier "reg": 12 film pertama (debugCounter = 12)
     * 2. Untuk tier "gold": 12+12 film pertama (debugCounter = 24)
     * 3. Untuk tier "platinum": 12 + 12 + 12 film pertama (debug counter = 36)
     *
     * Urutan film dalam db[] sudah diatur sedemikian rupa sesuai dengan ketentuan di atas.
     */
    public int dbGetTierLimitor(String tier) {
        int debugCounter = 0;
        for (int i = 0; i < db.length; i++) {
            if (db[i] instanceof Reguler && tier.equals("reg")) {
                debugCounter++;
                // System.out.println("true reguler " + debugCounter);
            } else if ((db[i] instanceof Reguler || db[i] instanceof Baru) &&
                    tier.equals("gold")) {
                debugCounter++;
                // System.out.println("true gold " + debugCounter);
            } else if (tier.equals("platinum")) {
                debugCounter++;
                // System.out.println("true platinum " + debugCounter);
            }
        }
        return debugCounter;
    }

    Database() {
        // FILM 5 TAHUN LAWAS
        db[0] = new Reguler("Captain Indonesia", ac,
                "Seorang pria dari amerika yang berjuang demi menyelamatkan amerika dari serangan alien",
                1999, 13);
        db[1] = new Reguler("Waktu Zuhur", dr + ", " + ac,
                "Kisah dimana seorang pria yang sedang mencari kekasihnya di waktu zuhur", 2012, 13);
        db[2] = new Reguler("Nurse Strange", ac,
                "Seorang suster yang mengalami kecelakaan dan pergi ke sebuah gapura untuk mengatasi kecacatannya, pada akhirnya ia mendapatkan super power untuk membasmi kejahatan",
                2016, 13);
        db[3] = new Reguler("Kukira Kau Hotel", dr + ", " + rm,
                "Kisah cinta seorang pria yang menemukan cinta sejatinya di hotel", 2011, 16);
        db[4] = new Reguler("Filosofi Teh", dr,
                "Kisah dimana seorang pria yang mabuk teh hingga menjadi seorang entrepreneur yang sukses",
                2001, 13);
        db[5] = new Reguler("Kuntil-Bapak", ho,
                "Kisah dimana ada seorang pemuda yang tidak sengaja membangkitkan hantu yang bernama Kuntil-bapak",
                1998, 13);
        db[6] = new Reguler("Sepuluh Garis Biru", dr,
                "Kisah dimana ada seorang pemuda yang tidak sengaja membuat karya dengan 10 garis berwarna biru, yang membuatnya sukses",
                2012, 13);
        db[7] = new Reguler("My Smart Boss", dr,
                "Kisah dimana seorang wanita tua yang memiliki boss yang pintar sehingga membuat wanita itu sukses dunia akhirat",
                2017, 13);
        db[8] = new Reguler("Warteg DKI", dr,
                "Kisah dimana ada warteg yang berlokasi di Jakarta yang sedikit demi sedikit mulai terkenal di seluruh bagian Bimasakti",
                2012, 13);
        db[9] = new Reguler("Keluarga Beringin", dr + ", " + rm,
                "Kisah dimana menceritakan keluarga beringin yang dimana anggota keluarganya di tebang untuk membuat furniture yang fantastis",
                2016, 13);
        db[10] = new Reguler("Pistol-dalla", ac,
                "Kisah dimana bagaimana cara pahlawan kita, Gundalla membuat senjatanya", 2009, 16);
        db[11] = new Reguler("Injustic League", ac,
                "Kisah dimana ada sekelompok pahlawan yang sudah letih menjadi pahlawan dan membunuh semua makhluk dimuka bumi ",
                2016, 13);

        // FILM TERBARU
        db[12] = new Baru("Atau-nur", ho,
                "Kisah yang melanjutkan kisah Danur yang dimana asih sudah berubah menjadi seorang hantu pria",
                2018,
                13);
        db[13] = new Baru("Laskar Abu-Abu", dr + ", " + ac,
                "Kisah dimana sekelompok pemuda yang berusaha untuk sukses tetapi dengan cara yang salah, yaitu dengan menjadi penjual sabu yang sangat sukses",
                2019, 8);
        db[14] = new Baru("Mengembalikan Raden Saleh", ac,
                "Kisah dimana seorang pencuri yang sudah tobat dalam hal mencuri dan ingin mengembalikan lukisan Raden Saleh",
                2020, 13);
        db[15] = new Baru("Prissonlangkung", ho,
                "Kisah dimana seorang pemuda yang melakukan investigasi dalam sebuah penjara dan bertemu dengan hantu yang disebut dengan PrissonLangkung",
                2018, 13);
        db[16] = new Baru("Good Boys", ac,
                "Kisah dimana sekelompok pria paruh baya yang sudah taubat nasuha dan menjadi sekelompok orang yang akan menyelamatkan bumi dari serangan mafia intergalaksi",
                2019, 13);
        db[17] = new Baru("Jamal Potter", ac,
                "Kisah dimana ada seorang pemuda yang berubah menjadi orang kafir dengan mempelajari ilmu sihir dan memiliki motivasi untuk melakukan muggen sukoyomi",
                2021, 13);
        db[18] = new Baru("Slow Furrious", ac,
                "Kisah dimana ada seorang mekanik yang ingin membuat sebuah mobil sebuah mobil yang lambat tetapi memiliki daya serang yang kuat untuk melindungi negaranya",
                2023, 13);
        db[19] = new Baru("Ready Player Two", si + ", " + ac,
                "Kisah dimana seorang pria paruh baya yang masuk kedalam game perang yang dimana dia harus menyelesaikan game tersebut",
                2022, 13);
        db[20] = new Baru("Outerstellar", si + ", " + my,
                "Kisah dimana sekelompok pemuda gila yang sedang menjelajahi langit dan berperang dengan alien",
                2020,
                13);
        db[21] = new Baru("Mission Not Impossible", ac,
                "Kisah dimana ada seorang penembak jitu yang ingin menyelesaikan misi terakhirnya dengan menggunakan bantuan alien",
                2020, 13);
        db[22] = new Baru("The King of the Rings", ff,
                "Kisah dimana seorang cyborg yang belajar untuk membuat cincin yang sangat OP untuk berkomunikasi dengan malaikat maut agar dapat membunuh orang yang ia mau atas bantuan malaikat maut",
                2023, 13);
        db[23] = new Baru("The light Knight", ac,
                "Kisah dimana seorang pemuda yang sudah berjemur diatas teriknya matahari sehingga ia mampu mengontrol intentensitas cahaya matahari untuk berperang",
                2019, 13);

        // FILM ORIGINAL SERIES
        db[24] = new Original("Sawman", ac + ", " + jp,
                "Kisah dimana seorang pria dari planet mars yang memiliki misi untuk menebang semua pohon dibumi untuk membuat planet mars menjadi sebuah planet yang indah",
                2023, 13);
        db[25] = new Original("Two Kick Man", ac,
                "Kisah dimana ada seorang pahlawan yang dapat mematikan lawannya hanya dengan dua tendangan maut",
                2018,
                13);
        db[26] = new Original("Indonesia Revenger", ac + ", " + jp,
                "Kisah dimana ada sekelompok orang yang sangat kuat berasal dari Indonesia dan ingin menghancurkan Negara yang sudah menjajah Indonesia",
                2023, 13);
        db[27] = new Original("Dragon Cube", ac + ", " + jp,
                "Kisah dimana ada sekelompok pemuda yang sedang berkelana di dunia lain untuk menangkap semua naga untuk dijadikan sebuah kotak misterius yang dapat menghancurkan semua galaksi",
                2022, 13);
        db[28] = new Original("Spy x Penjabat", ac + ", " + dr + ", " + jp,
                "Kisah dimana ada seorang perempuan yang menikah dengan orang penjabat untuk memata-matai koruptor di Indonesia",
                2021, 13);
        db[29] = new Original("Pablo Bagas", ac + ", " + dr,
                "Kisah Bandar narkoba dari Indonesia yang menjual narkobanya hanya kenegara lain yang dimana uang hasil jualannya akan diberikan kepada orang miskin di Indonesia",
                2018, 13);
        db[30] = new Original("My Villian Academia", ac + ", " + jp,
                "Kisah dimana ada anak pahlawan yang bersekolah di sekolah penjahat terbaik agar dapat membunuh bapaknya sendiri",
                2019, 13);
        db[31] = new Original("Angel Slayer", ac + ", " + jp,
                "Kisah dimana ada seorang reinkarnasi dari iblis yang ingin membalas dendamnya ke semua malaikat yang membunuh semmua temannya ketika ia sedang menjadi iblis",
                2022, 13);
        db[32] = new Original("Two Piece", ac + ", " + jp,
                "Kisah dimana seorang pemuda yang berkelana antar galaksi sekaligus mencari anggota kelompoknya untuk mencari  artifak kuno yang terpisah jauh antar satu sama lain",
                2019, 13);
        db[33] = new Original("White Clover", ac + ", " + jp,
                "Kisah petualang seorang pemuda gila yang memiliki bentuk tubuh seperti semanggi dan berwarna putih yang terus mencari orang yang telah mengutuk tubuhnya",
                2019, 13);
        db[34] = new Original("Deffend on Titan", ac + ", " + jp,
                "Kisah dimana sekelompok manusia kerdil yang berjuang untuk melindungi manusia raksasa",
                2021, 13);
        db[35] = new Original("Attack on Dwarf", ac + ", " + jp,
                "Kisah dimana seluruh manusia raksasa yang melindungi kaumnya dari serangan manusia kerdil yang memiliki kekuatan dua kali manusia raksasa",
                2011, 17);
    }

}
