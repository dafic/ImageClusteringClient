<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Image Clustering:Distributed Approach</title>
  </head>
  <body>
    <h1>Images of Cluster</h1>
<%String[] b = obj2.split(",")
  for(int i = 0;i<b.length;i++){
  String imageName = b[i];%>
    <img src="/ImageClusteringClient/imageRender/renderImage/${imageName}" height ="200px"/>
<%}%>
  </body>
</html>
