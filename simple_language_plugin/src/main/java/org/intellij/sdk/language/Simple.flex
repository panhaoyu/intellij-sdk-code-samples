// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

import com.intellij.formatting.WhiteSpace;import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.bouncycastle.pqc.jcajce.interfaces.SABERKey;
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


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = {EndOfLineComment}

EndOfLineComment     = ";" {InputCharacter}* {LineTerminator}?

Identifier = [:jletter:] [:jletterdigit:]*

Number=[0-9][0-9.]*([eE]-?[0-9]+)?

Operators = {ArithmeticOperator} | {ComparisonOperator} | {EqualityOperator} | {LogicalOperator} | {UnaryOperator} | {AssignmentOperator} | {MemberAccessOperator} | {FunctionCallOperator} | {BracketOperator} | {CommaOperator} | {DotOperator}

ArithmeticOperator = { PlusOperator } | { MinusOperator } | { MultiplyOperator } | { DivideOperator } | { FloorDivideOperator } | { ModulusOperator } | { ExponentOperator }
PlusOperator = "+"
MinusOperator = "-"
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

UnaryOperator = { NegationOperator } | { LogicalNotOperator }
NegationOperator = "-"
LogicalNotOperator = "~"

AssignmentOperator = { DirectAssignmentOperator } | { AddAssignmentOperator } | { SubtractAssignmentOperator } | { MultiplyAssignmentOperator } | { DivideAssignmentOperator } | { ModulusAssignmentOperator }
DirectAssignmentOperator = "="
AddAssignmentOperator = "+="
SubtractAssignmentOperator = "-="
MultiplyAssignmentOperator = "*="
DivideAssignmentOperator = "/="
ModulusAssignmentOperator = "%="

MemberAccessOperator = "->"

FunctionCallOperator    =     "@"
CommaOperator = ","
DotOperator = "."

// Bracket Operators
BracketOperator = {LeftParenthesis} | {RightParenthesis} | {LeftSquareBracket} | {RightSquareBracket} | {LeftCurlyBracket} | {RightCurlyBracket}
LeftParenthesis         = "("
RightParenthesis        = ")"
LeftSquareBracket       = "["
RightSquareBracket      = "]"
LeftCurlyBracket        = "{"
RightCurlyBracket       = "}"

StringA = \" [^\"]* \"

StringB = \' [^\']* \'

String = {StringA} | {StringB}

Keywords = (
    "fish" |
    "caseof" | "case_of" | "case of" |
    "case" |
    "endcase" | "end_case" | "end case" |
    "command" |
    "endcommand" | "end_command" | "end command" |
    "define" |
    "end" |
    "exit" |
    "global" |
    "if" |
    "elseif" | "else_if" | "else if" |
    "else" |
    "endif" | "end_if" | "end if" |
    "local" |
    "lock" |
    "loop" |
    "endloop" | "end_loop" | "end loop" |
    "exitloop" | "exit_loop" | "exit loop" |
    "continue" |
    "return" |
    "section" |
    "endsection" | "end_section" | "end section" |
    "exitsection" | "exit_section" | "exit section" |
    "struct" | "structure"
)


%state STRING

%%

//Keywords
<YYINITIAL> {Keywords} {return SimpleTypes.KEYWORD;}

//Identifiers
<YYINITIAL>{
    //Identifiers
    {Identifier} {return SimpleTypes.IDENTIFIER;}

    //Literals
    {Number} {return SimpleTypes.NUMBER_LITERAL;}

    {String} {return SimpleTypes.STRING_LITERAL;}

    // Operators
    {Operators} {return SimpleTypes.OPERATOR;}

    {WhiteSpace}+ {return SimpleTypes.OPERATOR;}

    // Comments
    {Comment} {return SimpleTypes.COMMENT;}
}

/* error fallback */
[^] { return TokenType.BAD_CHARACTER; }
