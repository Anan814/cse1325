#include "Index.h"

void Index::add_word(const std::string& filename, int line, const Index::Word& word) {
    _index.insert(std::make_pair(word, Location(filename, line)));
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    for (auto it = index._index.begin(); it != index._index.end();) {
        os << it->first << ": ";
        auto range = index._index.equal_range(it->first);

        // Print the locations for the current word
        for (auto loc_it = range.first; loc_it != range.second; ++loc_it) {
            os << loc_it->second << ", ";
        }

        os << '\n';

        // Skip past duplicates
        it = range.second;
    }
    return os;
}