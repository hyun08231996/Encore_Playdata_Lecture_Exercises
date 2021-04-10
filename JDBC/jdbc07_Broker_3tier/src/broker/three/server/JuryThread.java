package broker.three.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.shares.Result;
import broker.three.vo.CustomerRec;
import broker.three.vo.SharesRec;
import broker.three.vo.StockRec;

public class JuryThread extends Thread{
	private Socket s;
	private Database db;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Command cmd;

	public JuryThread(Socket s, Database db) {
		this.s = s;
		this.db = db;
		
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		}catch(Exception e) {
			
		}
		System.out.println("Jury...creating...");
	}
	/*
	 * 1. protocol이 보낸 도시락 받는다....readObject()
	 * 2. 도시락 깐다. 10~90
	 * 3. 10~90상수값에 해당하는 Database메소드를 직접 호출한다.
	 * 	  이때 인값 알아서 잘 넣어준다.
	 * 4. DB갔다가 나온 결과값을 다시 도시락에 싸서 Protocol로 보낸다.
	 * 
	 */
	public void run() {
		System.out.println("run()...진입..");
		while(true) {
			try {
				//1.도시락 받는다.
				cmd = (Command)ois.readObject();
				System.out.println("cmd....jury readObject()....");
			
			}catch(Exception e) {
			
			}
			//2. 도시락 깐다....Data unpack...getter
			int comm = cmd.getCommandValue();
			String [ ] args = cmd.getArgs();
			Result r = cmd.getResult();;
			
			//3. comm값에 따라서 Database의 메소드를 각각 호출한다.
			switch(comm) {
				case Command.BUYSHARES:
					try {
						db.buyShares(args[0], args[1], Integer.parseInt(args[2]));
						
						//이 부분은 DB Access하고 난 후의 코드라인이 된다.
						r.setStatus(0);
					}catch(Exception e) {
						
					}
					
				break;
				
				case Command.SELLSHARES:
					try {
						db.sellShares(args[0], args[1], Integer.parseInt(args[2]));
						
						r.setStatus(0);
					}catch(RecordNotFoundException e) {
						System.out.println("팔 주식이 존재하지 않아요....jury catch..");
						r.setStatus(-1);
					}catch(InvalidTransactionException e) {
						System.out.println("팔 주식이 너무 많아요....jury catch..");
						r.setStatus(-3);
					}catch(Exception e) {
						
					}
				break;
				
				case Command.GETALLSTOCK:
					try {
						ArrayList<StockRec> list = db.getAllStocks();
						
						r.setStatus(0);
						r.add(list);
					}catch(Exception e) {
						
					}
				break;
				
				case Command.GETALLCUSTOMER:
					try {
						ArrayList<CustomerRec> list = db.getAllCustomers();
						
						r.setStatus(0);
						r.add(list);
					}catch(Exception e) {
						
					}
				break;
				
				case Command.GETCUSTOMER:
					try {
						CustomerRec cust = db.getCustomer(args[0]);
						
						r.setStatus(0);
						r.add(cust);
					}catch(Exception e) {
						
					}
				break;
				
				case Command.ADDCUSTOMER:
					try {
						db.addCustomer(new CustomerRec(args[0], args[1], args[2]));
						
						r.setStatus(0);
					}catch(DuplicateSSNException e) {
						System.out.println("고객이 이미 존재해요....jury catch..");
						r.setStatus(-2);
					}catch(Exception e) {
						
					}
				break;
				
				case Command.DELETECUSTOMER:
					try {
						db.deleteCustomer(args[0]);
						
						r.setStatus(0);
					}catch(RecordNotFoundException e) {
						System.out.println("정보가 존재하지 않아요....jury catch..");
						r.setStatus(-1);
					}catch(Exception e) {
						
					}
				break;
				
				case Command.UPDATECUSTOMER:
					try {
						db.updateCustomer(new CustomerRec(args[0], args[1], args[2]));
						
						r.setStatus(0);
					}catch(RecordNotFoundException e) {
						System.out.println("정보가 존재하지 않아요....jury catch..");
						r.setStatus(-1);
					}catch(Exception e) {
						
					}
				break;
			}
		try {
			oos.writeObject(cmd);
		} catch (IOException e) {
			
		}
		}
	}
}
