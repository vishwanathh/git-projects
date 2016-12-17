/**
 * 
 */
angular.module('demoApp.services', []).
factory('translationService', function ($resource) {
	return {
		getTranslation: function($scope, language) {
			var languageFilePath = 'localization/locale-' + language + '.json';			
			console.log("languageFilePath :::::::::::::::: "+languageFilePath);
			$resource(languageFilePath).get(function (data) {
				$scope.translation = data;
			});
		}
	}
});

