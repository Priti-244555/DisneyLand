
import string_operations.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.io.*;

public class Client
{
    static string_1 stringimpl;
    
    public static void main(String args[])
    {
      try
      {
	        String result = null, string1, string2 = null;
	
	        // Create and initialize the ORB	
	        ORB orb = ORB.init(args,null);
	         
	        // Get the root naming context
	        org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
	        
	        // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specification.
	        NamingContextExt ncref = NamingContextExtHelper.narrow(objref);
	
	        String pathname = "string_1";
	        stringimpl = string_1Helper.narrow(ncref.resolve_str(pathname));
	
	
	       int ch = 1;
	
	       while(ch != 0)
	       {
	    	   
		        System.out.println("\n1. Join strings");
		        System.out.println("2. Length of string");
		        System.out.println("3. Compare strings");
		        System.out.println("0. Exit");
		
		        BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
		
		        System.out.println("\nEnter your choice: ");
		        ch = Integer.parseInt(in1.readLine());
		
		        if(ch == 0)
		          break;
		
		        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		        System.out.println("\nEnter string1: ");
		        string1 = in.readLine();
//		        string1 = String.parseString(in.readLine());
		
		        if(ch == 1 || ch == 3)
		        {
		        	System.out.println("\nEnter string2: ");
		        	string2 = in.readLine();
//			        string2 = Double.parseDouble(in.readLine());
		        }
		        
		        
		        switch(ch)
		        {
		        
		          case 1:
		        	  
		          result = stringimpl.concatstring(string1, string2);
		          System.out.println("Joined string is: " + result);
		          break;
		
		          
		          case 2:
		              
		          result = stringimpl.lengthstring(string1);
		          System.out.println("Length of string is: " + result);
		          break;
		
		          
		          case 3:

		          result = stringimpl.comparestring(string1, string2);
		          System.out.println("Strings are " + result);
	                  break;

		        }
		           
	
	        }

      } catch(Exception e) {
    	  
         System.out.println(e);
      }
    }
}
