package org.example;

import java.util.ArrayList;
import java.util.List;

public class MessagesDB {
    private List<String> messages;
    private List<Integer> usersReadedMessagesCount;

    public MessagesDB(){
        messages = new ArrayList<>();
        usersReadedMessagesCount = new ArrayList<>();
    }

    public void addANewUser() {
        usersReadedMessagesCount.add(0);
    }

    public void addNewMessage(String message) {
        messages.add(message);
    }

    public String getLastMessages(int userId) {
        int size = messages.size();

        int messagesCount = usersReadedMessagesCount.get(userId);

        System.out.println("Messages: " + size + "\n" + "I will read: " + messagesCount + "\n");

        StringBuilder ans = new StringBuilder();

        for(int i = Math.max(messagesCount - 1, 0); i < size; i++) {
            ans.append(messages.get(i) + " ");
        }

        usersReadedMessagesCount.set(userId, size);
        return ans.toString();
    }
}
