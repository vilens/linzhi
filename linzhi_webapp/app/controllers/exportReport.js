/**
 * Created by vilens on 2017/6/2.
 */
app.controller('ExportReportCtrl', function ($scope, $timeout) {
    $scope.param = {};
    $scope.export = function () {
        // var url = 'http://localhost:8080/rest/export/exportProjectData';
        // if ($scope.beginTime) {
        //     url += "?beginTime=" + new Date($scope.beginTime).getTime();
        // }
        // if ($scope.endTime) {
        //     if (url.indexOf('?') > -1) {
        //         url += "&endTime=" + new Date($scope.endTime).getTime();
        //     } else {
        //         url += "?endTime=" + new Date($scope.endTime).getTime();
        //     }
        // }
        // console.info(url);
        // window.location.href = url;

        var form_ = document.createElement('form');
        document.body.appendChild(form_);
        var input_ = document.createElement("input");
        input_.type = "hidden";
        form_.appendChild(input_);
        form_.action = "http://localhost:8080/rest/export/exportProjectData";
        form_.method = "post";
        input_.name = 'param';
        input_.value = JSON.stringify($scope.param);
        form_.submit();
        document.body.removeChild(form_);
    }

    var init = function () {
        $('#startDate').datetimepicker({
            format: 'yyyy-mm-dd',
            startView: 2,
            minView: 2,
            // endDate: currentDate,
            initialDate: new Date(),
            ShowUpDown: true,
            language: 'zh-CN',
            autoclose: true,//选中之后自动隐藏日期选择框
            // clearBtn: true,//清除按钮
            // todayBtn: true//今日按钮
        }).on("changeDate", function (a) {
            $('#endDate').datetimepicker("setStartDate", a.date);
            $scope.beginTime = a.date.format('yyyy-MM-dd');
            if (new Date($scope.endTime).getTime() < new Date($scope.beginTime).getTime()) {
                $scope.endTime = $scope.beginTime;
                $timeout(function () {
                    $scope.$apply();
                }, 500);
            }
        });
        $('#endDate').datetimepicker({
            format: 'yyyy-mm-dd',
            startView: 2,
            minView: 2,
            // endDate: currentDate,
            initialDate: new Date(),
            ShowUpDown: true,
            language: 'zh-CN',
            autoclose: true,//选中之后自动隐藏日期选择框
            // clearBtn: true,//清除按钮
            // todayBtn: true//今日按钮
        }).on("changeDate", function (a) {
            $scope.endTime = a.date.format('yyyy-MM-dd');
        });
    }();
})