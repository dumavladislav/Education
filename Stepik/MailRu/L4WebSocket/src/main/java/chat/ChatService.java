package chat;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatService {

    private final Set<ChatWebSocket> webSockets;

    public ChatService(){
        webSockets = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }

    public void sendMessage(String data){
        for(ChatWebSocket user: webSockets){
            user.sendString(data);
        }
    }

    public void add(ChatWebSocket user){
        webSockets.add(user);
    }

    public void remove(ChatWebSocket user){
        webSockets.remove(user);
    }

}
