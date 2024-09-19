class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer>answer=new ArrayList<>();
        for(int i=0;i<expression.length();i++)
        {
            char ch=expression.charAt(i);
            if(ch=='*' || ch=='+' || ch=='-')
            {
                String left=expression.substring(0,i);
                String right=expression.substring(i+1);
                List<Integer>list1=diffWaysToCompute(left);
                List<Integer>list2=diffWaysToCompute(right);
                
                for(Integer j:list1)
                {
                    for(Integer k:list2)
                    {
                        int val=0;
                        if(ch=='+')
                            val=j+k;
                        else if(ch=='*')
                            val=j*k;
                        else
                            val=j-k;
                        answer.add(val);
                    }
                }
            }
        }
        if(answer.size()==0)
            answer.add(Integer.valueOf(expression));
        return answer;
        
    }
}