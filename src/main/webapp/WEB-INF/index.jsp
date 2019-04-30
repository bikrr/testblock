<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<html>
    <meta http-equiv="content-type" content="text/html; charset=utf8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <head>
        <title>TestBlock client</title>
    </head>
    <body>
        <script src="../js/script.js"></script>

        <div class="shadow-lg container-fluid animated zoomIn text-center col-8 jumbotron mt-5">
            <div class="animated fadeIn delay-1s">
                      <h1 class="h3 mb-3 font-weight-normal">TestBlock Client test</h1>
                      <label for="ajaxgetsoapresposeinput" class="sr-only">Input user name</label>
                      <input type="text" id="ajaxgetsoapresposeinput" class="form-control mb-3" placeholder="User name">
                      <label for="ajaxsetsoapadressinput" class="sr-only">Input wsdl adress</label>
                      <input type="text" id="ajaxsetsoapadressinput" value="http://localhost:8080/service/studentDetailsWsdl.wsdl" class="form-control mb-3" placeholder="WSDL adress">
                      <button id="ajaxgetsoapresposebutton" class="btn btn-info mb-3">Get active directory users</button>
                      <input type="text" id="soapresponsename" class="form-control mb-3" placeholder="Student name">
                      <input type="text" id="soapresponsestandard" class="form-control mb-3" placeholder="Student standard">
                      <input type="text" id="soapresponseadress" class="form-control mb-3" placeholder="Student adress">
                      <p class ="mt-1" id="returnsoap"></p>
            </div>
          </div>

          <div id="spinner" class="spinner" style="display: none; position: fixed; top: 50%; left: 50%;"><i class="fa fa-cog fa-spin fa-3x fa-fw"></i></div>

    </body>
</html>