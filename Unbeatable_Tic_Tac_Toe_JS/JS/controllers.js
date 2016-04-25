var myApp = angular.module('myApp', []);

//Shape controller to be extended from.
myApp.controller('ShapeController',function ($scope) {
    $scope.shape = {
        'name'      : 'Shape',
        'area'      : null,
        'test'      : 'test',
        'calculateArea' : function(){
            this.area = null;
        }
    }
});

//Square controller that extends the shape controller.
myApp.controller('SquareController', ['$scope', '$controller', function ($scope, $controller) {
    angular.extend(this, $controller('ShapeController', {
        $scope: $scope
    }));

    $scope.square = {
        'name'      : 'Square',
        'side'      : null,
        'area'      : null,
        'calculateArea' : function(){
            this.area = this.side * this.side;
        }
    }

    $scope.squareCounter = 0;
    $scope.squareMax = false;
    $scope.squareList = [];
    $scope.squareAdd = function() {
        $scope.squareList.push("[" + $scope.square.name + "][Side Length: " + $scope.square.side + "][ Area: " + $scope.square.area + "]");
        $scope.square.side = null;
        $scope.squareCounter += 1;

        if($scope.squareList.length == 10) {
            $scope.squareMax = true;
        }
    }
    $scope.deleteSquare = function (item) {
        $scope.squareList.splice($scope.squareList.indexOf(item), 1);
        $scope.squareCounter--;
        $scope.squareMax = false;
    }

    $scope.saveItem = function($index) {
        $scope.squareList[$index] = "[" + $scope.square.name + "][Side Length: " + $scope.square.side + "][ Area: " + $scope.square.side *$scope.square.side +  "]";
    };
}]);

//Rectangle controller that extends the shape controller.
myApp.controller('RectangleController', ['$scope', '$controller', function ($scope, $controller) {
    angular.extend(this, $controller('ShapeController', {
        $scope: $scope
    }));

    $scope.rectangle = {
        'name'      : 'Rectangle',
        'sideA'     : null,
        'sideB'     : null,
        'area'      : null,
        'calculateArea' : function(){
            this.area = this.sideA * this.sideB;
        }
    }
    $scope.rectangleCounter = 0;
    $scope.rectangleMax = false;
    $scope.rectangleList = [];
    $scope.rectangleAdd = function() {
        $scope.rectangleList.push("[" + $scope.rectangle.name + "][SideA Length: " + $scope.rectangle.sideA + "][SideB Length:  " + $scope.rectangle.sideB + "][ Area: " + $scope.rectangle.area + "]");
        $scope.rectangle.sideA = null;
        $scope.rectangle.sideB = null;
        $scope.rectangleCounter += 1;

        if($scope.rectangleList.length == 10) {
            $scope.rectangleMax = true;
        }
    }
    $scope.deleteRectangle = function (item) {
        $scope.rectangleList.splice($scope.rectangleList.indexOf(item), 1);
        $scope.rectangleCounter--;
        $scope.rectangleMax = false;
    }

    $scope.saveItem = function($index) {
        $scope.rectangleList[$index] = "[" + $scope.rectangle.name + "][SideA Length: " + $scope.rectangle.sideA + "][SideB Length:  " + $scope.rectangle.sideB + "][ Area: " + $scope.rectangle.sideA * $scope.rectangle.sideB +  "]";
    };
}]);

//Triangle controller that extends the shape controller.
myApp.controller('TriangleController', ['$scope', '$controller', function ($scope, $controller) {
    angular.extend(this, $controller('ShapeController', {
        $scope: $scope
    }));

    $scope.triangle = {
        'name'      : 'Triangle',
        'height'    : null,
        'base'      : null,
        'area'      : null,
        'calculateArea' : function(){
            this.area = (this.height * this.base) / 2;
        }
    }
    $scope.triangleCounter = 0;
    $scope.triangleMax = false;
    $scope.triangleList = [];
    $scope.triangleAdd = function() {
        $scope.triangleList.push("[" + $scope.triangle.name + "][Height Length: " + $scope.triangle.height + "][Base Length: " + $scope.triangle.base + "][ Area: " + $scope.triangle.area + "]");
        $scope.triangle.height = null;
        $scope.triangle.base = null;
        $scope.triangleCounter += 1;

        if($scope.triangleList.length == 10) {
            $scope.triangleMax = true;
        }
    }
    $scope.deleteTriangle = function (item) {
        $scope.triangleList.splice($scope.triangleList.indexOf(item), 1);
        $scope.triangleCounter--;
        $scope.triangleMax = false;
    }
    $scope.saveItem = function($index) {
        $scope.triangleList[$index] = "[" + $scope.triangle.name + "][Height Length: " + $scope.triangle.height + "][Base Length:  " + $scope.triangle.base + "][ Area: " + ($scope.triangle.height * $scope.triangle.base)/2 +  "]";
    };
}]);

//Circle controller that extends the shape controller.
myApp.controller('CircleController', ['$scope', '$controller', function ($scope, $controller) {
    angular.extend(this, $controller('ShapeController', {
        $scope: $scope
    }));

    $scope.circle = {
        'name'      : 'Circle',
        'radius'    : null,
        'area'      : null,
        'calculateArea' : function(){
            this.area = 3.14 * (this.radius * this.radius);
        }
    }
    $scope.circleCounter = 0;
    $scope.circleMax = false;
    $scope.circleList = [];
    $scope.circleAdd = function() {
        $scope.circleList.push("[" + $scope.circle.name + "][Radius Length: " + $scope.circle.radius + "][ Area: " + $scope.circle.area + "]");
        $scope.circle.radius = null;
        $scope.circleCounter += 1;

        if($scope.circleList.length == 10) {
            $scope.circleMax = true;
        }
    }
    $scope.deleteCircle = function (item) {
        $scope.circleList.splice($scope.circleList.indexOf(item), 1);
        $scope.circleCounter--;
        $scope.circleMax = false;
    }
    $scope.saveItem = function($index) {
        $scope.circleList[$index] = "[" + $scope.circle.name + "][Radius Length: " + $scope.circle.radius + "][ Area: " + 3.14 * ($scope.circle.radius * $scope.circle.radius) + "]";
    };
}]);
