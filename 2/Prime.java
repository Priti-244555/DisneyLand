import mpi.*;
class Prime
{
	public static void main(String args[])
	{
		MPI.Init(args);
		int rank  = MPI.COMM_WORLD.Rank();
		int tag =100;
		int dest;
		
		if(rank==1)
		{
			System.out.println("This is sending process");
			int sdata[] = new int[5];
			sdata[0] = 99;
			sdata[1] = 56;
			sdata[2] = 78;
			sdata[3] = 28;
			sdata[4] = 25;
			dest = 0;
			System.out.println("Sending process rank "+rank);
			System.out.println("Sending process data"+sdata[0]);
			
			MPI.COMM_WORLD.Send(sdata, 0, 5, MPI.INT, dest, tag);
			
		}
		else
		{
				dest = 1;
				System.out.println("This is Recieving process");
				int rdata[] = new int[5];
				MPI.COMM_WORLD.Recv(rdata, 0, 5, MPI.INT, dest, tag);
				System.out.println("Sending process rank "+rank);
				System.out.println("Sending process data"+rdata[0]);		
				
		}
		MPI.Finalize();
	}
}























