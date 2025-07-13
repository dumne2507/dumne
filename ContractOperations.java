
import java.util.List;

public interface ContractOperations {
    public void createContract(Contract contract);

    public void updateContract(int contractID, Contract contract);

    public boolean deleteContract(int ContractID);

    List<Contract> findContractsByName(String name);

    List<Contract> listAllContracts();
}
