package esprit.tn.farmily.messages;

public class MyMessageData {
    private String SenderName ;
    private String SenderMessage ;
    private Integer SenderPhoto;

    public MyMessageData(String senderName, String senderMessage, Integer senderPhoto) {
        this.SenderName = senderName;
        this.SenderMessage = senderMessage;
        this.SenderPhoto = senderPhoto;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String senderName) {
        SenderName = senderName;
    }

    public String getSenderMessage() {
        return SenderMessage;
    }

    public void setSenderMessage(String senderMessage) {
        SenderMessage = senderMessage;
    }

    public Integer getSenderPhoto() {
        return SenderPhoto;
    }

    public void setSenderPhoto(Integer senderPhoto) {
        SenderPhoto = senderPhoto;
    }
}
