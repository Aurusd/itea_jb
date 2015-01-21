package itea.lsn6.Wrk_Phones;

public class IPhone extends Phone {

    public IPhone() {
        System.out.println("IPhone constructor");
        number = "IPhone_number";
        touch = true;
        hasWifi = true;
        screenSize = 3;
    }

    @Override
    final public void call(String number) {
        super.call(number);
        System.out.println("IPhone class is calling " + number);
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("IPhone class is sending sms: " + message + " to " + number);
    }

    @Override
    public void answer() {
        System.out.println("IPhone is answering!");
    }
}