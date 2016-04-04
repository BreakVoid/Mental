JVC = javac -cp "./antlr-4.5.3-complete.jar:.:$$CLASSPATH"

all:
	$(JVC) MentalAST/*.java
	$(JVC) MentalAST/AstDeclaration/*.java
	$(JVC) MentalAST/AstExpression/*.java
	$(JVC) MentalAST/AstStatement/*.java
	$(JVC) MentalCore/*.java
	$(JVC) MentalParser/*.java
	$(JVC) MentalSymbols/*.java
	$(JVC) MentalType/*.java

clean:
	$(MAKE) -C MentalAST clean
	$(MAKE) -C MentalCore clean
	$(MAKE) -C MentalParser clean
	$(MAKE) -C MentalSymbols clean
	$(MAKE) -C MentalType clean