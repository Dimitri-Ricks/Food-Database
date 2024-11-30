import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Search Method
    public static String searchFood(ArrayList<Food> elements, String foods) {
        for (Food food : elements) {
            if (food.getFood().equals(foods)) {
                return food.toString();
            }
        }
        return "Food not found";
    }

    // sort method
    public static void sortPrice(ArrayList<Food> elements) {
        for (int i = 0; i < elements.size() - 1; i++) {
            int minNum = i;
            for (int num = i + 1; num < elements.size(); num++) {
                if (elements.get(num).getCost() < elements.get(minNum).getCost()) {
                    minNum = num;
                }
            }
            Food hold = elements.get(i);
            elements.set(i, elements.get(minNum));
            elements.set(minNum, hold);
        }
    }

    public static void main(String[] args) {

        Scanner intDoublescan = new Scanner(System.in);// int and double
        Scanner stringScanner = new Scanner(System.in);// string

        ArrayList<Food> foodList = new ArrayList<Food>();

        System.out.println("1. Add a food");
        System.out.println("2. Search by food name");
        System.out.println("3. Sory by price");
        System.out.println("4. Print all");
        System.out.println("5. Quit");
        System.out.println();
        System.out.print("Enter Choice: ");
        int choice = intDoublescan.nextInt();
        System.out.println();

        while (choice != 5) {
            if (choice == 1) {
                System.out.print("food Name: ");
                String food = stringScanner.next();
                System.out.print("Rating (out of 10): ");
                double rate = intDoublescan.nextDouble();
                System.out.print("Price: ");
                double price = intDoublescan.nextDouble();
                System.out.println();
                Food newFood = new Food(food, rate, price);
                foodList.add(newFood);
            }
            if (choice == 2) {
                System.out.print("Food Name: ");
                String Food = stringScanner.next();
                System.out.println();
                System.out.println(searchFood(foodList, Food));
            }
            if (choice == 3) {
                System.out.println("Sorting...");
                sortPrice(foodList);
                System.out.println("Sorted by price");
                System.out.println("");
            }
            if (choice == 4) {
                for (Food food : foodList) {
                    System.out.println(food);
                }
            }
            System.out.println("1. Add a food");
            System.out.println("2. Search by food name");
            System.out.println("3. Sory by price");
            System.out.println("4. Print all");
            System.out.println("5. Quit");
            System.out.println();
            System.out.print("Enter Choice: ");
            choice = intDoublescan.nextInt();
            System.out.println();
        }

    }
}

class Food {
    private String food;
    private double rating;
    private double cost;

    // constructor
    public Food(String initFood, double initRating, double initCost) {
        food = initFood;
        rating = initRating;
        cost = initCost;
    }

    public Food() {
        food = "Ice Cream";
        rating = 10;
        cost = 7.25;
    }

    // getter methods
    public String getFood() {
        return food;
    }

    public double getRating() {
        return rating;
    }

    public double getCost() {
        return cost;
    }

    public String toString() {
        return "Food: " + food + ", Rating: " + rating + ", Cost: $" + cost + "\n";
    }

}