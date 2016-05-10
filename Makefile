all:
	$(MAKE) -C src all
	if [ ! -d bin ]; then mkdir bin; fi
	if [ ! -d bin/MentalAST ]; then mkdir bin/MentalAST; fi
	if [ ! -d bin/MentalAST/AstDeclaration ]; then mkdir bin/MentalAST/AstDeclaration; fi
	if [ ! -d bin/MentalAST/AstExpression ]; then mkdir bin/MentalAST/AstExpression; fi
	if [ ! -d bin/MentalAST/AstStatement ]; then mkdir bin/MentalAST/AstStatement; fi
	if [ ! -d bin/MentalCore ]; then mkdir bin/MentalCore; fi
	if [ ! -d bin/MentalIR ]; then mkdir bin/MentalIR; fi
	if [ ! -d bin/MentalIR/Arithmetic ]; then mkdir bin/MentalIR/Arithmetic; fi
	if [ ! -d bin/MentalIR/Branch ]; then mkdir bin/MentalIR/Branch; fi
	if [ ! -d bin/MentalIR/Data ]; then mkdir bin/MentalIR/Data; fi
	if [ ! -d bin/MentalIR/Label ]; then mkdir bin/MentalIR/Label; fi
	if [ ! -d bin/MentalParser ]; then mkdir bin/MentalParser; fi
	if [ ! -d bin/MentalSymbols ]; then mkdir bin/MentalSymbols; fi
	if [ ! -d bin/MentalTranslator ]; then mkdir bin/MentalTranslator; fi
	if [ ! -d bin/MentalType ]; then mkdir bin/MentalType; fi
	cp src/MentalAST/*.class bin/MentalAST/
	cp src/MentalAST/AstDeclaration/*.class bin/MentalAST/AstDeclaration/
	cp src/MentalAST/AstExpression/*.class bin/MentalAST/AstExpression/
	cp src/MentalAST/AstStatement/*.class bin/MentalAST/AstStatement/
	cp src/MentalCore/*.class bin/MentalCore/
	cp src/MentalIR/*.class bin/MentalIR/
	cp src/MentalIR/Arithmetic/*.class bin/MentalIR/Arithmetic/
	cp src/MentalIR/Branch/*.class bin/MentalIR/Branch/
	cp src/MentalIR/Data/*.class bin/MentalIR/Data/
	cp src/MentalIR/Label/*.class bin/MentalIR/Label/
	cp src/MentalParser/*.class bin/MentalParser/
	cp src/MentalSymbols/*.class bin/MentalSymbols/
	cp src/MentalType/*.class bin/MentalType/
	cp src/MentalTranslator/*.class bin/MentalTranslator/
	cp src/antlr-4.5.3-complete.jar bin/
	cp mips_built_in.s bin/
	cp built_in.mx bin/
	$(MAKE) -C src clean
clean:
	$(MAKE) -C src clean
	-rm -rf bin