package com.partner.core.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.partner.core.model.Coordinate;
import com.partner.core.model.Meter;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import static java.util.Arrays.asList;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;

/**
 * The data access object for assets.
 * 
 * @author Lane Chasteen
 *
 */
public class AssetImpl {
	private MongoDatabase db;	
	private MongoClient mongoClient;
	
	
	/**
	 * Default Constructor
	 */
	public AssetImpl(){		
		mongoClient = new MongoClient();		
		db = mongoClient.getDatabase("test");
		
	}
	

	/**
	 * This method inserts a Meter into the collection.
	 * 
	 * @param {@link Meter} m
	 * @return {@code true} if the insert completes successfully. 
	 * @throws {@link ParseException}
	 */
	public boolean insertAsset(Meter m) throws ParseException{		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		db.getCollection("meters").insertOne(
		        new Document("location",
		                new Document()
		                        .append("street", m.getStreet())
		                        .append("zipcode", m.getZipcode())
		                        .append("id", m.getId())
		                        .append("coord", asList(-73.9557413, 40.7720266))));

		return true;
	}
	
	/**
	 * This method returns a list of all meters in the collection.
	 * 
	 * @return {@link List} of {@link Meter}
	 */
	public List<Meter> getMeters(){	

		BasicDBObject query = new BasicDBObject();
		query.put("location.street", "Kings Highway");
		//FindIterable<Document> iterable = db.getCollection("meters").find(query);		
		//FindIterable<Document> iterable = db.getCollection("meters").find().limit(1000);
		FindIterable<Document> iterable = db.getCollection("assets").find();
		List<Meter> dlist = new ArrayList<>();	
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		    	//String borough = document.getString("borough");
		    	
		    	Document d = (Document) document.get("location");
		    	String meterID = d.getString("meter");
		    	String street = d.getString("street");
		    	String zipCode = d.getString("zipcode");		    	
		    	Object coordinates = (Object) d.get("coord");
		    	
		    	
		    	Meter meter = new Meter();
		    	
		    	
		    	if (coordinates != null && coordinates instanceof List) {
		    		List<Object> coord = Arrays.asList(coordinates);
		    		Iterator<Object> it = coord.iterator();
		    		String lat = null;
		    		String lon = null;
		    		int ct = 0;
		    		
		    		while (it.hasNext()) {
		    			Object o = it.next();
		    			
		    			if (ct == 0) {
		    				lat = String.valueOf(o);
		    				System.out.println("lat" + lat);
		    			}
		    			if (ct == 1) {
		    				lon = String.valueOf(o);
		    				Coordinate cord = new Coordinate(lat,lon);
		    				meter.setCoord(cord);
		    				System.out.println( "lon:" + lon);
		    			}
		    			ct++;
		    		}		    		
		    	}
		    
		    	meter.setId(meterID);
		    	meter.setStreet(street);
		    	meter.setZipcode(zipCode);
		    	
		    	
		    	
		        dlist.add(meter);
		    }
		});
	
		return dlist;
	}
	
}
