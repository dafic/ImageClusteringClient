<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Image Clustering</title>
  </head>
  <body>
    <%int i = 1%>
<%for(String imageName:obj1){%>
  
    <img src="/ImageClusteringClient/getGMM/imageRetrive/${imageName}" height ="200px" width ="200px"/>
    <g:link controller ="GetGMM" action ="imageRetrive" id="${imageName}">Click</g:link>
<!--    <g:createLink controller="getGMM" action="imageRetrive"
              params="[title: 'The Shining', author: 'Stephen King', id: '1']"/>-->
    <%i++}%>
<!--<img src="${createLink(controller: 'GetGMM', action: 'imageRetrive')}"/>-->
</body>
</html>
