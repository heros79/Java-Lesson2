package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8082)) {
            System.out.println("Server start");
            socket = serverSocket.accept();
            System.out.println("Client join");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String message = dis.readUTF();
                if (message.equalsIgnoreCase("/finish")) {
                    dos.writeUTF(message);
                    break;
                }
                dos.writeUTF("Echo " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
