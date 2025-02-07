// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType COMMAND_BLOCK = new SimpleElementType("COMMAND_BLOCK");
  IElementType COMMAND_BLOCK_DEFINE = new SimpleElementType("COMMAND_BLOCK_DEFINE");
  IElementType COMMAND_BLOCK_SINGLE = new SimpleElementType("COMMAND_BLOCK_SINGLE");
  IElementType COMMAND_INLINE_FISH_LINE = new SimpleElementType("COMMAND_INLINE_FISH_LINE");
  IElementType COMMAND_INLINE_FISH_LINE_ARRAY_DECLARE = new SimpleElementType("COMMAND_INLINE_FISH_LINE_ARRAY_DECLARE");
  IElementType COMMAND_INLINE_FISH_LINE_ASSIGN = new SimpleElementType("COMMAND_INLINE_FISH_LINE_ASSIGN");
  IElementType COMMAND_INLINE_FISH_LINE_EXPR = new SimpleElementType("COMMAND_INLINE_FISH_LINE_EXPR");
  IElementType COMMAND_LINE = new SimpleElementType("COMMAND_LINE");
  IElementType COMMAND_TOKEN_ALL = new SimpleElementType("COMMAND_TOKEN_ALL");
  IElementType COMMAND_TOKEN_FUNC_CALL = new SimpleElementType("COMMAND_TOKEN_FUNC_CALL");
  IElementType COMMAND_TOKEN_IDENTIFIER = new SimpleElementType("COMMAND_TOKEN_IDENTIFIER");
  IElementType COMMAND_TOKEN_IDENTIFIER_WITHOUT_MINUS = new SimpleElementType("COMMAND_TOKEN_IDENTIFIER_WITHOUT_MINUS");
  IElementType COMMAND_TOKEN_INLINE_FISH = new SimpleElementType("COMMAND_TOKEN_INLINE_FISH");
  IElementType COMMAND_TOKEN_KEYWORD_ALL = new SimpleElementType("COMMAND_TOKEN_KEYWORD_ALL");
  IElementType COMMAND_TOKEN_NUMBER_LITERAL = new SimpleElementType("COMMAND_TOKEN_NUMBER_LITERAL");
  IElementType COMMAND_TOKEN_SIMPLE_OPERATION = new SimpleElementType("COMMAND_TOKEN_SIMPLE_OPERATION");
  IElementType CURLY_L = new SimpleElementType("CURLY_L");
  IElementType CURLY_R = new SimpleElementType("CURLY_R");
  IElementType EOL = new SimpleElementType("EOL");
  IElementType FISH_ASSIGN_SCOPE = new SimpleElementType("FISH_ASSIGN_SCOPE");
  IElementType FISH_BLOCK = new SimpleElementType("FISH_BLOCK");
  IElementType FISH_BLOCK_BODY_CASE_OF = new SimpleElementType("FISH_BLOCK_BODY_CASE_OF");
  IElementType FISH_BLOCK_BODY_COMMAND = new SimpleElementType("FISH_BLOCK_BODY_COMMAND");
  IElementType FISH_BLOCK_BODY_DEFINE = new SimpleElementType("FISH_BLOCK_BODY_DEFINE");
  IElementType FISH_BLOCK_BODY_ELSE = new SimpleElementType("FISH_BLOCK_BODY_ELSE");
  IElementType FISH_BLOCK_BODY_ELSE_IF = new SimpleElementType("FISH_BLOCK_BODY_ELSE_IF");
  IElementType FISH_BLOCK_BODY_IF = new SimpleElementType("FISH_BLOCK_BODY_IF");
  IElementType FISH_BLOCK_BODY_LOOP = new SimpleElementType("FISH_BLOCK_BODY_LOOP");
  IElementType FISH_BLOCK_BODY_SECTION = new SimpleElementType("FISH_BLOCK_BODY_SECTION");
  IElementType FISH_BLOCK_CASE_OF = new SimpleElementType("FISH_BLOCK_CASE_OF");
  IElementType FISH_BLOCK_COMMAND = new SimpleElementType("FISH_BLOCK_COMMAND");
  IElementType FISH_BLOCK_IF = new SimpleElementType("FISH_BLOCK_IF");
  IElementType FISH_BLOCK_LOOP = new SimpleElementType("FISH_BLOCK_LOOP");
  IElementType FISH_BLOCK_SECTION = new SimpleElementType("FISH_BLOCK_SECTION");
  IElementType FISH_BLOCK_SINGLE = new SimpleElementType("FISH_BLOCK_SINGLE");
  IElementType FISH_EXPR = new SimpleElementType("FISH_EXPR");
  IElementType FISH_EXPR_ASSIGN = new SimpleElementType("FISH_EXPR_ASSIGN");
  IElementType FISH_EXPR_ASSIGN_LEFT_FOR_LOOP = new SimpleElementType("FISH_EXPR_ASSIGN_LEFT_FOR_LOOP");
  IElementType FISH_EXPR_ASSIGN_RIGHT = new SimpleElementType("FISH_EXPR_ASSIGN_RIGHT");
  IElementType FISH_EXPR_ASSIGN_TARGET = new SimpleElementType("FISH_EXPR_ASSIGN_TARGET");
  IElementType FISH_EXPR_CSV = new SimpleElementType("FISH_EXPR_CSV");
  IElementType FISH_EXPR_DEFINE_PARAMS = new SimpleElementType("FISH_EXPR_DEFINE_PARAMS");
  IElementType FISH_EXPR_FUNC_CALL = new SimpleElementType("FISH_EXPR_FUNC_CALL");
  IElementType FISH_EXPR_FUNC_CALL_FUNC_NAME = new SimpleElementType("FISH_EXPR_FUNC_CALL_FUNC_NAME");
  IElementType FISH_EXPR_LOOP_INDEXED = new SimpleElementType("FISH_EXPR_LOOP_INDEXED");
  IElementType FISH_EXPR_PAREN = new SimpleElementType("FISH_EXPR_PAREN");
  IElementType FISH_EXPR_SQUARE = new SimpleElementType("FISH_EXPR_SQUARE");
  IElementType FISH_EXPR_UNARY = new SimpleElementType("FISH_EXPR_UNARY");
  IElementType FISH_EXPR_VALUE = new SimpleElementType("FISH_EXPR_VALUE");
  IElementType FISH_LINE = new SimpleElementType("FISH_LINE");
  IElementType FISH_LINE_ARRAY_DECLARE = new SimpleElementType("FISH_LINE_ARRAY_DECLARE");
  IElementType FISH_LINE_ASSIGN = new SimpleElementType("FISH_LINE_ASSIGN");
  IElementType FISH_LINE_BREAK = new SimpleElementType("FISH_LINE_BREAK");
  IElementType FISH_LINE_CASE_OF_BLOCK_FOOTER = new SimpleElementType("FISH_LINE_CASE_OF_BLOCK_FOOTER");
  IElementType FISH_LINE_CASE_OF_BLOCK_HEADER = new SimpleElementType("FISH_LINE_CASE_OF_BLOCK_HEADER");
  IElementType FISH_LINE_CASE_OF_BLOCK_OPTION = new SimpleElementType("FISH_LINE_CASE_OF_BLOCK_OPTION");
  IElementType FISH_LINE_COMMAND_FOOTER = new SimpleElementType("FISH_LINE_COMMAND_FOOTER");
  IElementType FISH_LINE_COMMAND_HEADER = new SimpleElementType("FISH_LINE_COMMAND_HEADER");
  IElementType FISH_LINE_COMMENT = new SimpleElementType("FISH_LINE_COMMENT");
  IElementType FISH_LINE_CONTINUE = new SimpleElementType("FISH_LINE_CONTINUE");
  IElementType FISH_LINE_DEFINE_FOOTER = new SimpleElementType("FISH_LINE_DEFINE_FOOTER");
  IElementType FISH_LINE_DEFINE_HEADER = new SimpleElementType("FISH_LINE_DEFINE_HEADER");
  IElementType FISH_LINE_EXIT = new SimpleElementType("FISH_LINE_EXIT");
  IElementType FISH_LINE_EXIT_LOOP = new SimpleElementType("FISH_LINE_EXIT_LOOP");
  IElementType FISH_LINE_EXIT_SECTION = new SimpleElementType("FISH_LINE_EXIT_SECTION");
  IElementType FISH_LINE_EXPR = new SimpleElementType("FISH_LINE_EXPR");
  IElementType FISH_LINE_IF_BLOCK_ELSE = new SimpleElementType("FISH_LINE_IF_BLOCK_ELSE");
  IElementType FISH_LINE_IF_BLOCK_ELSE_IF = new SimpleElementType("FISH_LINE_IF_BLOCK_ELSE_IF");
  IElementType FISH_LINE_IF_BLOCK_FOOTER = new SimpleElementType("FISH_LINE_IF_BLOCK_FOOTER");
  IElementType FISH_LINE_IF_BLOCK_HEADER = new SimpleElementType("FISH_LINE_IF_BLOCK_HEADER");
  IElementType FISH_LINE_LOOP_BLOCK_FOOTER = new SimpleElementType("FISH_LINE_LOOP_BLOCK_FOOTER");
  IElementType FISH_LINE_LOOP_BLOCK_HEADER = new SimpleElementType("FISH_LINE_LOOP_BLOCK_HEADER");
  IElementType FISH_LINE_RETURN = new SimpleElementType("FISH_LINE_RETURN");
  IElementType FISH_LINE_SECTION_FOOTER = new SimpleElementType("FISH_LINE_SECTION_FOOTER");
  IElementType FISH_LINE_SECTION_HEADER = new SimpleElementType("FISH_LINE_SECTION_HEADER");
  IElementType KW_ARRAY = new SimpleElementType("KW_ARRAY");
  IElementType KW_BREAK = new SimpleElementType("KW_BREAK");
  IElementType KW_CASE = new SimpleElementType("KW_CASE");
  IElementType KW_CASE_OF = new SimpleElementType("KW_CASE_OF");
  IElementType KW_COMMAND = new SimpleElementType("KW_COMMAND");
  IElementType KW_CONTINUE = new SimpleElementType("KW_CONTINUE");
  IElementType KW_ELSE = new SimpleElementType("KW_ELSE");
  IElementType KW_ELSE_IF = new SimpleElementType("KW_ELSE_IF");
  IElementType KW_END = new SimpleElementType("KW_END");
  IElementType KW_ENDLOOP = new SimpleElementType("KW_ENDLOOP");
  IElementType KW_END_CASE = new SimpleElementType("KW_END_CASE");
  IElementType KW_END_COMMAND = new SimpleElementType("KW_END_COMMAND");
  IElementType KW_END_IF = new SimpleElementType("KW_END_IF");
  IElementType KW_END_SECTION = new SimpleElementType("KW_END_SECTION");
  IElementType KW_EXIT = new SimpleElementType("KW_EXIT");
  IElementType KW_EXIT_LOOP = new SimpleElementType("KW_EXIT_LOOP");
  IElementType KW_EXIT_SECTION = new SimpleElementType("KW_EXIT_SECTION");
  IElementType KW_FISH_DEFINE = new SimpleElementType("KW_FISH_DEFINE");
  IElementType KW_FISH_OPERATOR = new SimpleElementType("KW_FISH_OPERATOR");
  IElementType KW_FOR = new SimpleElementType("KW_FOR");
  IElementType KW_FOREACH = new SimpleElementType("KW_FOREACH");
  IElementType KW_GLOBAL = new SimpleElementType("KW_GLOBAL");
  IElementType KW_IF = new SimpleElementType("KW_IF");
  IElementType KW_LOCAL = new SimpleElementType("KW_LOCAL");
  IElementType KW_LOOP = new SimpleElementType("KW_LOOP");
  IElementType KW_RETURN = new SimpleElementType("KW_RETURN");
  IElementType KW_SECTION = new SimpleElementType("KW_SECTION");
  IElementType KW_STRUCT = new SimpleElementType("KW_STRUCT");
  IElementType KW_THEN = new SimpleElementType("KW_THEN");
  IElementType KW_WHILE = new SimpleElementType("KW_WHILE");
  IElementType LOOP_EACH = new SimpleElementType("LOOP_EACH");
  IElementType LOOP_FOR = new SimpleElementType("LOOP_FOR");
  IElementType LOOP_WHILE = new SimpleElementType("LOOP_WHILE");
  IElementType OP_ASSIGN = new SimpleElementType("OP_ASSIGN");
  IElementType OP_AT = new SimpleElementType("OP_AT");
  IElementType OP_BINARY = new SimpleElementType("OP_BINARY");
  IElementType OP_BINARY_WITHOUT_MINUS = new SimpleElementType("OP_BINARY_WITHOUT_MINUS");
  IElementType OP_COMMA = new SimpleElementType("OP_COMMA");
  IElementType OP_COMMENT = new SimpleElementType("OP_COMMENT");
  IElementType OP_DOT = new SimpleElementType("OP_DOT");
  IElementType OP_MINUS = new SimpleElementType("OP_MINUS");
  IElementType OP_UNARY = new SimpleElementType("OP_UNARY");
  IElementType PAREN_L = new SimpleElementType("PAREN_L");
  IElementType PAREN_R = new SimpleElementType("PAREN_R");
  IElementType SQUARE_L = new SimpleElementType("SQUARE_L");
  IElementType SQUARE_R = new SimpleElementType("SQUARE_R");
  IElementType TK_COMMENT = new SimpleElementType("TK_COMMENT");
  IElementType TK_COMMENT_TEXT = new SimpleElementType("TK_COMMENT_TEXT");
  IElementType TK_IDENTIFIER = new SimpleElementType("TK_IDENTIFIER");
  IElementType TK_IDENTIFIER_RAW = new SimpleElementType("TK_IDENTIFIER_RAW");
  IElementType TK_LITERAL = new SimpleElementType("TK_LITERAL");
  IElementType TK_NEWLINE = new SimpleElementType("TK_NEWLINE");
  IElementType TK_NUMBER_LITERAL = new SimpleElementType("TK_NUMBER_LITERAL");
  IElementType TK_STRING_LITERAL = new SimpleElementType("TK_STRING_LITERAL");
  IElementType TK_VALUE = new SimpleElementType("TK_VALUE");

  IElementType ARRAY = new SimpleTokenType("ARRAY");
  IElementType ASSIGNMENT_OPERATOR = new SimpleTokenType("ASSIGNMENT_OPERATOR");
  IElementType BINARY_OPERATOR = new SimpleTokenType("BINARY_OPERATOR");
  IElementType BREAK = new SimpleTokenType("BREAK");
  IElementType CASE = new SimpleTokenType("CASE");
  IElementType CASEOF = new SimpleTokenType("CASEOF");
  IElementType COMMAND = new SimpleTokenType("COMMAND");
  IElementType COMMA_OPERATOR = new SimpleTokenType("COMMA_OPERATOR");
  IElementType COMMENT_OPERATOR = new SimpleTokenType("COMMENT_OPERATOR");
  IElementType COMMENT_TEXT = new SimpleTokenType("COMMENT_TEXT");
  IElementType CONTINUE = new SimpleTokenType("CONTINUE");
  IElementType DOT_OPERATOR = new SimpleTokenType("DOT_OPERATOR");
  IElementType ELSE = new SimpleTokenType("ELSE");
  IElementType ELSEIF = new SimpleTokenType("ELSEIF");
  IElementType END = new SimpleTokenType("END");
  IElementType ENDCASE = new SimpleTokenType("ENDCASE");
  IElementType ENDCOMMAND = new SimpleTokenType("ENDCOMMAND");
  IElementType ENDIF = new SimpleTokenType("ENDIF");
  IElementType ENDLOOP = new SimpleTokenType("ENDLOOP");
  IElementType ENDSECTION = new SimpleTokenType("ENDSECTION");
  IElementType EXIT = new SimpleTokenType("EXIT");
  IElementType EXITLOOP = new SimpleTokenType("EXITLOOP");
  IElementType EXITSECTION = new SimpleTokenType("EXITSECTION");
  IElementType FISH_DEFINE = new SimpleTokenType("FISH_DEFINE");
  IElementType FISH_OPERATOR = new SimpleTokenType("FISH_OPERATOR");
  IElementType FOR = new SimpleTokenType("FOR");
  IElementType FOREACH = new SimpleTokenType("FOREACH");
  IElementType FUNCTION_CALL_OPERATOR = new SimpleTokenType("FUNCTION_CALL_OPERATOR");
  IElementType GLOBAL = new SimpleTokenType("GLOBAL");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType IF = new SimpleTokenType("IF");
  IElementType LEFT_CURLY_BRACKET = new SimpleTokenType("LEFT_CURLY_BRACKET");
  IElementType LEFT_PARENTHESIS = new SimpleTokenType("LEFT_PARENTHESIS");
  IElementType LEFT_SQUARE_BRACKET = new SimpleTokenType("LEFT_SQUARE_BRACKET");
  IElementType LOCAL = new SimpleTokenType("LOCAL");
  IElementType LOCK = new SimpleTokenType("LOCK");
  IElementType LOOP = new SimpleTokenType("LOOP");
  IElementType MINUS_OPERATOR = new SimpleTokenType("MINUS_OPERATOR");
  IElementType NEWLINE = new SimpleTokenType("NEWLINE");
  IElementType NUMBER_LITERAL = new SimpleTokenType("NUMBER_LITERAL");
  IElementType RETURN = new SimpleTokenType("RETURN");
  IElementType RIGHT_CURLY_BRACKET = new SimpleTokenType("RIGHT_CURLY_BRACKET");
  IElementType RIGHT_PARENTHESIS = new SimpleTokenType("RIGHT_PARENTHESIS");
  IElementType RIGHT_SQUARE_BRACKET = new SimpleTokenType("RIGHT_SQUARE_BRACKET");
  IElementType SECTION = new SimpleTokenType("SECTION");
  IElementType STRING_LITERAL = new SimpleTokenType("STRING_LITERAL");
  IElementType STRUCT = new SimpleTokenType("STRUCT");
  IElementType THEN = new SimpleTokenType("THEN");
  IElementType UNARY_OPERATOR = new SimpleTokenType("UNARY_OPERATOR");
  IElementType WHILE = new SimpleTokenType("WHILE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMAND_BLOCK) {
        return new SimpleCommandBlockImpl(node);
      }
      else if (type == COMMAND_BLOCK_DEFINE) {
        return new SimpleCommandBlockDefineImpl(node);
      }
      else if (type == COMMAND_BLOCK_SINGLE) {
        return new SimpleCommandBlockSingleImpl(node);
      }
      else if (type == COMMAND_INLINE_FISH_LINE) {
        return new SimpleCommandInlineFishLineImpl(node);
      }
      else if (type == COMMAND_INLINE_FISH_LINE_ARRAY_DECLARE) {
        return new SimpleCommandInlineFishLineArrayDeclareImpl(node);
      }
      else if (type == COMMAND_INLINE_FISH_LINE_ASSIGN) {
        return new SimpleCommandInlineFishLineAssignImpl(node);
      }
      else if (type == COMMAND_INLINE_FISH_LINE_EXPR) {
        return new SimpleCommandInlineFishLineExprImpl(node);
      }
      else if (type == COMMAND_LINE) {
        return new SimpleCommandLineImpl(node);
      }
      else if (type == COMMAND_TOKEN_ALL) {
        return new SimpleCommandTokenAllImpl(node);
      }
      else if (type == COMMAND_TOKEN_FUNC_CALL) {
        return new SimpleCommandTokenFuncCallImpl(node);
      }
      else if (type == COMMAND_TOKEN_IDENTIFIER) {
        return new SimpleCommandTokenIdentifierImpl(node);
      }
      else if (type == COMMAND_TOKEN_IDENTIFIER_WITHOUT_MINUS) {
        return new SimpleCommandTokenIdentifierWithoutMinusImpl(node);
      }
      else if (type == COMMAND_TOKEN_INLINE_FISH) {
        return new SimpleCommandTokenInlineFishImpl(node);
      }
      else if (type == COMMAND_TOKEN_KEYWORD_ALL) {
        return new SimpleCommandTokenKeywordAllImpl(node);
      }
      else if (type == COMMAND_TOKEN_NUMBER_LITERAL) {
        return new SimpleCommandTokenNumberLiteralImpl(node);
      }
      else if (type == COMMAND_TOKEN_SIMPLE_OPERATION) {
        return new SimpleCommandTokenSimpleOperationImpl(node);
      }
      else if (type == CURLY_L) {
        return new SimpleCurlyLImpl(node);
      }
      else if (type == CURLY_R) {
        return new SimpleCurlyRImpl(node);
      }
      else if (type == EOL) {
        return new SimpleEolImpl(node);
      }
      else if (type == FISH_ASSIGN_SCOPE) {
        return new SimpleFishAssignScopeImpl(node);
      }
      else if (type == FISH_BLOCK) {
        return new SimpleFishBlockImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_CASE_OF) {
        return new SimpleFishBlockBodyCaseOfImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_COMMAND) {
        return new SimpleFishBlockBodyCommandImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_DEFINE) {
        return new SimpleFishBlockBodyDefineImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_ELSE) {
        return new SimpleFishBlockBodyElseImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_ELSE_IF) {
        return new SimpleFishBlockBodyElseIfImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_IF) {
        return new SimpleFishBlockBodyIfImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_LOOP) {
        return new SimpleFishBlockBodyLoopImpl(node);
      }
      else if (type == FISH_BLOCK_BODY_SECTION) {
        return new SimpleFishBlockBodySectionImpl(node);
      }
      else if (type == FISH_BLOCK_CASE_OF) {
        return new SimpleFishBlockCaseOfImpl(node);
      }
      else if (type == FISH_BLOCK_COMMAND) {
        return new SimpleFishBlockCommandImpl(node);
      }
      else if (type == FISH_BLOCK_IF) {
        return new SimpleFishBlockIfImpl(node);
      }
      else if (type == FISH_BLOCK_LOOP) {
        return new SimpleFishBlockLoopImpl(node);
      }
      else if (type == FISH_BLOCK_SECTION) {
        return new SimpleFishBlockSectionImpl(node);
      }
      else if (type == FISH_BLOCK_SINGLE) {
        return new SimpleFishBlockSingleImpl(node);
      }
      else if (type == FISH_EXPR) {
        return new SimpleFishExprImpl(node);
      }
      else if (type == FISH_EXPR_ASSIGN) {
        return new SimpleFishExprAssignImpl(node);
      }
      else if (type == FISH_EXPR_ASSIGN_LEFT_FOR_LOOP) {
        return new SimpleFishExprAssignLeftForLoopImpl(node);
      }
      else if (type == FISH_EXPR_ASSIGN_RIGHT) {
        return new SimpleFishExprAssignRightImpl(node);
      }
      else if (type == FISH_EXPR_ASSIGN_TARGET) {
        return new SimpleFishExprAssignTargetImpl(node);
      }
      else if (type == FISH_EXPR_CSV) {
        return new SimpleFishExprCsvImpl(node);
      }
      else if (type == FISH_EXPR_DEFINE_PARAMS) {
        return new SimpleFishExprDefineParamsImpl(node);
      }
      else if (type == FISH_EXPR_FUNC_CALL) {
        return new SimpleFishExprFuncCallImpl(node);
      }
      else if (type == FISH_EXPR_FUNC_CALL_FUNC_NAME) {
        return new SimpleFishExprFuncCallFuncNameImpl(node);
      }
      else if (type == FISH_EXPR_LOOP_INDEXED) {
        return new SimpleFishExprLoopIndexedImpl(node);
      }
      else if (type == FISH_EXPR_PAREN) {
        return new SimpleFishExprParenImpl(node);
      }
      else if (type == FISH_EXPR_SQUARE) {
        return new SimpleFishExprSquareImpl(node);
      }
      else if (type == FISH_EXPR_UNARY) {
        return new SimpleFishExprUnaryImpl(node);
      }
      else if (type == FISH_EXPR_VALUE) {
        return new SimpleFishExprValueImpl(node);
      }
      else if (type == FISH_LINE) {
        return new SimpleFishLineImpl(node);
      }
      else if (type == FISH_LINE_ARRAY_DECLARE) {
        return new SimpleFishLineArrayDeclareImpl(node);
      }
      else if (type == FISH_LINE_ASSIGN) {
        return new SimpleFishLineAssignImpl(node);
      }
      else if (type == FISH_LINE_BREAK) {
        return new SimpleFishLineBreakImpl(node);
      }
      else if (type == FISH_LINE_CASE_OF_BLOCK_FOOTER) {
        return new SimpleFishLineCaseOfBlockFooterImpl(node);
      }
      else if (type == FISH_LINE_CASE_OF_BLOCK_HEADER) {
        return new SimpleFishLineCaseOfBlockHeaderImpl(node);
      }
      else if (type == FISH_LINE_CASE_OF_BLOCK_OPTION) {
        return new SimpleFishLineCaseOfBlockOptionImpl(node);
      }
      else if (type == FISH_LINE_COMMAND_FOOTER) {
        return new SimpleFishLineCommandFooterImpl(node);
      }
      else if (type == FISH_LINE_COMMAND_HEADER) {
        return new SimpleFishLineCommandHeaderImpl(node);
      }
      else if (type == FISH_LINE_COMMENT) {
        return new SimpleFishLineCommentImpl(node);
      }
      else if (type == FISH_LINE_CONTINUE) {
        return new SimpleFishLineContinueImpl(node);
      }
      else if (type == FISH_LINE_DEFINE_FOOTER) {
        return new SimpleFishLineDefineFooterImpl(node);
      }
      else if (type == FISH_LINE_DEFINE_HEADER) {
        return new SimpleFishLineDefineHeaderImpl(node);
      }
      else if (type == FISH_LINE_EXIT) {
        return new SimpleFishLineExitImpl(node);
      }
      else if (type == FISH_LINE_EXIT_LOOP) {
        return new SimpleFishLineExitLoopImpl(node);
      }
      else if (type == FISH_LINE_EXIT_SECTION) {
        return new SimpleFishLineExitSectionImpl(node);
      }
      else if (type == FISH_LINE_EXPR) {
        return new SimpleFishLineExprImpl(node);
      }
      else if (type == FISH_LINE_IF_BLOCK_ELSE) {
        return new SimpleFishLineIfBlockElseImpl(node);
      }
      else if (type == FISH_LINE_IF_BLOCK_ELSE_IF) {
        return new SimpleFishLineIfBlockElseIfImpl(node);
      }
      else if (type == FISH_LINE_IF_BLOCK_FOOTER) {
        return new SimpleFishLineIfBlockFooterImpl(node);
      }
      else if (type == FISH_LINE_IF_BLOCK_HEADER) {
        return new SimpleFishLineIfBlockHeaderImpl(node);
      }
      else if (type == FISH_LINE_LOOP_BLOCK_FOOTER) {
        return new SimpleFishLineLoopBlockFooterImpl(node);
      }
      else if (type == FISH_LINE_LOOP_BLOCK_HEADER) {
        return new SimpleFishLineLoopBlockHeaderImpl(node);
      }
      else if (type == FISH_LINE_RETURN) {
        return new SimpleFishLineReturnImpl(node);
      }
      else if (type == FISH_LINE_SECTION_FOOTER) {
        return new SimpleFishLineSectionFooterImpl(node);
      }
      else if (type == FISH_LINE_SECTION_HEADER) {
        return new SimpleFishLineSectionHeaderImpl(node);
      }
      else if (type == KW_ARRAY) {
        return new SimpleKwArrayImpl(node);
      }
      else if (type == KW_BREAK) {
        return new SimpleKwBreakImpl(node);
      }
      else if (type == KW_CASE) {
        return new SimpleKwCaseImpl(node);
      }
      else if (type == KW_CASE_OF) {
        return new SimpleKwCaseOfImpl(node);
      }
      else if (type == KW_COMMAND) {
        return new SimpleKwCommandImpl(node);
      }
      else if (type == KW_CONTINUE) {
        return new SimpleKwContinueImpl(node);
      }
      else if (type == KW_ELSE) {
        return new SimpleKwElseImpl(node);
      }
      else if (type == KW_ELSE_IF) {
        return new SimpleKwElseIfImpl(node);
      }
      else if (type == KW_END) {
        return new SimpleKwEndImpl(node);
      }
      else if (type == KW_ENDLOOP) {
        return new SimpleKwEndloopImpl(node);
      }
      else if (type == KW_END_CASE) {
        return new SimpleKwEndCaseImpl(node);
      }
      else if (type == KW_END_COMMAND) {
        return new SimpleKwEndCommandImpl(node);
      }
      else if (type == KW_END_IF) {
        return new SimpleKwEndIfImpl(node);
      }
      else if (type == KW_END_SECTION) {
        return new SimpleKwEndSectionImpl(node);
      }
      else if (type == KW_EXIT) {
        return new SimpleKwExitImpl(node);
      }
      else if (type == KW_EXIT_LOOP) {
        return new SimpleKwExitLoopImpl(node);
      }
      else if (type == KW_EXIT_SECTION) {
        return new SimpleKwExitSectionImpl(node);
      }
      else if (type == KW_FISH_DEFINE) {
        return new SimpleKwFishDefineImpl(node);
      }
      else if (type == KW_FISH_OPERATOR) {
        return new SimpleKwFishOperatorImpl(node);
      }
      else if (type == KW_FOR) {
        return new SimpleKwForImpl(node);
      }
      else if (type == KW_FOREACH) {
        return new SimpleKwForeachImpl(node);
      }
      else if (type == KW_GLOBAL) {
        return new SimpleKwGlobalImpl(node);
      }
      else if (type == KW_IF) {
        return new SimpleKwIfImpl(node);
      }
      else if (type == KW_LOCAL) {
        return new SimpleKwLocalImpl(node);
      }
      else if (type == KW_LOOP) {
        return new SimpleKwLoopImpl(node);
      }
      else if (type == KW_RETURN) {
        return new SimpleKwReturnImpl(node);
      }
      else if (type == KW_SECTION) {
        return new SimpleKwSectionImpl(node);
      }
      else if (type == KW_STRUCT) {
        return new SimpleKwStructImpl(node);
      }
      else if (type == KW_THEN) {
        return new SimpleKwThenImpl(node);
      }
      else if (type == KW_WHILE) {
        return new SimpleKwWhileImpl(node);
      }
      else if (type == LOOP_EACH) {
        return new SimpleLoopEachImpl(node);
      }
      else if (type == LOOP_FOR) {
        return new SimpleLoopForImpl(node);
      }
      else if (type == LOOP_WHILE) {
        return new SimpleLoopWhileImpl(node);
      }
      else if (type == OP_ASSIGN) {
        return new SimpleOpAssignImpl(node);
      }
      else if (type == OP_AT) {
        return new SimpleOpAtImpl(node);
      }
      else if (type == OP_BINARY) {
        return new SimpleOpBinaryImpl(node);
      }
      else if (type == OP_BINARY_WITHOUT_MINUS) {
        return new SimpleOpBinaryWithoutMinusImpl(node);
      }
      else if (type == OP_COMMA) {
        return new SimpleOpCommaImpl(node);
      }
      else if (type == OP_COMMENT) {
        return new SimpleOpCommentImpl(node);
      }
      else if (type == OP_DOT) {
        return new SimpleOpDotImpl(node);
      }
      else if (type == OP_MINUS) {
        return new SimpleOpMinusImpl(node);
      }
      else if (type == OP_UNARY) {
        return new SimpleOpUnaryImpl(node);
      }
      else if (type == PAREN_L) {
        return new SimpleParenLImpl(node);
      }
      else if (type == PAREN_R) {
        return new SimpleParenRImpl(node);
      }
      else if (type == SQUARE_L) {
        return new SimpleSquareLImpl(node);
      }
      else if (type == SQUARE_R) {
        return new SimpleSquareRImpl(node);
      }
      else if (type == TK_COMMENT) {
        return new SimpleTkCommentImpl(node);
      }
      else if (type == TK_COMMENT_TEXT) {
        return new SimpleTkCommentTextImpl(node);
      }
      else if (type == TK_IDENTIFIER) {
        return new SimpleTkIdentifierImpl(node);
      }
      else if (type == TK_IDENTIFIER_RAW) {
        return new SimpleTkIdentifierRawImpl(node);
      }
      else if (type == TK_LITERAL) {
        return new SimpleTkLiteralImpl(node);
      }
      else if (type == TK_NEWLINE) {
        return new SimpleTkNewlineImpl(node);
      }
      else if (type == TK_NUMBER_LITERAL) {
        return new SimpleTkNumberLiteralImpl(node);
      }
      else if (type == TK_STRING_LITERAL) {
        return new SimpleTkStringLiteralImpl(node);
      }
      else if (type == TK_VALUE) {
        return new SimpleTkValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
