<#macro layout>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Trading organization</title>

    <!-- Bootstrap core CSS -->
    <link href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <style>
      body {
          padding-top: 50px;
      }
      .starter-template {
          padding: 40px 15px;
          /*text-align: center;*/
      }
    </style>
  </head>

  <body>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                  data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Trading organization</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/services">Services</a></li>
            <li><a href="/entity/provider">Providers</a></li>
            <li><a href="/entity/trading_place">Trading places</a></li>
            <li><a href="/entity/consumer">Consumers</a></li>
            <li><a href="/entity/delivery">Deliveries</a></li>
            <#--<li><a href="/entity/good">Goods</a></li>-->
            <#--<li><a href="/entity/order">Orders</a></li>-->
            <#--<li><a href="/entity/sale">Sales</a></li>-->
            <#--<li><a href="/entity/salesmen">Salespeople</a></li>-->
            <#--<li><a href="/entity/trading_place_type">Trading place types</a></li>-->
          </ul>
        </div>
      </div>
    </nav>

    <div class="container">

      <div class="starter-template">
        <#nested>
      </div>

    </div><!-- /.container -->

  </body>
</html>
</#macro>
