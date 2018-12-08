#include <stdlib.h>
#include <assert.h>
#include <stdio.h>

#include "bitset.h"


// create a new, empty bit vector set with a universe of 'size' items
struct bitset *bitset_new(int size) {
    struct bitset *bs = malloc(sizeof(struct bitset));
    int oneOrZero = 0;
    bs->bits_in_word=32;
    if (size % bs->bits_in_word != 0)
        oneOrZero = 1;

    bs->size_in_bits = size;
    bs->size_in_words = size / bs->bits_in_word + oneOrZero;
    bs->data = malloc(sizeof(int) * bs->size_in_words);
    for (int i = 0; i < bs->size_in_words; i++) {
        bs->data[i] = 0;
    }
    return bs;
}

// get the size of the universe of items that could be stored in the set
int bitset_size(struct bitset *this) {
    return this->size_in_words * this->bits_in_word;
}

// get the number of items that are stored in the set
int bitset_cardinality(struct bitset *this) {
    int count = 0;
    int i;
    int size_in_bits = bitset_size(this);
    for (i = 0; i < size_in_bits; i++) {
        if (bitset_lookup(this, i) == 1)count++;
    }
    return count;
}

// check to see if an item is in the set
int bitset_lookup(struct bitset *this, int item) {
    int i = item / this->bits_in_word;
    int pos = item % this->bits_in_word;
    unsigned int flag = 1;
    flag = flag << pos;
    unsigned int k = this->data[i] & flag;
    if (k == 0)
        return 0;
    else
        return 1;
}

// add an item, with number 'item' to the set
// has no effect if the item is already in the set
void bitset_add(struct bitset *this, int item) {
    int isThere = bitset_lookup(this, item);
    if (isThere == 0) {
        int i = item / this->bits_in_word;
        int pos = item % this->bits_in_word;
        int flag = 1;
        flag = flag << pos;
        this->data[i] = this->data[i] | flag;
    }
}

// remove an item with number 'item' from the set
void bitset_remove(struct bitset *this, int item) {
    if (bitset_lookup(this, item) == 1) {
        int i = item / this->bits_in_word;
        int pos = item % this->bits_in_word;
        unsigned int flag = 1;
        flag = flag << pos;
        flag = ~flag;
        this->data[i] &= flag;
    }
}

// place the union of src1 and src2 into dest;
// all of src1, src2, and dest must have the same size universe
void bitset_union(struct bitset *dest, struct bitset *src1, struct bitset *src2) {
    int i;
    if(bitset_size(dest) == bitset_size(src1) && bitset_size(dest)== bitset_size(src2)) {
        for (i = 0; i < dest->size_in_words; i++) {
            dest->data[i] = src1->data[i] | src2->data[i];
        }
    }
}

// place the intersection of src1 and src2 into dest
// all of src1, src2, and dest must have the same size universe
void bitset_intersect(struct bitset *dest, struct bitset *src1, struct bitset *src2) {
    int i;
    if(bitset_size(dest) == bitset_size(src1) && bitset_size(dest)== bitset_size(src2)) {
        for (i = 0; i < dest->size_in_words; i++) {
            dest->data[i] = src1->data[i] & src2->data[i];
        }
    }
}


// print the contents of the bitset
void bitset_print(struct bitset *this) {
    int i;
    int size = bitset_size(this);
    for (
            i = 0;
            i < size;
            i++) {
        if (bitset_lookup(this, i) == 1) {
            printf("%d ", i);
        }
    }
    printf("\n");
}

