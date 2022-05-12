import java.net.*;
import java.io.*;
public class TcpClient
{
	public static void main(String arg[])
	{
		Socket c=null;
		String line;
		DataInputStream dis1;
		PrintStream os;
		try
		{
			c=new Socket("localhost",9999);		
			dis=new DataInputStream(System.in);
			dis1=new DataInputStream(c.getInputStream());
			os=new PrintStream(c.getOutputStream());

			do
			{
				System.out.println("Enter message for Server:");
				line=dis.readLine();
				os.println(line);
				System.out.println("Message from Server:" + dis1.readLine());
			}while(line.equalsIgnoreCase("quit")==false);
			dis1.close();
			os.close();			

		}
		catch(IOException e)
		{
			System.out.println("Socket Closed!Message Passing is over");
		}
	}
}