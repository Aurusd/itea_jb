package itea.lsn6.Wrk_Phones;

public abstract class Phone {

    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;
    protected int countCall;
    protected int countSMS;
    protected String number;

    public Phone() {
        System.out.println("Phone constructor");
        number = "";
        countCall = 0;
        countSMS = 0;
    }

    public boolean isTouch() {
        return touch;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public String getNumber() {
        return number;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getCountCall() {
        return countCall;
    }

    public int getCountSMS() {
        return countSMS;
    }

    public void call(String number) {
        System.out.println("Phone class is calling " + number);
        countCall++;
    }

    public void answer() {
        System.out.println("Phone class is answering!");
    }

    public abstract void sendSMS(String number, String message);
}
