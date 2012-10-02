<html>
<body>
<h2>Hello World!</h2>

<form>
    <input type='button' onclick='testCache();' value='Test Cache'/>
</form>
<div id="testCache"></div>

<script src="/try-resteasy/rest-js" type="text/javascript"></script>
<script type="text/javascript">
    function testCache() {
        document.getElementById('testCache').innerHTML = CachedResource.get();
    }
</script>
</body>
</html>
