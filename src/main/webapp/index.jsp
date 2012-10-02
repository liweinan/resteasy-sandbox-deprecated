<html>
<body>
<h2>Hello World!</h2>

<form>
    <input type='button' onclick='testPathParam();' value='Test Path Param'/>
</form>
<div id="path_result"></div>

<script src="/try-resteasy/rest-js" type="text/javascript"></script>
<script type="text/javascript">
//    REST.apiURL = 'http://127.0.0.1:8080/try-resteasy/resteasy';

    var global_order_id = 0;
    function testPathParam() {
        document.getElementById('path_result').innerHTML =
                CachedResource.get();

    }
</script>
</body>
</html>
