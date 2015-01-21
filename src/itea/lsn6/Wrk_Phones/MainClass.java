package itea.lsn6.Wrk_Phones;

public class MainClass {

    protected static PhoneList phL = new PhoneList();

    public static void main(String[] args) {
        // Phone p = new Phone(); ошибка т.к. класс абстрактный

        Nokia3310 nokia = new Nokia3310();
        phL.add(nokia);
        System.out.println("Nokia3310 screen size: " + nokia.getScreenSize());
        System.out.println("Nokia3310 has a number " + nokia.getNumber());
        nokia.call("444-44-44");
        searchPh("444-44-44");
        nokia.sendSMS("567-78-89", "TEXT MESSAGE");
        System.out.println("Nokia3310 does " + nokia.getCountCall() + " calls");

        System.out.println("----------------------------------");

        IPhone iphone = new IPhone();
        phL.add(iphone);
        System.out.println("IPhone screen size: " + iphone.getScreenSize());
        System.out.println("IPhone has a number " + iphone.getNumber());
        iphone.call("444-44-44");
        searchPh("444-44-44");

        iphone.sendSMS("567-78-89", "TEXT MESSAGE");
        System.out.println("IPhone does " + iphone.getCountCall() + " calls");

        System.out.println("----------------------------------");

        IPhone5 iphone5 = new IPhone5();
        phL.add(iphone5);
        System.out.println("IPhone5 screen size: " + iphone5.getScreenSize());
        System.out.println("IPhone5 has a number " + iphone5.getNumber());
        iphone5.call("Nokia3310_number");
        searchPh("Nokia3310_number");

        iphone5.sendSMS("567-78-89", "TEXT MESSAGE");
        System.out.println("IPhone5 does " + iphone5.getCountCall() + " calls");

        System.out.println("----------------------------------");

        SamsungS4 ss4 = new SamsungS4();
        phL.add(ss4);
        System.out.println("SamsungS4 screen size: " + ss4.getScreenSize());
        System.out.println("SamsungS4 has a number " + ss4.getNumber());
        ss4.sendSMS("567-78-89", "text message");
        ss4.call("IPhone5_number");
        searchPh("IPhone5_number");

        System.out.println("SamsungS4 does " + ss4.getCountCall() + " calls and " + ss4.getCountSMS() + " SMS");
    }

    static void searchPh(String nn) {
        int k = phL.findNumber(nn);
        if (k >= 0 && k < phL.getListLength())
            phL.get(k).answer();
        else
            System.out.println("Телефон с таким номером вне зоны доступа.");
    }
}