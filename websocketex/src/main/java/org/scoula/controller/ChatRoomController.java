package org.scoula.controller;

import org.scoula.domain.ChatRoom;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/chat-rooms")
public class ChatRoomController {

    private final Map<String, ChatRoom> chatRoomMap = new LinkedHashMap<>();

    @PostMapping
    public ChatRoom createRoom(@RequestParam String name, @RequestParam String headCount) {
        ChatRoom room = ChatRoom.create(name, headCount);
        chatRoomMap.put(room.getId(), room);
        return room;
    }

    @GetMapping
    public List<ChatRoom> getAllRooms() {
        return new ArrayList<>(chatRoomMap.values());
    }
}
