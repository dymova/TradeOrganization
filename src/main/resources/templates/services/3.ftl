<@layout>
<div id="header">
    <h2 style="align-content: center">Получить номенклатуру и объем товаров в указанной торговой точке.</h2>
</div>


<div id="content">
    <fieldset>
        <form name="addForm" role="form" method="get" action="/services/3">
            <div class="form-group">
                <label for="name">Trading place:</label>
                <select class="form-control" id="selPlace" name="tradingPlace">
                    <#list places as place>
                        <option>${place.name}</option>
                    </#list>
                </select>
            </div>
            <button type="submit" class="btn btn-default">Find</button>
        </form>
    </fieldset>

    <br>
    <br>

    <table class="table table-bordered table-striped">
        <tbody>
        <#if goodsInTradingPlace??>
            <#list goodsInTradingPlace as goodInTradingPlace>
                <tr>
                    <td>${goodInTradingPlace.good.name}</td>
                    <td>${goodInTradingPlace.count}</td>
                    <td>${goodInTradingPlace.price}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
        <thead>
        <tr>
            <th>Name</th>
            <th>Count</th>
            <th>Price</th>
        </tr>
        </thead>
    </table>
    <#if resultCount??>
    <div class="panel panel-success">
        <div class="panel-heading">Count:</div>
        <div class="panel-body">${resultCount}</div>
    </div>
    </#if>

</div>
</@layout>