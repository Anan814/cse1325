#include "Circle.h"
#include <cmath>

const double PI = 3.1416;

Circle:: Circle(double radius) : _radius(radius) {}

std::string Circle:: name() const{
    return "Circle of radius " + std::to_string(_radius);
}

double Circle:: area() const{
    return PI * _radius * _radius;
}