angular.module('app-front', []).controller('appController', function ($scope, $http) {
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
            console.log(response);
            $scope.products = response.data;
        });
    }
    //создание продукта через передачу параметров (не работает, не знаю почему...)
    // $scope.createProduct = function (title, price) {
    //     $http.post({
    //         url: contextPath + 'products/create',
    //
    //         method: 'POST',
    //         params: {
    //             title: title,
    //             price: price
    //         }
    //     }).then(function (response) {
    //         console.log(response);
    //         $scope.products = response.data;
    //     });
    // }
    //функция для создания продукта по аналогии с лекцией
    $scope.createProduct = function () {
        $http.post(contextPath + 'products', $scope.new_product)
            .then(function successCallback(response) {
                    $scope.loadProducts();

                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );
        }
        //console.log($scope.new_product);

});

