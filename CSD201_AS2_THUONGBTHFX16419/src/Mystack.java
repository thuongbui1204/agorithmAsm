public class Mystack {
        private Node head;

        public Mystack() {
            this.head = null;
        }

        public boolean isEmpty() {
            return (this.head == null);
        }

        public void push(Product product) {
            Node newNode=new Node(product);
            newNode.setNextNode(this.head);
            this.head = newNode;
        }

        public Node pop() {
            if (isEmpty()) {
                return null;
            } else {
                Node result = this.head;
                this.head = this.head.getNextNode();
                return result;
            }
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getHead() {
            return head;
        }
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
