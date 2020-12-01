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

public class BlockchainController {
	// Contact address been taken from deployed contract
	private static final String CONTRACT_ADDRESS = "0xe78A0F7E598Cc8b0Bb87894B0F60dD2a88d6a8Ab";
	private static final String ADMIN_PRIVATE_KEY = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
	private static final String JOHN_ACCOUNT = "0xFFcf8FDEE72ac11b5c542428B35EEF5769C409f0";
	private static final String JOHN_PRIVATE_KEY = "0x6cbed15c793ce57650b9877cf6fa156fbef513c4e6134f022a85b1ffdd59b2a1";

	private Web3j web3;
	private ContractGasProvider gasProvider;
	private Credentials credentials;
	private DiplomaService adminService;


	private void initialization() {
		// Web3j client initialization
		web3 = Web3j.build(new HttpService());
		gasProvider = new DefaultGasProvider();

		// Accessing to service as admin and creating new block
		credentials = Credentials.create(ADMIN_PRIVATE_KEY);
		adminService = DiplomaService.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);
	}

	public void addBlock(Block block) {
		// initialization
		initialization();

		try {
			adminService.createOrUpdatePassport(JOHN_ACCOUNT, block.getName(), block.getSurname(),
					BigInteger.valueOf(block.getMark()), block.getMarkl()).send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Block> showBlocks() {
		// initializationv
		initialization();

		ArrayList<Block> blocks = new ArrayList<Block>();
		
		try {
			for (int i = 0; i < adminService.getHistoryRecordLength().send().intValue(); i++) {
				Tuple6<BigInteger, String, String, String, BigInteger, String> record = adminService
						.getHistoryRecord(BigInteger.valueOf(i)).send();

				Block block = new Block(Instant.ofEpochSecond(record.component1().longValue()),record.component3(), record.component4(), record.component5().intValue(),
						record.component6());
				blocks.add(block);
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blocks;
	}

}
