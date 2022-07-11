angular.module('app-front').controller('editProductController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/app';

    $scope.prepareProductForUpdate = function () {
        $http.get(contextPath + '/products/' + $routeParams.productId)
            .then(function successCallback(response) {
                    $scope.updated_product = response.data;
                }, function failCallback(response) {
                    alert(response.data.message);
                    $location.path('/product')
                }
            );
    }

    $scope.updateProduct = function () {
        $http.put(contextPath + '/products', $scope.updated_product)
            .then(function successCallback(response) {
                    $scope.updated_product = null;
                    alert("Продукт успешно обновлен");
                    $location.path('/product')
                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );
    }

    $scope.prepareProductForUpdate();
});

