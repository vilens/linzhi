/**
 * Created by vilens on 2017/4/15.
 */
app.controller('EditProjectCtrl', function ($scope, $state, $stateParams, $q,$timeout) {
    $scope.data = {
        // subContractor:[]
    };
    $scope.userInfo = {};

    $scope.edit = function () {
        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            data: $scope.data,
            url: "rest/commonData/updateProject",
            success: function (data) {
                if (data.success) {
                    $state.go('app.projectList');
                } else {
                    layer.msg(data.message);
                }
            }
        });
    };
    if ($stateParams.projectId) {

        var getUser = function () {
            var defer = $q.defer();
            $.ajax({
                type: "post",
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                data: $scope.data,
                url: "rest/commonData/getCurrentUser",
                success: function (data) {
                    defer.resolve(data);
                    // if (data.success) {
                    //     $scope.userInfo = data.result;
                    // } else {
                    //     layer.msg(data.message);
                    // }
                }
            });
            return defer.promise;
        };

        var loadProject = function () {
            var defer = $q.defer();
            $.ajax({
                type: "post",
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                data: {projectId: $stateParams.projectId},
                url: "rest/commonData/getProjectById",
                success: function (data) {
                    defer.resolve(data);
                    // if (data.success) {
                    //     $scope.data = angular.extend($scope.data, data.result);
                    // } else {
                    //     layer.msg(data.message);
                    // }
                }
            });
            return defer.promise;
        }

        var loadSubContract = function () {
            var defer = $q.defer();
            $.ajax({
                type: "post",
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                data: {projectId: $stateParams.projectId},
                url: "rest/commonData/getSubContractListByProjectId",
                success: function (data) {
                    defer.resolve(data);
                    // if (data.success) {
                    //     angular.forEach(data.result, function (data, index, array) {
                    //         if (index == 0) {
                    //             $scope.data.subContractor1 = data;
                    //         }
                    //         if (index == 1) {
                    //             $scope.data.subContractor2 = data;
                    //         }
                    //     })
                    // } else {
                    //     layer.msg(data.message);
                    // }
                }
            });
            return defer.promise;
        }
        var p1 = getUser();
        var p2 = loadProject();
        var p3 = loadSubContract();
        
        $q.all([p1,p2,p3]).then(function (data) {
            console.info(data);
            if(data[1]){
                var data_=data[1];
                if (data_.success) {
                    $scope.data = angular.extend($scope.data, data_.result);
                } else {
                    layer.msg(data_.message);
                }
            }
            if(data[2]){
                var data_=data[2];
                if (data_.success) {
                    angular.forEach(data_.result, function (data, index, array) {
                        if (index == 0) {
                            $scope.data.subContractor1 = data;
                        }
                        if (index == 1) {
                            $scope.data.subContractor2 = data;
                        }
                    })
                } else {
                    layer.msg(data_.message);
                }
            }
            if(data[0]){
                var data_=data[0];
                if (data_.success) {
                    $scope.userInfo = data_.result;
                } else {
                    layer.msg(data_.message);
                }
            }
            $timeout(function () {
                $scope.$apply();
            },500);

        })

    }

})