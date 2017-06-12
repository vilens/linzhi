/**
 * Created by vilens on 2017/6/3.
 */
app.controller('NavBarCtrl', function ($scope, $state) {

    $scope.logout = function () {
        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            data: $scope.data,
            url: "rest/commonData/logout",
            success: function (data) {
                if (data.success) {
                    $state.go('login');
                }else{
                    layer.msg(data.message);
                }
            }
        });
    }

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