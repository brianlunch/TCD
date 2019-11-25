s(Nb)--> [Nb].
s(Nb)--> [X], {mkList(Nb,L), member(X,L), A is Nb-X, A\=0}, s(A).

mkList(1, [1]).
mkList(X, [X|List]) :- X > 0, X1 is X-1, mkList(X1, List).