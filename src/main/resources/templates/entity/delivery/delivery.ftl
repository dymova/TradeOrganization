<@layout>
<div id="header">
    <h2 style="align-content: center">Deliveries</h2>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        $('button.remove').click(function() {
            $.post("/entity/delivery/delete/" + $(this).attr('deliveryId'),
                    {},
                    function(data, status){
                        location.reload();
                    });

        });
        $('#filter').click(function() {
            $.get("/entity/delivery/filter/",
                    {good: $('#selGood').val(),
                    provider: $('#selProvider').val(),
                    period: $('#periodPicker').val()},
                    function(data, status){
                        location.reload();
                    });

        });

        $('button.edit').click(function() {
            $(location).attr('href', "/entity/delivery/edit/" + $(this).attr('deliveryId'))
        });
    });

</script>
<!-- Include Required Prerequisites -->
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/latest/css/bootstrap.css" />
<!-- Include Date Range Picker -->
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

<div id="content">
    <p>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseAdd" aria-expanded="false" aria-controls="collapseAdd">
            Add new delivery
        </a>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseFilter" aria-expanded="false" aria-controls="collapseFilter">
            Filter by good, provider and period
        </a>
    </p>
    <div class="collapse" id="collapseAdd">
        <fieldset>
            <form name="addForm" role="form" method="post">
                <div class="form-group">
                    <label for="name">Good:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
                </div>
                <button type="submit" class="btn btn-default">Save</button>
            </form>
        </fieldset>
    </div>
    <div class="collapse" id="collapseFilter">
        <fieldset>
            <form name="filterForm" role="form" method="get" action="/entity/delivery/filter">
                <div class="form-group">
                    <label>Good:</label>
                    <select class="form-control" id="selGood" name="good"">
                        <#list goods as good>
                            <option value="${good.id}">${good.name}</option>
                        </#list>
                    </select>
                    <label>Provider:</label>
                    <select class="form-control" id="selProvider" name="provider">
                        <#list providers as provider>
                            <option value="${provider.id}">${provider.name}</option>
                        </#list>
                    </select>
                    <label for="period">Period:</label>
                    <input type="text" name="period" id="periodPicker"/>
                    <script type="text/javascript">
                        $(function() {
                            $('input[name="period"]').daterangepicker();
                        });
                    </script>
                </div>
                <button type="submit" class="btn btn-default" id="filter">Find</button>
            </form>
        </fieldset>
    </div>

    <br>
    <br>

    <table class="table table-bordered table-striped">
        <tbody>
            <#list deliveries as delivery>
                <#if deliveries??>
                <tr>
                    <td>${delivery.provider.name}</td>
                    <td>${delivery.good.name}</td>
                    <td>${delivery.count}</td>
                    <td>${delivery.date}</td>
                    <td>${delivery.order.number}</td>
                    <td><button type="button" class="btn btn-danger remove" deliveryId="${delivery.id}">delete</button></td>
                    <td><button type="button" class="btn btn-info edit" deliveryId="${delivery.id} ">edit</button></td>
                </tr>
                </#if>
            </#list>
        </tbody>
        <thead>
        <tr>
            <th>Provider</th>
            <th>Good</th>
            <th>Count</th>
            <th>Date</th>
            <th>Order number</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
    </table>
    <div class="panel panel-success">
        <div class="panel-heading">Count:</div>
        <div class="panel-body">${resultCount}</div>
    </div>

</div>
</@layout>