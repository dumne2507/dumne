
import java.util.Scanner;

public class ContractType {

    int typeID;
    String typeName;

    public ContractType() {
    }

    public ContractType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the typeID:");
            typeID = sc.nextInt();
            sc.nextLine();
            if (typeID < 0) {
                throw new IllegalArgumentException("typeID must be > 0 !!");
            }

            System.out.println("Enter the Type Name:");
            typeName = sc.nextLine();
            if (typeName == null || typeName.trim().isEmpty()) {
                throw new IllegalArgumentException("typeName cannot empty or null !!!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error:" + e.getMessage());
        }

    }
    // chạy test file
//    public static void main(String[] args) {
//        ContractType contracttype = new ContractType();
//        contracttype.input();
//        System.out.println(contracttype.toString());
//    }

    @Override
    public String toString() {
        return String.format("type ID: %d \ntype Name: %s", typeID, typeName);
    }
}
