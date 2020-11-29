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
import org.web3j.tuples.generated.Tuple6;
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
    public static final String BINARY = "608060405234801561001057600080fd5b506108a6806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806316cc76991461004657806361ed5a0a146101c8578063a552ec4a14610399575b600080fd5b6100636004803603602081101561005c57600080fd5b50356103b3565b60405180878152602001866001600160a01b0316815260200180602001806020018560ff16815260200180602001848103845288818151815260200191508051906020019080838360005b838110156100c65781810151838201526020016100ae565b50505050905090810190601f1680156100f35780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b8381101561012657818101518382015260200161010e565b50505050905090810190601f1680156101535780820380516001836020036101000a031916815260200191505b50848103825285518152855160209182019187019080838360005b8381101561018657818101518382015260200161016e565b50505050905090810190601f1680156101b35780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b610397600480360360a08110156101de57600080fd5b6001600160a01b03823516919081019060408101602082013564010000000081111561020957600080fd5b82018360208201111561021b57600080fd5b8035906020019184600183028401116401000000008311171561023d57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561029057600080fd5b8201836020820111156102a257600080fd5b803590602001918460018302840111640100000000831117156102c457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929560ff85351695909490935060408101925060200135905064010000000081111561032257600080fd5b82018360208201111561033457600080fd5b8035906020019184600183028401116401000000008311171561035657600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061065d945050505050565b005b6103a16107aa565b60408051918252519081900360200190f35b600080606080600060606103c56107bb565b600087815481106103d257fe5b906000526020600020906006020160000154600088815481106103f157fe5b6000918252602082206001600690920201015481546001600160a01b0390911691908a90811061041d57fe5b906000526020600020906006020160020160008a8154811061043b57fe5b906000526020600020906006020160030160008b8154811061045957fe5b60009182526020822060046006909202010154815460ff90911691908d90811061047f57fe5b9060005260206000209060060201600501838054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105255780601f106104fa57610100808354040283529160200191610525565b820191906000526020600020905b81548152906001019060200180831161050857829003601f168201915b5050865460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959950889450925084019050828280156105b35780601f10610588576101008083540402835291602001916105b3565b820191906000526020600020905b81548152906001019060200180831161059657829003601f168201915b5050845460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959850869450925084019050828280156106415780601f1061061657610100808354040283529160200191610641565b820191906000526020600020905b81548152906001019060200180831161062457829003601f168201915b5050505050905095509550955095509550955091939550919395565b6106656107bb565b6040805160c0810182524281526001600160a01b0387811660208084019182529383018881526060840188905260ff8716608085015260a084018690526000805460018101825590805284517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563600690920291820190815592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564820180546001600160a01b03191691909516179093555180519394919361074e937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e565019291909101906107dd565b506060820151805161076a9160038401916020909101906107dd565b50608082015160048201805460ff191660ff90921691909117905560a082015180516107a09160058401916020909101906107dd565b5050505050505050565b60006107b46107bb565b5060005490565b337390f8bf6a479f320ead074411a4b0e7944ea8c9c1146107db57600080fd5b565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061081e57805160ff191683800117855561084b565b8280016001018555821561084b579182015b8281111561084b578251825591602001919060010190610830565b5061085792915061085b565b5090565b5b80821115610857576000815560010161085c56fea26469706673582212200c0bc6ab497ccd1d85622fabab807f1ed5fea96f3a8e5b230537db20dc7eb15f64736f6c634300060c0033";

    public static final String FUNC_CREATEORUPDATEPASSPORT = "createOrUpdatePassport";

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

    public RemoteFunctionCall<TransactionReceipt> createOrUpdatePassport(String _owner, String _name, String _surname, BigInteger _mark, String _markl) {
        final Function function = new Function(
                FUNC_CREATEORUPDATEPASSPORT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_surname), 
                new org.web3j.abi.datatypes.generated.Uint8(_mark), 
                new org.web3j.abi.datatypes.Utf8String(_markl)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple6<BigInteger, String, String, String, BigInteger, String>> getHistoryRecord(BigInteger index) {
        final Function function = new Function(FUNC_GETHISTORYRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple6<BigInteger, String, String, String, BigInteger, String>>(function,
                new Callable<Tuple6<BigInteger, String, String, String, BigInteger, String>>() {
                    public Tuple6<BigInteger, String, String, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<BigInteger, String, String, String, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
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
