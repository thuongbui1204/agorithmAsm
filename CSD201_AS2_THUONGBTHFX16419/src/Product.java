public class Product {
    private String ID;
    private String title;
    private int quantity;
    private double price;
    public Product(String ID,String title,int quantity,double price){
        this.ID=ID;
        this.title=title;
        this.quantity=quantity;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public String getID() {
        return ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }
}
