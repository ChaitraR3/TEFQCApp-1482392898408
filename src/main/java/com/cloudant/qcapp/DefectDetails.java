package com.cloudant.qcapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/getDefectInfo")
public class DefectDetails {
	
	@GET
	@Path("retrieveDefectDetailsForDefect/{DefectID}")
	@Produces({"application/json"})
	
	public String retrieveDefectDetailsForDefectId(@PathParam("DefectID") int DefectID) {
		return ReadDefectDetailsForDefectId.CheckDefectExists(DefectID); 
	}
	
	@GET
	@Path("retrieveDefectDetailsForDefect/{DefectID}/{Summary}")
	@Produces({"application/json"})
	
	public String retrieveDefectDetailsForDefectId(@PathParam("DefectID") int DefectID,@PathParam("Summary") String Summary ) {
		return ReadDefectDetailsForDefectId.CheckDefectExists(DefectID,Summary); 
	}	

	@GET
	@Path("retrieveDefectDetailsForDefect/{DefectID}/{currentPage}")
	@Produces({"application/json"})

	public String retrieveDefectDetailsForDefectId(@PathParam("DefectID") int DefectID, @PathParam("currentPage") int currentPage) {
		return ReadDefectDetailsForDefectId.CheckDefectExists(DefectID,currentPage); 
	}	

	@GET
	@Path("retrieveDefectDetailsForComponent/{ImpactedComponent}/{currentPage}")
	@Produces({"application/json"})

	public String retrieveDefectDetailsForImpactedComponent(@PathParam("ImpactedComponent") String ImpactedComponent, @PathParam("currentPage") int currentPage) {
		return ReadDefectDetailsForImpactedComponent.CheckImpactedComponentExists(ImpactedComponent,currentPage);
	}

	@GET
	@Path("retrieveDefectDetailsForPerson/{AssignedTo}/{currentPage}")
	@Produces({"application/json"})

	public String retrieveDefectDetailsForAssignedPerson(@PathParam("AssignedTo") String AssignedTo, @PathParam("currentPage") int currentPage) {
		return ReadDefectDetailsForAssignedPerson.CheckAssignedPersonExists(AssignedTo, currentPage);
	}

	@GET
	@Path("retrieveDocumentsCount")
	@Produces({"application/json"})
	
	public String retrieveDocumentsCount() {
		return DocumentsCount.GetDocumentsCount();

	}
	
	@GET
	@Path("retrieveDocumentsCountForAssignedPerson/{AssignedTo}")
	@Produces({"application/json"})
	
	public String retrieveDocumentsCountForAssignedPerson(@PathParam("AssignedTo") String AssignedTo) {
		return DocumentsCount.GetDocumentsCountForAssignedPerson(AssignedTo);

	}
	
	@GET
	@Path("retrieveDocumentsCountForDefectId/{DefectID}")
	@Produces({"application/json"})
	
	public String retrieveDocumentsCountForDefectId(@PathParam("DefectID") String DefectID) {
		return DocumentsCount.GetDocumentsCountForDefectId(DefectID);	
	}
	
	
	@GET
	@Path("retrieveDocumentsCountForImpactedComponent/{ImpactedComponent}")
	@Produces({"application/json"})
	
	public String retrieveDocumentsCountForImpactedComponent(@PathParam("ImpactedComponent") String ImpactedComponent) {
		return DocumentsCount.GetDocumentsCountForImpactedComponent(ImpactedComponent);

	}
}