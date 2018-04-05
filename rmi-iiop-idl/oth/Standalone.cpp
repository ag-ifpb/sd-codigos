// File Standalone.cpp
#include <iostream>

// Future server function.
void Output(const char* szOutput)
{
   std::cout << szOutput << std::endl;
}

int main()
{
   // Future client call.
   Output("Hello Lonely World!");
}
