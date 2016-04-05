all:
	$(MAKE) -C src all
	if [ ! -d bin ]; then mkdir bin; fi
	if [ ! -d bin/MentalAST ]; then mkdir bin/MentalAST; fi
	if [ ! -d bin/MentalAST/AstDeclaration ]; then mkdir bin/MentalAST/AstDeclaration; fi
	if [ ! -d bin/MentalAST/AstExpression ]; then mkdir bin/MentalAST/AstExpression; fi
	if [ ! -d bin/MentalAST/AstStatement ]; then mkdir bin/MentalAST/AstStatement; fi
	if [ ! -d bin/MentalCore ]; then mkdir bin/MentalCore; fi
	if [ ! -d bin/MentalParser ]; then mkdir bin/MentalParser; fi
	if [ ! -d bin/MentalSymbols ]; then mkdir bin/MentalSymbols; fi
	if [ ! -d bin/MentalType ]; then mkdir bin/MentalType; fi
	cp src/MentalAST/*.class bin/MentalAST/
	cp src/MentalAST/AstDeclaration/*.class bin/MentalAST/AstDeclaration/
	cp src/MentalAST/AstExpression/*.class bin/MentalAST/AstExpression/
	cp src/MentalAST/AstStatement/*.class bin/MentalAST/AstStatement/
	cp src/MentalCore/*.class bin/MentalCore/
	cp src/MentalParser/*.class bin/MentalParser/
	cp src/MentalSymbols/*.class bin/MentalSymbols/
	cp src/MentalType/*.class bin/MentalType/
	cp src/antlr-4.5.3-complete.jar bin/
	$(MAKE) -C src clean
clean:
	$(MAKE) -C src clean
	-rm -rf bin