all: gen

clean:
	rm -f out/BSTGenerator.jar

out/BSTGenerator.jar: out/parcs.jar src/BSTGenerator.java
	@javac -cp out/parcs.jar src/BSTGenerator.java
	@jar cf out/BSTGenerator.jar -C src BSTGenerator.class
	@rm -f src/BSTGenerator.class

build: out/BSTGenerator.jar

gen: out/BSTGenerator.jar
	@cd out && java -cp 'parcs.jar:BSTGenerator.jar' BSTGenerator $(SIZE)