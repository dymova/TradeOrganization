<@layout>
<div id="header">
    <h2 style="align-content: center">Providers</h2>
</div>

<div id="content">
    <fieldset>
        <form name="addForm" role="form" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
            </div>
            <div class="form-group">
                <label for="type">Type:</label>
                <input type="text" class="form-control" id="type" name="type" placeholder="Enter type" required>
            </div>
            <button type="submit" class="btn btn-default">Save</button>
        </form>
    </fieldset>
    <br/>

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#--<#list model["tradingPlaces"] as tradingPlace>-->
            <#list tradingPlaces as tradingPlace>
            <tr>
                <td>${tradingPlace.name}</td>
                <td>${tradingPlace.type.name}</td>
                <td><button type="button" class="btn btn-danger remove" tradingPlaceId="${tradingPlace.id}">delete</button></td>
            <#--<td><button type="button" class="btn btn-danger remove" tradingPlaceId="${tradingPlace.id}" onclick="removeElement(${tradingPlace.id})">delete</button></td>-->
                <td><button type="button" class="btn btn-info edit" tradingPlaceid="${tradingPlace.id} ">edit</button></td>
            </tr>
            </#list>
        </tbody>
    </table>

</div>
</@layout>