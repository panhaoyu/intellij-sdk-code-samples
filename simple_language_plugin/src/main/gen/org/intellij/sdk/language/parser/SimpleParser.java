// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.SimpleTypes.*;
import static org.intellij.sdk.language.parser.SimpleParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimpleParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return simpleFile(b, l + 1);
  }

  /* ********************************************************** */
  // (expression (',' expression)* )?
  static boolean argumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList")) return false;
    argumentList_0(b, l + 1);
    return true;
  }

  // expression (',' expression)*
  private static boolean argumentList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && argumentList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' expression)*
  private static boolean argumentList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argumentList_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argumentList_0_1", c)) break;
    }
    return true;
  }

  // ',' expression
  private static boolean argumentList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' expression
  static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression operator expression
  static boolean binaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'case' expression statementBlock
  static boolean caseClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClause")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "case");
    r = r && expression(b, l + 1);
    r = r && statementBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'case_of' expression caseClause* 'end_case'
  static boolean caseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "case_of");
    r = r && expression(b, l + 1);
    r = r && caseStatement_2(b, l + 1);
    r = r && consumeToken(b, "end_case");
    exit_section_(b, m, null, r);
    return r;
  }

  // caseClause*
  private static boolean caseStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStatement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseStatement_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COMMENT
  static boolean comment(PsiBuilder b, int l) {
    return consumeToken(b, COMMENT);
  }

  /* ********************************************************** */
  // ifStatement | loopStatement | caseStatement
  static boolean controlFlow(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "controlFlow")) return false;
    boolean r;
    r = ifStatement(b, l + 1);
    if (!r) r = loopStatement(b, l + 1);
    if (!r) r = caseStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // statementBlock
  static boolean controlStructure(PsiBuilder b, int l) {
    return statementBlock(b, l + 1);
  }

  /* ********************************************************** */
  // CRLF
  static boolean crlf(PsiBuilder b, int l) {
    return consumeToken(b, CRLF);
  }

  /* ********************************************************** */
  // 'else' 'if' expression 'then' statementBlock
  static boolean elseIfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseIfStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && consumeToken(b, "if");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && statementBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'else' statementBlock
  static boolean elseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && statementBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // binaryExpression | unaryExpression | literal | IDENTIFIER
  static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    r = binaryExpression(b, l + 1);
    if (!r) r = unaryExpression(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '(' argumentList ')'
  static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && argumentList(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'fish' 'define' functionName '(' parameterList ')' controlStructure
  static boolean functionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "fish");
    r = r && consumeToken(b, "define");
    r = r && functionName(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && parameterList(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && controlStructure(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  static boolean functionName(PsiBuilder b, int l) {
    return consumeToken(b, IDENTIFIER);
  }

  /* ********************************************************** */
  // 'global' IDENTIFIER (',' IDENTIFIER)* ('=' expression)?
  static boolean globalVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "global");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && globalVariableDeclaration_2(b, l + 1);
    r = r && globalVariableDeclaration_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean globalVariableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!globalVariableDeclaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "globalVariableDeclaration_2", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean globalVariableDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' expression)?
  private static boolean globalVariableDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_3")) return false;
    globalVariableDeclaration_3_0(b, l + 1);
    return true;
  }

  // '=' expression
  private static boolean globalVariableDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'if' expression 'then' statementBlock elseIfStatement* elseStatement? 'end_if'
  static boolean ifStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "if");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && statementBlock(b, l + 1);
    r = r && ifStatement_4(b, l + 1);
    r = r && ifStatement_5(b, l + 1);
    r = r && consumeToken(b, "end_if");
    exit_section_(b, m, null, r);
    return r;
  }

  // elseIfStatement*
  private static boolean ifStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elseIfStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ifStatement_4", c)) break;
    }
    return true;
  }

  // elseStatement?
  private static boolean ifStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement_5")) return false;
    elseStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // outerScopeStatement|functionDefinition|multilineComment|separator|crlf
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = outerScopeStatement(b, l + 1);
    if (!r) r = functionDefinition(b, l + 1);
    if (!r) r = multilineComment(b, l + 1);
    if (!r) r = separator(b, l + 1);
    if (!r) r = crlf(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KEYWORD
  static boolean keyword(PsiBuilder b, int l) {
    return consumeToken(b, KEYWORD);
  }

  /* ********************************************************** */
  // STRING_LITERAL | NUMBER_LITERAL
  static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    if (!nextTokenIs(b, "", NUMBER_LITERAL, STRING_LITERAL)) return false;
    boolean r;
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, NUMBER_LITERAL);
    return r;
  }

  /* ********************************************************** */
  // 'local' IDENTIFIER (',' IDENTIFIER)* ('=' expression)?
  static boolean localVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "local");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && localVariableDeclaration_2(b, l + 1);
    r = r && localVariableDeclaration_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean localVariableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!localVariableDeclaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "localVariableDeclaration_2", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean localVariableDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' expression)?
  private static boolean localVariableDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_3")) return false;
    localVariableDeclaration_3_0(b, l + 1);
    return true;
  }

  // '=' expression
  private static boolean localVariableDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'loop' statementBlock 'end_loop'
  static boolean loopStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loopStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "loop");
    r = r && statementBlock(b, l + 1);
    r = r && consumeToken(b, "end_loop");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // comment+
  static boolean multilineComment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multilineComment")) return false;
    if (!nextTokenIs(b, COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comment(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multilineComment", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OPERATOR
  static boolean operator(PsiBuilder b, int l) {
    return consumeToken(b, OPERATOR);
  }

  /* ********************************************************** */
  // '[' statement ']'
  static boolean outerScopeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outerScopeStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && statement(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  static boolean parameter(PsiBuilder b, int l) {
    return consumeToken(b, IDENTIFIER);
  }

  /* ********************************************************** */
  // (parameter (',' parameter)* )?
  static boolean parameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList")) return false;
    parameterList_0(b, l + 1);
    return true;
  }

  // parameter (',' parameter)*
  private static boolean parameterList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && parameterList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' parameter)*
  private static boolean parameterList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameterList_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameterList_0_1", c)) break;
    }
    return true;
  }

  // ',' parameter
  private static boolean parameterList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY)
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, SimpleParser::recover_property);
    return r;
  }

  /* ********************************************************** */
  // !(KEY|SEPARATOR|COMMENT)
  static boolean recover_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_property_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY|SEPARATOR|COMMENT
  private static boolean recover_property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property_0")) return false;
    boolean r;
    r = consumeToken(b, KEY);
    if (!r) r = consumeToken(b, SEPARATOR);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // SEPARATOR
  static boolean separator(PsiBuilder b, int l) {
    return consumeToken(b, SEPARATOR);
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // controlFlow | assignment | functionCall | multilineComment | localVariableDeclaration | globalVariableDeclaration
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = controlFlow(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = multilineComment(b, l + 1);
    if (!r) r = localVariableDeclaration(b, l + 1);
    if (!r) r = globalVariableDeclaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean statementBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statementBlock")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statementBlock", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // operator expression
  static boolean unaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression")) return false;
    if (!nextTokenIs(b, OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
