<html>
<head>
    <meta charset="utf-8">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.0.0/jquery.min.js">
    </script>
</head>
<body>
<h2>Hello World!</h2>
<button type="button" onclick="test()">test</button>
</body>
<script>
    function test() {
        $.ajax({
            type: "post",
            contentType : "application/json ; charset=utf-8",
            dataType: "json",
            data:JSON.stringify({test:"test"}),
            url: "rest/commonData/getUsersById",
            success: function (data) {
                console.info(data);
            }
        });
    }
</script>
</html>
