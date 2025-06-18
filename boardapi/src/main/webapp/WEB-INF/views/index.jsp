<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="layouts/header.jsp" %>

<style>
    body {
        font-family: 'Helvetica Neue', sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(to right, #e0f7fa, #ffffff);
        min-height: 100vh;
    }

    .main-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 60px 20px;
    }

    h1 {
        color: #00796b;
        margin-bottom: 10px;
    }

    p {
        color: #555;
        font-size: 16px;
        margin-bottom: 40px;
    }

    .kanban-board {
        display: flex;
        gap: 20px;
        flex-wrap: wrap;
        justify-content: center;
    }

    .kanban-card {
        background-color: #ffffff;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        width: 250px;
        height: 160px;
        padding: 20px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        cursor: pointer;
        transition: transform 0.2s, box-shadow 0.3s;
    }

    .kanban-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
    }

    .card-title {
        font-size: 20px;
        font-weight: bold;
        color: #004d40;
    }

    .card-description {
        font-size: 14px;
        color: #666;
        margin-top: 10px;
    }
</style>

<h1>환영합니다.</h1>
<p>토끼개발자조르디의 페이지 입니다</p>

<div class="main-container">
    <h1>🌤️ 오늘의 날씨 서비스</h1>
    <p>아래에서 원하는 기능을 선택하세요</p>

    <div class="kanban-board">
        <div class="kanban-card" onclick="location.href='/weather/seoul'">
            <div class="card-title">날씨 알아보기</div>
            <div class="card-description">도시 이름을 입력해 실시간 날씨를 확인하세요.</div>
        </div>

        <!-- 추가적인 카드가 필요하다면 여기에 더 작성 가능 -->
        <%--
        <div class="kanban-card" onclick="location.href='/news'">
            <div class="card-title">뉴스 보기</div>
            <div class="card-description">오늘의 주요 뉴스를 확인해보세요.</div>
        </div>
        --%>
    </div>
</div>

<%@ include file="layouts/footer.jsp" %>
