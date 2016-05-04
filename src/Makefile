JVC = javac -cp "./antlr-4.5.3-complete.jar:.:$$CLASSPATH"

all:
	$(JVC) MentalAST/*.java
	$(JVC) MentalAST/AstDeclaration/*.java
	$(JVC) MentalAST/AstExpression/*.java
	$(JVC) MentalAST/AstStatement/*.java
	$(JVC) MentalCore/*.java
	$(JVC) MentalIR/*.java
	$(JVC) MentalIR/Arithmetic/*.java
	$(JVC) MentalIR/Branch/*.java
	$(JVC) MentalIR/Data/*.java
	$(JVC) MentalIR/Label/*.java
	$(JVC) MentalParser/*.java
	$(JVC) MentalSymbols/*.java
	$(JVC) MentalIR/Translator/*.java
	$(JVC) MentalType/*.java

clean:
	-rm -f MentalAST/*.class
	-rm -f MentalAST/AstDeclaration/*.class
	-rm -f MentalAST/AstExpression/*.class
	-rm -f MentalAST/AstStatement/*.class
	-rm -f MentalCore/*.class
	-rm -f MentalIR/*.class
	-rm -f MentalIR/Arithmetic/*.class
	-rm -f MentalIR/Branch/*.class
	-rm -f MentalIR/Data/*.class
	-rm -f MentalIR/Label/*.class
	-rm -f MentalParser/*.class
	-rm -f MentalSymbols/*.class
	-rm -f MentalIR/Translator/*.class
	-rm -f MentalType/*.class