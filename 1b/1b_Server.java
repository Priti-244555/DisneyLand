import java.io.*;
import java.util.Scanner;
import java.net.*;

public class Server {

	private DatagramSocket datagramSocket;
	private byte[] buffer = new byte[256];
	
	public Server(DatagramSocket datagramSocket){
		this.datagramSocket = datagramSocket;
	}
	
	public void ReceiveThenSend()
	{
		try{
		while(true)
		{
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(datagramPacket);
			InetAddress inetAddress = datagramPacket.getAddress();
			int port = datagramPacket.getPort();
			String msgFromClient = new String(datagramPacket.getData(),0,datagramPacket.getLength());
			
			System.out.println("Client : " + msgFromClient);
			
			datagramPacket = new DatagramPacket(buffer,buffer.length,inetAddress,port);
			datagramSocket.send(datagramPacket);
			
			if(msgFromClient.equalsIgnoreCase("BYE")){
				break;
			}
			
		}
		}catch(Exception e){
			System.err.print(e);
		}
	}
	
	public static void main(String[] args ) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(1234);
		Server server = new Server(datagramSocket);
		server.ReceiveThenSend();
	}
}

