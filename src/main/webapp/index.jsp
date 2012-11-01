<html>
<body>
<h2>Hello World!</h2>

<form>

    <input type='button' onclick='testAdd();' value='Test Add'/>
    <input type='button' onclick='testMinus();' value='Test Minus'/>
</form>

<div id="add_result"></div>
<div id="minus_result"></div>

<script src="/try-resteasy/rest-js" type="text/javascript"></script>
<script type="text/javascript">
    function testAdd() {
        document.getElementById('add_result').innerHTML =
                AddImpl.operate({operand1:1, operand2:1});
    }

    function testMinus() {
        document.getElementById('minus_result').innerHTML =
                MinusImpl.operate({operand1:1, operand2:1});
    }
</script>
</body>
</html>
