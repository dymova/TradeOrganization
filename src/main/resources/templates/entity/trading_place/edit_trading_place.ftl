<@layout>
<div id="header">
    <h2 style="align-content: center">Trading places</h2>
</div>
<div id="content">
    <fieldset>
        <form name="addForm" role="form" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required value=${tradingPlaceName}>
            </div>
            <div class="form-group">
                <label for="type">Type:</label>
                <input type="text" class="form-control" id="type" name="type" placeholder="Enter name" required value=${tradingPlaceType}>
            </div>
            <button type="submit" class="btn btn-default">Save</button>
        </form>
    </fieldset>
    <br/>

</div>
</@layout>