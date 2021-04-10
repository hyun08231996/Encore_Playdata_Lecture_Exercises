package stream.data.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest5 {

	public static void main(String[] args) throws IOException{
		DataInputStream dis = null; 
		DataOutputStream dos = null; 
		
		try {
			dis = new DataInputStream(new FileInputStream("src\\watermelon.png"));
			dos = new DataOutputStream(new FileOutputStream("src\\water.png"));
			int data = 0;
			while((data = dis.readInt())!=-1) dos.writeInt(data);
		}catch(EOFException e){
			
		}finally {
			dis.close();
			dos.close();
		}
		

	}

}
