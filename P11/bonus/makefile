CXX = g++
CXXFLAGS = --std=c++17
OBJS = mkindex.o Index.o Location.o

mkindex: $(OBJS)
	$(CXX) $(CXXFLAGS) $(OBJS) -o mkindex

mkindex.o: mkindex.cpp Index.h Location.h
	$(CXX) $(CXXFLAGS) -c mkindex.cpp

Index.o: Index.cpp Index.h Location.h
	$(CXX) $(CXXFLAGS) -c Index.cpp

Location.o: Location.cpp Location.h
	$(CXX) $(CXXFLAGS) -c Location.cpp

clean:
	rm -f *.o mkindex