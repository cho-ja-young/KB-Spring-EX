let stompClient = null;
let roomId = null;

function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

function connectToRoom(roomId) {
    stompClient = new StompJs.Client({
        brokerURL: 'ws://localhost:8080/chat-app',
        onConnect: () => {
            stompClient.subscribe(`/topic/chat/${roomId}`, (msg) => {
                const message = JSON.parse(msg.body);
                showMessage(message.name, message.content);
            });
        }
    });
    stompClient.activate();
}

function showMessage(name, content) {
    const ul = document.getElementById('chat-messages');
    const li = document.createElement('li');
    li.className = (name === document.getElementById('name').value) ? 'mine' : 'theirs';
    li.innerHTML = `<span class="name">${name}</span><div class="bubble">${content}</div>`;
    ul.appendChild(li);
    ul.scrollTop = ul.scrollHeight;
}

function sendMessage() {
    const name = document.getElementById('name').value;
    const content = document.getElementById('content').value;
    if (name && content) {
        stompClient.publish({
            destination: `/app/chat/${roomId}`,
            body: JSON.stringify({ name, content })
        });
        document.getElementById('content').value = '';
    }
}

document.getElementById('send').addEventListener('click', sendMessage);

window.addEventListener('DOMContentLoaded', () => {
    roomId = getQueryParam('roomId');
    const roomName = getQueryParam('roomName');
    document.getElementById('room-title').textContent = decodeURIComponent(roomName || '채팅방');
    connectToRoom(roomId);
});
