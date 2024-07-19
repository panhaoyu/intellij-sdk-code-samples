// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

// 导入 IntelliJ SDK 和其他库所需的类。
import com.intellij.formatting.WhiteSpace;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import groovyjarjarantlr.Token;
import org.bouncycastle.pqc.jcajce.interfaces.SABERKey;
import org.intellij.sdk.language.psi.SimpleTypes;
import com.intellij.psi.TokenType;

// FlexLexer 规范从这里开始。

%%

// 定义 lexer 类并实现 FlexLexer 接口。
%class SimpleLexer
%implements FlexLexer

// 指定 lexer 应处理 Unicode 字符。
%unicode

// 定义将用于推进 lexer 状态的函数名。
%function advance

// 指定 lexer 将生成的标记类型。
%type IElementType

// 定义在到达文件结束符 (EOF) 时的操作。
%eof{
    return;
%eof}

// 定义一个字符串缓冲区以供 lexer 内部使用。
%{
  StringBuffer string = new StringBuffer();
%}

// 定义标记的模式。

// 新行模式，可能带有缩进（空格或制表符）。
NewLine = (\R( \t)*)

// 空白模式（空格、制表符、垂直制表符、换页符）。
WhiteSpace = [ \t\x0B\f]+

// 省略号模式 ("...")。
Ellipsis = "..."


// 注释模式（以 ';' 开头）。
Comment = ;.*

/*
 * 标识符模式。
 * 标识符以字母或下划线开头，后跟字母、数字或点。
 */
Identifier = ([:jletter:]|_) ([:jletterdigit:]|".")*

// 数字字面量模式。
Number = [0-9][0-9.]*([eE]-?[0-9]+)?

/*
 * 二进制运算符模式。
 * 包括算术运算符、比较运算符、相等运算符、逻辑运算符和成员访问运算符。
 */
BinaryOperator = { ArithmeticOperator } | { ComparisonOperator } | { EqualityOperator } | { LogicalOperator } | {MemberAccessOperator}

// 算术运算符模式。
ArithmeticOperator = { PlusOperator } | { MultiplyOperator } | { DivideOperator } | { FloorDivideOperator } | { ModulusOperator } | { ExponentOperator }
PlusOperator = "+"
MultiplyOperator = "*"
DivideOperator = "/"
FloorDivideOperator = "//"
ModulusOperator = "%"
ExponentOperator = "^"

// 比较运算符模式。
ComparisonOperator = { GreaterThanOperator } | { LessThanOperator } | { GreaterThanOrEqualOperator } | { LessThanOrEqualOperator }
GreaterThanOperator = ">"
LessThanOperator = "<"
GreaterThanOrEqualOperator = ">="
LessThanOrEqualOperator = "<="

// 相等运算符模式。
EqualityOperator = { EqualsOperator } | { NotEqualsOperator }
EqualsOperator = "=="
NotEqualsOperator = "#"

// 逻辑运算符模式。
LogicalOperator = { AndOperator } | { OrOperator }
AndOperator = "&"
OrOperator = "|"

// 一元运算符模式。
UnaryOperator = { LogicalNotOperator } | { MultithreadOperator}
LogicalNotOperator = "~"
MultithreadOperator = "::"

// 赋值运算符模式。
AssignmentOperator = { DirectAssignmentOperator } | { AddAssignmentOperator } | { SubtractAssignmentOperator } | { MultiplyAssignmentOperator } | { DivideAssignmentOperator } | { ModulusAssignmentOperator }
DirectAssignmentOperator = "="
AddAssignmentOperator = "+="
SubtractAssignmentOperator = "-="
MultiplyAssignmentOperator = "*="
DivideAssignmentOperator = "/="
ModulusAssignmentOperator = "%="

// 成员访问运算符模式。
MemberAccessOperator = "->"

// 字符串字面量模式。
StringA = \" [^\"]* \"
StringB = \' [^\']* \'
String = {StringA} | {StringB}

// 定义一个用于处理字符串的特定状态。
%state STRING

%%

// 关键字的标记模式。
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

// 标识符、字面量、运算符和分隔符的标记模式。
<YYINITIAL>{
    {Identifier} {return SimpleTypes.IDENTIFIER;}
    {Number} {return SimpleTypes.NUMBER_LITERAL;}
    {String} {return SimpleTypes.STRING_LITERAL;}
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

/* 处理所有未识别的字符作为错误标记。 */
[^] { return TokenType.BAD_CHARACTER; }