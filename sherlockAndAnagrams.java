static int sherlockAndAnagrams(String s) {
        int sum = 0;
        for(int index = 1; index < s.length();index++){
            for(int i = 0; i < s.length() - index +1; i++){//plus 1 because right end is exclusive so it can go over by 1
                String s1 = s.substring(i, index + i);//want sth like (0,1) (1,2)... then (0,2) (1,3),so i always come back the same set of values, so i goes to the inner loop.
                for(int j = i+1; j < s.length() - index+1; j++){
                    String s2 = s.substring(j, index + j);
                    sum += checkAnagram(s1, s2);
                }
            }
        }
        return sum;

    }
    public static int checkAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return 0;
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < s1.length(); i++){
            list.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++){
            if(list.contains(s2.charAt(i))){
                list.remove(list.indexOf(s2.charAt(i)));
            }
            else{
                return 0;
            }
        }
        return 1;