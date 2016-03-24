grammar Mo;

COMMENT : '//' ~[\r\n]* '\r'? '\n' -> skip ;

WS : [ \t\n\r]+ -> skip ;

INT : [0-9]+ ;

ID : [a-zA-z_][a-zA-z0-9_]* ;
STRING : '"' (ESC | .)*? '"' ;
fragment ESC : '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

ori_type : 'int'
         | 'string'
         | ID
         ;

type : type '[' ']' | ori_type ;

prog : (decl | def)* ;

decl : class_decl
     | var_decl
     | func_decl
     ;

var_decl : type ID (',' ID)* ';' ;

class_decl : 'class' ID? '{' var_decl* '}' ';' ;

func_decl : (type | 'void') ID '(' paramters_list ')' ';' ;

paramters_list : (type ID) (',' type ID)*
               |
               ;

def : func_def | var_def;

var_def : type ID '=' expr (',' ID ('=' expr)? )* ';';

func_def : (type | 'void') ID '(' paramters_list ')' compound_stmt ;

compound_stmt : '{' stmt* '}' ;

stmt : compound_stmt
     | if_stmt
     | for_stmt
     | while_stmt
     | expr_stmt
     | jump_stmt
     ;

if_stmt : 'if' '(' expr ')' stmt
        | 'if' '(' expr ')' stmt 'else' stmt
        ;

for_stmt : 'for' '(' expr ';' expr ';' stmt ')' stmt ;

while_stmt : 'while' '(' expr ')' stmt ;

expr_stmt : expr ';' ;

jump_stmt : 'return' expr ';'
          | 'break' ';'
          | 'continue' ';'
          ;

left_value : ID
           | ID '.' ID
           | ID '[' expr ']';

constant : INT | STRING | 'true' | 'false' | 'null' ;

expr : '(' expr ')'
     | expr '[' expr ']'
     | expr '.' expr
     | expr ('++'|'--')
     | ('-'|'~'|'!'|'++'|'--'|'+'|'&') expr
     | expr ('*'|'/'|'%') expr
     | expr ('+'|'-') expr
     | expr ('<<'|'>>') expr
     | expr ('<='|'>='|'<'|'>') expr
     | expr ('=='|'!=') expr
     | expr '&' expr
     | expr '^' expr
     | expr '|' expr
     | expr '&&' expr
     | expr '||' expr
     | left_value '=' expr
     | func_call
     | ID
     | constant
     ;

func_call : ID '(' paramters_list ')' ;