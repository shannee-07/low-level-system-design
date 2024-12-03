package movieticketbooking;

import java.util.Date;

public class Show {
    private Movie movie;
    private Theatre theatre;
    private int screenIndex;
    private Date startTime;
    private int id;

    public Show(int id, Movie movie, Theatre theatre, Date startTime, int screenIndex) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.startTime = startTime;
        this.screenIndex = screenIndex;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getScreenIndex() {
        return screenIndex;
    }

    public int getId() {
        return id;
    }

    public void showDetails() {
        System.out.println("Movie: " + movie.getName() + ", Theatre: " + theatre.getName() + ", Location: " + theatre.getLocation() + ", Time: " + startTime);
    }
}
