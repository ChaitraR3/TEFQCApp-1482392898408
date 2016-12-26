package com.cloudant.qcapp;

import java.util.List;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class DocumentsCount {

	public static String GetDocumentsCount()
	{
		long count=0;
		String strLong;
		
		try{

			String username= "7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix";

			String password= "2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d";

			String url="https://7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix:2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d@7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix.cloudant.com";

			CloudantClient dbClient = new CloudantClient(url,username,password);

			Database db = dbClient.database("qclist_db", false);
			count = db.info().getDocCount();
			
		}
		catch(Exception e)
		{
			System.out.println("=====Exception=====" +e);
		}
		
		strLong = Long.toString(count);
		return strLong;			

	}
	
	public static String GetDocumentsCountForAssignedPerson(String AssignedTo) {

		long count=0;
		String strLong;
		
		try{

			String username= "7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix";

			String password= "2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d";

			String url="https://7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix:2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d@7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix.cloudant.com";

			CloudantClient dbClient = new CloudantClient(url,username,password);

			Database db = dbClient.database("qclist_db", false);

			db.createIndex("{\"index\": { \"fields\": [\"AssignedTo\"] }, \"type\": \"json\"}");

			List<ReadDefectIdWithSummary> defectDetailsList = db.findByIndex("\"selector\": {\"_id\": {\"$gt\": 0},\"AssignedTo\": {\"$eq\":\""+AssignedTo+"\"}}", ReadDefectIdWithSummary.class);  

			if(!defectDetailsList.isEmpty()){

				count = defectDetailsList.size();
				System.out.println("====Total documents count===="+count);
			}
			else{
				System.out.println("No QC records found");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		strLong = Long.toString(count);
		return strLong;			

	}
	
	public static String GetDocumentsCountForDefectId(String DefectID) {

		long count=0;
		String strLong;
		
		try{

			String username= "7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix";

			String password= "2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d";

			String url="https://7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix:2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d@7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix.cloudant.com";

			CloudantClient dbClient = new CloudantClient(url,username,password);

			Database db = dbClient.database("qclist_db", false);

			db.createIndex("{\"index\": { \"fields\": [\"DefectID\"] }, \"type\": \"json\"}");

			List<Defects> defectDetailsList = db.findByIndex("\"selector\": {\"_id\": {\"$gt\": 0},\"DefectID\": {\"$eq\":\""+DefectID+"\"}}", Defects.class);  

			if(!defectDetailsList.isEmpty()){

				count = defectDetailsList.size();
				System.out.println("====Total documents count===="+count);
			}
			else{
				System.out.println("No QC records found");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		strLong = Long.toString(count);
		return strLong;			

	}
	
	public static String GetDocumentsCountForImpactedComponent(String ImpactedComponent) {

		long count=0;
		String strLong;
		
		try{

			String username= "7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix";

			String password= "2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d";

			String url="https://7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix:2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d@7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix.cloudant.com";

			CloudantClient dbClient = new CloudantClient(url,username,password);

			Database db = dbClient.database("qclist_db", false);

			db.createIndex("{\"index\": { \"fields\": [\"ImpactedComponent\"] }, \"type\": \"json\"}");

			List<ReadDefectIdWithSummary> defectDetailsList = db.findByIndex("\"selector\": {\"_id\": {\"$gt\": 0},\"ImpactedComponent\": {\"$eq\":\""+ImpactedComponent+"\"}}", ReadDefectIdWithSummary.class);  

			if(!defectDetailsList.isEmpty()){

				count = defectDetailsList.size();
				System.out.println("====Total documents count===="+count);
			}
			else {
				System.out.println("No QC records found");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		strLong = Long.toString(count);
		return strLong;			

	}
	
}



