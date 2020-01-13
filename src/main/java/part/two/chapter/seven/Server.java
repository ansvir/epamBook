package part.two.chapter.seven;

import part.one.chapter.four.PassengerRailroadCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8071);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected to "+socket.getInetAddress().getHostAddress());
                ServerThread st = new ServerThread(socket);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
