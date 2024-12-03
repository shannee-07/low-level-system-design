package movieticketbooking;

public class Seat {
    private boolean isAvailable;
    private int row;
    private int column;

    public Seat() {
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean book() {
        if (!isAvailable) {
            throw new IllegalStateException("Seat already booked");
        }
        isAvailable = false;
        return true;
    }
}
