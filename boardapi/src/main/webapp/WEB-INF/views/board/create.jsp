<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 6. 16.
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@ include file="../layouts/header.jsp"%>

<%--개별 페이지 --%>
<h1 class="page-header my-4"><i class="far fa-edit"></i> 새 글쓰기</h1>

<div class="container">
    <form method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>제목</label>
            <input name="title" class="form-control">
        </div>
        <div class="form-group">
            <label>작성자</label>
            <input name="writer" class="form-control">
        </div>

        <!-- 파일 업로드 필드 -->
        <div class="form-group">
            <label>첨부파일</label>
            <input type="file"
                   class="form-control-file border"
                   multiple
                   name="files"/>
        </div>

        <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" name="content" rows="10"></textarea>
        </div>
        <div class="form-group text-center mt-4">
            <button type="submit" class="btn btn-primary"><i class="fas fa-check"></i> 등록</button>
            <button type="reset" class="btn btn-warning"><i class="fas fa-undo"></i> 취소</button>
            <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
        </div>
    </form>
</div>

<%@ include file="../layouts/footer.jsp"%>