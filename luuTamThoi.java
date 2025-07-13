//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//public class ContractOperations {
//
//    private final ArrayList<Contract> contracts;
//    private final ArrayList<Client> clients;
//    private final ArrayList<ContractType> contractTypes;
//
//    public ContractOperations(ArrayList<Contract> contracts, ArrayList<Client> clients, ArrayList<ContractType> contractTypes) {
//        this.contracts = contracts;
//        this.clients = clients;
//        this.contractTypes = contractTypes;
//    }
//
//    public void createContract(Contract contract) {
//        contracts.add(contract);
//        // máy sẽ tự động chuyển sang dạng for loop
//        // đổi về for dạng C cho dễ hiểu để chạy
//        // bước kiểm tra ID trước
//        for (int i = 0; i < contracts.size(); i++) {
//            if (contracts.get(i).getContractID() == contract.getContractID()) {
//                System.out.println("Contract ID already exists.");
//                return; // tìm thấy được thì thoát khỏi vòng lặp
//            }
//        }
//
//        // kiểm tra ClientID xem có tồn tại trong hợp đồng không
//        for (int i = 0; i < contracts.size(); i++) {
//            if (contracts.get(i).getClientID() == contract.getClientID()) {
//                break;
//            } else {
//                System.out.println("Invalid Client Id");
//                return; // thoát khỏi vòng lặp luôn
//            }
//            // kiểm tra xem hợp đồng đó có thuộc trong list hợp đồng đó không
//            // nếu có thì lưu tiếp thông tin 
//            // còn nếu không dừng thoát khỏi vòng lặp để tránh gây lỗi
//        }
//
//        // kiểm tra TypeID có thuộc danh sách hợp đồng hay không
//        for (int i = 0; i < contracts.size(); i++) {
//            if (contracts.get(i).getTypeID() == contract.getTypeID()) {
//                break; // tìm thấy thông tin trong list thì thoát khỏi vòng lặp
//            } else {
//                System.out.println("Contract TypeID alreadt exists.");
//            }
//            return;
//        }
//
//    }
//
//    public void displayContract() {
//
//        System.out.println("\n=== List Contract ===");
//        System.out.printf("%-12s %-20s %-10s %-10s %-12s %-12s %-12s\n", "ContractID", "Contract Name", "ClientID", "TypeID", "Start Date", "End Date", "Total Value");
//
//        for (int i = 0; i < contracts.size(); i++) {
//            Contract c = contracts.get(i);
//            System.out.printf("%-12d %-20s %-10d %-10d %-12s %-12s %-12.2f\n",
//                    c.getContractID(),
//                    c.getContractName(),
//                    c.getClientID(),
//                    c.getTypeID(),
//                    c.getStartDate(),
//                    c.getEndDate(),
//                    c.getTotalValue()
//            );
//        }
//
//    }
//
//    public void displaySampleData() {
//        // Hiển thị danh sách khách hàng
//        System.out.println("\n===The Client List===");
//        for (int i = 0; i < clients.size(); i++) {
//            Client c = clients.get(i);
//            System.out.println(c.getClientID() + " " + c.getClientName());
//        }
//        //hiện thị danh sách hợp đồng
//        System.out.println("\n===The List Contract===");
//        for (int i = 0; i < contractTypes.size(); i++) {
//            ContractType t = contractTypes.get(i);
//            System.out.println(t.getTypeID() + " " + t.getTypeName());
//        }
//
//    }
//
//    public void deleteContract() {
//        contracts.clear();
//        System.out.println("Contract deleted successfully!");
//
//    }
//
//    public void saveToFile(String filename) {
//        // này thuộc về phần kiến thức IO Stream
//        try {
//            // hàm ghi đè file dữ liệu ( để lưu file)
//            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
//                // hàm ghi đè file dữ liệu ( để lưu file)
//                for (int i = 0; i < contracts.size(); i++) {
//                    Contract c = contracts.get(i);
//                    writer.printf("%d %s %d %d %s %s %f\n",
//                            c.getContractID(),
//                            c.getContractName(),
//                            c.getClientID(),
//                            c.getTypeID(),
//                            c.getStartDate(),
//                            c.getEndDate(),
//                            c.getTotalValue()
//                    );
//                }
//            }
//            System.out.println("Contracts saved to file successfully!");
//        } catch (IOException e) {
//            System.out.println("Error saving file:" + e.getMessage());
//        }
//    }
//}
