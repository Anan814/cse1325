CXX = g++
CXXFLAGS = -std=c++11
LDFLAGS =

all: shapes

shapes: Shapes.cpp Shape.cpp Rectangle.cpp Circle.cpp
	$(CXX) $(CXXFLAGS) $(LDFLAGS) -o shapes Shapes.cpp Shape.cpp Rectangle.cpp Circle.cpp

clean:
	rm -f shapes