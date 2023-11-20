#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>

class Location {
public:
    Location(const std::string& filename, int line);

    bool operator==(const Location& rhs) const;
    bool operator!=(const Location& rhs) const;
    bool operator<(const Location& rhs) const;
    bool operator>(const Location& rhs) const;
    bool operator<=(const Location& rhs) const;
    bool operator>=(const Location& rhs) const;

    int compare(const Location& rhs) const;

    friend std::ostream& operator<<(std::ostream& os, const Location& location);

private:
    std::string _filename;
    int _line;
    
    static std::string last_filename;
    
public:
    static void next_word();
};

#endif