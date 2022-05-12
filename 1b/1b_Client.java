import java.io.*;
import java.util.Scanner;
import java.net.*;

public class Client{
	private DatagramSocket datagramSocket;
	private InetAddress inetAddress;
	private byte[] buffer = new byte[256];
	
	public Client(DatagramSocket datagramSocket, InetAddress inetAddress){
		this.inetAddress = inetAddress;
		this.datagramSocket = datagramSocket;
	}
	
	public void SendThenReceive(){
	
		try{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Me : ");
			String msgToServer = sc.nextLine();
			buffer = msgToServer.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,inetAddress, 1234);
			datagramSocket.send(datagramPacket);
			datagramPacket = new DatagramPacket(buffer,buffer.length);
			datagramSocket.receive( datagramPacket );
			String msgFromServer = new String( datagramPacket.getData(), 0 , datagramPacket.getLength() );
			System.out.println( "Server : " + msgFromServer);
			
			if(msgToServer.equalsIgnoreCase("BYE"))
			break;
		}
		} catch(Exception e) {
			System.err.print(e);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();
		Client client = new Client(datagramSocket , InetAddress.getByName("localhost"));
		client.SendThenReceive();
	}
}

