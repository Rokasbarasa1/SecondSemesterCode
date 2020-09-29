package viewmodel;

import model.ModelFactory;

public class ViewModelFactory {

    private ChatVM chatVM;

    private ModelFactory modelFactory;
    private LoginVM loginVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ChatVM getChatVM() {
        if(chatVM == null) chatVM = new ChatVM(modelFactory.getChatModel());
        return chatVM;
    }

    public LoginVM getLoginVM() {
        if(loginVM == null) loginVM = new LoginVM(modelFactory.getChatModel());
        return loginVM;
    }
}
