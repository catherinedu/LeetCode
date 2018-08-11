// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// Example 1:

// Input: coins = [1, 2, 5], amount = 11
// Output: 3 
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1




public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return  robot(coins, amount, new int[amount+1]);
        
    }
    
    public int robot(int[] coins, int rem, int memo[]){
        int min = Integer.MAX_VALUE;
        if(rem < 0) return -1;
        if(rem == 0) return 0;
        if(memo[rem] != 0) return memo[rem];
        for(int i = 0; i < coins.length; i++){
            int res = robot(coins, rem-coins[i], memo);
            if(res >= 0 && res < min){
                min = res + 1; //f(11) = f(10) + 1 eg.
            }
        }
        memo[rem] = (min == Integer.MAX_VALUE)? -1:min;
        
        return memo[rem];
    }
