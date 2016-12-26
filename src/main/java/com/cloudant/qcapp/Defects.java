package com.cloudant.qcapp;

public class Defects
{
	private String ImpactedComponent; 
	private String Status;  
	private String Description;  
	private String DefectReason; 
	private String Attachment;  
	private String DetectedBy;  
	private String AssignedTo;  
	private String WorkStreamId;  
	private String O2;  
	private int DefectID;  
	private String Summary;  
	private String Priority;

	public Defects(String ImpactedComponent,String Status,String Description, String DefectReason, String Attachment, String DetectedBy,
			String AssignedTo,String WorkStreamId,String O2,int DefectID,String Summary,String Priority)
	{
		this.ImpactedComponent=ImpactedComponent; 
		this.Status=Status;  
		this.Description=Description;  
		this.DefectReason=DefectReason; 
		this.Attachment=Attachment;  
		this.DetectedBy=DetectedBy;  
		this.AssignedTo=AssignedTo;  
		this.WorkStreamId=WorkStreamId;  
		this.O2=O2;  
		this.DefectID=DefectID;  
		this.Summary=Summary;  
		this.Priority=Priority;

	}


	public String getImpactedComponent() {
		return ImpactedComponent;
	}


	public void setImpactedComponent(String impactedComponent) {
		ImpactedComponent = impactedComponent;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getDefectReason() {
		return DefectReason;
	}


	public void setDefectReason(String defectReason) {
		DefectReason = defectReason;
	}


	public String getAttachment() {
		return Attachment;
	}


	public void setAttachment(String attachment) {
		Attachment = attachment;
	}


	public String getDetectedBy() {
		return DetectedBy;
	}


	public void setDetectedBy(String detectedBy) {
		DetectedBy = detectedBy;
	}


	public String getAssignedTo() {
		return AssignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		AssignedTo = assignedTo;
	}


	public String getWorkStreamId() {
		return WorkStreamId;
	}


	public void setWorkStreamId(String workStreamId) {
		WorkStreamId = workStreamId;
	}


	public String getO2() {
		return O2;
	}


	public void setO2(String o2) {
		O2 = o2;
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


	public String getPriority() {
		return Priority;
	}


	public void setPriority(String priority) {
		Priority = priority;
	}

}  