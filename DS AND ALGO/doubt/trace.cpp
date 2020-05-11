#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int main() {
int r,c,i,j;
    cin>>r>>c;
    vector<vector<int>>mat1(r,vector<int>(c,0));
    vector<vector<int>>mat2(r,vector<int>(c,0));
    for(i=0;i<mat1.size();i++)
    {
        for(j=0;j<mat1[0].size();j++)
            cin>>mat1[i][j];
    }
    for(i=0;i<mat2.size();i++)
    {
        for(j=0;j<mat2[0].size();j++)
            cin>>mat2[i][j];
    }
     for(i=0;i<mat2.size();i++)
    {
        for(j=0;j<mat2[0].size();j++)
            mat1[i][j]+=mat2[i][j];
    }
    int sum=0;
     for(i=0;i<mat2.size();i++)
    {
        for(j=0;j<mat2[0].size();j++)           //how can we decrease complexity
            if(i==j)
            sum=sum+mat1[i][j];
                
    }
    cout<<sum;
    return 0;
}
