import java.util.*;
public class MinimumCoins{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int dp[]=new int[n+1];
		//how many coins u hav
		
		int t=sc.nextInt();
		int coins[]=new int[t];
		for(int i=0;i<t;i++)
			coins[i]=sc.nextInt();
		Arrays.fill(dp,0);
		System.out.println("Top to Bottom DP :- "+minCoins(n,coins,t,dp));
		System.out.println("Bottom To Top Dp :-"+minCoinsBU(n,coins,t));
	}
	//Top To Bottom
	public static int minCoins(int n,int coins[],int t,int dp[]){
		if(n==0)
			return 0;
		if (dp[n]!=0)
			return dp[n];
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<t;i++){
			if(n-coins[i]>=0){
				int subprob=minCoins(n-coins[i],coins,t,dp);
				ans=Math.min(ans,subprob+1);
			}
		}
		dp[n]=ans;
		return dp[n];
	}
	//Bottom To Top
	public static int minCoinsBU(int n,int coins[],int t){
		
		int dp[]=new int[n+1];
		Arrays.fill(dp,0);
		for(int i=1;i<=n;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<t;j++){
				if (i-coins[j]>=0){
					int subprob=dp[i-coins[j]];
					dp[i]=Math.min(dp[i],subprob+1);
				}
			}
		}
		for(int i=0;i<n+1;i++)
			System.out.println(dp[i]);
		return dp[n];
	}
}