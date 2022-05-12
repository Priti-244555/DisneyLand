import java.io.*;
import java.net.*;
class UdpClient 
{
	public static void main(String args[])
	{
		String msg=null;
		DatagramSocket c=null;
		DataInputStream dis;
		DatagramPacket sendp,recievep;
		
		try
		{
			c=new DatagramSocket();
			dis=new DataInputStream(System.in);
			do
			{
				System.out.println("msg for server");
				msg=dis.readLine();
				
				byte [] sdata=new byte[1024];
				byte [] rdata=new byte[1024];
				
				sdata=msg.getBytes();
				InetAddress add=InetAddress.getLocalHost();
				
				sendp=new DatagramPacket(sdata,sdata.length,add,9999);
				c.send(sendp);
		
				recievep=new DatagramPacket(rdata,rdata.length);
				c.receive(recievep);
				
				System.out.println("msg from server "+(new String(recievep.getData())).trim());

			}while(!msg.equals("bye"));
					
				dis.close();
				c.close();

		}
		catch(Exception e)
		{
		}	
	}

}					