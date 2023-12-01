//
// Created by timhe on 01.12.2023.
//

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
    string tp;
    string to_compare[9] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int result = 0;

    ifstream new_file("input.txt");

    while(getline(new_file, tp)) {
        int first = -1;
        int last = -1;

        string from_start;
        for(char& c : tp) {
            if(first != -1) {
                break;
            }

            if (c < 58 && c > 47) {
                first = c - '0';
            } else {
                from_start += c;

                if(from_start.length() < 3) {
                    continue;
                }

                for(int i = 0; i < 9; i++) {
                    if(from_start.find(to_compare[i]) != string::npos) {
                        first = i + 1;
                        break;
                    }
                }
            }
        }

        string from_back;
        for(int i = tp.length() - 1; i >= 0; i--) {
            if(last != -1) {
                break;
            }

            if (tp[i] < 58 && tp[i] > 47) {
                last = tp[i] - '0';
            } else {
                from_back.insert(0, 1, tp[i]);

                if(from_back.length() < 3) {
                    continue;
                }

                for(int j = 0; j < 9; j++) {
                    if(from_back.find(to_compare[j]) != string::npos) {
                        last = j + 1;
                        break;
                    }
                }
            }
        }

        result += first * 10 + last;
    }

    cout << result;

    new_file.close();

    return 0;
}