#include "Location.h"

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
    os << location._filename << " line " << location._line;
    return os;
}