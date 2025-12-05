class Solution {
    public int fib(int n) {
    //     if(n==0)
    //     return 0;

    //     if(n==1)
    //     return 1;

    //     return fib(n-1) + fib(n-2);
    // }}

//         int a=0;
//         int b=1;
//         int c= 0;

//         for(int i=2;i<=n;i++){
//             c=a+b;
//             a=b;
//             b=c;
//         }
//         return c;
//     }
// }

int[] dp= new int[n+1];
Arrays.fill(dp,-1);
return fib(n,dp);
    }

    public int fib(int n,int[] dp){
        if(n==0)
        return 0;

        if(n==1)
        return 1;

        return fib(n-1,dp) + fib(n-2,dp);
    }
}