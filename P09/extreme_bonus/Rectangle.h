#ifndef RECTANGLE_H
#define RECTANGLE_H 

#include "Shape.h"

class Rectangle : public Shape {
    public:
        Rectangle(double width, double height);
        std::string name() const override;
        double area() const override;
        double get_width() const;
        double get_height() const;

    private:
        double _width;
        double _height;
};

#endif