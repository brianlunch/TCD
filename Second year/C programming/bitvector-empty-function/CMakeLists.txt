cmake_minimum_required(VERSION 3.12)
project(bs C)

set(CMAKE_C_STANDARD 99)

add_executable(bitvector-empty-function main.c bitset.c bitset.h bloom.c bloom.h)