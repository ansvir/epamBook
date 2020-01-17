package part.two.chapter.seven;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int userId = 0;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8071);
            while (true) {
                Socket socket = server.accept();
                userId++;
                System.out.println("Connected to user \"" + userId + "\" on " + socket.getInetAddress().getHostAddress());
                ServerThread st = new ServerThread(socket, userId);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
