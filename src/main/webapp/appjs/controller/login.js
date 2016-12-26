angular.module('LoginCtrl', []).controller('LoginController', function ($scope, $location, qcHttpService) {
    console.log('displaying loging page from the controller');
   
    $scope.authenticate = function () {
    	 
        console.log('authenticating the user' + $scope.email + '  ' + $scope.password);
        $scope.user = qcHttpService;
        $scope.user.email = $scope.email;
        $scope.user.password = $scope.password;
        
        
        //Prepare the data to be sent as JSON to backend
        var authData;
        qcHttpService.autheticate(authData).success(function (data, status) {
            console.log(data);
    	   
            //On successful authentication.
            $location.path('/landing');
        })

        .error(function (error, status) {
            console.log(status);
            console.log(error);
            //parse the error and display on the error div
        });
    };
});
