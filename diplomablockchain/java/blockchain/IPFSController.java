package blockchain;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;

public class IPFSController {
	private IPFS ipfs;
	private void initialization() {
		ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
		try {
			ipfs.refs.local();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String creatHash(String path) {
		// initialization
		initialization();

		NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File(path));
		MerkleNode addResult = null;
		try {
			addResult = ipfs.add(file).get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return addResult.toString();
	}

	
}
