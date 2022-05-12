import java.rmi.*;  

public interface Calc extends Remote{  
    public int add(int x,int y)throws RemoteException; 
} 
