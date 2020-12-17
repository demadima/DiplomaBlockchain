package blockchain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class DiplomaService extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610a60806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806316cc769914610046578063a552ec4a1461022e578063a7a62c5d14610248575b600080fd5b6100636004803603602081101561005c57600080fd5b5035610498565b60405180888152602001876001600160a01b0316815260200180602001806020018660ff168152602001806020018060200185810385528a818151815260200191508051906020019080838360005b838110156100ca5781810151838201526020016100b2565b50505050905090810190601f1680156100f75780820380516001836020036101000a031916815260200191505b5085810384528951815289516020918201918b019080838360005b8381101561012a578181015183820152602001610112565b50505050905090810190601f1680156101575780820380516001836020036101000a031916815260200191505b50858103835287518152875160209182019189019080838360005b8381101561018a578181015183820152602001610172565b50505050905090810190601f1680156101b75780820380516001836020036101000a031916815260200191505b50858103825286518152865160209182019188019080838360005b838110156101ea5781810151838201526020016101d2565b50505050905090810190601f1680156102175780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b6102366107f3565b60408051918252519081900360200190f35b610496600480360360c081101561025e57600080fd5b6001600160a01b038235169190810190604081016020820135600160201b81111561028857600080fd5b82018360208201111561029a57600080fd5b803590602001918460018302840111600160201b831117156102bb57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561030d57600080fd5b82018360208201111561031f57600080fd5b803590602001918460018302840111600160201b8311171561034057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929560ff853516959094909350604081019250602001359050600160201b81111561039d57600080fd5b8201836020820111156103af57600080fd5b803590602001918460018302840111600160201b831117156103d057600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561042257600080fd5b82018360208201111561043457600080fd5b803590602001918460018302840111600160201b8311171561045557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610804945050505050565b005b60008060608060006060806104ab610975565b600088815481106104b857fe5b906000526020600020906007020160000154600089815481106104d757fe5b6000918252602082206001600790920201015481546001600160a01b0390911691908b90811061050357fe5b906000526020600020906007020160020160008b8154811061052157fe5b906000526020600020906007020160030160008c8154811061053f57fe5b60009182526020822060046007909202010154815460ff90911691908e90811061056557fe5b906000526020600020906007020160050160008e8154811061058357fe5b9060005260206000209060070201600601848054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106295780601f106105fe57610100808354040283529160200191610629565b820191906000526020600020905b81548152906001019060200180831161060c57829003601f168201915b5050875460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959a50899450925084019050828280156106b75780601f1061068c576101008083540402835291602001916106b7565b820191906000526020600020905b81548152906001019060200180831161069a57829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959950879450925084019050828280156107455780601f1061071a57610100808354040283529160200191610745565b820191906000526020600020905b81548152906001019060200180831161072857829003601f168201915b5050845460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959750869450925084019050828280156107d35780601f106107a8576101008083540402835291602001916107d3565b820191906000526020600020905b8154815290600101906020018083116107b657829003601f168201915b505050505090509650965096509650965096509650919395979092949650565b60006107fd610975565b5060005490565b61080c610975565b6040805160e0810182524281526001600160a01b0388811660208084019182529383018981526060840189905260ff8816608085015260a0840187905260c084018690526000805460018101825590805284517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563600790920291820190815592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564820180546001600160a01b0319169190951617909355518051939491936108fc937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56501929190910190610997565b5060608201518051610918916003840191602090910190610997565b50608082015160048201805460ff191660ff90921691909117905560a0820151805161094e916005840191602090910190610997565b5060c0820151805161096a916006840191602090910190610997565b505050505050505050565b337390f8bf6a479f320ead074411a4b0e7944ea8c9c11461099557600080fd5b565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106109d857805160ff1916838001178555610a05565b82800160010185558215610a05579182015b82811115610a055782518255916020019190600101906109ea565b50610a11929150610a15565b5090565b5b80821115610a115760008155600101610a1656fea2646970667358221220080761000fdebbb81a2ef7d0b4987992b38b716adae84d9da022f16e8f20ea8c64736f6c634300060c0033";

    public static final String FUNC_CREATEORUPDATEDATA = "createOrUpdateData";

    public static final String FUNC_GETHISTORYRECORD = "getHistoryRecord";

    public static final String FUNC_GETHISTORYRECORDLENGTH = "getHistoryRecordLength";

    @Deprecated
    protected DiplomaService(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DiplomaService(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DiplomaService(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DiplomaService(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> createOrUpdateData(String _owner, String _name, String _surname, BigInteger _mark, String _markl, String _hash) {
        final Function function = new Function(
                FUNC_CREATEORUPDATEDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_surname), 
                new org.web3j.abi.datatypes.generated.Uint8(_mark), 
                new org.web3j.abi.datatypes.Utf8String(_markl), 
                new org.web3j.abi.datatypes.Utf8String(_hash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple7<BigInteger, String, String, String, BigInteger, String, String>> getHistoryRecord(BigInteger index) {
        final Function function = new Function(FUNC_GETHISTORYRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple7<BigInteger, String, String, String, BigInteger, String, String>>(function,
                new Callable<Tuple7<BigInteger, String, String, String, BigInteger, String, String>>() {
                    @Override
                    public Tuple7<BigInteger, String, String, String, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<BigInteger, String, String, String, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getHistoryRecordLength() {
        final Function function = new Function(FUNC_GETHISTORYRECORDLENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static DiplomaService load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DiplomaService(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DiplomaService load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DiplomaService(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DiplomaService load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DiplomaService(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DiplomaService load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DiplomaService(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DiplomaService> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DiplomaService.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DiplomaService> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DiplomaService.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DiplomaService> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DiplomaService.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DiplomaService> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DiplomaService.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
