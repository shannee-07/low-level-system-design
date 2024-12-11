package movieticketbooking;

import java.util.*;

public class MovieTicketBooking {
    public static List<Show> populateData() {
        List<Show> shows = new ArrayList<>();
        Movie inception = new Movie(
                1,
                "Inception",
                Arrays.asList(MovieGenre.ACTION, MovieGenre.THRILLER),
                Language.ENGLISH,
                148,
                9
        );

        Movie parasite = new Movie(
                2,
                "Parasite",
                Arrays.asList(MovieGenre.DRAMA, MovieGenre.THRILLER),
                Language.KOREAN,
                132,
                8
        );

        Movie threeIdiots = new Movie(
                3,
                "3 Idiots",
                Arrays.asList(MovieGenre.COMEDY, MovieGenre.DRAMA),
                Language.HINDI,
                170,
                10
        );
        Movie avatar = new Movie(
                4,
                "Avatar",
                Arrays.asList(MovieGenre.ACTION, MovieGenre.SCI_FI),
                Language.ENGLISH,
                162,
                9
        );

        Movie titanic = new Movie(
                5,
                "Titanic",
                Arrays.asList(MovieGenre.DRAMA, MovieGenre.ROMANCE),
                Language.ENGLISH,
                195,
                8
        );

        Movie joker = new Movie(
                6,
                "Joker",
                Arrays.asList(MovieGenre.DRAMA, MovieGenre.THRILLER),
                Language.ENGLISH,
                122,
                9
        );

        Theatre velocity = new Theatre(1, "Velocity", Arrays.asList(new Screen(6, 10)), "Indore");
        Theatre c21 = new Theatre(2, "C21", Arrays.asList(new Screen(6, 7)), "Indore");
        Theatre inox = new Theatre(3, "Inox", Arrays.asList(new Screen(8, 13)), "Mumbai");
        Theatre pvr = new Theatre(4, "PVR", Arrays.asList(new Screen(11, 18)), "Delhi");

        // Shows for Velocity
        shows.add(new Show(1, avatar, velocity, new Date(2024, 12, 4, 12, 30), 0));
        shows.add(new Show(2, titanic, velocity, new Date(2024, 12, 4, 15, 30), 0));
        shows.add(new Show(1, threeIdiots, velocity, new Date(2024, 12, 4, 12, 30), 0));
        shows.add(new Show(2, inception, velocity, new Date(2024, 12, 4, 12, 30), 0));

        // Shows for C21
        shows.add(new Show(3, joker, c21, new Date(2024, 12, 5, 10, 0), 0));
        shows.add(new Show(4, avatar, c21, new Date(2024, 12, 5, 13, 0), 0));

        // Shows for Inox
        shows.add(new Show(5, titanic, inox, new Date(2024, 12, 6, 14, 0), 0));
        shows.add(new Show(6, joker, inox, new Date(2024, 12, 6, 17, 30), 0));

        // Shows for PVR
        shows.add(new Show(7, avatar, pvr, new Date(2024, 12, 7, 11, 0), 0));
        shows.add(new Show(8, titanic, pvr, new Date(2024, 12, 7, 14, 30), 0));
        return shows;
    }

    public static void showOptionsToSearch() {
        System.out.println("\nPlease select an option");
        System.out.println("1: search movie by name");
        System.out.println("2: search movie by genre");
        System.out.println("3: search movie by location");
        System.out.println("4: search movie by language");
        System.out.println("5: Exit");
    }

    public static List<Show> searchMovieByName(String name, List<Show> shows) {
        List<Show> availableShows = new ArrayList<>();
        for (Show show : shows) {
            if (show.getMovie().getName().equalsIgnoreCase(name)) {
                availableShows.add(show);
            }
        }
        return availableShows;
    }

    public static boolean initiateBooking(List<Show> availableShows){
        Scanner sc = new Scanner(System.in);
        if (availableShows.isEmpty()) {
            System.out.println("No shows available for selected  movie");
            return false;
        }
        int showNumber = 1;
        for (Show show : availableShows) {
            System.out.println(showNumber++);
            show.showDetails();
        }
        System.out.println("Select show to book");
        int selectedShowNum = sc.nextInt();
        if (selectedShowNum > availableShows.size()) {
            System.out.println("Invalid selection!!!");
            return false;
        }
        Show selectedShow = availableShows.get(selectedShowNum - 1);
        selectedShow.getTheatre().showSeats(selectedShow.getScreenIndex());
        System.out.println("Enter number of seats to book");
        int total = sc.nextInt();
        int[][] selectedSeats = new int[total][2];
        for (int i = 1; i <= total; i++) {
            System.out.println("Enter row and column for seat "+i);
            while (true) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                boolean isAvailable = selectedShow.getTheatre().getScreens().get(selectedShow.getScreenIndex()).isSeatAvailable(row, col);
                if (isAvailable) {
                    selectedShow.getTheatre().getScreens().get(selectedShow.getScreenIndex()).bookSeat(row, col);
                    break;
                }else{
                    System.out.println("Seat:" + row + ", " + col + " is not available. Choose other seat");
                }
            }
        }
        return true;
    }

    public static void start() {
        Scanner sc = new Scanner(System.in);
        List<Show> shows = populateData();
        while (true) {
            showOptionsToSearch();
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1: {
                    System.out.println("Enter name of the movie");
                    String name = sc.nextLine();
                    List<Show> availableShows = searchMovieByName(name, shows);
                    boolean success = initiateBooking(availableShows);
                    break;
                }

                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}
