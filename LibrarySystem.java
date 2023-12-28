package com.mycompany.librarysystem;

import java.util.*;

public class LibrarySystem {//Static variables for use by other methods
    static Scanner sc = new Scanner(System.in);
    static int attempts = 0; 
    static int maxattempts = 3;
    static String user = "a";
    static String userpass = "qwerty";
    static String[][] books ={
                {"History 1 - 17th Century History(*)", "History 2 - 18th Century History(*)", "History 3 - 19th Century History(*)", "History 4 - 20th Century History(*)"},
                {"Fiction 1 - Aliens(*)", "Fiction 2 - A Clockwork Apple(*)", "Fiction 3 - The Hungry Games(*)", "Fiction 4 - Harry Fucker(*)"},
                {"Science 1 - Biology(*)", "Science 2 - Chemistry(*)", "Science 3 - Physics(*)", "Science 4 - Geology(*)"},
                {"Computer Programming 1 - Java(*)", "Computer Programming 2 - C++(*)", "Computer Programming 3 - Python(*)", "Computer Programming 4 - HTML(*)"},
                };
    static int choice(){
        int choice2 = 0;
        boolean choice = true;
        while(choice){
            choice2 = sc.nextInt();
        if(choice2 >= 1 && choice2 <= 4){
            choice = false;
    }else{
          System.out.println("Invalid choice, try again");
        }
    }
        return choice2;
    }
  
    public static void main(String[] args) {//Login introduction
        System.out.println("Login");
        System.out.println("=====================");
        login();//Transfers to the login method
    }

    public static void login() {//Login system
    while (attempts < maxattempts) {
        System.out.println("Insert username: ");
        String login = sc.nextLine();
        System.out.println("Insert password: ");
        String loginpass = sc.nextLine();

        if (login.equals(user) && loginpass.equals(userpass)) {//If username and password is correct
            System.out.println("Welcome guest!");
            list();//Transfers to method that contains the list of books
            break;
        } else {//If username or password is incorrect
            attempts++;
            System.out.println("Invalid credentials. Attempts left: " + (maxattempts - attempts));
        }

        if (attempts >= maxattempts) {//If incorrect username or password has been inserted 3 times
            System.out.println("Maximum login attempts reached. Exiting...");
            break;
        }
    }
}
    public static void list(){//List of books
                    System.out.println("Available books (Marked with '*', 'X' means the book is already borrowed): ");
                    for (int row1 = 0; row1 < books.length; row1++) {
                     for (int col1 = 0; col1 < books[row1].length; col1++) {
                         System.out.print(books[row1][col1] + " ");
                     }
                     System.out.println();
                    }guest();//Transfers to method where the user can borrow books
    }
    
    public static void guest() {
        
         boolean guest = true;
         while(guest){
            System.out.println("Would you like to borrow a book?");
            String yesno = sc.nextLine();
            if(yesno.equalsIgnoreCase("yes")){
                guest = false;
                boolean on = true;
                while(on){
                attempts+=3;
                    System.out.println("Select a category");
                    String category = sc.nextLine().toLowerCase();//It has .toLowerCase() to remove case insensitivity of categories
                        switch(category){//Categories
                            case "history":
                                boolean hist = true;
                                while(hist){//In while loop so the program doesnt end after printing "Invalid choice, try again"
                                    System.out.println("Select a book from 1 - 4");
                                    int hselect = choice();
                                    String wtf = sc.nextLine();//Apparently, the program prints "Invalid option" if not under the int even though the program continues on its flow. I do not know why
                                    if(hselect >= 1 && hselect <= 4){
                                        if(books[0][hselect - 1].endsWith("(*)")){//Checks if the book is available for borrowing (marked with (*))
                                            System.out.println("Book sucessfully borrowed!");
                                            books[0][hselect - 1] = books[0][hselect - 1].replace("(*)", "(X)");//Replaces (*) with (X), marking it as borrowed
                                            int hrow = 0;//Row of this category
                                            for (String book : books[hrow]) {//Prints the row of the selected category (in this case, the history category)
                                                System.out.print(book + " ");
                                            }
                                            System.out.println();
                                            System.out.println("Would you like to borrow another book?");
                                            String yesno2 = sc.nextLine();
                                            if(yesno2.equalsIgnoreCase("yes")){
                                                boolean hist2 = true;
                                                while(hist2){//In while loop so the program doesnt end after printing "Invalid choice"
                                                System.out.println("Same category or different category?");
                                                String category2 = sc.nextLine();
                                                if(category2.equalsIgnoreCase("same category") || category2.equalsIgnoreCase("same")){
                                                    hist2 = false;//Closes loop to return to selecting books
                                                }else if (category2.equalsIgnoreCase("different category") || category2.equalsIgnoreCase("different")){
                                                    hist = false;//Closes loop to return to selecting category
                                                    System.out.println("Updated list of borrowed books:");
                                                    for(int row = 0; row < books.length; row++){
                                                        for (int col = 0; col < books[row].length; col++) {
                                                            System.out.print(books[row][col] + " ");
                                                        }
                                                        System.out.println();
                                                    }//Prints the whole array again, but with the borrowed book/s marked
                                                     break;
                                                }else{
                                                    System.out.println("Invalid choice");
                                                }
                                                }
                                            }else if(yesno2.equalsIgnoreCase("no")){//If you're done with borrowing books
                                                System.out.println("Thank you, please come again!");
                                                on = false;
                                                break;
                                            }else{
                                                System.out.println("Invalid option");
                                                
                                            }
                                        }else{
                                            System.out.println("Book is already borrowed, try again");
                                        }
                                    }
                               }
                                break;
                                
                            case "fiction":
                                boolean fic = true;
                                while(fic){
                                    System.out.println("Select a book from 1 - 4");
                                    int fselect = choice();
                                    String wtf = sc.nextLine();
                                    if(fselect >= 1 && fselect <= 4){
                                        if(books[1][fselect - 1].endsWith("(*)")){
                                            System.out.println("Book sucessfully borrowed!");
                                            books[1][fselect - 1] = books[1][fselect - 1].replace("(*)", "(X)");
                                            int frow = 1;
                                            for (String book : books[frow]) {
                                                System.out.print(book + " ");
                                            }
                                            System.out.println();
                                            System.out.println("Would you like to borrow another book?");
                                            String yesno2 = sc.nextLine();
                                            if(yesno2.equalsIgnoreCase("yes")){
                                                boolean fic2 = true;
                                                while(fic2){
                                                System.out.println("Same category or different category?");
                                                String category2 = sc.nextLine();
                                                if(category2.equalsIgnoreCase("same category") || category2.equalsIgnoreCase("same")){
                                                    fic2 = false;
                                                }else if (category2.equalsIgnoreCase("different category") || category2.equalsIgnoreCase("different")){
                                                    fic = false;
                                                    System.out.println("Updated list of borrowed books:");
                                                    for(int row = 0; row < books.length; row++){
                                                        for (int col = 0; col < books[row].length; col++) {
                                                            System.out.print(books[row][col] + " ");
                                                        }
                                                        System.out.println();
                                                    }
                                                     break;
                                                }else{
                                                    System.out.println("Invalid choice");
                                                }
                                                }
                                            }else if(yesno2.equalsIgnoreCase("no")){
                                                System.out.println("Thank you, please come again!");
                                                on = false;
                                                break;
                                            }else{
                                                System.out.println("Invalid option");
                                                
                                            }
                                        }else{
                                            System.out.println("Book is already borrowed, try again");
                                        }   
                                    }   
                               }break;
                               
                            case"science":
                                boolean sci = true;
                                while(sci){
                                    System.out.println("Select a book from 1 - 4");
                                    int sselect = choice();
                                    String wtf = sc.nextLine();
                                    if(sselect >= 1 && sselect <= 4){
                                        if(books[2][sselect - 1].endsWith("(*)")){
                                            System.out.println("Book sucessfully borrowed!");
                                            books[2][sselect - 1] = books[2][sselect - 1].replace("(*)", "(X)");
                                            int srow = 2;
                                            for (String book : books[srow]) {
                                                System.out.print(book + " ");
                                            }
                                            System.out.println();
                                            System.out.println("Would you like to borrow another book?");
                                            String yesno2 = sc.nextLine();
                                            if(yesno2.equalsIgnoreCase("yes")){
                                                boolean sci2 = true;
                                                while(sci2){
                                                System.out.println("Same category or different category?");
                                                String category2 = sc.nextLine();
                                                if(category2.equalsIgnoreCase("same category") || category2.equalsIgnoreCase("same")){
                                                    sci2 = false;
                                                }else if (category2.equalsIgnoreCase("different category") || category2.equalsIgnoreCase("different")){
                                                    sci = false;
                                                    System.out.println("Updated list of borrowed books:");
                                                    for(int row = 0; row < books.length; row++){
                                                        for (int col = 0; col < books[row].length; col++) {
                                                            System.out.print(books[row][col] + " ");
                                                        }
                                                        System.out.println();
                                                    }
                                                     break;
                                                }else{
                                                    System.out.println("Invalid choice");
                                                }
                                                }
                                            }else if(yesno2.equalsIgnoreCase("no")){
                                                System.out.println("Thank you, please come again!");
                                                on = false;
                                                break;
                                            }else{
                                                System.out.println("Invalid option");
                                                
                                            }
                                        }else{
                                            System.out.println("Book is already borrowed, try again");                                           
                                        }                                       
                                    }
                               }break;
                            case "computer programming":
                                boolean cp = true;
                                while(cp){
                                    System.out.println("Select a book from 1 - 4");
                                    int cpselect = choice();
                                    String wtf = sc.nextLine();
                                    if(cpselect >= 1 && cpselect <= 4){
                                        if(books[3][cpselect - 1].endsWith("(*)")){
                                            System.out.println("Book sucessfully borrowed!");
                                            books[3][cpselect - 1] = books[3][cpselect - 1].replace("(*)", "(X)");
                                            int cprow = 3;
                                            for (String book : books[cprow]) {
                                                System.out.print(book + " ");
                                            }
                                            System.out.println();
                                            System.out.println("Would you like to borrow another book?");
                                            String yesno2 = sc.nextLine();
                                            if(yesno2.equalsIgnoreCase("yes")){
                                                boolean cp2 = true;
                                                while(cp2){
                                                System.out.println("Same category or different category?");
                                                String category2 = sc.nextLine();
                                                if(category2.equalsIgnoreCase("same category") || category2.equalsIgnoreCase("same")){
                                                    cp2 = false;
                                                }else if (category2.equalsIgnoreCase("different category") || category2.equalsIgnoreCase("different")){
                                                    cp = false;
                                                    System.out.println("Updated list of borrowed books:");
                                                    for(int row = 0; row < books.length; row++){
                                                        for (int col = 0; col < books[row].length; col++) {
                                                            System.out.print(books[row][col] + " ");
                                                        }
                                                        System.out.println();
                                                    }
                                                     break;
                                                }else{
                                                    System.out.println("Invalid choice");
                                                }
                                                }
                                            }else if(yesno2.equalsIgnoreCase("no")){
                                                System.out.println("Thank you, please come again!");
                                                on = false;
                                                break;
                                            }else{
                                                System.out.println("Invalid option");
                                                
                                            }
                                        }else{
                                            System.out.println("Book is already borrowed, try again"); 
                                        }                                         
                                    }
                               }break;
                               
                                default:
                                    System.out.println("Invalid category");
                           }
                }
                }else if(yesno.equalsIgnoreCase("no")){//If you don't want to borrow books
    System.out.println("This system is only for borrowing books, shutting down");
    Shutdown();//Transfers to method that shuts down the program
    break;
}else{//If you type neither yes nor no
    System.out.println("Invalid choice");
    }
}
}
    public static void Shutdown() {//Method for shutting down
        boolean shit = true;
        while(shit){
            break;
        }
    }
}






