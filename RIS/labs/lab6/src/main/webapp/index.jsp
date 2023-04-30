<html>
<body>
<form action="getAllAnimals" method="GET">
    <button>Get all animals</button>
</form>
<br/>
<form action="getBankAccountByNumber" method="GET">
    <h2>Search by number</h2>
    <input required type="number" name = "number" placeholder="Account number"><br/><br/>
    <button>Get animal by name</button>
</form>
<br/>
<form action="getBankAccountsByBalance" method="GET">
    <h2>Search by balance</h2>
    <input required type="number" name = "balance" min="1" placeholder="Balance"><br/><br/>
    <button>Get animal by feed</button>
</form>
</body>
</html>