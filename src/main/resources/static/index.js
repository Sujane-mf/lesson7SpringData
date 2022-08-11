(function () {
    angular
        .module('app-front', ['ngRoute'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/product', {
                templateUrl: 'product/product.html',
                controller: 'productPageController'
            })
            .when('/auth',{
                templateUrl: 'registration_page/registration.html',
                controller: 'registrationPageController'
             })
            .when('/edit_product/:productId', {
                templateUrl: 'edit_product/edit.html',
                controller: 'editProductController'
            })
            .when('/create_product', {
                templateUrl: 'create_product/create_product.html',
                controller: 'createProductController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.webMarketUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.webMarketUser.token;
        }
    }
})();

angular.module('app-front').controller('indexController', function ($rootScope, $scope, $http) {
    const contextPath = 'http://localhost:8189/app/';

});

