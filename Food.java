public class Food {
    private String name;
    private double price;
    private String spicyLevel;

    public Food(String name, double price, String spicyLevel) {
        this.name = name;
        this.price = price;
        this.spicyLevel = spicyLevel;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSpicyLevel() {
        return spicyLevel;
    }

    public void displayFood() {
        System.out.println(name + " - $" + price + " - Spicy Level: " + spicyLevel);
    }
}
