// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

import com.intellij.formatting.WhiteSpace;import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import groovyjarjarantlr.Token;import org.bouncycastle.pqc.jcajce.interfaces.SABERKey;
import org.intellij.sdk.language.psi.SimpleTypes;
import com.intellij.psi.TokenType;

%%

%class SimpleLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
  StringBuffer string = new StringBuffer();
%}


NewLine = (\R( \t)*)

WhiteSpace     = [ \t\x0B\f]+
Ellipsis       = "..."


Comment     = ;.*

Identifier = ([:jletter:]|_) ([:jletterdigit:]|".")*

Number=[0-9][0-9.]*([eE]-?[0-9]+)?

BinaryOperator = { ArithmeticOperator } | { ComparisonOperator } | { EqualityOperator } | { LogicalOperator } | {MemberAccessOperator}

ArithmeticOperator = { PlusOperator } | { MultiplyOperator } | { DivideOperator } | { FloorDivideOperator } | { ModulusOperator } | { ExponentOperator }
PlusOperator = "+"
MultiplyOperator = "*"
DivideOperator = "/"
FloorDivideOperator = "//"
ModulusOperator = "%"
ExponentOperator = "^"

ComparisonOperator = { GreaterThanOperator } | { LessThanOperator } | { GreaterThanOrEqualOperator } | { LessThanOrEqualOperator }
GreaterThanOperator = ">"
LessThanOperator = "<"
GreaterThanOrEqualOperator = ">="
LessThanOrEqualOperator = "<="

EqualityOperator = { EqualsOperator } | { NotEqualsOperator }
EqualsOperator = "=="
NotEqualsOperator = "#"

LogicalOperator = { AndOperator } | { OrOperator }
AndOperator = "&"
OrOperator = "|"

UnaryOperator = { LogicalNotOperator } | { MultithreadOperator}
LogicalNotOperator = "~"
MultithreadOperator = "::"

AssignmentOperator = { DirectAssignmentOperator } | { AddAssignmentOperator } | { SubtractAssignmentOperator } | { MultiplyAssignmentOperator } | { DivideAssignmentOperator } | { ModulusAssignmentOperator }
DirectAssignmentOperator = "="
AddAssignmentOperator = "+="
SubtractAssignmentOperator = "-="
MultiplyAssignmentOperator = "*="
DivideAssignmentOperator = "/="
ModulusAssignmentOperator = "%="

MemberAccessOperator = "->"


StringA = \" [^\"]* \"

StringB = \' [^\']* \'

String = {StringA} | {StringB}


%state STRING

%%

//Keywords
<YYINITIAL> {
    "end section"| "endsection" | "endSection" | "end_section" { return SimpleTypes.ENDSECTION; }
    "exitsection" | "exitSection" | "exit_section" | "exit section" {return SimpleTypes.EXITSECTION; }
    "caseof" | "case_of"  { return SimpleTypes.CASEOF; }
    "case" { return SimpleTypes.CASE; }
    "endcase" | "end_case" { return SimpleTypes.ENDCASE; }
    "command" { return SimpleTypes.COMMAND; }
    "endcommand" | "end_command"  { return SimpleTypes.ENDCOMMAND; }
    "fish define" { return SimpleTypes.FISH_DEFINE; }
    "def" { return SimpleTypes.FISH_DEFINE; }
    "define" { return SimpleTypes.FISH_DEFINE; }
    "fish operator" { return SimpleTypes.FISH_OPERATOR; }
    "end" { return SimpleTypes.END; }
    "exit" { return SimpleTypes.EXIT; }
    "global" { return SimpleTypes.GLOBAL; }
    "if" { return SimpleTypes.IF; }
    "elseif" | "else_if"  { return SimpleTypes.ELSEIF; }
    "else" { return SimpleTypes.ELSE; }
    "endif" | "end_if"  { return SimpleTypes.ENDIF; }
    "local" { return SimpleTypes.LOCAL; }
    "lock" { return SimpleTypes.LOCK; }
    "loop" { return SimpleTypes.LOOP; }
    "foreach" { return SimpleTypes.FOREACH; }
    "while" { return SimpleTypes.WHILE; }
    "for" { return SimpleTypes.FOR; }
    "exitloop" | "exit_loop" | "exitLoop"  { return SimpleTypes.EXITLOOP; }
    "endloop" | "endLoop" | "end_loop" { return SimpleTypes.ENDLOOP; }
    "continue" { return SimpleTypes.CONTINUE; }
    "break" { return SimpleTypes.BREAK; }
    "return" { return SimpleTypes.RETURN; }
    "section" { return SimpleTypes.SECTION; }
    "struct" | "structure" { return SimpleTypes.STRUCT; }
    "then"  { return SimpleTypes.THEN; }
    "Array" {return SimpleTypes.ARRAY; }
}

//Identifiers
<YYINITIAL>{
    //Identifiers
    {Identifier} {return SimpleTypes.IDENTIFIER;}

    //Literals
    {Number} {return SimpleTypes.NUMBER_LITERAL;}

    {String} {return SimpleTypes.STRING_LITERAL;}

    // Operators
    {BinaryOperator} {return SimpleTypes.BINARY_OPERATOR;}

    {AssignmentOperator} {return SimpleTypes.ASSIGNMENT_OPERATOR;}

    {UnaryOperator} {return SimpleTypes.UNARY_OPERATOR;}

    {WhiteSpace} {return TokenType.WHITE_SPACE;}

    {NewLine} {return SimpleTypes.NEWLINE;}

    {Comment} {return SimpleTypes.COMMENT;}


    \} {return SimpleTypes.LEFT_CURLY_BRACKET; }
    \{ {return SimpleTypes.RIGHT_CURLY_BRACKET; }
    \( {return SimpleTypes.LEFT_PARENTHESIS; }
    \) {return SimpleTypes.RIGHT_PARENTHESIS; }
    \[ {return SimpleTypes.LEFT_SQUARE_BRACKET; }
    \] {return SimpleTypes.RIGHT_SQUARE_BRACKET; }

    \@ {return SimpleTypes.FUNCTION_CALL_OPERATOR; }
    \. {return SimpleTypes.DOT_OPERATOR; }
    \, {return SimpleTypes.COMMA_OPERATOR; }
    \- {return SimpleTypes.MINUS_OPERATOR;}

    {Ellipsis} {WhiteSpace}* {NewLine} {return TokenType.WHITE_SPACE; }
    {Ellipsis} {return TokenType.WHITE_SPACE; }

}

/* error fallback */
[^] { return TokenType.BAD_CHARACTER; }
