<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
  </head>
  <body>
    <h1>Central Image of Clusters</h1>
<%int i = 1%>
<%for(String s:obj1){
  String[] b = s.split(",")
  String imageName = b[1]
  String rowKey = b[0]%>
    
    <img src="/ImageClusteringClient/imageRender/renderImage/${imageName}" height ="200px"/>
  <g:link controller ="clusterInfo" action ="getImageList" id="${rowKey}">Click</g:link>
  <%i++}%>
</body>
</html>
