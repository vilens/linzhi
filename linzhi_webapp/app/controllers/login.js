/**
 * Created by vilens on 2017/4/15.
 */
app.controller('LoginCtrl', function ($scope, $state) {
    $scope.data = {
        userName:"test1",
        password:"test1"
    };
    $scope.login = function () {
        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            data: $scope.data,
            url: "rest/commonData/login",
            success: function (data) {
                if (data.success) {
                    localStorage.token=data.result;
                    $state.go('app.dashboard');
                } else {
                    alert(data.message);
                }
            }
        });

    }
})