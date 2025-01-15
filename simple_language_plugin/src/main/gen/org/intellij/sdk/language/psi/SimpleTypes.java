// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType ASSIGN_LEFT_FOR_LOOP = new SimpleElementType("ASSIGN_LEFT_FOR_LOOP");
  IElementType BLOCK_CASE_OF = new SimpleElementType("BLOCK_CASE_OF");
  IElementType BLOCK_CASE_OPTION = new SimpleElementType("BLOCK_CASE_OPTION");
  IElementType BLOCK_CMD = new SimpleElementType("BLOCK_CMD");
  IElementType BLOCK_DEFINE = new SimpleElementType("BLOCK_DEFINE");
  IElementType BLOCK_ELSE = new SimpleElementType("BLOCK_ELSE");
  IElementType BLOCK_ELSE_IF = new SimpleElementType("BLOCK_ELSE_IF");
  IElementType BLOCK_FISH = new SimpleElementType("BLOCK_FISH");
  IElementType BLOCK_HEADER_LOOP = new SimpleElementType("BLOCK_HEADER_LOOP");
  IElementType BLOCK_IF = new SimpleElementType("BLOCK_IF");
  IElementType BLOCK_LOOP = new SimpleElementType("BLOCK_LOOP");
  IElementType BLOCK_SECTION = new SimpleElementType("BLOCK_SECTION");
  IElementType BLOCK_SINGLE_FISH = new SimpleElementType("BLOCK_SINGLE_FISH");
  IElementType BODY_CASE_OF = new SimpleElementType("BODY_CASE_OF");
  IElementType BODY_CMD = new SimpleElementType("BODY_CMD");
  IElementType BODY_ELSE = new SimpleElementType("BODY_ELSE");
  IElementType BODY_ELSE_IF = new SimpleElementType("BODY_ELSE_IF");
  IElementType BODY_FISH_DEFINE = new SimpleElementType("BODY_FISH_DEFINE");
  IElementType BODY_IF = new SimpleElementType("BODY_IF");
  IElementType BODY_LOOP = new SimpleElementType("BODY_LOOP");
  IElementType BODY_SECTION = new SimpleElementType("BODY_SECTION");
  IElementType CMD_BLOCK = new SimpleElementType("CMD_BLOCK");
  IElementType CMD_STAT_FUNC_CALL = new SimpleElementType("CMD_STAT_FUNC_CALL");
  IElementType CMD_STAT_INLINE_FISH = new SimpleElementType("CMD_STAT_INLINE_FISH");
  IElementType CMD_STAT_OTHER = new SimpleElementType("CMD_STAT_OTHER");
  IElementType EOL = new SimpleElementType("EOL");
  IElementType FISH_DEFINE_HEADER = new SimpleElementType("FISH_DEFINE_HEADER");
  IElementType LOOP_INDEXED_RANGE = new SimpleElementType("LOOP_INDEXED_RANGE");
  IElementType STAT_ASSIGN = new SimpleElementType("STAT_ASSIGN");
  IElementType STAT_FISH = new SimpleElementType("STAT_FISH");
  IElementType TK_IDENTIFIER = new SimpleElementType("TK_IDENTIFIER");
  IElementType TK_LITERAL = new SimpleElementType("TK_LITERAL");
  IElementType TK_VALUE = new SimpleElementType("TK_VALUE");

  IElementType ARRAY = new SimpleTokenType("ARRAY");
  IElementType ASSIGNMENT_OPERATOR = new SimpleTokenType("ASSIGNMENT_OPERATOR");
  IElementType BINARY_OPERATOR = new SimpleTokenType("BINARY_OPERATOR");
  IElementType BREAK = new SimpleTokenType("BREAK");
  IElementType CASE = new SimpleTokenType("CASE");
  IElementType CASEOF = new SimpleTokenType("CASEOF");
  IElementType COMMAND = new SimpleTokenType("COMMAND");
  IElementType COMMA_OPERATOR = new SimpleTokenType("COMMA_OPERATOR");
  IElementType COMMENT = new SimpleTokenType("COMMENT");
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
      if (type == ASSIGN_LEFT_FOR_LOOP) {
        return new SimpleAssignLeftForLoopImpl(node);
      }
      else if (type == BLOCK_CASE_OF) {
        return new SimpleBlockCaseOfImpl(node);
      }
      else if (type == BLOCK_CASE_OPTION) {
        return new SimpleBlockCaseOptionImpl(node);
      }
      else if (type == BLOCK_CMD) {
        return new SimpleBlockCmdImpl(node);
      }
      else if (type == BLOCK_DEFINE) {
        return new SimpleBlockDefineImpl(node);
      }
      else if (type == BLOCK_ELSE) {
        return new SimpleBlockElseImpl(node);
      }
      else if (type == BLOCK_ELSE_IF) {
        return new SimpleBlockElseIfImpl(node);
      }
      else if (type == BLOCK_FISH) {
        return new SimpleBlockFishImpl(node);
      }
      else if (type == BLOCK_HEADER_LOOP) {
        return new SimpleBlockHeaderLoopImpl(node);
      }
      else if (type == BLOCK_IF) {
        return new SimpleBlockIfImpl(node);
      }
      else if (type == BLOCK_LOOP) {
        return new SimpleBlockLoopImpl(node);
      }
      else if (type == BLOCK_SECTION) {
        return new SimpleBlockSectionImpl(node);
      }
      else if (type == BLOCK_SINGLE_FISH) {
        return new SimpleBlockSingleFishImpl(node);
      }
      else if (type == BODY_CASE_OF) {
        return new SimpleBodyCaseOfImpl(node);
      }
      else if (type == BODY_CMD) {
        return new SimpleBodyCmdImpl(node);
      }
      else if (type == BODY_ELSE) {
        return new SimpleBodyElseImpl(node);
      }
      else if (type == BODY_ELSE_IF) {
        return new SimpleBodyElseIfImpl(node);
      }
      else if (type == BODY_FISH_DEFINE) {
        return new SimpleBodyFishDefineImpl(node);
      }
      else if (type == BODY_IF) {
        return new SimpleBodyIfImpl(node);
      }
      else if (type == BODY_LOOP) {
        return new SimpleBodyLoopImpl(node);
      }
      else if (type == BODY_SECTION) {
        return new SimpleBodySectionImpl(node);
      }
      else if (type == CMD_BLOCK) {
        return new SimpleCmdBlockImpl(node);
      }
      else if (type == CMD_STAT_FUNC_CALL) {
        return new SimpleCmdStatFuncCallImpl(node);
      }
      else if (type == CMD_STAT_INLINE_FISH) {
        return new SimpleCmdStatInlineFishImpl(node);
      }
      else if (type == CMD_STAT_OTHER) {
        return new SimpleCmdStatOtherImpl(node);
      }
      else if (type == EOL) {
        return new SimpleEolImpl(node);
      }
      else if (type == FISH_DEFINE_HEADER) {
        return new SimpleFishDefineHeaderImpl(node);
      }
      else if (type == LOOP_INDEXED_RANGE) {
        return new SimpleLoopIndexedRangeImpl(node);
      }
      else if (type == STAT_ASSIGN) {
        return new SimpleStatAssignImpl(node);
      }
      else if (type == STAT_FISH) {
        return new SimpleStatFishImpl(node);
      }
      else if (type == TK_IDENTIFIER) {
        return new SimpleTkIdentifierImpl(node);
      }
      else if (type == TK_LITERAL) {
        return new SimpleTkLiteralImpl(node);
      }
      else if (type == TK_VALUE) {
        return new SimpleTkValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
