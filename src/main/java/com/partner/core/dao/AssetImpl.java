package com.partner.core.dao;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.partner.core.model.Coordinate;
import com.partner.core.model.Meter;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import static java.util.Arrays.asList;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
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
		
		db.getCollection("meters").insertOne(
		        new Document("location",
		                new Document()
		                        .append("street", m.getStreet())
		                        .append("zipcode", m.getZipcode())
		                        .append("id", m.getId())
		                        .append("coord", asList(m.getCoord().getLongitude(), m.getCoord().getLatitude()))));

		return true;
	}
	
	/**
	 * This method returns a list of all meters in the collection.
	 * 
	 * @return {@link List} of {@link Meter}(s)
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
		    	@SuppressWarnings("unchecked")
				List<Double> coordinates = ( List<Double> ) d.get("coord");	    
		    	
		    	Meter meter = new Meter();	    	
		    	
		    	if (coordinates != null ) {	    		
		    		String lat = null;
		    		String lon = null;
		    		int ct = 0;
		    		
		    		for ( Double o : coordinates) {	    			
		    			if (ct == 0) {
		    				lat = String.valueOf(o);
		    				
		    			}
		    			if (ct == 1) {
		    				lon = String.valueOf(o);
		    				Coordinate c = new Coordinate(lat,lon);
		    				meter.setCoord(c);    				
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
