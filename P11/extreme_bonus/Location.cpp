#include "Location.h"

std::string Location::last_filename = "";

void Location::next_word() {
    last_filename = "";
}

Location::Location(const std::string& filename, int line)
    : _filename(filename), _line(line) {}

bool Location::operator==(const Location& rhs) const {
    return compare(rhs) == 0;
}

bool Location::operator!=(const Location& rhs) const {
    return compare(rhs) != 0;
}

bool Location::operator<(const Location& rhs) const {
    return compare(rhs) < 0;
}

bool Location::operator>(const Location& rhs) const {
    return compare(rhs) > 0;
}

bool Location::operator<=(const Location& rhs) const {
    return compare(rhs) <= 0;
}

bool Location::operator>=(const Location& rhs) const {
    return compare(rhs) >= 0;
}

int Location::compare(const Location& rhs) const {
    if (_filename != rhs._filename) {
        return _filename.compare(rhs._filename);
    }
    return _line - rhs._line;
}

std::ostream& operator<<(std::ostream& os, const Location& location) {
    if (location._filename != Location::last_filename) {
        os << location._filename << " line ";
        Location::last_filename = location._filename;
    }
    os << location._line;
    return os;
}