import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // CREATE INSTANCE VARIABLES HERE. Ensure they are static.
    //May want to create an array of goodbye answers.
    private static Food[] menu = new Food[3];

    public static void main(String[] args) {
        makeMenu();

        Scanner scanner = new Scanner(System.in);
        String userInput;


        System.out.println("Welcome to the Five Guys Order Bot! What can I do for you today?");
        System.out.println("To get started, try asking about the menu.");
        System.out.println("Type \"quit\" or \"exit\" to exit.");

        while (true) {
            userInput = scanner.nextLine().toLowerCase();
            ArrayList<Food> cart = new ArrayList<>();  // Using ArrayList for dynamic cart size

            if (userInput.contains("exit") || userInput.contains("quit")) {
                randomGoodbye();
                break;
            }

            processUserInput(userInput, cart);
        }

        scanner.close();
        //You will need to make sure your chatbot continues looping until it sees certain keywords from the user such as "bye","goodbye"...
        // do you need a while loop or a for loop?
          
        //Consider: How do I check what the user says and compare it to my keywords? What methods do I have?
             
    }

        //Create other methods that might be helpful down here. 
        //For example a method called checkWord where the user traverses through an array to check if a word matches.

        //One method you might need is getRandomResponse()

    public static void makeMenu() {
        menu[0] = new Food("Burger", 7.99, "Medium");
        menu[1] = new Food("Fries", 2.99, "Mild");
        menu[2] = new Food("Hot Dog", 4.99, "High");
    }

    public static void processUserInput(String input, ArrayList<Food> cart) {
        if (input.contains("menu")) {
            displayMenu();
        } else if (input.contains("spicy") || input.contains("spice")) {
            respondSpicyLevel();
        } else if (input.contains("price")) {
            displayPrices();
        } else if (input.contains("order")) {
            placeOrder(cart);
        } else if (input.contains("vegetarian")) {
            System.out.println("We have vegetarian options like fries!");
        } else {
            randomResponse();
        }
    }

    public static void displayMenu() {
        System.out.println("Here are our menu items:");
        for (Food food : menu) {
            System.out.println();
            food.displayFood();
        }
        System.out.println("To start an order, type \"order\"");
    }

    public static void respondSpicyLevel() {
        System.out.println("We have food with varying spicy levels: Mild, Medium, and High!");
    }

    public static void displayPrices() {
        System.out.println("Here are our prices:");
        for (Food food : menu) {
            System.out.println(food.getName() + ": $" + food.getPrice());
        }
    }

    public static void randomResponse() {
        String[] responses = {
            "Sorry, I didn't understand that. Can you try asking something else?",
            "Could you rephrase your question?",
            "I didn't quite get that. Try asking about the menu or prices.",
            "I didn't quite get that. Try asking about the spice levels or menu.",
            "Hmm, I didn't catch that. What else can I help with?"
        };
        int randomIndex = (int) (Math.random() * responses.length);
        System.out.println(responses[randomIndex]);
    }
    public static void randomGoodbye() {
        String[] goodbyes = {
            "Goodbye. Thanks for choosing Five Guys!",
            "See you next time! Have a great day.",
            "Enjoy your meal!",
        };
        int randomIndex = (int) (Math.random() * goodbyes.length);
        System.out.println(goodbyes[randomIndex]);
    }
    
    public static void placeOrder(ArrayList<Food> cart) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to order? (Type the food name or type 'done' to finish)");
            String orderInput = scanner.nextLine().toLowerCase();

            if (orderInput.contains("done")) {
                if (cart.isEmpty()) {
                        System.out.println("You didn't add any items to your order.");
                        continue;
                } else {
                        break;
                }
            }

            boolean itemFound = false;

            for (Food food : menu) {
                if (orderInput.contains(food.getName().toLowerCase())) {
                    cart.add(food);
                    System.out.println(food.getName() + " has been added to your order.");
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                System.out.println("Sorry, we couldn't find that item on the menu. Please try again.");
            }
        }

        if (cart.isEmpty()) {
            System.out.println("You didn't add any items to your order.");
        } else {
            double total = 0;
            System.out.println("Your order summary:");
            for (Food food : cart) {
                food.displayFood();
                total += food.getPrice();
            }
            System.out.println("Total: $" + total);
            System.out.println("You may now start a new order or quit.");
        }
    }
}