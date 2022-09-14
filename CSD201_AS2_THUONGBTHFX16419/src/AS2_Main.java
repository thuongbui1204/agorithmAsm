import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class AS2_Main {
    public static int choice =1;
    public static MyList myList=new MyList();
    public static Mystack stack=new Mystack();
    public static Myqueue queue=new Myqueue();
    public static void main(String[] args) {
        //Clear file console_output cũ trước khi bắt đầu ghi mới
        OperationToProduct.writeFile("","console_output.txt",false);
        //chạy chương trình
        while (choice!=0){
            menu();
        }

    }
    public static void menu(){
        printConsoleAndFileln("-----------------Menu-----------------------------");
        printConsoleAndFileln("Choose one of these options:");
        printConsoleAndFileln("Product List.");
        printConsoleAndFileln("1. Load data from file and display.");
        printConsoleAndFileln("2. Input & add to the end.");
        printConsoleAndFileln("3. Display data.");
        printConsoleAndFileln("4. Save product list to file.");
        printConsoleAndFileln("5. Search by ID.");
        printConsoleAndFileln("6. Delete by ID.");
        printConsoleAndFileln("7. Sort by ID.");
        printConsoleAndFileln("8. Convert to Binary.");
        printConsoleAndFileln("9. Load to stack and display.");
        printConsoleAndFileln("10. Load to queue and display. ");
        printConsoleAndFileln("Exit: ");
        printConsoleAndFileln("0. Exit. ");
        printConsoleAndFileln("------------------------------------------------");
        printConsoleAndFile("Choice = ");
        try{
        Scanner sc=new Scanner(System.in);
        choice = sc.nextInt();
        OperationToProduct.writeFile(choice+"\n","console_output.txt",true);
        switch (choice) {
            case 1:
                choice1();
                break;
            case 2:
                choice2();
                break;
            case 3:
                choice3();
                break;
            case 4:
                choice4();
                break;
            case 5:
                choice5();
                break;
            case 6:
                choice6();
                break;
            case 7:
                choice7();
                break;
            case 8:
                choice8();
                break;
            case 9:
                choice9();
                break;
            case 10:
                choice10();
                break;
            case 0:
                printConsoleAndFileln("Thanks");
                break;
            default:
                printConsoleAndFileln("Wrong choice, please re-input your choice!");
        }}
        catch(InputMismatchException e){
            printConsoleAndFileln("Wrong choice, please re-input your choice!");
        }
    }
    public static void choice1(){
        try{
            printConsoleAndFileln("ID | Title | Quantity | Price ");
            //đọc dữ liệu từ file
            String text=OperationToProduct.readFile("data.txt");
            //lưu vào danh sách móc nối
            myList=OperationToProduct.changeTextToLinkedList(text);
            //hiển thị ra màn hình
            printConsoleAndFileln(myList.toString());
        }catch(ArrayIndexOutOfBoundsException e){
            //nếu file trống, hiển thị yêu cầu nhập dữ liệu trước khi display
            printConsoleAndFileln("File is empty, please input data by choice 2");
        }


    }
    public static void choice2(){
        try {
            //nhập dữ liệu
            Scanner input=new Scanner(System.in);
            printConsoleAndFile("Input new ID: ");
            String ID = input.nextLine();
            OperationToProduct.writeFile(ID+"\n","console_output.txt",true);
            printConsoleAndFile("Input product's Name: ");
            String title = input.nextLine();
            OperationToProduct.writeFile(title+"\n","console_output.txt",true);
            printConsoleAndFile("Input Product's quantity: ");
            int quantity = input.nextInt();
            OperationToProduct.writeFile(quantity+"\n","console_output.txt",true);
            printConsoleAndFile("Input Product's price: ");
            double price = input.nextDouble();
            OperationToProduct.writeFile(quantity+"\n","console_output.txt",true);
            Product newProduct=new Product(ID,title,quantity,price);
            //lưu dữ liệu vào danh sách
            myList.insertToTail(newProduct);
        }catch (InputMismatchException e){//báo lỗi nếu dữ liệu nhập vào không đúng định dạng
            printConsoleAndFileln("\nWrong data input, please re-input your choice!");
        }
    }
    public static void choice3(){
        //hiển thị danh sách
        printConsoleAndFileln("ID | Title | Quantity | Price ");
        printConsoleAndFileln(myList.toString());
    }
    public static void choice4(){
        //lưu danh sách vào file
        OperationToProduct.writeFile(myList.toString(),"data.txt",false);
        printConsoleAndFileln("Successfully!");
    }
    public static void choice5(){
        //nhập ID cần tìm
        printConsoleAndFile("Input the ID to search = ");
        Scanner input=new Scanner(System.in);
        String id=input.next();
        OperationToProduct.writeFile(id+"\n","console_output.txt",true);
        //tìm kiếm ID
        Node result=myList.searchById(id);
        //hiển thị kết quả
        if(result==null){
            printConsoleAndFileln("Result: -1");
        }else {
            printConsoleAndFileln("Result: " + result);
        }
    }
    public static void choice6(){
        //nhập ID cần xoá
        printConsoleAndFile("Input the ID to delete = ");
        Scanner input=new Scanner(System.in);
        String id= input.next();
        OperationToProduct.writeFile(id+"\n","console_output.txt",true);
        //xoá ID
        boolean deleted= myList.deleteElement(id);
        //hiển thị kết quả
        if(deleted){
            printConsoleAndFileln("Deleted!");
        }else {printConsoleAndFileln("No element found to delete!");}
    }
    public static void choice7(){
        try {
            //sắp xếp danh sách
            MyList listSorted=OperationToProduct.sortById(myList);
            //hiển thị danh sách sau sắp xếp
            printConsoleAndFileln(listSorted.toString());
            printConsoleAndFileln("Successfully!");
        }catch (NullPointerException e){ // báo lỗi nếu danh sách rỗng
            printConsoleAndFileln("Data is empty, please load data by choice 1 or input data by choice 2");
        }
    }
    public static void choice8(){
        try {
            //lấy số lượng của sản phẩm đầu tiên
            int number = myList.getHead().getProduct().getQuantity();
            //chuyển ra hệ nhị phân và hiển thị ra màn hình
            printConsoleAndFileln(OperationToProduct.convertToBinary(number));
        }catch (NullPointerException e){
            printConsoleAndFileln("Data is empty, please load data by choice 1 or input data by choice 2");
        }

    }
    public static void choice9(){
        try{
            printConsoleAndFileln("ID | Title | Quantity | Price ");
            //đọc dữ liệu từ file
            String text=OperationToProduct.readFile("data.txt");
            //lưu vào stack
            stack=OperationToProduct.changeTextToStack(text);
            //hiển thị ra màn hình
            printConsoleAndFileln(stack.toString());
        }catch(ArrayIndexOutOfBoundsException e){//nếu file trống, hiển thị yêu cầu nhập dữ liệu trước khi display
            printConsoleAndFileln("File is empty, please input data by choice 2");
        }
    }
    public static void choice10(){
        try{
            printConsoleAndFileln("ID | Title | Quantity | Price ");
            //đọc dữ liệu từ file
            String text=OperationToProduct.readFile("data.txt");
            //lưu vào queue
            queue=OperationToProduct.changeTextToQueue(text);
            //hiển thị ra màn hình
            printConsoleAndFileln(queue.toString());
        }catch(ArrayIndexOutOfBoundsException e){//nếu file trống, hiển thị yêu cầu nhập dữ liệu trước khi display
            printConsoleAndFileln("File is empty, please input data by choice 2");
        }
    }
    //Method đồng thời in ra màn hình và in vào file thay thế cho System.out.println
    public static void printConsoleAndFileln(String text){
        System.out.println(text);
        OperationToProduct.writeFile(text+"\n","console_output.txt",true);

    }
    //Method đồng thời in ra màn hình và in vào file thay thế cho System.out.print
    public static void printConsoleAndFile(String text){
        System.out.print(text);
        OperationToProduct.writeFile(text,"console_output.txt",true);

    }
}
