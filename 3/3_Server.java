
import string_operations.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class serverimpl extends string_1POA
{
	   private ORB orb;
	   
	   public void setorb(ORB orb_val)
	   {
	      orb = orb_val;
	   }
	
	   public String concatstring(String n1, String n2)
	   {
	     return (n1+n2);
	   }
	   
	   public String lengthstring(String n1)
	   {
	     return String.valueOf(n1.length());
	   }
	   
	   public String comparestring(String n1, String n2)
	   {
		   if(n1.toLowerCase().compareTo(n2.toLowerCase()) == 0)
			   return "equal";
		   else
			   return "not Equal";
	   }

}


public class Server
{
   public static void main(String args[])
   {
     try
     {
         //Create and initialize the ORB
         ORB orb = ORB.init(args,null);

         // Get reference to rootpoa & activate the POAManager
         org.omg.CORBA.Object objref1 = orb.resolve_initial_references("RootPOA");
         POA rootpoa = POAHelper.narrow(objref1);
         rootpoa.the_POAManager().activate();

         //Create servant and register it with the ORB
         serverimpl serverobj = new serverimpl();
         serverobj.setorb(orb);
         
         // Get object reference from the servant
         org.omg.CORBA.Object objref2 = rootpoa.servant_to_reference(serverobj);
         string_1 href = string_1Helper.narrow(objref2);

         // Get the root naming context
         org.omg.CORBA.Object objref3 = orb.resolve_initial_references("NameService");

         // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specification.
         NamingContextExt ncref = NamingContextExtHelper.narrow(objref3);
         String pathname = "string_1";
         NameComponent path[] = ncref.to_name(pathname);

         // bind the Object Reference in Naming
         ncref.rebind(path,href);

         System.out.println("Server ready and waiting...");
         
         // wait for invocations from clients
         orb.run();

     } catch(Exception e) {
       
    	 System.out.println(e);
     }
   }

}
