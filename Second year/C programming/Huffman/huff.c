// code for a huffman coder


#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <ctype.h>

#include "huff.h"


// create a new huffcoder structure
struct huffcoder *huffcoder_new() {
    struct huffcoder *huff;
    huff = malloc(sizeof(struct huffcoder));
    huff->tree = NULL;
    for (int i = 0; i < NUM_CHARS; i++) {
        huff->freqs[i] = 0;
        huff->codes[i] = 0;
        huff->code_lengths[i] = 0;

    }
    return huff;
}

// count the frequency of characters in a file; set chars with zero
// frequency to one
void huffcoder_count(struct huffcoder *this, char *filename) {
    unsigned char c = 'i';
    FILE *file;
    file = fopen(filename, "r");
    assert(file != NULL);
    c = fgetc(file);
    while (!feof(file)) {
        this->freqs[c] = this->freqs[c] + 1;
        c = fgetc(file);
    }
    for (int i = 0; i < NUM_CHARS; i++) {
        if (this->freqs[i] == 0)
            this->freqs[i] = 1;
    }
    fclose(file);
}


// using the character frequencies build the tree of compound
// and simple characters that are used to compute the Huffman codes
void huffcoder_build_tree(struct huffcoder *this) {
    struct huffchar **list;
    int i;
    list = malloc(sizeof(struct huffchar *) * NUM_CHARS);
    for (i = 0; i < NUM_CHARS; i++) {
        list[i] = malloc(sizeof(struct huffchar));
        list[i]->freq = this->freqs[i];
        list[i]->is_compound = 0;
        list[i]->seqno = i;
        list[i]->u.c = i;
    }

//build huffman tree
    for (i = 0; i < NUM_CHARS - 1; i++) {
        sort_chars(list, NUM_CHARS-i);
        struct huffchar *compound;
        compound = malloc(sizeof(struct huffchar));
        compound->freq = list[0]->freq + list[1]->freq;
        compound->is_compound = 1;
        compound->seqno = NUM_CHARS + i;

        compound->u.compound.left = list[0];
        compound->u.compound.right = list[1];

        list[0] = NULL;
        list[1] = compound;
        list++;
    }
    this->tree = list[0];
}


void tree2table_recursive(struct huffcoder * this, struct huffchar * node, unsigned long long path, int depth) {
    if(node->is_compound == 1) {
        //move to next nodes
        path = path << 1;
        tree2table_recursive(this, node->u.compound.left, path, depth + 1);
        path = path|1;
        tree2table_recursive(this, node->u.compound.right, path, depth + 1);
    } else {
        //set code and code length
        unsigned char index= node->u.c;
        this->code_lengths[index] = depth;
        this->codes[index] = path;
        //printf("%d\n", this->codes);
    }
}

// using the Huffman tree, build a table of the Huffman codes
// with the huffcoder object
void huffcoder_tree2table(struct huffcoder * this)
{
    unsigned long long path =0;
    tree2table_recursive(this, this->tree,path, 0);
}

// print the Huffman codes for each character in order
void huffcoder_print_codes(struct huffcoder *this) {
    int i, j;
    char buffer[NUM_CHARS];
    char h[NUM_CHARS];
    for (i = 0; i < NUM_CHARS; i++) {
        // put the code into a string
        for ( j = this->code_lengths[i]-1; j >= 0; j--) {
            buffer[j] = ((this->codes[i] >> j) & 1) + '0';
        }
        // don't forget to add a zero to end of string
        buffer[this->code_lengths[i]] = '\0';
        reverse(buffer, this->code_lengths[i]);
        // print the code
        printf("char: %d, freq: %d, code: %s\n", i, this->freqs[i], buffer);;
    }
}

void reverse(char s[], int n)
{
    int c, i, j;

    for (i = 0, j = n-1; i < j; i++, j--) {
        c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}
void sort_chars(struct huffchar **charlist, int n) {
    int i, j;
    for (i = 0; i < n-1; i++)
        // Last i elements are already in place
        for (j = 0; j < n-i-1; j++)
            if (charlist[j]->freq > charlist[j+1]->freq)
            {
                struct huffchar* temp =charlist[j];
                charlist[j]=charlist[j+1];
                charlist[j+1]= temp;
            }
            else if(charlist[j]->freq == charlist[j+1]->freq && charlist[j]->seqno > charlist[j+1]->seqno){
                struct huffchar* temp =charlist[j];
                charlist[j]=charlist[j+1];
                charlist[j+1]= temp;
            }
}

// encode the input file and write the encoding to the output file
void huffcoder_encode(struct huffcoder * this, char * input_filename,
                      char * output_filename)
{
    
}

// decode the input file and write the decoding to the output file
void huffcoder_decode(struct huffcoder * this, char * input_filename,
                      char * output_filename)
{
}

