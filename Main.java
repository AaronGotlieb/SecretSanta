
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {  
    public static void main(String [] args) throws IOException { 
        Scanner console = new Scanner(System.in);
        ArrayList people = new ArrayList<Person>();
        ArrayList random = new ArrayList<Person>(); 
        int choice = 0;
        do{
            choice = menuGetChoice(console);
            if(choice == 1) {
                System.out.println(menuGetGiftee(console, people));
                System.out.println();
                System.out.println("*------------------------------------------------------*");
                wait(4000);
                //Runtime.exec("clear");
                drawTree();
                drawTree();
                drawTree();
                //send to get giftee method, idk dafuq
            } else if (choice == 2) {
                //send to Admin add names method.
                addPerson(people, console);
                randomize(people, random);
            }
        }while(choice != 3);
        
        /*Writer output = null;
        File file = new File("burnafterreading.txt");
        output = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < people.size(); i ++) {   
            Person tmpp = people.get(i);
            String text = tmpp.toString();
            output.write(text);
            ((BufferedWriter)output).newLine();
        }
         output.close();*/
    }
    
    public static void randomize(ArrayList people, ArrayList random){
        while (people.size() > 0){
            int randomPerson = (int) ((int) people.size() *  Math.random());
            Person tmp = (Person) people.get(randomPerson);
            people.remove(randomPerson);
            random.add(tmp);
        }
        int j = 0;
        while (j <= random.size()) {
            Person tmp = (Person) random.get(j);
            if (j + 1 >= random.size()){
                Person first = (Person) random.get(0);
                tmp.changeGiftee(first.getName());
                people.add(tmp);
                break;
            } 
            Person tmp1 = (Person) random.get(j + 1);
            tmp.changeGiftee(tmp1.getName());
            people.add(tmp);
            j++;
        }
    }
    
    public static String menuGetGiftee(Scanner console, ArrayList people){
        //push in your name to find who you gata buy a fucking gift for
        console.nextLine();
        System.out.println("Enter your name: ");
        String seedName = console.nextLine();
        seedName = seedName.toUpperCase();
        System.out.println("Enter your password please: ");
        String pw = console.nextLine();
        drawTree();
        for (int i = 0; i < people.size(); i++){
            Person tmp = (Person) people.get(i);
            if (tmp.getName().equals(seedName) && tmp.getPW().equals(pw)){
                System.out.println("*------------------------------------------------------*");
                System.out.println();
                return tmp.toString();
            }
        }
        return "You are either not in on this fucking activity or u need to remember your password!";
    }
    
    public static int menuGetChoice(Scanner console){
        System.out.println("MENU:");
        System.out.println("  1. Get your giftee!");
        System.out.println("  2. Add names(requires password)"); 
        System.out.println("  3. quit");
        int choice;
        do {
            while(!console.hasNextInt()) {
                console.nextLine();
                System.out.print("Not an integer. Try Again: ");
            }
            choice = console.nextInt();
            if(choice < 1 || choice > 3) {
                System.out.println("Invalid choice!");
            } 
        } while(choice < 1 || choice > 3);
        return choice;
    }
    //gets and checks if the password is correct
    public static Boolean passwordCheck(Scanner console){
        System.out.println("Enter password: ");
        int count = 0; 
        while(count < 3){ // this loop gives the user 3 tries to log in
            String pw = console.next();
            drawTree(); 
            if(pw.equals("hello")){ // cool pw, right? yeah, pw is sick 
                return true; 
            } else {
                count ++;
                System.out.print("Wrong password!! ");
                if(count == 2){
                    System.out.println("Last try: ");
                } else {
                    System.out.println("Try again: "); 
                }
            }
        }
        return false;
    }
    
    public static String addPW(Scanner console){
        System.out.println("Enter your Password: ");
        String inPW = console.nextLine();
        System.out.println("Stupid test, retype your password plesae: ");
        String inPW2 = console.nextLine();
        inPW = pwCheck(inPW, inPW2, console);
        return inPW;
    }

    public static void drawTree(){
        for (int line = 1; line <= 15; line++){
            for (int i = 1; i <= 16 - line; i++){ 
                //prints space before the first /
                System.out.print(" ");
            }
            for (int i = 1; i <= line; i++){          
                //prints /
                System.out.print("/");
            }
            System.out.print("|");                    
            //prints "|", no for loop because its always 1
            for (int i = 1; i <= line; i++){         
                //prints one "\" after 
                System.out.print("\\");
            }
            System.out.println();                     
            //prints a new line
        }
        for (int t = 0; t < 3; t++){
            for(int i = 0; i < 15; i++){
                System.out.print(" ");
            }
            for (int i = 0; i < 3; i ++){
                System.out.print("|");
            }
            System.out.println("");
        }
        for (int i = 0; i < 12; i++){
            System.out.print(" ");
        }
        for (int i = 0; i < 9; i++){
            System.out.print("=");
        }
        System.out.println("");
    }
    public static String pwCheck(String pw1, String pw2, Scanner console){
        while (!pw1.equals(pw2)){
            System.out.println("I know it's hard, but you need to get this password thing right!");
            for (int i = 5; i > 0; i--){
                wait(1000);
                System.out.println("Your stupidity is contagious and has affected the computer");
                System.out.println("Please wait while the RAM is cleansed of all your absolute dumbness");
                System.out.println(i + " seconds remaining...");
            }
            System.out.println("lets try again, Enter your Password: ");
            pw1 = console.nextLine();
            System.out.println("retype your password plesae: ");
            pw2 = console.nextLine();      
        }
        return pw1;
    }
    public static void wait (int n){
        long t0,t1;
        t0=System.currentTimeMillis();
        do{
            t1=System.currentTimeMillis();
        }
        while (t1-t0<n);
    }
    
    public static void addPerson(ArrayList people, Scanner console){
        
        
        int count = 0;
        Boolean flag = passwordCheck(console); //check the password
        if(!flag){
            return;
        }
        System.out.print("Enter names: (enter 'done' when finished) ");
        console.nextLine(); // this discards the last space the pops up (i know...hacky)
        String name = console.nextLine();
        String pw = addPW(console);
        name = name.toUpperCase();
        do // this is where the adding people comes into play 
        {
            Person p1 = new Person(name, null, pw);
            people.add(p1);
            System.out.println("Enter more names or press 'done'");
            name = console.nextLine();
            name = name.toUpperCase();
            if (!name.equals("DONE")){
                pw = addPW(console);
            }
            count = 3;
        } while(!(name.equals("DONE"))); //entering "done" stops the name entering process 
        
        
    }
}
