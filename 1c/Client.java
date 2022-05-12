import java.rmi.registry.*;
import java.rmi.*;  
import java.rmi.server.*;
import java.util.*;
public class Client{
    private Client()throws RemoteException {}
    public static void main(String[] args) {
   	 try{
   		 Calc stub=(Calc)Naming.lookup("rmi://localhost:5000/calculate");  
   		 Scanner sc = new Scanner(System.in);

   		 int a,b,choice;
   			 System.out.println("\nEnter your choice");
   			 System.out.println("1. Addition");
   		    System.out.println("Enter 1st number");
   			 a = sc.nextInt();
   			System.out.println("Enter 2nd number");
   			 b = sc.nextInt();
   			 System.out.println("Addition of "+a+" and "+b+" is "+stub.add(a,b));  
   				  		 
   		 
   	 }
   	 catch(Exception e){
   		 System.out.println(e);
   	 }
    }
}

