# Additional clean files
cmake_minimum_required(VERSION 3.16)

if("${CONFIG}" STREQUAL "" OR "${CONFIG}" STREQUAL "Debug")
  file(REMOVE_RECURSE
  "CMakeFiles\\FFProjectQTFront_autogen.dir\\AutogenUsed.txt"
  "CMakeFiles\\FFProjectQTFront_autogen.dir\\ParseCache.txt"
  "FFProjectQTFront_autogen"
  )
endif()
