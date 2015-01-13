package itea.lsn12.Wrk_Monitor;

public interface IFileEvents {
    void onFileAdded(String path);
    void onFileDeleted(String path);
}
