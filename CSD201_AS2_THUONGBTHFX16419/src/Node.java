public class Node {
    Product product;
    Node nextNode;
    public Node(Product product) {
        this.product = product;
        this.nextNode = null;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString(){
        return this.product.getID()+" | "+this.product.getTitle()+" | "+this.product.getQuantity()+" | "+this.product.getPrice();
    }
}
