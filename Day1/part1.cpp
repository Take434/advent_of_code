//
// Created by timhe on 01.12.2023.
//

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
    string tp;
    int result = 0;

    ifstream newfile("input.txt");

    while(getline(newfile, tp)) {
        string number;

        for(char& c : tp) {
            int a = int(c);
            if (a < 58 && a > 47) {
                number += c;
            }
        }

        result += (number[0] - '0') * 10 + (number[number.length() - 1] - '0');
    }

    cout << result;

    newfile.close();

    return 0;
}
