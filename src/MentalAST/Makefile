all:
	javac *.java
	$(MAKE) -C AstDeclaration all
	$(MAKE) -C AstExpression all
	$(MAKE) -C AstStatement all
clean:
	-rm -f *.class
	$(MAKE) -C AstDeclaration clean
	$(MAKE) -C AstExpression clean
	$(MAKE) -C AstStatement clean