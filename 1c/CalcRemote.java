import java.rmi.*;  
import java.rmi.server.*;  
public class CalcRemote extends UnicastRemoteObject implements Calc{  
    CalcRemote()throws RemoteException{  
   	 super();  
    }  
    public int add(int x,int y){return x+y;}  
} 
