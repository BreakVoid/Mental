all:
	javac MentalAST/*.java
	javac MentalAST/AstDeclaration/*.java
	javac MentalAST/AstExpression/*.java
	javac MentalAST/AstStatement/*.java
	javac MentalCore/*.java
	javac MentalParser/*.java
	javac MentalSymbols/*.java
	javac MentalType/*.java

clean:
	$(MAKE) -C MentalAST clean
	$(MAKE) -C MentalCore clean
	$(MAKE) -C MentalParser clean
	$(MAKE) -C MentalSymbols clean
	$(MAKE) -C MentalType clean