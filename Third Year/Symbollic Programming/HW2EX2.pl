s -->  house(Col1,Nat1,Pet1), house(Col2,Nat2,Pet2), house(Col3,Nat3,Pet3),
			{Col1\=Col2}, {Col2\=Col3}, {Col1\=Col3},
			{Nat1\=Nat2}, {Nat2\=Nat3}, {Nat1\=Nat3},
			{Pet1\=Pet2}, {Pet2\=Pet3}, {Pet1\=Pet3}.

house(Colour, Nation, Pet) --> [Colour],{lex(Colour, col)}, [Nation],{lex(Nation, nat)}, [Pet],{lex(Pet, pet)}.

lex(red, col).
lex(green, col).
lex(blue, col). 

lex(english, nat).
lex(japanese, nat).
lex(spanish, nat).

lex(snail, pet).
lex(jaguar, pet).
lex(zebra, pet).
