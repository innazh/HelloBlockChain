# HelloBlockChain
Created my first blockchain. It's made up of blocks that store data (a simple message). Each block
has a hash is composed of it's internal data to make sure that it's secure and no one messes with the data. It also contains the hash of the previous block to make the chain inseparable.
In the main class (HelloChain), each block gets mined right after being created.

After all blocks are mined, function isChainValid() validates the chain by:
1. comparing it's current hash value with the hash that's calculated using its internal data
2. comparing the previous hash stored in the block with the hash of the previous block
3. making sure that the proof-of-work is there and answeres to the required difficulty

The contents of the blockchain are then printed.
