package itea.lsn13.DZ_task12_Monitor;

/**
 * Изменить проект монитора так, чтобы "старые" файлы автоматически удалялись.
 */

public class MyClass {

    static class MyStop extends Thread {
        private Monitor s;
        
        public MyStop(Monitor s) {
            this.s = s;
        }
        
        public void run() {
            s.stop();
        }
    }

    private static class MyEvents implements IFileEvents {
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
        Monitor m = new Monitor("c:\\temp");
        m.setTimeout(2000);
        m.setEvents(new MyEvents());
        m.start();
        
        Runtime.getRuntime().addShutdownHook(new MyStop(m));
    }
}
