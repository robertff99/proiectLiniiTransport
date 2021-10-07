package client;

public class ClientMessage {

    public static String sendMsg(String msg){
        Client.sendMsgToServer(msg);
        return msg;
    }
}
