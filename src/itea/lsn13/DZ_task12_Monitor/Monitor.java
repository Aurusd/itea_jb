package itea.lsn13.DZ_task12_Monitor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Monitor
{
    private class MonitorThread extends Thread {
        
        private String path;
        private int timeout;
        private HashMap<String, Long> prev = new HashMap<String, Long>();
        private HashMap<String, Long> curr = new HashMap<String, Long>();
        private IFileEvents events;
        
        public MonitorThread(String path) {
            this.path = path;
            createHashMap(prev);
        }
        
        public void run() {
            while ( ! isInterrupted()) {
                createHashMap(curr);
                compareMaps(prev, curr);
                prev.clear();
                prev.putAll(curr);
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }
        
        public int getTimeout() {
            return timeout;
        }
        
        public void setTimeout(int value) {
            timeout = value;
        }
        
        public IFileEvents getEvents() {
            return events;
        }
        
        public void setEvents(IFileEvents value) {
            events = value;
        }
        
        private void doFileChanged(String path) {
            if (events != null)
                events.onFileChanged(path);
        }
        
        private void doFileAdded(String path) {
            if (events != null)
                events.onFileAdded(path);
        }
        
        private void doFileDeleted(String path) {
            if (events != null)
                events.onFileDeleted(path);
        }
        
        private void compareMaps(HashMap<String, Long> m1, HashMap<String, Long> m2) {
            Set<String> keys = m1.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext())
            {
                String path = it.next();
                
                if (m2.containsKey(path)) {
                    long date1 = m1.get(path);
                    long date2 = m2.get(path);
                    
                    if (date2 > date1)
                        doFileChanged(path);

                    if (System.currentTimeMillis() - date2 > 30000) {
                        File file = new File(path);
                        file.delete();
                    }
                } else {
                    doFileDeleted(path);
                }
            }
            
            keys = m2.keySet();
            it = keys.iterator();
            while (it.hasNext())
            {
                String path = it.next();
                
                if ( ! m1.containsKey(path))
                    doFileAdded(path);
            }
        }
        
        private void createHashMap(HashMap<String, Long> output) {
            try {
                File file = new File(path);
                File[] list = file.listFiles();
                
                output.clear();
                for (File f : list) {
                    output.put(f.getCanonicalPath(), new Long(f.lastModified()));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // ---------------------------------- //

    private String path;
    private MonitorThread thread;
    private IFileEvents events;
    private int timeout = 1000;
    
    public Monitor(String path) {
        this.path = path;
    }
    
    public void start() {
        thread = new MonitorThread(path);
        thread.setTimeout(timeout);
        thread.setEvents(events);
        thread.start();
    }
    
    public void stop() {
        thread.interrupt();
    }
    
    public int getTimeout() {
        return timeout;
    }
        
    public void setTimeout(int value) {
        timeout = value;
    }
        
    public IFileEvents getEvents() {
        return events;
    }
        
    public void setEvents(IFileEvents value) {
        events = value;
    }
}
