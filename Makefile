all: run

clean:
	rm -f out/BSTGenerator.jar out/Node.jar

out/BSTGenerator.jar: out/parcs.jar src/BSTGenerator.java
	@javac -cp out/parcs.jar src/BSTGenerator.java
	@jar cf out/BSTGenerator.jar -C src BSTGenerator.class
	@rm -f src/BSTGenerator.class

out/Node.jar: out/parcs.jar src/Node.java
	@javac -cp out/parcs.jar src/Node.java
	@jar cf out/Node.jar -C src Node.class
	@rm -f src/Node.class

build: out/BSTGenerator.jar out/Node.jar

gen: out/BSTGenerator.jar
	@cd out && java -cp 'parcs.jar:BSTGenerator.jar' BSTGenerator $(SIZE)

run: out/Node.jar
	@cd out && java -cp 'parcs.jar:Node.jar' Node