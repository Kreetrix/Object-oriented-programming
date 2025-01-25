package Task1;

public class Television {
    private int currentChannel;
    private boolean status;

    void setChannel(int channel) {
        this.currentChannel = channel;
        if (this.currentChannel > 10) {
            this.currentChannel = 1;
        }
    }

    boolean isOn(){
        return this.status;
    }

    void pressOnOff(){
        this.status = !this.status;
    }

    int getChannel(){
        return this.currentChannel;
    }
}


