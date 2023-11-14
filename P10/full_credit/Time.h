
#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <iomanip>

class Time {
private:
    int _hour;
    int _minute;
    int _second;

    void rationalize();

public:
    Time(int hour = 0, int minute = 0, int second = 0);

    Time operator+(const Time& time) const;
    Time& operator++();
    Time operator++(int);
    bool operator==(const Time& time) const;
    bool operator!=(const Time& time) const;
    bool operator<(const Time& time) const;
    bool operator>(const Time& time) const;
    bool operator<=(const Time& time) const;
    bool operator>=(const Time& time) const;

    friend std::ostream& operator<<(std::ostream& ost, const Time& time);
    friend std::istream& operator>>(std::istream& ist, Time& time);
};

#endif
