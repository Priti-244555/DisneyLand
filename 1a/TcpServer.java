import java.net.*;
import java.io.*;
public class TcpServer
{
	public static void main(String arg[])
	{
		ServerSocket s=null;
		String line;
		DataInputStream dis=null,dis1=null;
		PrintStream os=null;
		Socket c=null;
		try
		{
			s=new ServerSocket(9999);
		
		
			c=s.accept();
			os=new PrintStream(c.getOutputStream());
			dis=new DataInputStream(c.getInputStream());
			dis1=new DataInputStream(System.in);
			do
			{
				line=dis.readLine();
				System.out.println("Message From Client:"+line);
				System.out.println("Enter message for Client:");
				line=dis1.readLine();
				os.println(line);
			}while(line.equalsIgnoreCase("quit")==false);
			dis.close();
			os.close();
		}
		catch(IOException e)	
		{
			System.out.println(e);
		}		
	}	
}
