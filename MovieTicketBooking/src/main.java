import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int status = 1;
        Movie movieList[] = null;
        do {
            System.out.println("Welcome to C.West Theaters");
            System.out.println("1. Add movie details");
            System.out.println("2. Search & Book");
            System.out.println("3. View All");
            System.out.println("Enter your choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter number of movies: ");
                    int no = sc.nextInt();
                    movieList = new Movie[no];
                    for (int i = 0; i < movieList.length; i++) {
                        int j = i;
                        System.out.println("Enter the movie " + ++j + " Details");
                        movieList[i] = new Movie();
                    }
                    System.out.println("Data save....");
                    break;
                case 2:
                    boolean flag = true;
                    sc.nextLine();
                    System.out.println("Enter the movie name: ");
                    String name = sc.nextLine();
                    for (int i = 0; i < movieList.length; i++) {
                        if (movieList[i].getName().equals(name)) {
                            movieList[i].viewAllDetails();
                            flag = true;
                            System.out.println("Would you like to book tickets for this movie?");
                            System.out.println("Enter 1 to book and 2 to exit");
                            int c = sc.nextInt();
                            if (c == 1) {
                                System.out.println("Enter the number of tickets: ");
                                int tickets = sc.nextInt();
                                int tc = movieList[i].getCost() * tickets;
                                System.out.println("The bill comes to: " + tc);
                            }
                        }  else { flag = false;  }
                    }

                        if (flag == false) { System.err.println("not found");}
                        break;
                        case 3:
                            for (int i = 0; i < movieList.length; i++) {
                                movieList[i].viewAllDetails();
                            }
                        default:
                            System.out.println("Please enter a proper response");
                            System.out.println("Do you want to continue( 1. yes/ 2. No) : ");
                            status = sc.nextInt();


            }
        } while (status == 1);
        System.out.println("Execution completed successfully...");

    }
}
