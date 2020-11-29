package blockchain;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

public class AddData {
	 // Contact address been taken from deployed contract
    private static final String CONTRACT_ADDRESS = "0x254dffcd3277C0b1660F6d42EFbB754edaBAbC2B";
    private static final String ADMIN_PRIVATE_KEY = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
    private static final String JOHN_ACCOUNT = "0xFFcf8FDEE72ac11b5c542428B35EEF5769C409f0";
    private static final String JOHN_PRIVATE_KEY = "0x6cbed15c793ce57650b9877cf6fa156fbef513c4e6134f022a85b1ffdd59b2a1";
    
    public void addBlock(Block block) {
    	//Web3j client initialization
  	  Web3j web3 = Web3j.build(new HttpService());
  	  ContractGasProvider gasProvider;
  	  gasProvider = new DefaultGasProvider();
  	  
  	//Accessing to passport service as admin and creating new passport for JOHN_ACCOUNT
	  Credentials credentials = Credentials.create(ADMIN_PRIVATE_KEY);
	  DiplomaService adminPassportService = DiplomaService.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

	  try {
		adminPassportService.createOrUpdatePassport(JOHN_ACCOUNT, block.getName(), block.getSurname(), BigInteger.valueOf(block.getMark()), block.getMarkl()).send();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    }
    
}
