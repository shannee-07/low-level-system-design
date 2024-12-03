package movieticketbooking;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final List<List<Seat>> seats;

    public Screen(int rows, int cols) {
        seats = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Seat> seatRow = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                seatRow.add(new Seat());
            }
            seats.add(seatRow);
        }
    }

    public void showSeats() {
        System.out.print("    ");
        for (int i = 0; i < seats.getFirst().size(); i++) {
            System.out.print(i + "  ");
            if (i < 10) {
                System.out.print("  ");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < seats.size(); i++) {
            System.out.print(i);
            if (i < 10) {
                System.out.print(" ");
            }

            for (int j = 0; j < seats.getFirst().size(); j++) {
                if (seats.get(i).get(j).isAvailable()) {
                    System.out.print("  □  ");
                } else {
                    System.out.print("  ■  ");
                }
            }
            System.out.println();
        }
    }

    public boolean bookSeat(int row, int col) {
        return seats.get(row).get(col).book();
    }

    public List<List<Seat>> getSeats() {
        return seats;
    }

    public boolean isSeatAvailable(int row, int col){
        return seats.get(row).get(col).isAvailable();
    }
}
