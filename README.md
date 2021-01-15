# City-Project
Proiectul contine 3 packages impartite astfel:
### main
Contine clasa Main si reprezinta singurul mod prin care user-ul 			
	interactioneaza cu programul. Se creeaza un nou obiect de tip TestGraph
	si se apeleaza metoda de start. Toate celelalte clase sunt package-private
	pentru a impiedica user-ul din a le apela.
### graph
Contine toate clasele ce au legature cu graful si elementele acestuia.
	Clasele Node si Street sunt reprezentari ale unui nod, respectiv ale 
	unei strazi in graf. Clasa Restriction contine tipurile de ambuteiaje
	aparute pe o strada, precum trafic, accident sau blocaj. Clasa Graph
	reprezinta graful construit cu ajutorul unei liste de adiacenta, continand
	in plus si o lista cu toate nodurile, respectiv o lista cu toate strazile.
	Clasa Dijkstra este folosita pentru implementarea algoritmului Dijkstra.
	In clasa TestGraph este efectuata citirea inputului din fisierul "map.in"
	si este singura clasa cu care userul poate interactiona prin apelarea metodei
	"start()".
### vehicles
Contine clasa parinte Vehicle, iar celelalte clase Bicycle, Car,
	Motorcycle si Truck o mostenesc, fiind create prin apelarea constructorului
	clasei parinte cu valori predefinite, specifice fiecarui tip de vehicul.

