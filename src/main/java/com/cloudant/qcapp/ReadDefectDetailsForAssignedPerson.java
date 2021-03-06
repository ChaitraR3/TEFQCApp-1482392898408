package com.cloudant.qcapp;
import java.util.List;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.Gson;

public class ReadDefectDetailsForAssignedPerson {

	public static String CheckAssignedPersonExists(String AssignedTo, int currentPage) {

		System.out.println("====Inside CheckAssignedPersonExists====");
		int numPerPage=20;
		String result=null;
		Gson gson = new Gson();

		try{

			String username= "7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix";

			String password= "2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d";

			String url="https://7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix:2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d@7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix.cloudant.com";

			CloudantClient dbClient = new CloudantClient(url,username,password);

			Database db = dbClient.database("qclist_db", false);

			db.createIndex("{\"index\": { \"fields\": [\"AssignedTo\"] }, \"type\": \"json\"}");
			
			int limitValue = numPerPage;
			int skipValue = currentPage * limitValue;

			List<ReadDefectIdWithSummary> defectDetailsList = db.findByIndex("\"selector\": {\"_id\": {\"$gt\": 0},\"AssignedTo\": {\"$eq\":\""+AssignedTo+"\"}},\"skip\":"+skipValue+",\"limit\":"+limitValue+"", ReadDefectIdWithSummary.class);  

			if(!defectDetailsList.isEmpty()){

				result = gson.toJson(defectDetailsList);
				System.out.println("===result==="+result);

			}
			else{
				System.out.println("No QC records found");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public static void main(String args[])
	{
		CheckAssignedPersonExists("wout_davidse",0);
	}

}
