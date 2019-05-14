    var inputsoaprequest;
    var wsdladressfield;

// JDBC connect verify

$(document).ready(function() {
        $("#dbconnectverify").click(function(){
        $('#spinner').show();
        $('#returnsoap').text("please wait...");
                var registerData = $('#commandtextinput').val();
                        $.ajax({
                                url: '/commandJDBCconnect',
                                type: 'POST',
                                data: {ajaxcommand: registerData},
                                success: function(data){
                                   //     alert(data);
                                        $('#spinner').hide();
                                        $('#returnsoap').text(data);


                                }
                });
        });


});


// AD connect verify

$(document).ready(function() {
        $("#adconnectverify").click(function(){
        $('#spinner').show();
                var registerData = $('#responselogin').val();
                        $.ajax({
                                url: '/commandStartGetAD',
                                type: 'POST',
                                data: {ajaxcommand: registerData},
                                success: function(data){
                               $('#returnsoap').text("");
                                                       if(data.includes("error")){
                                                                         data='[LDAP error code 49 - Invalid Credentials]';
                                                                         $('#spinner').hide();
                                                                         $('#returnsoap').text(data);
                                                                     }
                                                var responseauthenticated = $.trim(data.split(':')[0]);
                                                var responselogin = $.trim(data.split(':')[1]);
                                                var responsepassword = $.trim(data.split(':')[2]);
                                                var soapresponseemail = $.trim(data.split(':')[3]);


                                   //     alert(data);
                                        $('#spinner').hide();
                                        $('#responseauthenticated').val(responseauthenticated);
                                        $('#soapresponseemail').val(soapresponseemail);


                                }
                });
        });


});


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


                                   var responselogin = $.trim(data.split(':')[0]);
                                   var responsepassword = $.trim(data.split(':')[1]);



                                      $('#returnsoap').text("");
                                        $('#spinner').hide();
                                        $('#responselogin').val(responselogin);
                                        $('#responsepassword').val(responsepassword);
                                            $('#responseauthenticated').val(" ");
                                          $('#soapresponseemail').val(" ");
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
                                        $('#returnsoap').text(" ");
                                        $('#spinner').hide();
                                        $('#responselogin').val(data);
                                        $('#responsepassword').val(data);
                                        $('#responseauthenticated').val(" ");
                                        $('#soapresponseemail').val(" ");
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

                var responselogin = $.trim(data.split(':')[0]);
                var responsepassword = $.trim(data.split(':')[1]);
                var soapresponseemail = $.trim(data.split(':')[2]);
                    if(data.length==0){
                        data='Нет ответа от сервера. Проверьте доступность адреса AD';
                        $('#spinner').hide();
                        $('#returnsoap').text(data);
                    }
                        $('#spinner').hide();
                        $('#responselogin').val(responselogin);
                        $('#responsepassword').val(responsepassword);
                        $('#soapresponseemail').val(soapresponseemail);
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