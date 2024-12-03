package movieticketbooking;

import java.util.List;

public class Theatre {
    private int theatreId;
    private List<Screen> screens;
    private String location;
    private String name;

    public Theatre(int theatreId, String name, List<Screen> screens, String location) {
        this.theatreId = theatreId;
        this.screens = screens;
        this.location = location;
        this.name = name;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getLocation() {
        return location;
    }

    public void showSeats(int screenIndex){
        Screen screen = screens.get(screenIndex);
        screen.showSeats();
    }

    public boolean bookSeat(int screenIndex, int row, int col){
        Screen screen = screens.get(screenIndex);
        return screen.bookSeat(row, col);
    }

    public String getName() {
        return name;
    }
}
