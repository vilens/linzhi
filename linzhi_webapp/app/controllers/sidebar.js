/**
 * Created by vilens on 2017/6/11.
 */
app.controller('sidebarCtrl',function ($scope) {
    $scope.userInfo = {};

    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/json; charset=utf-8",//(可以)
        data: {},
        url: "rest/commonData/getCurrentUser",
        success: function (data) {
            $scope.userInfo = data.result;
            // localStorage.setItem("userName",data.result.userName);
            // localStorage.setItem("roleLevel",data.result.roleLevel);
        }
    });
})