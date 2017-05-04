/**
 * Created by vilens on 2017/4/15.
 */
app.controller('ProjectListCtrl', function ($scope, $state) {
    $scope.toEdit = function (_projectId) {
        $state.go('app.editProject', {projectId: _projectId});
    };

    $scope.data = {};
    $scope.dataList;

    $scope.search = function () {
        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            data: $scope.data,
            url: "rest/commonData/getProjectList",
            success: function (data) {
                if (data.success) {
                    $scope.dataList = data.result;
                    $scope.$apply();
                } else {
                    alert(data.message);
                }
            }
        });
    };

    $scope.search();
})