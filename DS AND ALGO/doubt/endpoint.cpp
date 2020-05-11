#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void EndPoint(vector<vector<int>>&arr)
{
    int dir=0,r=0,c=0;
        
while(1)
{
    dir=dir+arr[r][c];
            dir%=4;
    if(dir==0)
    {
        c++;
        if(c==arr[0].size())
        {
            break;
        }
       
    }
    else if(dir==1)
    {
        r++;
        if(r==arr.size())
        {
            break;
        }
    }
    else if(dir==2)
    {
        c--;
        if(c<0)
        {
            break;
        }
    }
    else if(dir==3)
    {
        r--;
        if(r<0)
        {
            break;
        }
    }
}  
   cout<<r<<", "<<c; 
        
}
int main() {
int r,c,i,j;
    cin>>r>>c;
    vector<vector<int>>arr(r,vector<int>(c,0));
    for(i=0;i<arr.size();i++)
    {
        for(j=0;j<arr[0].size();j++)
            cin>>arr[i][j];
    }
    EndPoint(arr);
    return 0;
}
