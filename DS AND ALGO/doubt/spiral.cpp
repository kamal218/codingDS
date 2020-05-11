#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void spiralclock(vector<vector<int>>&arr)
{
    int rmin=0,cmin=0;
    int rmax=arr.size()-1;
    int cmax=arr[0].size()-1;
    int tne=arr.size()*arr[0].size();
    int i;
    while(tne>0)
    {
        for(i=cmin;i<=cmax&&tne>0;i++)
        {
        cout<<arr[rmin][i]<<" ";
            tne--;
        }
        rmin++;
        for(i=rmin;i<=rmax&&tne>0;i++)
        {
            cout<<arr[i][cmax]<<" ";
             tne--;
        }
        cmax--;
        for(i=cmax;i>=cmin&&tne>0;i--)
        {
            cout<<arr[rmax][i]<<" ";
             tne--;
        }
        rmax--;
        for(i=rmax;i<=rmin&&tne>0;i--)
        {
        cout<<arr[i][cmin]<<" ";
             tne--;
        }
        cmin++;
    }
    
}


int main() {
int r,c;
    cin>>r>>c;
    vector<vector<int>>arr(r,vector<int>(c,0));
    for(int i=0;i<arr.size();i++)
    {
        for(int j=0;j<arr[0].size();j++)
            cin>>arr[i][j];
    }
   spiralclock(arr);
   
    return 0;
}
