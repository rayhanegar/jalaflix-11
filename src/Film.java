public class Film {
    private String judul, genre, sinopsis;
    private int tahun, rating; // rating umur

    Film() {
    }

    Film(String judul, String genre, String sinopsis, int tahun, int rating) {
        this.judul = judul;
        this.genre = genre;
        this.sinopsis = sinopsis;
        this.tahun = tahun;
        this.rating = rating;
    }

    Film(String judul, Genre genre, String sinopsis, int tahun, int rating) {
        this.judul = judul;
        this.genre = genre.getGenre();
        this.sinopsis = sinopsis;
        this.tahun = tahun;
        this.rating = rating;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

class Reguler extends Film {
    public Reguler(String judul, String genre, String sinopsis, int tahun, int rating) {
        super(judul, genre, sinopsis, tahun, rating);
    }

    public Reguler(String judul, Genre genre, String sinopsis, int tahun, int rating) {
        super(judul, genre, sinopsis, tahun, rating);
    }
}

class Baru extends Film {
    public Baru(String judul, String genre, String sinopsis, int tahun, int rating) {
        super(judul, genre, sinopsis, tahun, rating);
    }

    public Baru(String judul, Genre genre, String sinopsis, int tahun, int rating) {
        super(judul, genre, sinopsis, tahun, rating);
    }
}

class Original extends Film {
    public Original(String judul, String genre, String sinopsis, int tahun, int rating) {
        super(judul, genre, sinopsis, tahun, rating);
    }

    public Original(String judul, Genre genre, String sinopsis, int tahun, int rating) {
        super(judul, genre, sinopsis, tahun, rating);
    }
}
