angular.module('app-front').controller('productPageController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/app/';

    //функция для вывода списка продуктов
    $scope.loadProducts = function () {
        $http.get(contextPath + 'products')
            .then(function (response){
                console.log(response);
                $scope.products = response.data;
            });
    }
    //функция для удаления продукта по id
    $scope.deleteProduct = function (id) {
        $http({
            url: contextPath + 'products/delete',
            method: 'GET',
            params: {
                id: id
            }
        }).then(function (response) {
            $scope.loadProducts();
            console.log(response);
            $scope.products = response.data;
        });
    }

    $scope.navToEditProductPage = function (productId){
        $location.path('/edit_product/' + productId);
    }
    $scope.loadProducts();
});

