package itea.lsn12.DZ_task4_5_Monitor;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Monitor {

    private String path;
    private int timeout;
    private LinkedList<String> prevF = new LinkedList<String>();
    private LinkedList<Date> prevT = new LinkedList<Date>();
    private LinkedList<String> currF = new LinkedList<String>();
    private LinkedList<Date> currT = new LinkedList<Date>();
    private IFileEvents events;

    public Monitor(String path) {
        this.path = path;
        createArray(prevF, prevT);
    }

    public void start() {
        while (true) {
            createArray(currF, currT);
            compareArrays(prevF, currF, prevT, currT);
            prevF.clear();
            prevT.clear();
            prevF.addAll(currF);
            prevT.addAll(currT);

            System.out.println("Waiting...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public void setTimeout(int value) {
        timeout = value;
    }

    public void setEvents(IFileEvents value) {
        events = value;
    }

    private void doFileAdded(String path) {
        if (events != null)
            events.onFileAdded(path);
    }

    private void doFileDeleted(String path) {
        if (events != null)
            events.onFileDeleted(path);
    }

    private void doFileChanged(String path) {
        if (events != null)
            events.onFileChanged(path);
    }

    private void compareArrays(LinkedList<String> m1, LinkedList<String> m2, LinkedList<Date> t1, LinkedList<Date> t2) {
        Iterator<String> it = m1.iterator();
        String path;

        while (it.hasNext()) {
            path = it.next();

            if ( ! m2.contains(path))
                doFileDeleted(path);
        }

        it = m2.iterator();
        while (it.hasNext()) {
            path = it.next();

            if ( ! m1.contains(path))
                doFileAdded(path);
        }

        Iterator<Date> itt = t1.iterator();
        it = m1.iterator();
        Date pathT;
        while (itt.hasNext()) {
            path = it.next();
            pathT = itt.next();

            if ( ! t2.contains(pathT))
                doFileChanged(path);
        }
    }

    private void createArray(LinkedList<String> outFile, LinkedList<Date> outTime) {
        try {
            File file = new File(path);
            File[] list = file.listFiles();

            outFile.clear();
            outTime.clear();
            for (File f : list) {
                outFile.add(f.getCanonicalPath());
                outTime.add(new Date(f.lastModified()));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
