import java.io.*;
import java.util.Arrays;

public class OperationToProduct {
    public static void writeFile(String text,String fileName,boolean append){
        File file= new File("../"+fileName);
        try{
            FileWriter newFile=new FileWriter(file,append);
            newFile.write(text);
            newFile.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Writer error");
        }
    }
    public static String readFile(String fileName){
        File file= new File("../"+fileName);
        String result="";
        int c;
        try{
           FileReader fr =new FileReader(file);
           while((c=fr.read())!=-1){
               result=result+(char)c;
           }
           fr.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Writer error");
        }
        return result;
    }
    public static MyList changeTextToLinkedList(String text){
        MyList list=new MyList();
        String [] arr=text.split("\n");
        for(int i=0;i<arr.length;i++) {
            String[] item = arr[i].split(" \\| ");
            Product product = new Product(item[0], item[1], Integer.parseInt(item[2]), Double.parseDouble(item[3]));
            list.insertToTail(product);
        }
        return list;
    }
    public static Mystack changeTextToStack(String text){
        String [] arr=text.split("\n");
        Mystack stack=new Mystack();
        for(int i=0;i<arr.length;i++){
            String[] item=arr[i].split(" \\| ");
            Product product =new Product(item[0],item[1],Integer.parseInt(item[2]),Double.parseDouble(item[3]));
            stack.push(product);
        }
        return stack;
    }
    public static Myqueue changeTextToQueue(String text){
        Myqueue queue=new Myqueue();
        String [] arr=text.split("\n");
        for(int i=0;i<arr.length;i++) {
            String[] item = arr[i].split(" \\| ");
            Product product = new Product(item[0], item[1], Integer.parseInt(item[2]), Double.parseDouble(item[3]));
            queue.enqueue(product);
        }
        return queue;
    }
    public static String convertToBinary(int x){
        if(x/2==0) {
            return ""+(x%2);
        }else{
        return convertToBinary(x/2)+(x%2);
        }
    }
    //sắp xếp bằng Quicksort
    public static MyList sortById(MyList list) {
        if (list.isEmpty()||list.getHead().getNextNode()==null) {
            return list;
        }
        //Lấy head làm mốc và tách ra 2 list:
        Node current = list.getHead().getNextNode();
        MyList list1 = new MyList();
        MyList list2 = new MyList();
        //xếp product trước head vào list 1 và product sau head vào list 2
        while (current != null) {
            if (current.getProduct().getID().compareTo(list.getHead().getProduct().getID()) < 0) {
                list1.insertToHead(current.getProduct());
            } else {
                list2.insertToHead(current.getProduct());
            }
            current=current.getNextNode();
        }
        //ghép 2 list và head, sử dụng đệ quy
        MyList result=new MyList();
        MyList list1Sorted=sortById(list1);
        MyList list2Sorted=sortById(list2);
        if(!list1Sorted.isEmpty()) {
            Node tem = list1Sorted.getHead();
            while (tem != null) {
                result.insertToTail(tem.getProduct());
                tem = tem.getNextNode();
            }
        }

        result.insertToTail(list.getHead().getProduct());

        if(!list2Sorted.isEmpty()) {
            Node tem = list2Sorted.getHead();
            while (tem != null) {
                result.insertToTail(tem.getProduct());
                tem = tem.getNextNode();
            }
        }
        return result;
    }

}
