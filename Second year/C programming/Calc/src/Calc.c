/*
 ============================================================================
 Name        : Calc.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

struct Node
{
	double data;
	struct Node *next;
}*top = NULL;

void push(char);
double pop();
double pow(double,double);
double postfix(char[]);
void infix(char[],char[]);

int main(void) {

	double finalRes=0;
	char iOrP = '2';

	//printf("Is your expression in 1.Postfix or 2.Infix (Type '1' or '2')?\n");
	//fflush(stdout);
	//scanf("%c", &iOrP);

	FILE *pToFile = fopen("C:\\Users\\brian\\OneDrive\\Documents\\Processing\\New Ws\\Reading Data\\Text","r");
	char input[50];
	while( fgets( input, 50, pToFile )) {
		printf("%s \n", input);
	}
	fclose(pToFile);
	if(iOrP=='2')
	{
		//turns the * into an X so precedence rules work
		for(int i = 0; i<sizeof(input);i++){
			if(input[i]=='*')
				input[i]='X';
		}
		//array for rpn
		char rpn [50];

		// Gets rid of gibberish in array
		for(int i = 0; i<sizeof(rpn);i++){
			rpn[i]=' ';
		}
		//turns infix to rpn
		infix(input, rpn);
		printf("3 5 7 22 - X +\n");
		for(int i = 0; i<sizeof(rpn);i++){
			printf("%c",rpn[i]);
		}
		finalRes= postfix(rpn);
	}
	else
		finalRes=postfix(input);
	printf("The answer is %f", finalRes);
}

struct node
{
	double data;
	struct node* next;
};

//push an element into stack
void push(char value)
{
	struct Node *newNode;
	newNode = (struct Node*)malloc(sizeof(struct Node));
	newNode->data = value;
	if(top == NULL)
		newNode->next = NULL;
	else
		newNode->next = top;
	top = newNode;
	//printf("\nInsertion is Success!!!\n");
}
//deletes element from stack and returns value of deleted element
double pop()
{
	double value = 0;
	if(top == NULL)
		printf("\nStack is Emptyyy!!!\n");
	else{
		struct Node *temp = top;
		//printf("\nDeleted element: %f", temp->data);
		value = temp -> data;
		top = temp->next;
		free(temp);
	}
	return value;
}

char getTop(){
	double value = 0;
	if(top == NULL)
		printf("\n");
	else{
		value = top -> data;
	}
	return value;
}

double postfix(char a [])
{
	double temp = 0;
	double result=0;
	struct node* head = NULL;
	//50 is size of array (sizeof gave error)
	for(int i =0; i<50;i++)
	{
		char c = a[i];
		if( c >= '0' && c <= '9' && a[i+1] == ' ' && temp==0)
		{
			c = c - 48;
			push(c);
		}
		else if(c >= '0' && c <= '9')
		{
			c = c -48;
			temp = (temp * 10)+ c;
		}
		else if(c == ' ' && temp!=0)
		{
			push(temp);
			temp=0;
		}
		else if(c == ' ')
			temp=0;
		else if(c == '^' || c == 'x' || c == 'X' || c == '-' || c == '+' ||c == '/' || c=='*')
		{
			double a = pop();
			double b = pop();
			if(c == '^')
				result = pow(b,a);
			else if(c=='x' || c == 'X' || c=='*')
				result = a *b;
			else if(c == '-')
				result = b-a;
			else if(c == '+')
				result = a + b;
			else if(c == '/')

				result = b/a;						// Find how to divide
			else
				printf("error");
			push(result);
		}

	}
	return result();
}

void infix(char input [], char rpn[]){
	struct node* head = NULL;
	int j=0;
	char c =' ';


	for(int i =0; i < 50; i++){
		c = input[i];
		if( c >= '0' && c <= '9' && input[i+1] == ' ')
		{
			rpn[j]=c;
			j++;
			rpn[j]=' ';
			j++;
		}
		else if((c >= '0' && c <= '9') && (input[i+1] >= '0' && input[i+1] <= '9') )
		{
			rpn[j]=c;
			j++;
		}
		else if((c >= '0' && c <= '9'))
		{
			rpn[j]=c;
			j++;
			rpn[j]=' ';
			j++;
		}
		else if(c =='(')
		{
			push(c);
		}
		else if(c == '^' || c == 'x' || c == 'X' || c == '-' || c == '+' ||c == '/' || c=='*')
		{
			double topOp = getTop();
			while(topOp>c&& top!=NULL)
			{
				rpn[j]= pop();
				j++;
				rpn[j]=' ';
				j++;
			}
			push(c);
		}
		else if(c==')'){
			while(getTop() != '(')
			{
				double operator = pop();
				rpn[j]= operator;
				j++;
				rpn[j]=' ';
				j++;
			}
		}
	}
	while(top!=NULL)
	{
		double operator = pop();
		rpn[j]= operator;
		j++;
		rpn[j]=' ';
		j++;
	}
}


