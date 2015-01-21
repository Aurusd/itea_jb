package itea.lsn13.Wrk_MonitorOnHashMap;

public interface IFileEvents1 {
    void onFileChanged(String path);
    void onFileAdded(String path);
    void onFileDeleted(String path);
}
