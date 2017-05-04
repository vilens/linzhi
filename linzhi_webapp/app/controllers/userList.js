/**
 * Created by vilens on 2017/4/15.
 */
app.controller('UserListCtrl', function ($scope) {
    $scope.search = function () {
        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            data: {},
            url: "rest/commonData/getUsers",
            success: function (data) {
                if (data.success) {
                    $scope.dataList = data.result;
                } else {
                    alert(data.message);
                }
            }
        });
    }

    $scope.search();
})