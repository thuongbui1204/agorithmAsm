public class MyList {
    private Node head;
    private Node tail;
    public MyList(){
        this.head=null;
        this.tail=null;
    }

    public boolean isEmpty(){
        return(this.head==null);
    }
    public int length(){
        int length=0;
        Node current=this.head;
        while(current!=null){
            length++;
            current=current.getNextNode();
        }
        return length;
    }
    public void insertToHead(Product product){
        Node newNode=new Node(product);
        newNode.setNextNode(this.head);
        this.head=newNode;
        if(this.tail==null&&this.head.getNextNode()!=null){
            this.tail=this.head.getNextNode();
        }
    }
    public void insertToTail(Product product){
        Node newNode=new Node(product);
        if(this.head==null){
            this.head=newNode;
        }else if(this.tail==null){
            this.head.setNextNode(newNode);
            this.tail=newNode;
        }else { this.tail.setNextNode(newNode);
        this.tail=newNode;
        }
    }
    public boolean deleteElement(String id){
        boolean deleted=false;
        Node current = this.head;
        if(current.getProduct().getID().toUpperCase().equals(id.toUpperCase())){
            this.head=this.head.getNextNode();
            deleted=true;
        }else {
            while(current.getNextNode()!=null) {
                if (current.getNextNode().getProduct().getID().toUpperCase().equals(id.toUpperCase())) {
                        current.setNextNode(current.getNextNode().getNextNode());
                        deleted=true;
                        break;
                    }
                current=current.getNextNode();
            }
        }
        if(current.getNextNode()==null&current!=this.head){
            this.tail=current;
        }
        return deleted;
    }
    public Node searchById(String id){
        Node current =this.head;
        while(current !=null){
            if(current.getProduct().getID().toUpperCase().equals(id.toUpperCase())){
                break;
            }
            current=current.getNextNode();
        }
        return current;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    @Override
    public String toString(){
        String result="";
        Node current=this.head;
        while (current!=null){
            result=result+current.toString()+"\n";
            current=current.getNextNode();
        }
        return result;
    }

}
