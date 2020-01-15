package part.two.chapter.seven;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",8071);
                BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream os = new PrintStream(socket.getOutputStream())) {
            String input;
            String response;
            Scanner scanner;
            do {
                response = is.readLine();
                if (response.equals("\\4")) {
                    break;
                }
                System.out.println(response);
                scanner = new Scanner(System.in);
                input = scanner.nextLine();
                os.println(input);
            } while (true);
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
