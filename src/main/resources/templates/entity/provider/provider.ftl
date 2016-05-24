<@layout>
<div id="header">
    <h2 style="align-content: center">Providers</h2>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        $('button.remove').click(function() {
            $.post("/entity/provider/delete/" + $(this).attr('providerId'),
                    {},
                    function(data, status){
                        location.reload();
                    });

        });

        $('button.edit').click(function() {
            $(location).attr('href', "/entity/provider/edit/" + $(this).attr('providerId'))
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
        Add new provider
    </a>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseFilter" aria-expanded="false" aria-controls="collapseFilter">
        Filter
    </a>
    </p>
    <div class="collapse" id="collapseAdd">
        <fieldset>
            <form name="addForm" role="form" method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
                </div>
                <button type="submit" class="btn btn-default">Save</button>
            </form>
        </fieldset>
    </div>
    <div class="collapse" id="collapseFilter">
        <fieldset>
            <form name="filterForm" role="form" method="get" action="/entity/provider/filter">
                <div class="form-group">
                    <label>Good:</label>
                    <select class="form-control" id="selGood" name="good">
                        <#list goods as good>
                        <option>${good.name}</option>
                        </#list>
                    </select>
                    <label for="count">Minimal amount:</label>
                    <input type="number" class="form-control" id="count" name="count" placeholder="Enter count" required>
                    <label for="period">Period:</label>
                    <input type="text" name="period"/>
                    <script type="text/javascript">
                        $(function() {
                            $('input[name="period"]').daterangepicker();
                        });
                    </script>
                </div>
                <button type="submit" class="btn btn-default" >Find</button>
            </form>
        </fieldset>
    </div>

    <br>
    <br>

    <table class="table table-bordered table-striped">
        <tbody>
            <#list providers as provider>
                <#if providers??>
                <tr>
                    <td>${provider.name}</td>
                    <td><button type="button" class="btn btn-danger remove" providerId="${provider.id}">delete</button></td>
                    <td><button type="button" class="btn btn-info edit" providerId="${provider.id} ">edit</button></td>
                </tr>
                </#if>
            </#list>
        </tbody>
        <thead>
        <tr>
            <th>Name</th>
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