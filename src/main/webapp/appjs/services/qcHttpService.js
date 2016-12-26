angular.module('QCHttp', []).factory('qcHttpService', ['$http', function ($http) {

    
    return {
        autheticate: function (authData) {
            return $http.post('localData/login.json', authData);
        },
         
        getDocumentsCount: function(){
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDocumentsCount"});
        },
        
        getDocumentsCountforPerson: function(person){
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDocumentsCountForAssignedPerson/"+person+""});
        },
        
        getDocumentsCountforDefectId: function(defectId){
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDocumentsCountForDefectId/"+defectId+""});
        },
        
        getDocumentsCountforImpactedComponent: function(component){
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDocumentsCountForImpactedComponent/"+component+""});
        },
       		
		getdefectDetailsforPerson: function(person,currentPage){
			currentPage = currentPage - 1;
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDefectDetailsForPerson/"+person+"/"+currentPage+""});
        },
      
        getdefectDetailsforDefectId: function(defectId){
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDefectDetailsForDefect/"+defectId+""});
        },
        
        getdefectDetailsforImpactedComponent: function(component,currentPage){
        	currentPage = currentPage - 1;
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDefectDetailsForComponent/"+component+"/"+currentPage+""});
        },
        
        getdefectDetailsforDefectId1: function(defectid,currentPage){
        	currentPage = currentPage - 1;
        	return $http({ method:"GET", url:"rest/getDefectInfo/retrieveDefectDetailsForDefect/"+defectid+"/"+currentPage+""});
        }
      
        
    }
}]);
