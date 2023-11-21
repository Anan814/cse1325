
#include "Index.h"

void Index::add_word(const std::string& filename, int line, const Index::Word& word) {
    Locations& locations = _index[word];
    locations.emplace(filename, line);
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    for (const auto& entry : index._index) {
        Location::next_word(); 
        os << entry.first << ": ";
        for (const auto& location : entry.second) {
            os << location << ", ";
        }
        os << '\n';
    }
    return os;
}



