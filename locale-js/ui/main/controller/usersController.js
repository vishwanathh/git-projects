angular.module('demoApp.controllers',[]).
controller('usersController', function($scope, translationService) {	
	translationService.getTranslation($scope, "en");
	$scope.usersList = [
        {
        	firstName: "foo",
        	lastName: "senior",
        	signum: "foo-senior",
        	email: "foo@test.com"
        },
        {
        	firstName: "git",
        	lastName: "junior",
        	signum: "git-junior",
        	email: "git@server.com"
        }
    ];
	
	$scope.setLang = function(lang) {
		console.log("Inside setLang function");
		translationService.getTranslation($scope, lang);
	};
});
