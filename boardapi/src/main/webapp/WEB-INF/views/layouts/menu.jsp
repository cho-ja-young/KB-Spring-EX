<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .custom-navbar {
        background-color: #a8edea; /* 밝은 민트 색상 */
        background-image: linear-gradient(315deg, #a8edea 0%, #fed6e3 74%);
        color: #333;
    }

    .custom-navbar .navbar-brand,
    .custom-navbar .nav-link {
        color: #333 !important;
        font-weight: 500;
    }

    .custom-navbar .nav-link:hover {
        color: #00796b !important; /* 호버 시 진한 민트 */
    }

    .avatar-sm {
        width: 30px;
        height: 30px;
        border-radius: 50%;
        margin-right: 5px;
    }
</style>

<nav class="navbar navbar-expand-md custom-navbar sticky-top">
    <div class="container-fluid">
        <!-- 브랜드 로고 -->
        <a class="navbar-brand" href="/">
            <i class="fa-solid fa-house"></i> Backend
        </a>

        <!-- 모바일 햄버거 메뉴 -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <!-- 좌측 메뉴 -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/board/list">게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">메뉴2</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">메뉴3</a>
                </li>
            </ul>

            <!-- 우측 메뉴 -->
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <img src="<c:url value='/resources/images/adminImage.jpg' />" class="avatar-sm"/>
                        admin
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fa-solid fa-right-from-bracket"></i> 로그아웃
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
