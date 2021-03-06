package main;

import java.util.Date;

public class Block {
	
	private String hash;
	private String previousHash;
	private String data; //our data is just a msg
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int difficulty;
	private int nonce;

	//Block constructor
	public Block(String data, String prevHash) {
		this.data = data;
		this.previousHash = prevHash;
		this.timeStamp = new Date().getTime();
		
		//assigns random difficulty to a block [1-6]
		this.difficulty = (int) (Math.random()*(6-1+1)+1); 
		
		this.hash = this.calculateHash();
		this.mineBlock(this.difficulty);
	}
	
	public String calculateHash() {
		String hash = 
				StringUtil.applySha256(this.previousHash+
						this.data + this.timeStamp + this.nonce + this.difficulty);//added the difficulty to the hash calc, will see how it behaves.
		return hash;
	}
	
	/*Takes in an int called difficulty, this is the number of 0’s they must solve for. 
	 * Low difficulty like 1 or 2 can be solved nearly instantly on most computers, 
	 * 4-6 would require a bit more computational power.*/
	private void mineBlock(int difficulty) {
		//Create a string of length: difficulty * "0"
		String target = new String(new char[difficulty]).replace('\0', '0');
		while(!this.hash.substring(0, difficulty).equals(target)) {
			this.nonce++;
			this.hash = this.calculateHash();
		}
		System.out.println("Block Mined!!, hash : " + hash);
	}
	
	//getters
	public String getHash() {
		return this.hash;
	}
	
	public String getPrevHash() {
		return this.previousHash;
	}
	
	public String getData() {
		return this.data;
	}
	
	public long getTimeStamp() {
		return this.timeStamp;
	}
	public int getDifficulty() {
		return this.difficulty;
	}
}
