
//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//Given a non-empty string containing only digits, determine the total number of ways to decode it.
public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            memo[i] = -1;
        }
        return helper(s, s.length(), memo);
    }
    
    public int helper(String s, int k, int[] memo){
        if(k == 0){
            return 1;
        }
        int result = 0;
        int j = s.length() - k; 
        
        if(s.charAt(j) == '0'){
            return 0;
        }
        if(memo[k] != -1){
            return memo[k];
        }
        result = helper(s, k-1, memo);
        
        if(k >= 2 && Integer.parseInt(s.substring(j, j+2)) <= 26){
            result += helper(s, k - 2, memo);
        }
        memo[k] = result;
        return result;
        
    }