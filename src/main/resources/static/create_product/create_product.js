angular.module('app-front').controller('createProductController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/app';

    $scope.createNewProduct = function () {
        if($scope.new_product == null){
            alert("Форма не заполнена");
            return;
        }
        $http.post(contextPath + '/products', $scope.new_product)
            .then(function successCallback(response) {
                    $scope.new_product = null;
                    alert("Продукт успешно создан");
                    $location.path('/product')
                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );
    }
});