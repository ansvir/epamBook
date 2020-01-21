package part.two.chapter.thirteen;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",8071);
                BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream os = new PrintStream(socket.getOutputStream())) {
            String input;
            Scanner scanner;
            while (true) {
                StringBuilder response = new StringBuilder();
                String tmp;
                while ((tmp = is.readLine()) != null && !"".equals(tmp)) {
                    response.append(tmp).append("\n");
                }
                if (response.length()>0) {
                    response.deleteCharAt(response.length() - 1); // delete new line character
                }
                if (response.toString().equals("exit")) {
                    break;
                }
                System.out.println(response.toString());
                scanner = new Scanner(System.in);
                input = scanner.nextLine();
                os.println(input);
                os.flush();
            }
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
