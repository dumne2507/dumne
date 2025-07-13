
import java.util.Scanner;

public class Client {

    int clientID;
    String clientName;

    public Client() {
    }

    public Client(int clientID, String clientName) {
        this.clientID = clientID;
        this.clientName = clientName;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the clientID:");
            clientID = sc.nextInt();
            sc.nextLine();
            if (clientID < 0 || clientID > 10) {
                throw new IllegalArgumentException("clientID must be >0 and <10");
            }

            System.out.println("Enter the clientName:");
            clientName = sc.nextLine();
            if (clientName == null || clientName.trim().isEmpty()) {
                throw new IllegalArgumentException("ClientName cannot null or empty!!!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error:" + e.getMessage());

        } catch (Exception e) {
            System.out.println("Invalid input.Please try again !!!");
            sc.nextLine();
        }

    }

    @Override
    public String toString() {
        return String.format("Client Id: %d \nClient Name: %s", clientID, clientName);
    }
    // hàm này dùng để chạy thử thooi !!!!
//    public static void main(String[] args) {
//        Client client = new Client();
//        client.input();
//        System.out.println(client.toString());
//    }
}
