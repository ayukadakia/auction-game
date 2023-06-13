//Ayushi Kadakia
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void printOutput(Parent obj){
        System.out.println("You chose the " + obj.getName() + ". The bidding will begin at $" + obj.getPrice() + ".");  // Output user input
        int price = obj.getPrice();
        int budget = 100 - price;
        System.out.println("Your budget is $100.");


        while (budget > 0) {
            Random ran = new Random();
            int x = ran.nextInt(10) + 9;
            System.out.println("Another bidder raised the price by $" + x);
            int newPrice = price + x;
            System.out.println("The new price of the " + obj.getName() + " is $" + newPrice);
            Scanner input1 = new Scanner(System.in);  // Create a Scanner object
            int a1 = 0;
            if (newPrice > 100) {
                break;
            }
            System.out.println("How much would you like to raise the price by?");
            a1 = input1.nextInt();
            budget = budget - (a1 + x);
            int newPrice2 = price + a1 + x;
            System.out.println("The new price of the " + obj.getName() + " is $" + newPrice2);
            if (budget <= 0) {
                break;
            }
            System.out.println("You can still raise by $" + budget);
            price = newPrice2;
        }
        if (budget == 0) {
            System.out.println("Congratulations, you have won the " + obj.getName() + ".");
        } else {
            System.out.println("Your budget has run out. You lost the " + obj.getName() +  ".");
        }
    }


    public static void Donation(ArrayList<String> donationItem, Scanner scanner) {


        scanner = new Scanner(System.in);


        System.out.println("Please enter ONE NEW item you are able to donate: ");
        donationItem.add(scanner.nextLine());


        System.out.println("Do you want to add a new item to donate? (Yes/No)");
        String answer = scanner.nextLine();


        if (answer.equals("no")) {
            System.out.println("Thanks for providing items to donate.");
            System.out.println("You have chosen to donate the following: " + donationItem);
            return;
        } else {
            Donation(donationItem, scanner);
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello and welcome to this auction.");
        System.out.println("Your budget is $100.");


        String[] items = {"Vase", "Painting", "Vintage Dress", "Baseball Card Collection"};
        for (int i = 0; i < items.length; i++)
            System.out.println("Auction Item #" + (i+1) + " : " + items[i]);


        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("There are four items available to auction. Please enter the number of the item you would like to bid on.");
        String name = myObj.nextLine();  // Read user input


        switch (name) {
            case "1":
                Parent obj1 = new Vase();
                printOutput(obj1);
                break;


            case "2":
                Parent obj2 = new Painting();
                printOutput(obj2);
                break;


            case "3":
                Parent obj3 = new Dress();
                printOutput(obj3);
                break;


            case "4":
                Parent obj4 = new Baseball();
                printOutput(obj4);
                break;


            default:
                System.out.println("Invalid");
                break;
        }


        //Switch Case - Requirement #12: Something New we have not covered in class
        https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html


        System.out.println("We ask all auction participants to donate items for future auctions. Please donate at least one item.");
        String[][] seatingInfo = { {"Jewelery,", "Books,", "Antique Rug",}, {"Camera,", "Handbag,", "Music Album",}, {"Mugs,","Sculptures,", "Sunglasses",} };
        int rows = 3;
        int columns = 3;
        System.out.println("So far, the items we have are: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seatingInfo[i][j] + " ");
            }
            System.out.println();
        }


        ArrayList<String> donationItem = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        Donation(donationItem, scanner);
    }
}
class Parent {
    private String name;
    private int price;
    public Parent(String n, int p) {
        name = n;
        price = p;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }


}
class Vase extends Parent {
    public Vase(){
        super("vase", 20);
    }
}
class Painting extends Parent {
    public Painting(){
        super("painting", 50);
    }
}
class Dress extends Parent {
    public Dress(){
        super("dress", 60);
    }
}
class Baseball extends Parent {
    public Baseball(){
        super("baseball cards", 15);
    }
}

