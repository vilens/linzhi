/**
 * Created by vilens on 2017/4/15.
 */
app.controller('CreateProjectCtrl', function ($scope,$state) {
    $scope.createProject = function () {
        if($scope.data && $scope.data.projectAccount && $scope.data.projectName){
            $.ajax({
                type: "post",
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                //contentType: "text/xml",//(可以)
                //contentType:"application/x-www-form-urlencoded",//(可以)
                data: $scope.data,
                url: "rest/commonData/createProject",
                success: function (data) {
                    if (data.success) {
                        $state.go('app.projectList');
                    } else {
                        layer.msg(data.message);
                    }
                }
            });
        }else{
            if($scope.data){
                if(!$scope.data.projectAccount || $scope.data.projectAccount.trim() == ''){
                    alert("工程账号不可为空！");
                    return;
                }
                if(!$scope.data.projectNamet || $scope.data.projectNamet.trim() == ''){
                    alert("项目名称不可为空！");
                    return;
                }
            }else{
                alert("填写项目信息后再创建");
            }
        }

    }
})