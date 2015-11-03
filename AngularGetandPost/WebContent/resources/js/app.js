var personApp = angular.module('personApp', []);

personApp.service('personService', [ '$http', function($http) {

	var getUrl = '/AngularGetandPost/getPerson';
	var sendUrl = '/AngularGetandPost/sendPerson';
	
	// returns the person data from the database to a JSON /getPerson url
	this.getPerson = function() {
		return $http.get(getUrl);
	};
	
	// add the person to the database add returns the update data
	// uses the /sendPerson url
	this.addPerson = function(personData) {
		return $http.post(sendUrl, personData);
	}

} ]);

personApp.controller('mainController', [ '$scope', 'personService',
		function($scope, personService) {
			
			// calls the personService to get the person data
			personService.getPerson().success(function(result) {
				$scope.persons = result;
			}).error(function(data, status) {
				console.log(data);
			});

			$scope.firstname = '';
			$scope.lastname = '';
			$scope.occupation = '';

			$scope.addPerson = function() {

				var personData = {
					firstname : $scope.firstname,
					lastname : $scope.lastname,
					occupation : $scope.occupation
				};
				
				// calls the personService to add the a new person
				personService.addPerson(personData).success(function(result) {
					$scope.persons = result;

					$scope.firstname = '';
					$scope.lastname = '';
					$scope.occupation = '';
				}).error(function(data, status) {
					console.log(data);
				});

			}
		} ]);
