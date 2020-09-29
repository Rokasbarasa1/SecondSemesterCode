package model;

public class ModelFactory {

    private ChatModel chatModel;

    public ChatModel getChatModel() {
        if(chatModel == null)
            chatModel = new ChatModelManager();
        return chatModel;
    }
}
