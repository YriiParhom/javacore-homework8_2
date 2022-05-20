import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static String name;
    private static String isChild;

    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection accepted \n");
            out.println("Write your name: ");
            name = in.readLine();
            out.println("Are you child? (yes/no)");
            isChild = in.readLine();
            if (isChild.equals("yes") || isChild.equals("нуы")) {
                out.println("Welcome to the kids area, " + name + "! Let's play!");
            } else {
                out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

