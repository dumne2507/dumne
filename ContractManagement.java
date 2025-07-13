
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContractManagement implements ContractOperations {

    private final ArrayList<Contract> contracts = new ArrayList<>();
    private final ArrayList<Client> clients = new ArrayList<>();
    private final ArrayList<ContractType> contractTypes = new ArrayList<>();

    public ContractManagement() {
        initializeData();
    }

    public final void initializeData() {
        // tạo thêm constructor để thêm cai Arraylist
        clients.add(new Client(1, "Vietcombank"));
        clients.add(new Client(2, "FPT Software"));
        clients.add(new Client(3, "Vinamilk"));
        clients.add(new Client(4, "Hoa Phat Group"));
        clients.add(new Client(5, "Mobile World"));
        clients.add(new Client(6, "Masan Group"));
        clients.add(new Client(7, "Vingroup"));
        clients.add(new Client(8, "Viettel"));
        clients.add(new Client(9, "PetroVietnam"));
        clients.add(new Client(10, "SABECO"));

        contractTypes.add(new ContractType(1, "Service"));
        contractTypes.add(new ContractType(2, "Supply"));
        contractTypes.add(new ContractType(3, "Consulting"));
        contractTypes.add(new ContractType(4, "Maintenance"));
        contractTypes.add(new ContractType(5, "Outsourcing"));
        contractTypes.add(new ContractType(6, "Leasing"));
        contractTypes.add(new ContractType(7, "Other"));

    }

    @Override
    public void createContract(Contract contract) {
        if (CheckContractID(contract.getContractID())) {
            System.out.println("Error!!! ContractID already exists!!!");
            return;
        }
        contracts.add(contract);
        System.out.println("Contract added successfully!");

    }

    @Override
    public List<Contract> listAllContracts() {

        System.out.println("\n=== List Contract ===");
        System.out.printf("%-15s %-45s %-15s %-15s %-20s %-20s %-20s\n", "ContractID", "Contract Name", "ClientID",
                "TypeID", "Start Date", "End Date", "Total Value");

        for (int i = 0; i < contracts.size(); i++) {
            Contract c = contracts.get(i);
            System.out.printf("%-15d %-45s %-15d %-15d %-20s %-20s %-20.2f\n",
                    c.getContractID(),
                    c.getContractName(),
                    c.getClientID(),
                    c.getTypeID(),
                    c.getStartDate(),
                    c.getEndDate(),
                    c.getTotalValue());
        }
        return contracts;
    }

    @Override
    public boolean deleteContract(int ContractID) {
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getContractID() == ContractID) {
                contracts.remove(i);
                System.out.println("Delete Successful !!!");
                return true;
            }
        }
        System.out.println("Contract can not found !!!");
        return false;
    }

    @Override
    public List<Contract> findContractsByName(String name) {
        List<Contract> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name Contract:");
        String keyWord = sc.nextLine().toLowerCase();
        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            if (contract.getContractName().toLowerCase().contains(keyWord)) {
                result.add(contract);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No matching contracts found !! ");
        } else {
            System.out.println("Found " + result.size() + " Contracts:");
            for (int i = 0; i < result.size(); i++) {
                Contract nameContracts = result.get(i);
                System.out.println(nameContracts.toString());

            }

        }
        return result;
    }

    @Override
    public void updateContract(int contractID, Contract contract) {

    }

    public void showMenu() {
        System.out.printf("%-35s| %-25s\n", "ClientID", "TypeID");
        System.out.println("-----------------------------------|--------------------------");

        System.out.println("[ID:  1, Name: Vietcombank       ] | [ID: 1, Type: Service     ]");
        System.out.println("[ID:  2, Name: FPT Software      ] | [ID: 2, Type: Supply      ]");
        System.out.println("[ID:  3, Name: Vinamilk          ] | [ID: 3, Type: Consulting  ]");
        System.out.println("[ID:  4, Name: Hoa Phat Group    ] | [ID: 4, Type: Maintenance ]");
        System.out.println("[ID:  5, Name: Mobile World      ] | [ID: 5, Type: Outsourcing ]");
        System.out.println("[ID:  6, Name: Masan Group       ] | [ID: 6, Type: Leasing     ]");
        System.out.println("[ID:  7, Name: Vingroup          ] | [ID: 7, Type: Other       ]");
        System.out.println("[ID:  8, Name: Viettel           ] | ");
        System.out.println("[ID:  9, Name: PetroVietnam      ] | ");
        System.out.println("[ID: 10, Name: SABECO            ] | ");

    }

    // kiểm tra xem CreateContract có bị lặp không
    private boolean CheckContractID(int ContractID) {
        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            if (contract.getContractID() == ContractID) {
                return true;
            }
        }
        return false;
    }

    // kiểm tra xem ClientID Có trùng không
    private boolean CheckClientID(int ClientID) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getClientID() == ClientID) {
                return true;
            }
        }
        return false;
    }

    private boolean CheckContractType(int ContractType) {
        for (ContractType contractType : contractTypes) {
            if (contractType.getTypeID() == ContractType) {
                return true;
            }
        }
        return false;
    }

    public void saveToFile(String filename) {
        // này thuộc về phần kiến thức IO Stream
        try {
            // hàm ghi đè file dữ liệu ( để lưu file)
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                // hàm ghi đè file dữ liệu ( để lưu file)
                for (int i = 0; i < contracts.size(); i++) {
                    Contract c = contracts.get(i);
                    writer.printf("%d %s %d %d %s %s %f\n",
                            c.getContractID(),
                            c.getContractName(),
                            c.getClientID(),
                            c.getTypeID(),
                            c.getStartDate(),
                            c.getEndDate(),
                            c.getTotalValue());
                }
            }
            System.out.println("Contracts saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error sanving file:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContractManagement manager = new ContractManagement();
        manager.showMenu();
        int choice = 0;
        do {
            System.out.println("\n=================================Menu==================================");
            System.out.println("1.Create Contract");
            System.out.println("2.Display All Contract");
            System.out.println("3.Update Contract");
            System.out.println("4.Delete Contract");
            System.out.println("5.Find Contracts By Name");
            System.out.println("6.Save To File");
            System.out.println("7.Exit");

            try {
                System.out.println("Enter the choice:");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("\n===Create Contract===");
                            Contract newContract = new Contract();
                            newContract.input();// gọi phương thức nhập hợp đồng từ class ContractOperations
                            manager.createContract(newContract);
                        } catch (Exception e) {
                            System.out.println("invalid Contract !!!");
                        }
                        break;

                    case 2:
                        System.out.println("\n===Display All Contract===");
                        manager.listAllContracts();
                        break;
                    // bên ContractOperations phai them ham addContract để lưu thông tin

                    case 3:
                        System.out.println("\n===Update Contract===");
                        break;

                    case 4:
                        System.out.println("\n===Delete Contract===");
                        System.out.println("Enter ContractID you want to delete:");
                        int ID = sc.nextInt();
                        manager.deleteContract(ID);
                        break;

                    case 5:
                        System.out.println("\n===Find Contracts By Name===");
                        manager.findContractsByName("");
                        break;

                    case 6:
                        System.out.println("\n===Save to File===");
                        manager.saveToFile("Contract.txt");

                        break;

                    case 7:
                        System.out.println("\nExit");
                        System.out.println("See you again ~_~");
                        break;

                }

            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
                sc.nextLine();
                choice = 0;
            }
        } while (choice < 7);
        sc.close();
    }
}
