#include "Rectangle.h"

Rectangle:: Rectangle(double width, double height) : _width(width), _height(height) {}

std::string Rectangle:: name() const{
    return std::to_string(_width) + "x" + std::to_string(_height) + " Rectangle" ;
}

double Rectangle:: area() const {
    return _width * _height;
}

double Rectangle::get_width() const{
    return _width;
}

double Rectangle::get_height() const{
    return _height;
}

