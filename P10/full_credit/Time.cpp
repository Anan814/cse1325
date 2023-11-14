
#include "Time.h"

Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second) {
    rationalize();
}

void Time::rationalize() {
    _hour = (_hour + (_minute + _second / 60) / 60) % 24;
    _minute = (_minute + _second / 60) % 60;
    _second %= 60;
}

Time Time::operator+(const Time& time) const {
    Time result(_hour + time._hour, _minute + time._minute, _second + time._second);
    result.rationalize();
    return result;
}

Time& Time::operator++() {
    _second++;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time temp = *this;
    _second++;
    rationalize();
    return temp;
}

bool Time::operator==(const Time& time) const {
    return (_hour == time._hour) && (_minute == time._minute) && (_second == time._second);
}

bool Time::operator!=(const Time& time) const {
    return !(*this == time);
}

bool Time::operator<(const Time& time) const {
    if (_hour != time._hour) {
        return _hour < time._hour;
    }
    if (_minute != time._minute) {
        return _minute < time._minute;
    }
    return _second < time._second;
}

bool Time::operator>(const Time& time) const {
    return !(*this <= time);
}

bool Time::operator<=(const Time& time) const {
    return (*this < time) || (*this == time);
}

bool Time::operator>=(const Time& time) const {
    return !(*this < time);
}

std::ostream& operator<<(std::ostream& os, const Time& time) {
    os << std::setfill('0') << std::setw(2) << time._hour << ":"
       << std::setfill('0') << std::setw(2) << time._minute << ":"
       << std::setfill('0') << std::setw(2) << time._second;
    return os;
}

std::istream& operator>>(std::istream& ist, Time& time) {
    ist >> time._hour;
    ist.ignore(1); 
    ist >> time._minute;
    ist.ignore(1); 
    ist >> time._second;

    time.rationalize();

    if (ist.fail()) {
        ist.setstate(std::ios::failbit);
    }

    return ist;
}