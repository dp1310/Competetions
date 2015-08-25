/**
 * @author Ashok Rajpurohit (ashok1113)
 * 
 **/

#include<iostream>
using namespace std;

int solve(int a, string s) {
	int res = 0;
	int i = 0;
	
	for(int i=0; i < s.length(); i++) {
		res = (res << 3) + (res << 1) + s[i] - '0';
		res = res % a;
	}
	return res;
}

int gcd(int a, int b) {
	if(a == 0)
		return b;
	
	return gcd(b % a, a);
}

int main() {
	int n;
	cin >> n;
	
	while(n > 0) {
		n--;
		int a;
		string s;
		cin >> a;
		cin >> s;
		if(a == 0)
			cout << s << endl;
		else if(a == 1)
			cout << 1 << endl;
		else
			cout << gcd(solve(a,s), a) << endl;
	}
}
		
