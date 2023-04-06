public enum Genre {
    ACTION("Action"), DRAMA("Drama"), ROMANCE("Romance"), HORROR("Horror"), SCIFI("Science Fiction"),
    MYSTERY("Mystery"), FANFIC("Fantasy Fiction"), ANIME("Japanese Animation");

    private final String filmGenre;

    private Genre(String input) {
        this.filmGenre = input;
    }

    public String getGenre() {
        return filmGenre;
    }
}
