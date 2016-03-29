grammar Mental;
COMMENT
	: '//' ~[\r\n]* '\r'? ('\n'|EOF) -> skip
	;

WS
	: [ \t\n\r]+ -> skip
	;

INT
	: DIGIT+
	;

Identifier
	: Identifiernondigit ( Identifiernondigit| DIGIT )*
	;
fragment
Hexquad
	: HEX HEX HEX HEX
	;
fragment
Universalcharactername
	: '\\u' Hexquad
	| '\\U' Hexquad Hexquad
	;
fragment
Identifiernondigit
	: NONDIGIT
	| Universalcharactername
	;

fragment
NONDIGIT
	: [a-zA-Z_]
	;

fragment DIGIT
	: [0-9]
	;

STRING
	: '"' (ESC | .)*? '"'
	;
fragment ESC
	: '\\' (["\\/bfnrt] | UNICODE)
	;
fragment UNICODE
	: 'u' HEX HEX HEX HEX
	;
fragment HEX
	: [0-9a-fA-F]
	;

originalType
	: 'int'
	| 'string'
	| Identifier
	;

array
    : originalType '[' ']'
    | array '[' ']'
    ;

type
	: originalType
	| array
	;

paramtersList
	: (type Identifier) (',' type Identifier)*
	;

program
	: (declaration | definition)*
	;

declaration
	: classDeclaration
	| functionDeclaration
	;

classDeclaration
	: 'class' Identifier? '{' variableDefinition* '}'
	;

functionDeclaration
	: (type | 'void') Identifier '(' paramtersList? ')' ';'
	;

definition
	: variableDefinition
	| functionDefinition
	;

variableDefinition
	: type Identifier ('=' expression)? (',' Identifier ('=' expression)?)* ';'
	;

functionDefinition
	: (type | 'void') Identifier '(' paramtersList? ')' compoundStatement
	;

compoundStatement
	: '{' statement* '}'
	;

statement
	: compoundStatement
	| ifStatement
	| ifElseStatement
	| forStatement
	| whileStatement
	| expressionStatement
	| jumpStatement
	| emptyStatement
	| variableDefinition
	| callPrint
	| callPrintln
	| callGetString
	| callGetInt
	| callToString
	;

callPrint
	: 'print' '(' expression ')' ';'
	;

callPrintln
	: 'println' '(' expression ')' ';'
	;

callGetString
	: 'getString' '(' ')' ';'
	;

callGetInt
	: 'getInt' '(' ')' ';'
	;

callToString
	: 'toString' '(' expression ')'
	;

emptyStatement
	: ';'
	;

ifStatement
	: 'if' '(' expression ')' statement
	;

ifElseStatement
	: 'if' '(' expression ')' statement 'else' statement
	;

forStatement
	: 'for' '(' expression? ';' expression? ';' expression? ')' statement
	;

whileStatement
	: 'while' '(' expression ')' statement
	;

jumpStatement
	: 'return' expression ';'
	| 'continue' ';'
	| 'break' ';'
	;

expressionStatement
	: expression ';'
	;

expression
	: 'new' originalType ('[' expression ']')*
	#CREATION_EXPRESSION
	| 'new' Identifier ('('expressionList')')*
	#CREATION_EXPRESSION
	| '(' expression ')'
	#SUBGROUP_EXPRESSION
	| expression '[' expression ']'
	#ARRAY_SUBSCRIPTING_EXPRESSION
	| expression op='.' expression
	#MEMBER_ACCESS_EXPRESSION
	| expression op=('++' | '--')
	#SUFFIX_INC_DEC_EXPRESSION
	| op=('++'|'--') expression
	#PREFIX_INC_DEC_EXPRESSION
	| op=('+'|'-') expression
	#UNRAY_PLUS_MINUS_EXPRESSION
	| op='~' expression
	#BIT_NOT_EXPRESSION
	| op='!' expression
	#LOGICAL_NOT_EXPRESSION
	| op='&' expression
	#REFERENCE_EXPRESSION
	| expression op=('*'|'/'|'%') expression
	#MULTIPLY_DIVIDE_EXPRESSION
	| expression op=('+'|'-')  expression
	#ADDITIVE_EXPRESSION
	| expression op=('<<'|'>>') expression
	#BIT_SHIFT_EXPRESSION
	| expression op=('<='|'>='|'<'|'>') expression
	#RELATION_EXPRESSION
	| expression op=('=='|'!=') expression
	#EQUALITY_EXPRESSION
	| expression op='&' expression
	#BIT_AND_EXPRESSION
	| expression op='^' expression
	#BIT_XOR_EXPRESSION
	| expression op='|' expression
	#BIT_OR_EXPRESSION
	| expression op='&&' expression
	#LOGICAL_AND_EXPRESSION
	| expression op='||' expression
	#LOGICAL_OR_EXPRESSION
	| <assoc=right> expression op='=' expression
	#ASSIGN_EXPRESSION
	| Identifier '(' expressionList? ')'
	#FUNCTION_CALL
	| Identifier
	#IDENTIFIER
	| INT
	#INT_LITERAL
	| STRING
	#STRING_LITERAL
	| 'true'
	#TRUE
	| 'false'
	#FALSE
	| 'null'
	#NULL
	;

expressionList
	: expression (',' expression)*
	;

PLUS
	: '+' 
	;
MINUS
	: '-' 
	;
MUL
	: '*' 
	;
DIV
	: '/' 
	;
MOD
	: '%'
	;
INC
	: '++' 
	;
DEC
	: '--' 
	;
BIT_NOT
	: '~' 
	;
LOGICAL_NOT
	: '!' 
	;
BIT_AND
	: '&' 
	;
BIT_XOR
	: '^' 
	;
BIT_OR
	: '|'
	;
LOGICAL_AND
	: '&&'
	;
LOGICAL_OR
	: '||'
	;
ASSIGN
	: '='
	;
EQUAL
	: '=='
	;
INEQUAL
	: '!='
	;
LESS
	: '<'
	;
GREATER
	: '>'
	;
LESS_EQUAL
	: '<='
	;
GREATER_EQUAL
	: '>='
	;
LEFT_SHIFT
	: '<<'
	;
RIGHT_SHIFT
	: '>>'
	;
PERIOD
	: '.'
	;
COMMA
	: ','
	;
LBRACKET
    : '['
    ;
RBRACKET
    : ']'
    ;


	
