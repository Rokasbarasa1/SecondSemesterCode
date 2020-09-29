package Exercise1;

public class Message {
    private int id;
    private String messageBody;

    public Message(int id, String msg){
        this.id = id;
        this.messageBody = msg;
    }
    public Message(String message){
        this(0, message);
        this.id =((int) (messageBody.hashCode() * Math.random()));
    }

    public int getId() { return id;}
    public void setId(int id) {
        this.id = id;
    }
    public String getBody() {
        return messageBody;
    }

    public String toString(){
        return "id=" + id + ",  "+ messageBody;
    }
}
