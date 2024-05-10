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
  // identifier | left_square_bracket | right_square_bracket |
  //  unary_operator | binary_operator| dot_operator|function_call_operator | literal | '...'
  static boolean anyInCommand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyInCommand")) return false;
    boolean r;
    r = identifier(b, l + 1);
    if (!r) r = left_square_bracket(b, l + 1);
    if (!r) r = right_square_bracket(b, l + 1);
    if (!r) r = unary_operator(b, l + 1);
    if (!r) r = binary_operator(b, l + 1);
    if (!r) r = dot_operator(b, l + 1);
    if (!r) r = function_call_operator(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = consumeToken(b, "...");
    return r;
  }

  /* ********************************************************** */
  // (expression (comma_operator expression)* )?
  static boolean argumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList")) return false;
    argumentList_0(b, l + 1);
    return true;
  }

  // expression (comma_operator expression)*
  private static boolean argumentList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && argumentList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator expression)*
  private static boolean argumentList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argumentList_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argumentList_0_1", c)) break;
    }
    return true;
  }

  // comma_operator expression
  private static boolean argumentList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier assignment_operator expression
  static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && assignment_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASSIGNMENT_OPERATOR
  static boolean assignment_operator(PsiBuilder b, int l) {
    return consumeToken(b, ASSIGNMENT_OPERATOR);
  }

  /* ********************************************************** */
  // BINARY_OPERATOR
  static boolean binary_operator(PsiBuilder b, int l) {
    return consumeToken(b, BINARY_OPERATOR);
  }

  /* ********************************************************** */
  // CASE
  static boolean case_$(PsiBuilder b, int l) {
    return consumeToken(b, CASE);
  }

  /* ********************************************************** */
  // case expression statementBlock
  static boolean caseClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClause")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_$(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && statementBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // caseof expression caseClause* endcase
  static boolean caseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStatement")) return false;
    if (!nextTokenIs(b, CASEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseof(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && caseStatement_2(b, l + 1);
    r = r && endcase(b, l + 1);
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
  // CASEOF
  static boolean caseof(PsiBuilder b, int l) {
    return consumeToken(b, CASEOF);
  }

  /* ********************************************************** */
  // Comma_Operator
  static boolean comma_operator(PsiBuilder b, int l) {
    return consumeToken(b, COMMA_OPERATOR);
  }

  /* ********************************************************** */
  // COMMAND
  static boolean command(PsiBuilder b, int l) {
    return consumeToken(b, COMMAND);
  }

  /* ********************************************************** */
  // anyInCommand+
  static boolean commandBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandBlock")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = anyInCommand(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!anyInCommand(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "commandBlock", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command commandBlock* endcommand
  static boolean commandStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandStatement")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1);
    r = r && commandStatement_1(b, l + 1);
    r = r && endcommand(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // commandBlock*
  private static boolean commandStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandStatement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!commandBlock(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "commandStatement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COMMENT
  static boolean comment(PsiBuilder b, int l) {
    return consumeToken(b, COMMENT);
  }

  /* ********************************************************** */
  // CONTINUE
  static boolean continue_$(PsiBuilder b, int l) {
    return consumeToken(b, CONTINUE);
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
  // DEFINE
  static boolean define(PsiBuilder b, int l) {
    return consumeToken(b, DEFINE);
  }

  /* ********************************************************** */
  // Dot_Operator
  static boolean dot_operator(PsiBuilder b, int l) {
    return consumeToken(b, DOT_OPERATOR);
  }

  /* ********************************************************** */
  // ELSE
  static boolean else_$(PsiBuilder b, int l) {
    return consumeToken(b, ELSE);
  }

  /* ********************************************************** */
  // elseif expression then statementBlock
  static boolean elseIfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseIfStatement")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && then(b, l + 1);
    r = r && statementBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // else statementBlock
  static boolean elseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseStatement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = else_$(b, l + 1);
    r = r && statementBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF
  static boolean elseif(PsiBuilder b, int l) {
    return consumeToken(b, ELSEIF);
  }

  /* ********************************************************** */
  // END
  static boolean end(PsiBuilder b, int l) {
    return consumeToken(b, END);
  }

  /* ********************************************************** */
  // ENDCASE
  static boolean endcase(PsiBuilder b, int l) {
    return consumeToken(b, ENDCASE);
  }

  /* ********************************************************** */
  // ENDCOMMAND
  static boolean endcommand(PsiBuilder b, int l) {
    return consumeToken(b, ENDCOMMAND);
  }

  /* ********************************************************** */
  // ENDIF
  static boolean endif(PsiBuilder b, int l) {
    return consumeToken(b, ENDIF);
  }

  /* ********************************************************** */
  // ENDLOOP
  static boolean endloop(PsiBuilder b, int l) {
    return consumeToken(b, ENDLOOP);
  }

  /* ********************************************************** */
  // ENDSECTION
  static boolean endsection(PsiBuilder b, int l) {
    return consumeToken(b, ENDSECTION);
  }

  /* ********************************************************** */
  // EXIT
  static boolean exit(PsiBuilder b, int l) {
    return consumeToken(b, EXIT);
  }

  /* ********************************************************** */
  // EXITLOOP
  static boolean exitloop(PsiBuilder b, int l) {
    return consumeToken(b, EXITLOOP);
  }

  /* ********************************************************** */
  // EXITSECTION
  static boolean exitsection(PsiBuilder b, int l) {
    return consumeToken(b, EXITSECTION);
  }

  /* ********************************************************** */
  // expression_binary_suffix | unaryExpression | literal | identifier
  static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    r = expression_binary_suffix(b, l + 1);
    if (!r) r = unaryExpression(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // expression binary_operator expression
  static boolean expression_binary_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_binary_suffix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && binary_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FISH
  static boolean fish(PsiBuilder b, int l) {
    return consumeToken(b, FISH);
  }

  /* ********************************************************** */
  // identifier left_parenthesis argumentList right_parenthesis
  static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && left_parenthesis(b, l + 1);
    r = r && argumentList(b, l + 1);
    r = r && right_parenthesis(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish define functionName (left_parenthesis parameterList right_parenthesis)? controlStructure
  static boolean functionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefinition")) return false;
    if (!nextTokenIs(b, FISH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish(b, l + 1);
    r = r && define(b, l + 1);
    r = r && functionName(b, l + 1);
    r = r && functionDefinition_3(b, l + 1);
    r = r && controlStructure(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (left_parenthesis parameterList right_parenthesis)?
  private static boolean functionDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefinition_3")) return false;
    functionDefinition_3_0(b, l + 1);
    return true;
  }

  // left_parenthesis parameterList right_parenthesis
  private static boolean functionDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = left_parenthesis(b, l + 1);
    r = r && parameterList(b, l + 1);
    r = r && right_parenthesis(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  static boolean functionName(PsiBuilder b, int l) {
    return identifier(b, l + 1);
  }

  /* ********************************************************** */
  // Function_Call_Operator
  static boolean function_call_operator(PsiBuilder b, int l) {
    return consumeToken(b, FUNCTION_CALL_OPERATOR);
  }

  /* ********************************************************** */
  // GLOBAL
  static boolean global(PsiBuilder b, int l) {
    return consumeToken(b, GLOBAL);
  }

  /* ********************************************************** */
  // global identifier (comma_operator identifier)* (assignment_operator expression)?
  static boolean globalVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration")) return false;
    if (!nextTokenIs(b, GLOBAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = global(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && globalVariableDeclaration_2(b, l + 1);
    r = r && globalVariableDeclaration_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator identifier)*
  private static boolean globalVariableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!globalVariableDeclaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "globalVariableDeclaration_2", c)) break;
    }
    return true;
  }

  // comma_operator identifier
  private static boolean globalVariableDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (assignment_operator expression)?
  private static boolean globalVariableDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_3")) return false;
    globalVariableDeclaration_3_0(b, l + 1);
    return true;
  }

  // assignment_operator expression
  private static boolean globalVariableDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVariableDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  static boolean identifier(PsiBuilder b, int l) {
    return consumeToken(b, IDENTIFIER);
  }

  /* ********************************************************** */
  // IF
  static boolean if_$(PsiBuilder b, int l) {
    return consumeToken(b, IF);
  }

  /* ********************************************************** */
  // if expression then statementBlock elseIfStatement* elseStatement? endif
  static boolean ifStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_$(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && then(b, l + 1);
    r = r && statementBlock(b, l + 1);
    r = r && ifStatement_4(b, l + 1);
    r = r && ifStatement_5(b, l + 1);
    r = r && endif(b, l + 1);
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
  // KEYWORD
  static boolean keyword(PsiBuilder b, int l) {
    return consumeToken(b, KEYWORD);
  }

  /* ********************************************************** */
  // Left_Curly_Bracket
  static boolean left_curly_bracket(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_CURLY_BRACKET);
  }

  /* ********************************************************** */
  // Left_Parenthesis
  static boolean left_parenthesis(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_PARENTHESIS);
  }

  /* ********************************************************** */
  // Left_Square_Bracket
  static boolean left_square_bracket(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_SQUARE_BRACKET);
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
  // LOCAL
  static boolean local(PsiBuilder b, int l) {
    return consumeToken(b, LOCAL);
  }

  /* ********************************************************** */
  // local identifier (comma_operator identifier)* (assignment_operator expression)?
  static boolean localVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = local(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && localVariableDeclaration_2(b, l + 1);
    r = r && localVariableDeclaration_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator identifier)*
  private static boolean localVariableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!localVariableDeclaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "localVariableDeclaration_2", c)) break;
    }
    return true;
  }

  // comma_operator identifier
  private static boolean localVariableDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (assignment_operator expression)?
  private static boolean localVariableDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_3")) return false;
    localVariableDeclaration_3_0(b, l + 1);
    return true;
  }

  // assignment_operator expression
  private static boolean localVariableDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LOCK
  static boolean lock(PsiBuilder b, int l) {
    return consumeToken(b, LOCK);
  }

  /* ********************************************************** */
  // LOOP
  static boolean loop(PsiBuilder b, int l) {
    return consumeToken(b, LOOP);
  }

  /* ********************************************************** */
  // loop statementBlock endloop
  static boolean loopStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loopStatement")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = loop(b, l + 1);
    r = r && statementBlock(b, l + 1);
    r = r && endloop(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // comment
  static boolean multilineComment(PsiBuilder b, int l) {
    return comment(b, l + 1);
  }

  /* ********************************************************** */
  // outerScopeStatement|functionDefinition|multilineComment|crlf|commandStatement
  static boolean outerItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outerItem")) return false;
    boolean r;
    r = outerScopeStatement(b, l + 1);
    if (!r) r = functionDefinition(b, l + 1);
    if (!r) r = multilineComment(b, l + 1);
    if (!r) r = crlf(b, l + 1);
    if (!r) r = commandStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // left_square_bracket statement right_square_bracket
  static boolean outerScopeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outerScopeStatement")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = left_square_bracket(b, l + 1);
    r = r && statement(b, l + 1);
    r = r && right_square_bracket(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  static boolean parameter(PsiBuilder b, int l) {
    return identifier(b, l + 1);
  }

  /* ********************************************************** */
  // (parameter (comma_operator parameter)* )?
  static boolean parameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList")) return false;
    parameterList_0(b, l + 1);
    return true;
  }

  // parameter (comma_operator parameter)*
  private static boolean parameterList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && parameterList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator parameter)*
  private static boolean parameterList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameterList_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameterList_0_1", c)) break;
    }
    return true;
  }

  // comma_operator parameter
  private static boolean parameterList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (identifier)
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, SimpleParser::recover_property);
    return r;
  }

  /* ********************************************************** */
  // !(IDENTIFIER|COMMENT)
  static boolean recover_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_property_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER|COMMENT
  private static boolean recover_property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // RETURN
  static boolean return_$(PsiBuilder b, int l) {
    return consumeToken(b, RETURN);
  }

  /* ********************************************************** */
  // Right_Curly_Bracket
  static boolean right_curly_bracket(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_CURLY_BRACKET);
  }

  /* ********************************************************** */
  // Right_Parenthesis
  static boolean right_parenthesis(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_PARENTHESIS);
  }

  /* ********************************************************** */
  // Right_Square_Bracket
  static boolean right_square_bracket(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_SQUARE_BRACKET);
  }

  /* ********************************************************** */
  // SECTION
  static boolean section(PsiBuilder b, int l) {
    return consumeToken(b, SECTION);
  }

  /* ********************************************************** */
  // outerItem*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!outerItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // controlFlow | assignment | functionCall | multilineComment | variableDeclaration | commandStatement
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = controlFlow(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = multilineComment(b, l + 1);
    if (!r) r = variableDeclaration(b, l + 1);
    if (!r) r = commandStatement(b, l + 1);
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
  // STRUCT
  static boolean struct(PsiBuilder b, int l) {
    return consumeToken(b, STRUCT);
  }

  /* ********************************************************** */
  // THEN
  static boolean then(PsiBuilder b, int l) {
    return consumeToken(b, THEN);
  }

  /* ********************************************************** */
  // binary_operator expression | variableDeclaration
  static boolean unaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unaryExpression_0(b, l + 1);
    if (!r) r = variableDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // binary_operator expression
  private static boolean unaryExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // UNARY_OPERATOR
  static boolean unary_operator(PsiBuilder b, int l) {
    return consumeToken(b, UNARY_OPERATOR);
  }

  /* ********************************************************** */
  // localVariableDeclaration | globalVariableDeclaration
  static boolean variableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration")) return false;
    if (!nextTokenIs(b, "", GLOBAL, LOCAL)) return false;
    boolean r;
    r = localVariableDeclaration(b, l + 1);
    if (!r) r = globalVariableDeclaration(b, l + 1);
    return r;
  }

}
