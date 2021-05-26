#include<iostream>
#include<vector>
#include<set>
#include<unordered_set>
#include<map>
#include<unordered_map>
#include<string>
#include<stack>
#include<algorithm>
#include<limits.h>

using namespace std;

void slove(int t){
    int n,k;
    long long ans = 0;
    long long mod = 1e9 + 7;
    string s;
    cin>>n>>k;
    cin>>s;

    /*dp*/
    int m = (n+1)/2;
    int limit = 1;
    vector<long long> dp(m);
    dp[0] = min(s[0]-'a',k);
    for(int i = 1; i < m; ++i){
        if(s[i] -'a' + 1 > k){
            dp[i] = (dp[i-1]*k + k)%mod;
            limit = 0;
        }else{
            dp[i] = (dp[i-1]*k + limit*(s[i]-'a'))%mod;
        }
    }
    ans = dp[m-1];
    if(limit){
        string p = s;
        for(int i = 0; i < m; ++i){
            p[n-1-i] = p[i] = s[i];
        }
        if(p < s) ans = (ans + 1)%mod;
    }
    ans = ans%mod;
    cout<<"Case #"<<t<<": ";
    cout<<ans;
    cout<<endl;
}

int main(){
    int t;
    cin>>t;
    for(int i = 0; i < t; ++i){
        slove(i+1);
    }
    return 0;
}