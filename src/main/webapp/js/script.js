    var inputsoaprequest;
    var wsdladressfield;


$(document).ready(function() {
        $("#ajaxstartbuttonid").click(function(){
        $('#spinner').show();
                var registerData = $('#commandtextinput').val();
                        $.ajax({
                                url: '/commandStartStopAjax',
                                type: 'POST',
                                data: {ajaxcommand: registerData},
                                success: function(data){
                                   //     alert(data);
                                        $('#spinner').hide();
                                        $('#soapresponsename').val(data);
                                        $('#soapresponsestandard').val(data);
                                        $('#soapresponseadress').val(data);
                                }
                });
        });


});



$(document).ready(function() {
        $("#ajaxstartbuttonid2").click(function(){
        $('#spinner').show();
                var registerData = $('#commandtextinput2').val();
                        $.ajax({
                                url: '/commandStartStopAjax2',
                                type: 'POST',
                                data: {ajaxcommand: registerData},
                                success: function(data){
                                   //     alert(data);
                                        $('#spinner').hide();
                                        $('#soapresponsename').val(data);
                                        $('#soapresponsestandard').val(data);
                                        $('#soapresponseadress').val(data);
                                }
                });
        });


});



    $(document).ready(function() {
        $("#ajaxgetsoapresposebutton").click(function(){
            ajaxsendfunction($('#ajaxgetsoapresposeinput').val(), $('#ajaxsetsoapadressinput').val());
        });
    });

    function ajaxsendfunction(inputsoaprequest, wsdladressfield) {
        $('#spinner').show();
            $.ajax({
                url: '/ajaxCommandPage',
                type: 'POST',
                data: {
                    soapfield: inputsoaprequest,
                    wsdlfield: wsdladressfield
                },
                success: function(data){

                var soapresponsename = $.trim(data.split(':')[0]);
                var soapresponsestandard = $.trim(data.split(':')[1]);
                var soapresponseadress = $.trim(data.split(':')[2]);
                    if(data.length==0){
                        data='Нет ответа от сервера. Проверьте доступность адреса wsdl';
                        $('#spinner').hide();
                        $('#returnsoap').text(data);
                    }
                        $('#spinner').hide();
                        $('#soapresponsename').val(soapresponsename);
                        $('#soapresponsestandard').val(soapresponsestandard);
                        $('#soapresponseadress').val(soapresponseadress);
                }
            });
    }

    $(document).ready(function(){
        $("#spinner").bind("ajaxSend", function() {
            $(this).show();
        }).bind("ajaxStop", function() {
            $(this).hide();
        }).bind("ajaxError", function() {
            $(this).hide();
    });
});