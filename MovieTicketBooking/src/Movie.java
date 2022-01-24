import java.util.Scanner;

public class Movie {

    private String name;
    private String theatername;
    private int numoftickets;
    private int cost;

    Movie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the movie:");
        this.name = sc.nextLine();
        System.out.println("Enter the theater's name.");
        this.theatername = sc.nextLine();
        System.out.println("Enter the number of tickers");
        this.numoftickets = sc.nextInt();
        System.out.println("Enter the cost per ticker");
        this.cost = sc.nextInt();
    }
    public void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    void setTheatername(String theatername) {
        this.theatername = theatername;
    }
    String getTheatername() {
        return theatername;
    }
    void setNumoftickets() {
        this.numoftickets = numoftickets;
    }
    int getNumoftickets() {
        return numoftickets;
    }
    void setcost(int cost) {
        this.cost = cost;
    }
    int getCost() {
        return cost;
    }
    void storeAllDetails(String name, String brand, int memory, int camera, double price) {

        this.name = name;
        this.theatername = theatername;
        this.numoftickets = numoftickets;
        this.cost = cost;
    }
    void viewAllDetails() {
        System.out.println("Name: " + name);
        System.out.println("Theater Name: " + theatername);
        System.out.println("The number of tickers is: " + numoftickets);
        System.out.println("The cost of a ticket is: " + cost);
    }
}
