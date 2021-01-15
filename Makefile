JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
com/graph/Restriction.java\
com/graph/Graph.java\
com/graph/TestGraph.java\
com/graph/Node.java\
com/graph/Street.java\
com/graph/Dijkstra.java\
com/main/Main.java\
com/vehicles/Bicycle.java\
com/vehicles/Car.java\
com/vehicles/Motorcycle.java\
com/vehicles/Truck.java\
com/vehicles/Vehicle.java

MAIN = com/main/Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	java $(MAIN)

