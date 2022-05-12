import java.io.*;
import java.util.Scanner;
import java.net.*;

public class Server{
	
	public static void main(String[] args) throws Exception {
		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		ServerSocket serverSocket = new ServerSocket(1234);
		
		
		
		while(true)
		{
		 	Scanner sc = new Scanner(System.in);
			socket = serverSocket.accept();
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedReader = new BufferedReader(inputStreamReader);
			
			
			while(true)
			{
				String msgFromClient = bufferedReader.readLine();
				String msgToClient = null;
				System.out.println("Client : " + msgFromClient );
				System.out.print("Me : " );
				msgToClient = sc.next();
				bufferedWriter.write(msgToClient);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				if(msgFromClient.equalsIgnoreCase("BYE") || msgToClient.equalsIgnoreCase("BYE") )
				{
					break;
				}
				
			}
			
			sc.close();
			socket.close();
			inputStreamReader.close();
			outputStreamWriter.close();
			bufferedReader.close();
			bufferedWriter.close();
			
		}
		
	}

}

