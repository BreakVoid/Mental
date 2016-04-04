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
	-rm -f MentalAST/*.class
	-rm -f MentalAST/AstDeclaration/*.class
	-rm -f MentalAST/AstExpression/*.class
	-rm -f MentalAST/AstStatement/*.class
	-rm -f MentalCore/*.class
	-rm -f MentalParser/*.class
	-rm -f MentalSymbols/*.class
	-rm -f MentalType/*.class