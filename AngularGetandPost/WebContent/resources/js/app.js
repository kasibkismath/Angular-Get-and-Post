var personApp = angular.module('personApp', []);

personApp.controller('mainController', [
		'$scope',
		'$http',
		function($scope, $http) {
			
			$http.get('/AngularGetandPost/getPerson').success(function(result) {
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

				$http.post('/AngularGetandPost/sendPerson', personData)
						.success(function(result) {
							$scope.persons = result;

							$scope.firstname = '';
							$scope.lastname = '';
							$scope.occupation = '';
						}).error(function(data, status) {
							console.log(data);
						});

			}
		} ]);
