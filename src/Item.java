public class Item {
    private String itemName;
    private int rating;
    private String itemCode;
    private double price;

    //
    public Item(String name, int rating, String code, double price) {
        this.itemName = name;
        this.rating = rating;
        this.itemCode = itemCode;
        this.price = price;
    }

    //
    public Item(String name, String code) {
        this.itemName = name;
        this.itemCode = code;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
