grammar Mo;

COMMENT : '//' ~[\r\n]* '\r'? '\n' -> skip ;

WS : [ \t\n\r]+ -> skip ;

INT : [0-9]+ ;

ID : [a-zA-z_][a-zA-z0-9_]* ;
STRING : '"' (ESC | .)*? '"' ;
fragment ESC : '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

type : 'int'
     | 'string'
     | ID
     ;

prog : decl prog
     | def prog
     |
     ;

decl : class_decl
     | var_decl
     | func_decl
     ;

var_decl : type ID (',' ID)* ';'
         | type ID '=' expr ';'
         ;

class_decl : 'class' ID '{' var_decl* '}' ';' ;

func_decl : (type | 'void') ID '(' paramters_list ')' ';' ;

paramters_list : (type ID)*
               ;

def : func_def ;

func_def : (type | 'void') ID '(' paramters_list ')' compound_stmt ;

compound_stmt : '{' stmt+ '}' ;

stmt : compound_stmt
     | if_stmt
     | for_stmt
     | while_stmt
     | assign_stmt
     | expr_stmt
     ;

if_stmt : 'if' '(' expr ')' stmt
        | 'if' '(' expr ')' stmt 'else' stmt
        ;

for_stmt : 'for' '(' expr ';' expr ';' stmt ')' stmt ;

while_stmt : 'while' '(' expr ')' stmt ;

assign_stmt : lvalue '=' expr ';' ;

expr_stmt : expr ';' ;

lvalue : ID;

expr : expr ('&&'|'||') expr
     | expr ('+'|'-') expr
     | expr ('*'|'/') expr
     | ID | INT | STRING
     ;
