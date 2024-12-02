public class Food {
    private String name;
    private double price;
    private String spicyLevel;

    // Constructor
    public Food(String name, double price, String spicyLevel) {
        this.name = name;
        this.price = price;
        this.spicyLevel = spicyLevel;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSpicyLevel() {
        return spicyLevel;
    }

    // Method to display food details
    public void displayFood() {
        System.out.println(name + " - $" + price + " - Spicy Level: " + spicyLevel);
    }
}
