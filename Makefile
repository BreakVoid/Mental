all:
	$(MAKE) -C src all
	if [ ! -d out/MentalAST ]; then mkdir out/MentalAST; fi
	if [ ! -d out/MentalAST/AstDeclaration ]; then mkdir out/MentalAST/AstDeclaration; fi
	if [ ! -d out/MentalAST/AstExpression ]; then mkdir out/MentalAST/AstExpression; fi
	if [ ! -d out/MentalAST/AstStatement ]; then mkdir out/MentalAST/AstStatement; fi
	if [ ! -d out/MentalCore ]; then mkdir out/MentalCore; fi
	if [ ! -d out/MentalParser ]; then mkdir out/MentalParser; fi
	if [ ! -d out/MentalSymbols ]; then mkdir out/MentalSymbols; fi
	if [ ! -d out/MentalType ]; then mkdir out/MentalType; fi
	cp src/MentalAST/*.class out/MentalAST/
	cp src/MentalAST/AstDeclaration/*.class out/MentalAST/AstDeclaration/
	cp src/MentalAST/AstExpression/*.class out/MentalAST/AstExpression/
	cp src/MentalAST/AstStatement/*.class out/MentalAST/AstStatement/
	cp src/MentalCore/*.class out/MentalCore/
	cp src/MentalParser/*.class out/MentalParser/
	cp src/MentalSymbols/*.class out/MentalSymbols/
	cp src/MentalType/*.class out/MentalType/
	$(MAKE) -C src clean
clean:
	$(MAKE) -C src clean
	-rm -rf out
	-rm Mental.jar