// ChatRoom.java
package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
    private String id;
    private String name;
    private String headCount;

    public static ChatRoom create(String name, String headCount) {
        return new ChatRoom(UUID.randomUUID().toString(), name, headCount);
    }
}
