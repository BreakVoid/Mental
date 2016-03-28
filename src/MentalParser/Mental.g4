grammar Mental;
COMMENT
    : '//' ~[\r\n]* '\r'? ('\n'|EOF) -> skip
    ;

WS
    : [ \t\n\r]+ -> skip
    ;

INT
    : [0-9]+
    ;

ID
    : [a-zA-z_][a-zA-z0-9_]*
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
    | ID
    ;

type
    : originalType
    | originalType '[' ']'
    ;

paramtersList
    : (type ID) (',' type ID)*
    ;

program
    : (declaration | definition)*
    ;

declaration
    : classDeclaration
    | functionDeclaration
    ;

classDeclaration
    : 'class' ID? '{' variableDefinition* '}'
    ;

functionDeclaration
    : (type | 'void') ID '(' paramtersList? ')' ';'
    ;

definition
    : variableDefinition
    | functionDefinition
    ;

variableDefinition
    : type ID ('=' expression)? (',' ID ('=' expression)?)* ';'
    ;

functionDefinition
    : (type | 'void') ID '(' paramtersList? ')' compoundStatement
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

leftValue
    : ID
    | ID '.' ID
    | ID '[' expression ']'
    | | ('++'|'--') leftValue
    ;

expression
    : 'new' type ('[' expression ']')*
    #CREATION_EXPRESSION
    | '(' expression ')'
    #SUBGROUP_EXPRESSION
    | expression '[' expression ']'
    #ARRAY_SUBSCRIPTING_EXPRESSION
    | expression '.' expression
    #MEMBER_ACCESS_EXPRESSION
    | expression ('++' | '--')
    #SUFFIX_INC_DEC_EXPRESSION
    | ('++'|'--') leftValue
    #PREFIX_INC_DEC_EXPRESSION
    | ('+'|'-') expression
    #UNRAY_PLUS_MINUS_EXPRESSION
    | '~' expression
    #BIT_NOT_EXPRESSION
    | '!' expression
    #LOGICAL_NOT_EXPRESSION
    | '&' expression
    #REFERENCE_EXPRESSION
    | expression ('*'|'/'|'%') expression
    #MULTIPLY_DIVIDE_EXPRESSION
    | expression ('+'|'-')  expression
    #ADDITIVE_EXPRESSION
    | expression ('<<'|'>>') expression
    #BIT_SHIFT_EXPRESSION
    | expression ('<='|'>='|'<'|'>') expression
    #RELATION_EXPRESSION
    | expression ('=='|'!=') expression
    #EQUALITY_EXPRESSION
    | expression '&' expression
    #BIT_AND_EXPRESSION
    | expression '^' expression
    #BIT_XOR_EXPRESSION
    | expression '|' expression
    #BIT_OR_EXPRESSION
    | expression '&&' expression
    #LOGICAL_AND_EXPRESSION
    | expression '||' expression
    #LOGICAL_OR_EXPRESSION
    | <assoc=right> expression '=' expression
    #ASSIGN_EXPRESSION
    | ID '(' expressionList? ')'
    #FUNCTION_CALL
    | ID
    #IDENTIFIER
    | INT
    #CONSTANT
    | STRING
    #CONSTANT
    | 'true'
    #CONSTANT
    | 'false'
    #CONSTANT
    | 'null'
    #CONSTANT
    ;

expressionList
    : expression (',' expression)*
    ;


