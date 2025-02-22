#include<string>
#include <iostream>
#include <stack>
using namespace std;

bool solution(string s)
{   
    stack<char> st;
    bool answer = true;
    for(int i =0; i<s.length(); i++){
        if(st.empty() && s[i] == ')') answer = false;
        if(s[i] == '(') st.push(s[i]);
        if(s[i] == ')' && !st.empty()) st.pop();
    }
    
    if(!st.empty()) answer = false;


    return answer;
}