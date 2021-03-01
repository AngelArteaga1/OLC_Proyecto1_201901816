package Analizadores;
import java_cup.runtime.*;

%%

%class Lexico
%cupsym sym
%cup 
%public
%unicode
%line 
%column
%ignorecase

%init{
    
%init}

//Caracteres Neutros
blancos = [ \t\r\n]+
//letra = [A-Za-z]
//entero = [0-9]+
identificador = [A-Za-z]([A-Za-z]|[0-9]+|"_")*
commen = ("//".*\n)|("//".*\r)
commenM = ("<""!"[^\!]*"!"">")
cadena = ("\""[^\"]*"\"")
caracterespecial = ("\\""n"|"\\""\'"|"\\""\"")
conjunto = (.)"~"(.)
conjuntoExp = ((.)" "*","" "*)+(.)
//id = [!-}]
%{
    
%}

%%


//MANDAMOS LOS SIMBOLOS A LA TABLA DE SIMBOLOS
//Caracteres Neutros
\n {yycolumn=1;}
{commen} {/*se ignoran*/}
{commenM} {/*se ignoran*/}
{blancos} {/*se ignoran*/}
"{" {return new Symbol(sym.TKParA,yycolumn,yyline,yytext());}
"}" {return new Symbol(sym.TKParC,yycolumn,yyline,yytext());}
"," {return new Symbol(sym.TKComa,yycolumn,yyline,yytext());}
"|" {return new Symbol(sym.TKBarra,yycolumn,yyline,yytext());}
"." {return new Symbol(sym.TKPunto,yycolumn,yyline,yytext());}
"+" {return new Symbol(sym.TKMas,yycolumn,yyline,yytext());}
"*" {return new Symbol(sym.TKAsterisco,yycolumn,yyline,yytext());}
"%" {return new Symbol(sym.TKPorcentaje,yycolumn,yyline,yytext());}
";" {return new Symbol(sym.TKPuntoComa,yycolumn,yyline,yytext());}
"?" {return new Symbol(sym.TKInterrogacion,yycolumn,yyline,yytext());}
"~" {return new Symbol(sym.TKColocho,yycolumn,yyline,yytext());}
":" {return new Symbol(sym.TKDosPuntos,yycolumn,yyline,yytext());}
"-" {return new Symbol(sym.TKGuion,yycolumn,yyline,yytext());}
">" {return new Symbol(sym.TKMayor,yycolumn,yyline,yytext());}
"CONJ" {return new Symbol(sym.TKConj,yycolumn,yyline,yytext());}
{identificador} {return new Symbol(sym.identificador,yycolumn,yyline,yytext());}
//{letra} {return new Symbol(sym.letra,yycolumn,yyline,yytext());}
{caracterespecial} {return new Symbol(sym.caracterespecial,yycolumn,yyline,yytext());}
{cadena} {return new Symbol(sym.cadena,yycolumn,yyline,yytext());}
{conjunto} {return new Symbol(sym.conjunto,yycolumn,yyline,yytext());}
{conjuntoExp} {return new Symbol(sym.conjuntoExp,yycolumn,yyline,yytext());}
//{id} {return new Symbol(sym.id,yycolumn,yyline,yytext());}

//CUALQUIER ERROR:           SIMBOLOS NO DEFINIDOS DENTRO DEL LENGUAJE
.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yycolumn));
    }
