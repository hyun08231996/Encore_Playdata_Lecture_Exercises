package broker.twotier.test;

import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		Database db = new Database("127.0.0.1");
		//db.addCustomer(new CustomerRec("777-777", "남승현", "Seoul"));   
		//db.deleteCustomer("777-777");
		//db.updateCustomer(new CustomerRec("777-777", "남승현", "금호동"));
		
//		Vector<SharesRec> v = db.getPortfolio("777-777");
//		for(SharesRec sr : v) System.out.println(sr);
//		
//		ArrayList<CustomerRec> v2 = db.getAllCustomers();
//		for(CustomerRec cr : v2) System.out.println(cr);
		
		//System.out.println(db.getCustomer("777-777"));
		
		//ArrayList<StockRec> v3 = db.getAllStocks();
		//for(StockRec sr : v3) System.out.println(sr);
		
		db.buyShares("777-777", "DUKE", 50);
		
		//db.sellShares("777-777", "DUKE", 50);
		
	}

}
