/**
 * Created by vilens on 2017/4/15.
 */
app.controller('ProjectListCtrl', function ($scope, $state, toaster) {
    $scope.toEdit = function (_projectId) {
        $state.go('app.editProject', {projectId: _projectId});
    };

    $scope.data = {
        currPage: 1,
        limit: 10
    };
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
                    $scope.dataList = data.result.list;
                    $scope.data.currPage = data.result.currPage;
                    $scope.data.totalPage = data.result.totalPage;
                    $scope.data.total = data.result.total;
                    // $scope.totalItems = data.result.total;
                    // showPagination(data.result.totalPage,data.result.currPage);
                    $scope.$apply();
                    toaster.pop("success", "成功", data.message);
                } else {
                    toaster.pop("error", "失败", data.message);
                }
            }
        });
    };

    $scope.maxSize = 5;
    // $scope.currentPage = 1;
    // $scope.totalPage = 1;
    // $scope.total = 0;
    $scope.pageChanged = function (currentPage) {
        $scope.search();
    };

    $scope.search();


})