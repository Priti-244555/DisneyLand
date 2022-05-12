import java.io.*;
import java.util.Scanner;
import java.net.*;

public class Client{
	
	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost",1234);
		InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Me : ");
			String msg = sc.nextLine();
			bufferedWriter.write(msg);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			System.out.println("Server : " +  bufferedReader.readLine());
			
			if( msg.equalsIgnoreCase("BYE") )
			{
				break;
			}
		}
		
		sc.close();
		socket.close();
		inputStreamReader.close();
		outputStreamWriter.close();
		bufferedWriter.close();
		bufferedReader.close();
	
	}
	
	
}

