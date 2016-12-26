angular.module('appRoutes', []).config(['$routeProvider', function ($routeProvider) {

    //console.log('Application routing logic');

    $routeProvider

        .when('/', {
            templateUrl: 'views/login.html',
            controller: 'LoginController'
        })
        .when('/landing', {
            templateUrl: 'views/components/landingPage.html',
            controller: 'LandingController'
        })
                         
            .otherwise({
            redirectTo: '/'
        })		


}]);
