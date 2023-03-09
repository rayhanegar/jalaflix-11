public class Movie {
    private String judul, genre, sinopsis;
    private int tahun, rating; // rating umur

    Movie() {
    }

    Movie(String judul, String genre, String sinopsis, int tahun, int rating) {
        this.judul = judul;
        this.genre = genre;
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

class Reguler extends Movie {
    Reguler() {
        super();
    }
}

class Baru extends Reguler {
    Baru() {
        super();
    }
}

class Original extends Baru {
    Original() {
        super();
    }
}
