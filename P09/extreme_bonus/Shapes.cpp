#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <iostream>
#include <vector>
#include <fstream>

int main() {
    std::vector<Shape*> shapes;

    Rectangle rectangle(100.0, 60.0);  
    Circle circle(3.0);


    shapes.push_back(&rectangle);
    
    shapes.push_back(&circle);

    for (const auto& shape : shapes) {
        std::cout << shape->to_string() << std::endl;

        
        if (Rectangle* rectangle_shape = dynamic_cast<Rectangle*>(shape)) {
            int width = static_cast<int>(rectangle_shape->get_width());
            int height = static_cast<int>(rectangle_shape->get_height());

            
            std::ofstream ppmFile("rectangle.ppm");
            ppmFile << "P3\n";
            ppmFile << width << " " << height << "\n";
            ppmFile << "255\n";

            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    
                    if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                        ppmFile << "255 0 0\n";  
                    } else {
                        ppmFile << "0 0 0\n";  
                    }
                }
            }

            ppmFile.close();

            
            system("eog rectangle.ppm");  
        }
        
    }

    return 0;
}

