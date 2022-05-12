import mpi.*;
public class ScatterGather{
public static void main(String[] args) throws Exception{
MPI.Init(args);
int rank = MPI.COMM_WORLD.Rank();
int size = MPI.COMM_WORLD.Size();
int unitsize = 4;
int root = 0;
int send_buffer[] = null;
send_buffer = new int[unitsize * size];
int recv_buffer[] = new int[unitsize];
MPI.COMM_WORLD.Scatter(send_buffer, 0 , unitsize, MPI.INT, recv_buffer, 0, unitsize,

MPI.INT, root);

for(int i = 0 ; i < unitsize; i++){
recv_buffer[i] = rank;
}
MPI.COMM_WORLD.Gather(recv_buffer, 0 , unitsize, MPI.INT, send_buffer, 0, unitsize,

MPI.INT, root);

if(rank == root){
for(int i = 0 ; i < (unitsize * size); i++){
System.out.println(send_buffer[i] + " ");
}
}

MPI.Finalize();
}
}
