/**
 * Created by vilens on 2017/4/15.
 */
app.controller('EditProjectCtrl', function ($scope, $state, $stateParams) {
    $scope.data = {
        // subContractor:[]
    };
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
                    alert(data.message);
                }
            }
        });
    };
    if ($stateParams.projectId) {
        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            data: {projectId: $stateParams.projectId},
            url: "rest/commonData/getProjectById",
            success: function (data) {
                if (data.success) {
                    $scope.data = angular.extend($scope.data, data.result);
                } else {
                    alert(data.message);
                }
            }
        });
        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            data: {projectId: $stateParams.projectId},
            url: "rest/commonData/getSubContractListByProjectId",
            success: function (data) {
                if (data.success) {
                    angular.forEach(data.result, function (data, index, array) {
                        if(index==0){
                            $scope.data.subContractor1 = data;
                        }
                        if(index==1){
                            $scope.data.subContractor2 = data;
                        }
                    })
                } else {
                    alert(data.message);
                }
            }
        });
    }

})