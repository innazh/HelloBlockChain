package main;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HelloChain {
	/*
	 * Each block doesn’t just contain the hash of the block before it, 
	 * but its own hash is in part, calculated from the previous 
	 * hash.*/
	
	/* Calculating and comparing the hashes allow us to see if a 
	 * blockchain is invalid.
		What does this mean ?
		Changing any data in this list, will change the signature 
		and break the chain.*/
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int difficulty = 6;//up to 6
	
	public static void main(String[] args) {
		//first block = genesis block
		blockchain.add(new Block("Hi im the first one to board the chain", "0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size()-1).getHash()));		
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size()-1).getHash()));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		Gson blockchainJson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson.toJson(blockchain));
	}
	
	public static Boolean isChainValid() {
		Block currentBlock;
		Block prevBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0','0');
		
		//loop through blockchain to check hashes
		for (int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			prevBlock = blockchain.get(i-1);
			//compare registered and calculated hash:
			if(!currentBlock.getHash().equals(currentBlock.calculateHash())) {
				System.out.println("Current hashes aren't equal");
				return false;
			}
			//compare previous hash and registered previous hash
			if(!prevBlock.getHash().equals(currentBlock.getPrevHash())) {
				System.out.println("Previous hashes don't match");
				return false;
			}
			//check for the proof of work
			if(!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		
		return true;
	}

}
