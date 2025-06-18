<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>오늘의 날씨</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Helvetica Neue', sans-serif;
            background: url("/resources/images/weather_bg1.jpg") no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .weather-container {
            background-color: rgba(255, 255, 255, 0.85);
            padding: 30px 40px;
            border-radius: 20px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 90%;
            max-width: 700px;
            backdrop-filter: blur(5px);
        }

        .city-name {
            font-size: 30px;
            font-weight: bold;
            color: #00796b;
            margin-bottom: 15px;
        }

        .weather-description {
            font-size: 18px;
            color: #444;
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
            margin-bottom: 25px;
        }

        .weather-icon {
            width: 50px;
        }

        .info-box {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 15px;
        }

        .info-item {
            background-color: #e0f2f1;
            border-radius: 12px;
            padding: 15px;
            flex: 1 1 30%;
            min-width: 130px;
            box-sizing: border-box;
        }

        .info-title {
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
        }

        .info-value {
            font-size: 20px;
            font-weight: bold;
            color: #333;
        }

        .search-box {
            margin-top: 25px;
        }

        .search-box input {
            padding: 10px;
            border: none;
            border-radius: 8px;
            width: 65%;
            font-size: 14px;
        }

        .search-box button {
            padding: 10px 15px;
            border: none;
            border-radius: 8px;
            background-color: #00796b;
            color: white;
            font-size: 14px;
            cursor: pointer;
            margin-left: 8px;
        }

        .search-box button:hover {
            background-color: #004d40;
        }

        .home-button {
            margin-top: 20px;
        }

        .home-button button {
            padding: 10px 20px;
            background-color: #004d40;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }

        .home-button button:hover {
            background-color: #002f2f;
        }
    </style>
    <script>
        function searchWeather() {
            const city = document.getElementById("cityInput").value.trim();
            if (city) {
                location.href = "/weather/" + encodeURIComponent(city);
            }
        }

        function goHome() {
            location.href = "/";
        }
    </script>
</head>
<body>
<div class="weather-container">
    <div class="city-name">${city}</div>

    <div class="weather-description">
        <span>오늘의 날씨: ${weather.weather[0].description}</span>
        <img class="weather-icon" src="${iconUrl}" alt="Weather Icon" />
    </div>

    <div class="info-box">
        <div class="info-item">
            <div class="info-title">🌡️ 현재 온도</div>
            <div class="info-value">${weather.main.temp}°C</div>
        </div>
        <div class="info-item">
            <div class="info-title">💦 습도</div>
            <div class="info-value">${weather.main.humidity}%</div>
        </div>
        <div class="info-item">
            <div class="info-title">🥶 체감 온도</div>
            <div class="info-value">${weather.main.feels_like}°C</div>
        </div>
        <div class="info-item">
            <div class="info-title">🌡️ 최저 / 최고</div>
            <div class="info-value">${weather.main.temp_min}°C / ${weather.main.temp_max}°C</div>
        </div>
        <div class="info-item">
            <div class="info-title">🔽 기압</div>
            <div class="info-value">${weather.main.pressure} hPa</div>
        </div>
        <div class="info-item">
            <div class="info-title">🌬️ 풍속</div>
            <div class="info-value">${weather.wind.speed} m/s</div>
        </div>
    </div>

    <div class="search-box">
        <input type="text" id="cityInput" placeholder="도시를 입력하세요 (예: seoul)" />
        <button onclick="searchWeather()">검색</button>
    </div>

    <div class="home-button">
        <button onclick="goHome()">🏠 홈으로</button>
    </div>
</div>
</body>
</html>
