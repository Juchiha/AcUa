function soloLetrasNumeros(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = "áéíóúabcdefghijklmnñopqrstuvwxyz1234567890";
    //especiales = [8, 37, 39, 46];
    especiales = [8];
    tecla_especial = false
    for(var i in especiales) {
        if(key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if(letras.indexOf(tecla) == -1 && !tecla_especial)
        return false;
}

function updateInformation(){
	$.ajax({
        url   : 'updateInformacion',
        method: 'post',
        data  : $("#formActualizacionDatos").serialize(),
        dataType    : 'json',
        success     : function(data){
            if(data.code == '0'){
                alertify.error('No se pudo guardar el AC');
            }else{
            	alertify.success('AC actualizado, correctamente');
            	$("#txtNombres").val("");
               	$("#txtAC").val("");
               	$("#btnCambiarEstadosD").click();
               	$("#btnCambiarEstadosA").hide();         	
               	$("#btnActualizarDatos").prop("disabled", true);
               	$("#txtIdentificacion").val("");
               	$("#txtIdentificacion").focus();
            }
        },
        beforeSend:function(){
            $.blockUI({ 
                message : '<h3>Un momento por favor....</h3>',
                css: { 
                    border: 'none', 
                    padding: '1px', 
                    backgroundColor: '#000', 
                    '-webkit-border-radius': '10px', 
                    '-moz-border-radius': '10px', 
                    opacity: .5, 
                    color: '#fff' 
                } 
            }); 
        },
        complete:function(){
            $.unblockUI();
        }
    });
}

$(function(){
	$("#btnActualizarDatos").click(function(){
		if($("#txtAC").val() == $("#Acanterior").val()){
			alertify.error("No se ha modificado el AC");
		}else{
			swal({
	            title: '&#191;Est&aacute; seguro de actualizar su AC&#63;',
	            text: "&iexcl;Si no lo est&aacute; puede cancelar la acci&oacute;n&#33;",
	            type: 'warning',
	            html:true,
	            showCancelButton: true,
	            confirmButtonColor: '#3085d6',
	            cancelButtonColor: '#d33',
	            cancelButtonText: 'Cancelar',
	            confirmButtonText: 'Si, actualizar'
	        },function(isConfirm) {
	            if (isConfirm) {
	            	updateInformation();
	            }
	        });
		}
	});

	$("#btnCambiarEstadosA").click(function(){
		$("#txtAC").attr('readonly', false);
		//$("#txtNombres").attr('readonly', false);
		$(this).hide();
		$("#btnCambiarEstadosD").show();
	});

	$("#btnCambiarEstadosD").click(function(){
		$("#txtAC").attr('readonly', true);
		//$("#txtNombres").attr('readonly', true);
		$(this).hide();
		$("#btnCambiarEstadosA").show();
		
	});

	$("#txtIdentificacion").change(function(){
		//console.log($(this).val());
		if($(this).val() != '' &&  $(this).val().length > 1){
			var strValorAspirante = $(this).val();
	        $.ajax({
	            url   : 'datosAspirante',
	            method: 'post',
	            data  : {getDataAspirante : strValorAspirante},
	            dataType    : 'json',
	            success     : function(data){
	                if(data.code == '0'){
	                    alertify.error('Esta Identificaci\u00F3n no existe');
	                    $("#txtIdentificacion").val("");
	                    $("#txtIdentificacion").focus();
	                }else{
	                	if(data.strNuevoAc != 'null' && data.strNuevoAc != ''){
	                		alertify.error('Identificaci\u00F3n Valida, pero usted ya modifico su AC');
	                		$("#txtNombres").val(data.strPrimerNombre+" "+ data.strSegundoNombre +" "+data.strPrimerApellido + " "+ data.strSegundoApellido);
		                   	$("#txtAC").val(data.strAc);
		                   	$("#btnCambiarEstadosA").hide();
		                   	$("#btnActualizarDatos").prop("disabled", true);
	                	}else{
	                		$("#txtNombres").val(data.strPrimerNombre+" "+ data.strSegundoNombre +" "+data.strPrimerApellido + " "+ data.strSegundoApellido);
		                   	$("#txtAC").val(data.strAc);
		                   	$("#Acanterior").val(data.strAc);
		                	alertify.success('Identificaci\u00F3n Valida');
		                	$("#btnCambiarEstadosA").show();
		                	$("#btnActualizarDatos").prop("disabled", false);
	                	}
	                   	       
	                }
	            },
	            beforeSend:function(){
	                $.blockUI({ 
	                    message : '<h3>Un momento por favor....</h3>',
	                    css: { 
	                        border: 'none', 
	                        padding: '1px', 
	                        backgroundColor: '#000', 
	                        '-webkit-border-radius': '10px', 
	                        '-moz-border-radius': '10px', 
	                        opacity: .5, 
	                        color: '#fff' 
	                    } 
	                }); 
	            },
	            complete:function(){
	                $.unblockUI();
	            }
	        });
		}else{
			$("#txtNombres").val("");
           	$("#txtAC").val("");
           	$("#btnCambiarEstadosA").hide();
           	$("#btnActualizarDatos").prop("disabled", true);
		}
	});

});