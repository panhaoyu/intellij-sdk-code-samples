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

Identifier = [:jletter:] ([:jletterdigit:]*|".")

Number=[0-9][0-9.]*([eE]-?[0-9]+)?

BinaryOperator = { ArithmeticOperator } | { ComparisonOperator } | { EqualityOperator } | { LogicalOperator } | {MemberAccessOperator}

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
    {BinaryOperator} {return SimpleTypes.BINARY_OPERATOR;}

    {AssignmentOperator} {return SimpleTypes.ASSIGNMENT_OPERATOR;}

    {UnaryOperator} {return SimpleTypes.UNARY_OPERATOR;}

    {WhiteSpace}+ {return TokenType.WHITE_SPACE;}

    // Comments
    {Comment} {return SimpleTypes.COMMENT;}

    {LeftCurlyBracket} {return SimpleTypes.LEFT_CURLY_BRACKET; }
    {RightCurlyBracket} {return SimpleTypes.RIGHT_CURLY_BRACKET; }
    {LeftParenthesis} {return SimpleTypes.LEFT_PARENTHESIS; }
    {RightParenthesis} {return SimpleTypes.RIGHT_PARENTHESIS; }
    {LeftSquareBracket} {return SimpleTypes.LEFT_SQUARE_BRACKET; }
    {RightSquareBracket} {return SimpleTypes.RIGHT_SQUARE_BRACKET; }

    {FunctionCallOperator} {return SimpleTypes.FUNCTION_CALL_OPERATOR; }
    {DotOperator} {return SimpleTypes.DOT_OPERATOR; }
    {CommaOperator} {return SimpleTypes.COMMA_OPERATOR; }
}

/* error fallback */
[^] { return TokenType.BAD_CHARACTER; }
