package itea.lsn13.DZ_task12_Monitor;

public interface IFileEvents {
    void onFileChanged(String path);
    void onFileAdded(String path);
    void onFileDeleted(String path);
}
