package itea.lsn6.Wrk_Phones;

public class SamsungS4 extends Phone {

    public SamsungS4() {
        System.out.println("SamsungS4 constructor");
        number = "SamsungS4_number";
        touch = true;
        hasWifi = true;
        screenSize = 5;
    }

    @Override
    final public void call(String number) {
        super.call(number);
        System.out.println("SamsungS4 class is calling " + number);
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("SamsungS4 class is sending sms: Hello, " + message + " to " + number);
        countSMS++;
    }

    @Override
    public void answer() {
        System.out.println("SamsungS4 is answering!");
    }
}
