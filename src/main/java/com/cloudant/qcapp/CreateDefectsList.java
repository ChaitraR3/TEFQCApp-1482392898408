package com.cloudant.qcapp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CreateDefectsList {

	public static void main(String[] args) throws Exception {

		String username= "7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix";

		String password= "2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d";

		String url="https://7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix:2a70da2059a91265015bf61fa728b9ffeb0819559316c66b88fabe5e1ba44a5d@7d26655c-d498-4ad9-8e8c-82d30439b5a6-bluemix.cloudant.com";

		CloudantClient client = new CloudantClient(url,username,password);
		System.out.println("Connected to Cloudant");
		
		client.createDB("qclist_db");
		System.out.println("Database Created");

		Database db1 = client.database("qclist_db", false);
		
		File input = new File("/Users/IBM_ADMIN/Documents/SametimeFileTransfers/QC_All_UTF.csv");
			
		//class used to generate JSON from CSV
		CsvMapper csvMapper = new CsvMapper();
		Map<String, String> rowAsMap = null;
		Map<String, String> map = new HashMap<>();

		// use first row as header for mapping; otherwise defaults are fine
		CsvSchema schema = CsvSchema.emptySchema().withHeader(); 
		MappingIterator<Map<String,String>> it = csvMapper.reader(Map.class)
				.with(schema)
				.readValues(input);
		while (it.hasNext()) {
		
			rowAsMap = it.next();   
			map.putAll(rowAsMap);
			db1.save(map);
			
		}
		System.out.println("=====Data successfully saved in cloudant======");
		
	}

}