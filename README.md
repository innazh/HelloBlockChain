# HelloBlockChain
Created my first blockchain. It's made up of blocks that store data (a simple message). Each block
has a hash is composed of it's internal data to make sure that it's secure and no one messes with the data. It also contains the hash of the previous block to make the chain inseparable.
Every block has a random difficulty of mining assigned to it in constructor.
In the main class (HelloChain), each block is mined upon creation.

After all blocks are created and mined, function isChainValid() validates the chain by:
1. comparing it's current hash value with the hash that's calculated using its internal data
2. comparing the previous hash stored in the block with the hash of the previous block
3. making sure that the proof-of-work is there and answers to the difficulty attached to the block

The contents of the blockchain are then printed.
