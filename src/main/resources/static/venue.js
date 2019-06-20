angular.module('venuedemo', [])
.controller('Venue', function($scope, $http) {
    $http.get('/findAll/').
        then(function(response) {
            $scope.venuelist = response.data;
            
        });
});