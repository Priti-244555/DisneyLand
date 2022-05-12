import java.io.*;
import java.net.*;
class UdpServer
{
	public static void main(String args[])
	{
		String msg=null;
		DatagramSocket s=null;
		DataInputStream dis;
		DatagramPacket sendp,recievep;
		
		try
		{
			s=new DatagramSocket(9999);
			dis=new DataInputStream(System.in);
			do
			{	
				byte [] sdata=new byte[1024];
				byte [] rdata=new byte[1024];
			
				
				recievep=new DatagramPacket(rdata,rdata.length);
				s.receive(recievep);
			
				
				System.out.println("msg from client "+(new String(recievep.getData())).trim());
		
				System.out.println("msg for client");
				msg=dis.readLine();
				
				sdata=msg.getBytes();
				InetAddress add=recievep.getAddress();
				int port=recievep.getPort();
				
				sendp=new DatagramPacket(sdata,sdata.length,add,port);
				s.send(sendp);
			

			}while(!msg.equals("bye"));
					
				dis.close();
				s.close();

		}
		catch(Exception e)
		{
		}	
	}

}					