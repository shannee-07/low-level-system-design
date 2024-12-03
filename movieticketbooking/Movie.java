package movieticketbooking;


import java.util.List;

public class Movie {
    private int movieId;
    private String name;
    private List<MovieGenre> genre;
    private Language language;
    private int duration;
    private int rating;

    public Movie(int movieId, String name, List<MovieGenre> genre, Language language, int duration, int rating) {
        this.movieId = movieId;
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public List<MovieGenre> getGenre() {
        return genre;
    }

    public Language getLanguage() {
        return language;
    }

    public int getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }
}
