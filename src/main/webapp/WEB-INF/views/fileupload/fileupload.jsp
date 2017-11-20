<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<html>
<body>
<h2>上传多个文件 实例</h2>


<form action="/fileUpload/fileUpload" method="post"
      enctype="multipart/form-data">
    <p>
        选择文件:<input type="file" name="files">
    <p>
        选择文件:<input type="file" name="files">
    <p>
        选择文件:<input type="file" name="files">
    <p>
        <input type="submit" value="提交">
</form>
</body>
</html>
