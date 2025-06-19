function loadRooms() {
    fetch('/chat-rooms')
        .then(res => res.json())
        .then(data => {
            const ul = document.getElementById('room-list');
            ul.innerHTML = '';
            data.forEach(room => {
                const li = document.createElement('li');
                li.innerHTML = `<span class="room-name">${room.name}</span> <span class="count">(${room.headCount}명)</span>`;
                li.onclick = () => {
                    console.log("✅ 채팅방 클릭됨!");
                    console.log("room.id:", room.id);
                    console.log("room.name:", room.name);

                    const url = `/chat.html?roomId=${room.id}&roomName=${encodeURIComponent(room.name)}`;
                    console.log("➡ 이동할 URL:", url);

                    window.location.href = url;
                };
                ul.appendChild(li);
            });
        });
}

document.getElementById('create-room-form').addEventListener('submit', function (e) {
    e.preventDefault();
    const name = document.getElementById('roomName').value;
    const headCount = document.getElementById('headCount').value;
    fetch(`/chat-rooms?name=${name}&headCount=${headCount}`, { method: 'POST' })
        .then(() => {
            document.getElementById('roomName').value = '';
            document.getElementById('headCount').value = '';
            loadRooms();
        });
});

window.addEventListener('DOMContentLoaded', () => {
    loadRooms();
});
