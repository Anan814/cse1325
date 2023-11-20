#include <iostream>
#include <fstream>
#include <sstream>
#include <cctype>
#include "Index.h"

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " file1 file2 ... fileN" << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error opening file: " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int line_number = 1;

        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;

            while (iss >> word) {
                // Remove punctuation
                while (!word.empty() && !std::isalnum(word.front())) {
                    word.erase(0, 1);
                }

                while (!word.empty() && !std::isalnum(word.back())) {
                    word.pop_back();
                }

                // Convert to lowercase
                for (char& c : word) {
                    c = std::tolower(c);
                }

                // Add word to index
                index.add_word(argv[i], line_number, word);
            }

            ++line_number;
        }
    }

    // Print the index
    std::cout << index;

    return 0;
}
