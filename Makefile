all: run

clean:
	rm -f out/BSTGenerator.jar out/Node.jar out/Main.jar

out/BSTGenerator.jar: out/parcs.jar src/BSTGenerator.java
	@javac -cp out/parcs.jar src/BSTGenerator.java
	@jar cf out/BSTGenerator.jar -C src BSTGenerator.class
	@rm -f src/BSTGenerator.class

out/Tree.jar: out/parcs.jar src/Tree.java src/Node.java
	@javac -cp out/parcs.jar src/Tree.java src/Node.java
	@jar cf out/Tree.jar -C src Tree.class -C src Node.class
	@rm -f src/Tree.class src/Node.class

out/Main.jar: out/parcs.jar src/Main.java src/Node.java
	@javac -cp out/parcs.jar src/Main.java src/Node.java
	@jar cf out/Main.jar -C src Main.class -C src Node.class
	@rm -f src/Main.class src/Node.class

build: out/BSTGenerator.jar out/Tree.jar out/Main.jar

gen: out/BSTGenerator.jar
	@cd out && java -cp 'parcs.jar:BSTGenerator.jar' BSTGenerator $(SIZE)

run: out/Tree.jar out/Main.jar
	@cd out && java -cp 'parcs.jar:Main.jar' Main