package com.cloudant.qcapp;

public class ReadDefectIdWithSummary {

	private int DefectID;  
	private String Summary;
	
	public ReadDefectIdWithSummary(int DefectID, String Summary)
	{
		this.DefectID=DefectID;  
		this.Summary=Summary;
	}

	public int getDefectID() {
		return DefectID;
	}

	public void setDefectID(int defectID) {
		DefectID = defectID;
	}
	
	public String getSummary() {
		return Summary;
	}


	public void setSummary(String summary) {
		Summary = summary;
	}


}
