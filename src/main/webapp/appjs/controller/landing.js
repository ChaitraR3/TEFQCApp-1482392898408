angular.module('LandingCtrl', []).controller('LandingController', function ($scope,qcHttpService) {

	$scope.showHeader = false;
	$scope.showPages = false;
	$('#mydiv').hide();  

	$scope.retrieveDefectDetailsForPerson = function()
	{
		$scope.currentPage=1;
		$scope.numPerPage=20;
		$scope.showPages = true;
		$scope.showHeader = true;
		$('#mydiv').show();

		$scope.count = qcHttpService.getDocumentsCountforPerson($scope.PersonName).then(function(response){
			$scope.count= response.data;
			if($scope.count>0)
			{
				$scope.qcList1 = qcHttpService
				.getdefectDetailsforPerson($scope.PersonName, $scope.currentPage).then(function (response) {
					$('#mydiv').hide();  
					$scope.qclist =response.data;

				});
			}
			else
			{
				alert("No QC records found");
				$('#mydiv').hide(); 
			}
		});
	}

	$scope.retrieveDefectDetailsForDefectId = function()
	{
		$scope.currentPage=1;
		$scope.numPerPage=20;
		$scope.showHeader = true;
		$('#mydiv').show();  

		$scope.count = qcHttpService.getDocumentsCountforDefectId($scope.DefectId).then(function(response){
			$scope.count= response.data;
			if($scope.count>0)
			{
				$scope.qcList2 = qcHttpService
				.getdefectDetailsforDefectId($scope.DefectId, $scope.currentPage).then(function (response) {
					$('#mydiv').hide();  
					$scope.qclist = response.data;


				});
			}
			else
			{
				alert("No QC records found");
				$('#mydiv').hide(); 
			}
		});
	}

	$scope.retrieveDefectDetailsForImpactedComponent = function()
	{
		$scope.currentPage=1;
		$scope.numPerPage=20;
		$scope.showPages = true;
		$scope.showHeader = true;
		$('#mydiv').show();  

		$scope.count = qcHttpService.getDocumentsCountforImpactedComponent($scope.ImpactedComponent).then(function(response){
			$scope.count= response.data;
			if($scope.count>0)
			{
				$scope.qcList3 = qcHttpService
				.getdefectDetailsforImpactedComponent($scope.ImpactedComponent, $scope.currentPage).then(function (response) {
					$('#mydiv').hide();  
					$scope.qclist = response.data;

				});
			}
			else
			{
				alert("No QC records found");
				$('#mydiv').hide(); 
			}
		});
	}

	$scope.getDefectDetails= function(DefectID)
	{
		$('#mydiv').show();  
		$scope.defectIdList = qcHttpService
		.getdefectDetailsforDefectId(DefectID).then(function (response) {
			$('#mydiv').hide();  
			$scope.defectIdlist = response.data;
			console.log($scope.defectIdlist);
			$scope.showPages = false;
			$scope.showIt = true;

		});

	}

	$scope.getCurrentPageValue= function(currentPage)
	{
		if($scope.PersonName!=undefined){
			$('#mydiv').show();  
			$scope.qcList1 = qcHttpService
			.getdefectDetailsforPerson($scope.PersonName, $scope.currentPage).then(function (response) {
				$('#mydiv').hide();  
				$scope.qclist = response.data;

			});
		}
		if($scope.ImpactedComponent!=undefined){
			$('#mydiv').show();  
			$scope.qcList1 = qcHttpService
			.getdefectDetailsforImpactedComponent($scope.ImpactedComponent, $scope.currentPage).then(function (response) {
				$('#mydiv').hide();  
				$scope.qclist = response.data;

			});
		}

	}

	$scope.hideIt = function () {
		$scope.showIt = false;
		$scope.showHeader = true;

	};

});

