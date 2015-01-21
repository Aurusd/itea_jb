package itea.lsn13.Wrk_MonitorOnHashMap;

public class MyClass1 {

    static class MyStop extends Thread {
        private Monitor1 s;
        
        public MyStop(Monitor1 s) {
            this.s = s;
        }
        
        public void run() {
            s.stop();
        }
    }

    private static class MyEvents implements IFileEvents1 {
        public void onFileChanged(String path) {
            System.out.println("File changed: " + path);
        }
        
        public void onFileAdded(String path) {
            System.out.println("File added: " + path);
        }
        
        public void onFileDeleted(String path) {
            System.out.println("File deleted: " + path);
        }
    }

    public static void main(String[] args) {
        Monitor1 m = new Monitor1("c:\\temp");
        m.setTimeout(2000);
        m.setEvents(new MyEvents());
        m.start();
        
        Runtime.getRuntime().addShutdownHook(new MyStop(m));
    }
}
