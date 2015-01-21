package itea.lsn15.Wrk_NET;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    private static
    class MyServer {
        int port;
        Thread thread;

        public MyServer(int port) {
            this.port = port;
        }

        public void stop() {
            thread.interrupt();
        }

        public void start() {
            thread = new Thread() {
                public void run() {
                    try {
                        ServerSocket serverSocket = new ServerSocket(port);
                        while (! isInterrupted()) {
                            System.out.println("Waiting for clients...");
                            try (Socket clientSocket = serverSocket.accept()) {
                                System.out.println("Client connected");
                                System.out.println("Client's local " + clientSocket.getRemoteSocketAddress());
                                System.out.println("Client's remote " + clientSocket.getLocalAddress());
                                String msg = "ServerSocketDemo says Hello!\r\n";
                                clientSocket.getOutputStream().write(msg.getBytes());
                            }
                        }
                        serverSocket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }

    public static void main(String[] args) {
        MyServer s = new MyServer(20000);
        s.start();
    }
}
