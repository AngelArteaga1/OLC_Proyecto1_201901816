package Analizadores;
import java_cup.runtime.*;
import Application.Errores;

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

//EXPRESIONES REGULARES DE MI LENGUAJE
blancos = [ \t\r\n]+
entero = [0-9]
identificador = [A-Za-z]([A-Za-z]|[0-9]+|"_")*
commen = ("//".*\n)|("//".*\r)
commenM = ("<""!"[^\!]*"!"">")
cadena = ("\""([^\"]*)"\"")
caracterespecial = ("\\""n"|"\\""\'"|"\\""\"")

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
{caracterespecial} {return new Symbol(sym.caracterespecial,yycolumn,yyline,yytext());}
{cadena} {return new Symbol(sym.cadena,yycolumn,yyline,yytext());}

//USAREMOS TODOS LOS CODIGO ASCII
{entero} {return new Symbol(sym.entero,yycolumn,yyline,yytext());}
"!" {return new Symbol(sym.C33,yycolumn,yyline,yytext());}
"#" {return new Symbol(sym.C35,yycolumn,yyline,yytext());}
"$" {return new Symbol(sym.C36,yycolumn,yyline,yytext());}
"&" {return new Symbol(sym.C38,yycolumn,yyline,yytext());}
"(" {return new Symbol(sym.C40,yycolumn,yyline,yytext());}
")" {return new Symbol(sym.C41,yycolumn,yyline,yytext());}
"/" {return new Symbol(sym.C47,yycolumn,yyline,yytext());}
"<" {return new Symbol(sym.C60,yycolumn,yyline,yytext());}
"=" {return new Symbol(sym.C61,yycolumn,yyline,yytext());}
"@" {return new Symbol(sym.C64,yycolumn,yyline,yytext());}
"[" {return new Symbol(sym.C91,yycolumn,yyline,yytext());}
"]" {return new Symbol(sym.C93,yycolumn,yyline,yytext());}
"^" {return new Symbol(sym.C94,yycolumn,yyline,yytext());}
"_" {return new Symbol(sym.C95,yycolumn,yyline,yytext());}
"`" {return new Symbol(sym.C96,yycolumn,yyline,yytext());}

//CUALQUIER ERROR:           SIMBOLOS NO DEFINIDOS DENTRO DEL LENGUAJE
.   {
        Application.App.TxtSalida.append("Error léxico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yycolumn) + "\n");
        Errores err = new Errores("Léxico", "El símbolo \"" + yytext() + "\" no pertenece al lenguaje", (yyline), (yycolumn));
        Application.App.ListaErrores.add(err);
    }
