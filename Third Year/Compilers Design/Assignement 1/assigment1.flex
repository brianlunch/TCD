%{
int evenNumbers = 0;
%}
	
%%
	
[0-9]*[02468]	{ evenNumbers++;}
[0-9]*[13579]	{ }
\n
.
	
%%
	
int main()
{
	yylex();
  	printf("%d\n", evenNumbers);
  	return 0;
}