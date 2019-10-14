numeral(X+Y) :- numeral(X), numeral(Y).
numeral(0).
numeral(s(X)) :- numeral(X).
numeral(p(X)) :- numeral(X).
numeral(-X) :- numeral(X).
numeral(X-Y) :- numeral(X), numeral(Y).

%------------------------------------------------------------------------------%

add2(-X, Y, Z) :- minus(X, X1), add2(X1,Y,Z).
add2(X, -Y, Z) :- minus(Y, Y1), add2(X,Y1,Z).
add2(-X, -Y, Z) :- minus(X, X1), minus(Y,Y1),add2(X1,Y1,Z).

add2(X1+X2,Y1+Y2,Z) :- add2(X1,X2,X3),add2(Y1,Y2,Y3),add2(X3,Y3,Z).
add2(X1+X2,Y,Z) :- add2(X1,X2,X3), add2(X3,Y,Z).
add2(X,Y1+Y2,Z) :- add2(Y1,Y2,Y3), add2(X,Y3,Z).

add2(X,s(p(Y)), Z) :- add2(X,Y,Z).
add2(s(p(X)),Y, Z) :- add2(X,Y,Z).

add2(p(X),s(Y),Z):- add2(X,Y,Z).
add2(s(X),p(Y),Z):- add2(X,Y,Z).

add2(s(X),Y,s(Z)) :- add2(X,Y,Z).
add2(X,s(Y),s(Z)) :- add2(X,Y,Z).
add2(p(X),Y,p(Z)) :- add2(X,Y,Z).
add2(X,p(Y),p(Z)) :- add2(X,Y,Z).

add2(0,X,X).

subtract(X, Y, Z) :- minus(Y, Y1), add2(X, Y1, Z).
subtract(X,-Y,Z):- add2(X,Y,Z).
subtract(-X,Y,Z):- minus(X,X1), minus(Y,Y1), add2(X1,Y1,Z).
subtract(-X,-Y,Z):- minus(X,X1), add2(X1,Y,Z).
      
minus(s(p(0)), 0).
minus(p(s(0)), 0).
minus(X-X1,Y):- subtract(X,X1,X2), minus(X2,Y).
minus(X+X1,Y):- add2(X,X1,X2), minus(X2,Y).
minus(s(X), p(Z)) :- minus(X, Z).
minus(p(X), s(Z)) :- minus(X, Z).
minus(0,0).





