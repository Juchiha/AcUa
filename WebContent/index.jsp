<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Universidad del Atl&aacute;ntico</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <meta name="description" content="Edici&oacute;n de datos Universidad del Atl&aacute;ntico">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/Ionicons/css/ionicons.min.css">

        <!-- Custom styles for this template -->
        <link href="assets/css/scrolling-nav.css" rel="stylesheet">

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <link href='//fonts.googleapis.com/css?family=Sansita+One' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>

        <link rel="shortcut icon" href="img/plantilla/acquia_marina_favicon_0.png">
        <link rel="stylesheet" type="text/css" href="assets/alertify/alertify.core.css">
        <link rel="stylesheet" type="text/css" href="assets/alertify/alertify.default.css">
        <link rel="stylesheet" type="text/css" href="assets/sweetalert/sweetalert.css">
        
    </head>
    <body id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">
                    <img src="img/plantilla/UniversidadAtlantico.png" style="width: 100%;">
                </a>
                <div class="collapse navbar-collapse" id="navbarResponsive">
    
                </div>
            </div>
        </nav>


        <section id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                    	<form enctype="application/x-www-form-urlencoded"  action="/updateInformacion" id="formActualizacionDatos" method="post" autocomplete="off">
                    		<div class="row">
	                            <div class="col-md-3 col-lg-3 col-xs-12">
	                                <div class="form-group">
	                                    <label>Identificaci&oacute;n</label>
	                                    <input type="text" onkeypress="return soloLetrasNumeros(event)" name="txtIdentificacion" id="txtIdentificacion" required class="form-control" placeholder="Identificaci&oacute;n">
	                                </div>
	                            </div>
	
	                            <div class="col-md-5 col-lg-5 col-xs-12">
	                                <div class="form-group">
	                                    <label>Nombres</label>
	                                    <input type="text" name="txtNombres" id="txtNombres" readonly class="form-control" placeholder="Nombres">
	                                </div>
	                            </div>
	
	                            <div class="col-md-3 col-lg-3 col-xs-11">
	                                <div class="form-group">
	                                    <label>AC</label>
	                                    <input type="text" name="txtAC" id="txtAC" onkeypress="return soloLetrasNumeros(event)" readonly class="form-control" placeholder="AC">
	                                </div>
	                            </div>
	
	                            <div class="col-md-1 col-lg-1 col-xs-1">
	                                <div class="form-group">
	                                    <label style="visibility: hidden;">AC</label>
	                                    <button id="btnCambiarEstadosA"  type="button" style="display: none;" title="Activar Datos" class="btn btn-primary">
	                                        <i class="fa fa-edit"></i>
	                                    </button>
	                                    <button style="display: none;" type="button" id="btnCambiarEstadosD" title="Cancelar" class="btn btn-danger">
	                                        <i class="fa fa-times"></i>
	                                    </button>
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="row">
	                            <div class="col-md-3 col-lg-3 col-xs-12  mx-auto">
	                                <div class="form-group">
	                                    <button class="btn btn-primary btn-large btn-block" disabled type="button" id="btnActualizarDatos">
	                                        Actualizar Datos
	                                    </button>
	                                </div>
	                            </div>
	                        </div>
	                        <input type="hidden" name="Acanterior" id="Acanterior">
	                        <input type="hidden" name="ActextoAceptado" id="ActextoAceptado">
                    	</form>
                    </div>
                </div>
            </div>
        </section>
        <!-- Scripts -->
        <script src="assets/jquery/dist/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/alertify/alertify.js"></script>
        <script type="text/javascript" src="assets/blockui/blockUi.js"></script>
        <script type="text/javascript" src="assets/sweetalert/sweetalert.min.js"></script>
        <script type="text/javascript" src="js/plantilla.js"></script>
    </body>
</html>