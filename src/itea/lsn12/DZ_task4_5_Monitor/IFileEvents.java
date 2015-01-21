package itea.lsn12.DZ_task4_5_Monitor;

public interface IFileEvents {
    void onFileAdded(String path);
    void onFileDeleted(String path);
    void onFileChanged(String path);
}
