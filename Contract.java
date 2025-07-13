
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Contract {

    private int contractID;
    private int clientID;
    private int typeID;
    private String contractName;
    private String startDate;
    private String endDate;
    private float totalValue;

    public Contract() {
    }

    public Contract(int contractID, int clientID, int typeID, String contractName, String startDate, String endDate, float totalValue) {
        this.contractID = contractID;
        this.clientID = clientID;
        this.typeID = typeID;
        this.contractName = contractName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalValue = totalValue;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    private LocalDate validateDate(String dateStr, String dataType) {
        //"..." là định dạng ngày tháng năm để in ra màn hình
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return date;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid" + dataType + "format.YYYY-MM-YY");
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the contract ID:");
            contractID = sc.nextInt();
            sc.nextLine();

            if (contractID < 0) {
                throw new IllegalArgumentException("Contract ID must be > 0 ");
            }

            System.out.println("Enter the client ID:");
            clientID = sc.nextInt();
            sc.nextLine();
            if (clientID < 0 || clientID > 10) {
                throw new IllegalArgumentException("Client ID must be > 0 || < 10");
            }

            System.out.println("Enter the Type ID:");
            typeID = sc.nextInt();
            sc.nextLine();
            if (typeID < 0 || typeID > 10) {
                throw new IllegalArgumentException("Type ID must be > 0 || <10");
            }

            System.out.println("Enter the Contract Name:");
            contractName = sc.nextLine();
            if (contractName == null || contractName.trim().isEmpty()) {
                throw new IllegalArgumentException("Contract name cannot empty or null !! ");
            }

            // nhập ngày bắt đầu và kiểm tra nó có đúng định dạng không
            // hàm dùng để nhập ngày và so sanh chuỗi ngày
            System.out.println("Enter the StartDay (YYYY/MM/DD):");
            String startDateInput = sc.nextLine().trim();
            LocalDate StartDate = validateDate(startDateInput, "startDate");

            System.out.println("Enter the EndDate (YYY/MMM/DDD):");
            String endDateInput = sc.nextLine().trim();
            LocalDate EndDate = validateDate(endDateInput, "endDate");
            if (!EndDate.isAfter(StartDate)) {
                throw new IllegalArgumentException("EndDAte must be after StartDate");
            }
            // dùng để nhập dữ liệu từ người dùng nhé
            this.startDate = startDateInput;
            this.endDate = endDateInput;

            System.out.println("Enter the total value:");
            totalValue = sc.nextFloat();
            sc.nextLine();
            if (totalValue < 0) {
                throw new IllegalArgumentException("total Value must be > 0 !! ");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;

        } catch (Exception e) {
            // dùng để bắt lỗi ngoài ý muốn ở int hay float
            // ví dụ dùng hàm String nhưng  nhập từ bàn phím là int hay float sẽ báo lỗi này 
            // dòng này không cần cx được 
            System.out.println("An unexpected error occurred:" + e.getMessage());
            throw e;
        }
    }

    public int getContractID() {
        return contractID;
    }

    public int getClientID() {
        return clientID;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getContractName() {
        return contractName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public float getTotalValue() {
        return totalValue;
    }

    @Override
    public String toString() {
        return String.format("contractID: %d  \nclientID:%d, typeID: %d  \ncontractName: %s  \nstartDate:%s \nendDate:%s \ntotalValue:%f ", contractID, clientID, typeID, contractName, startDate, endDate, totalValue);
    }
    // dòng chạy thử để kiểm tra xem có lỗi không

//    public static void main(String[] args) {
//        Contract contract = new Contract();
//        contract.input();
//        System.out.println(contract.toString());
//    }
}
