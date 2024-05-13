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
  // tk_identifier | square_l | square_r | paren_l | paren_r | op_comma |
  //     op_assign|
  //     op_unary | op_binary| op_dot|op_at | tk_literal | ellipsis | keywords_in_command_block
  static boolean any_in_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_in_command")) return false;
    boolean r;
    r = tk_identifier(b, l + 1);
    if (!r) r = square_l(b, l + 1);
    if (!r) r = square_r(b, l + 1);
    if (!r) r = paren_l(b, l + 1);
    if (!r) r = paren_r(b, l + 1);
    if (!r) r = op_comma(b, l + 1);
    if (!r) r = op_assign(b, l + 1);
    if (!r) r = op_unary(b, l + 1);
    if (!r) r = op_binary(b, l + 1);
    if (!r) r = op_dot(b, l + 1);
    if (!r) r = op_at(b, l + 1);
    if (!r) r = tk_literal(b, l + 1);
    if (!r) r = consumeToken(b, ELLIPSIS);
    if (!r) r = keywords_in_command_block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // kw_array tk_identifier paren_l literal_number paren_r
  static boolean array_declare_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_declare_statement")) return false;
    if (!nextTokenIs(b, ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_array(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && paren_l(b, l + 1);
    r = r && literal_number(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignment_target assignment_right?
  static boolean assignment_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_expression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_target(b, l + 1);
    r = r && assignment_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assignment_right?
  private static boolean assignment_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_expression_1")) return false;
    assignment_right(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_local? tk_identifier
  static boolean assignment_left_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_left_loop")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_left_loop_0(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // kw_local?
  private static boolean assignment_left_loop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_left_loop_0")) return false;
    kw_local(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // op_assign expression
  static boolean assignment_right(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_right")) return false;
    if (!nextTokenIs(b, ASSIGNMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_assign(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (kw_local | kw_global)? assignment_expression (op_comma assignment_expression)*
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_STATEMENT, "<assignment statement>");
    r = assignment_statement_0(b, l + 1);
    r = r && assignment_expression(b, l + 1);
    r = r && assignment_statement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (kw_local | kw_global)?
  private static boolean assignment_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement_0")) return false;
    assignment_statement_0_0(b, l + 1);
    return true;
  }

  // kw_local | kw_global
  private static boolean assignment_statement_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement_0_0")) return false;
    boolean r;
    r = kw_local(b, l + 1);
    if (!r) r = kw_global(b, l + 1);
    return r;
  }

  // (op_comma assignment_expression)*
  private static boolean assignment_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assignment_statement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assignment_statement_2", c)) break;
    }
    return true;
  }

  // op_comma assignment_expression
  private static boolean assignment_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && assignment_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tk_identifier parenthesis_csv_expression?
  static boolean assignment_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_target")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tk_identifier(b, l + 1);
    r = r && assignment_target_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // parenthesis_csv_expression?
  private static boolean assignment_target_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_target_1")) return false;
    parenthesis_csv_expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // non_binary_expression (op_binary non_binary_expression)*
  static boolean binary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = non_binary_expression(b, l + 1);
    r = r && binary_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_binary non_binary_expression)*
  private static boolean binary_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binary_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binary_expression_1", c)) break;
    }
    return true;
  }

  // op_binary non_binary_expression
  private static boolean binary_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && non_binary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_case expression (eol fish_block)?
  public static boolean case_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_block")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_case(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && case_block_2(b, l + 1);
    exit_section_(b, m, CASE_BLOCK, r);
    return r;
  }

  // (eol fish_block)?
  private static boolean case_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_block_2")) return false;
    case_block_2_0(b, l + 1);
    return true;
  }

  // eol fish_block
  private static boolean case_block_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_block_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_case_of expression (eol fish_block)? (eol case_block)* eol kw_end_case
  public static boolean case_of_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_of_block")) return false;
    if (!nextTokenIs(b, CASEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_case_of(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && case_of_block_2(b, l + 1);
    r = r && case_of_block_3(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end_case(b, l + 1);
    exit_section_(b, m, CASE_OF_BLOCK, r);
    return r;
  }

  // (eol fish_block)?
  private static boolean case_of_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_of_block_2")) return false;
    case_of_block_2_0(b, l + 1);
    return true;
  }

  // eol fish_block
  private static boolean case_of_block_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_of_block_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol case_block)*
  private static boolean case_of_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_of_block_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!case_of_block_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_of_block_3", c)) break;
    }
    return true;
  }

  // eol case_block
  private static boolean case_of_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_of_block_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && case_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_command (eol command_body)? eol kw_end_command
  public static boolean command_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_command(b, l + 1);
    r = r && command_block_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end_command(b, l + 1);
    exit_section_(b, m, COMMAND_BLOCK, r);
    return r;
  }

  // (eol command_body)?
  private static boolean command_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_1")) return false;
    command_block_1_0(b, l + 1);
    return true;
  }

  // eol command_body
  private static boolean command_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && command_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command_statement (eol command_statement)*
  public static boolean command_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_BODY, "<command body>");
    r = command_statement(b, l + 1);
    r = r && command_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol command_statement)*
  private static boolean command_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_body_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_body_1", c)) break;
    }
    return true;
  }

  // eol command_statement
  private static boolean command_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && command_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command_scope_inline_fish_statement |
  //     function_define_block |
  //     command_scope_function_call_statement |
  //     command_statement
  public static boolean command_scope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_scope")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_SCOPE, "<command scope>");
    r = command_scope_inline_fish_statement(b, l + 1);
    if (!r) r = function_define_block(b, l + 1);
    if (!r) r = command_scope_function_call_statement(b, l + 1);
    if (!r) r = command_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // op_at tk_identifier parenthesis_csv_expression
  static boolean command_scope_function_call_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_scope_function_call_expression")) return false;
    if (!nextTokenIs(b, FUNCTION_CALL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_at(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && parenthesis_csv_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command_scope_function_call_expression
  public static boolean command_scope_function_call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_scope_function_call_statement")) return false;
    if (!nextTokenIs(b, FUNCTION_CALL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_scope_function_call_expression(b, l + 1);
    exit_section_(b, m, COMMAND_SCOPE_FUNCTION_CALL_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // square_l fish_statement square_r
  static boolean command_scope_inline_fish_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_scope_inline_fish_expression")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = square_l(b, l + 1);
    r = r && fish_statement(b, l + 1);
    r = r && square_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command_scope_inline_fish_expression
  public static boolean command_scope_inline_fish_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_scope_inline_fish_statement")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_scope_inline_fish_expression(b, l + 1);
    exit_section_(b, m, COMMAND_SCOPE_INLINE_FISH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // any_in_command+
  public static boolean command_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_STATEMENT, "<command statement>");
    r = any_in_command(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!any_in_command(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_statement", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression (op_comma expression)*
  static boolean csv_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csv_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && csv_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma expression)*
  private static boolean csv_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csv_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!csv_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "csv_expression_1", c)) break;
    }
    return true;
  }

  // op_comma expression
  private static boolean csv_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csv_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACKET
  static boolean curly_l(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_CURLY_BRACKET);
  }

  /* ********************************************************** */
  // RIGHT_CURLY_BRACKET
  static boolean curly_r(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_CURLY_BRACKET);
  }

  /* ********************************************************** */
  // kw_else (eol fish_block)?
  public static boolean else_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_block")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_else(b, l + 1);
    r = r && else_block_1(b, l + 1);
    exit_section_(b, m, ELSE_BLOCK, r);
    return r;
  }

  // (eol fish_block)?
  private static boolean else_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_block_1")) return false;
    else_block_1_0(b, l + 1);
    return true;
  }

  // eol fish_block
  private static boolean else_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_else_if expression kw_then? (eol fish_block)?
  public static boolean else_if_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block")) return false;
    if (!nextTokenIs(b, "<else if block>", ELSE, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSE_IF_BLOCK, "<else if block>");
    r = kw_else_if(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && else_if_block_2(b, l + 1);
    r = r && else_if_block_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_then?
  private static boolean else_if_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block_2")) return false;
    kw_then(b, l + 1);
    return true;
  }

  // (eol fish_block)?
  private static boolean else_if_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block_3")) return false;
    else_if_block_3_0(b, l + 1);
    return true;
  }

  // eol fish_block
  private static boolean else_if_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NEWLINE|COMMENT)+
  public static boolean eol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol")) return false;
    if (!nextTokenIs(b, "<eol>", COMMENT, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EOL, "<eol>");
    r = eol_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!eol_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "eol", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEWLINE|COMMENT
  private static boolean eol_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // (square_l binary_expression square_r) |  binary_expression
  static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression_0(b, l + 1);
    if (!r) r = binary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // square_l binary_expression square_r
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = square_l(b, l + 1);
    r = r && binary_expression(b, l + 1);
    r = r && square_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // single_fish_block (eol single_fish_block)*
  public static boolean fish_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK, "<fish block>");
    r = single_fish_block(b, l + 1);
    r = r && fish_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol single_fish_block)*
  private static boolean fish_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_block_1", c)) break;
    }
    return true;
  }

  // eol single_fish_block
  private static boolean fish_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && single_fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // array_declare_statement |
  //     assignment_statement |
  //     expression |
  //     kw_break |
  //     kw_continue |
  //     kw_exit
  public static boolean fish_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_STATEMENT, "<fish statement>");
    r = array_declare_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = kw_break(b, l + 1);
    if (!r) r = kw_continue(b, l + 1);
    if (!r) r = kw_exit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // tk_identifier parenthesis_csv_expression
  static boolean function_call_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_expression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tk_identifier(b, l + 1);
    r = r && parenthesis_csv_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // function_define_header (eol fish_block)? eol kw_end
  public static boolean function_define_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_block")) return false;
    if (!nextTokenIs(b, "<function define block>", DEFINE, FISH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEFINE_BLOCK, "<function define block>");
    r = function_define_header(b, l + 1);
    r = r && function_define_block_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol fish_block)?
  private static boolean function_define_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_block_1")) return false;
    function_define_block_1_0(b, l + 1);
    return true;
  }

  // eol fish_block
  private static boolean function_define_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_fish? kw_def tk_identifier function_parameter_list?
  public static boolean function_define_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_header")) return false;
    if (!nextTokenIs(b, "<function define header>", DEFINE, FISH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEFINE_HEADER, "<function define header>");
    r = function_define_header_0(b, l + 1);
    r = r && kw_def(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && function_define_header_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_fish?
  private static boolean function_define_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_header_0")) return false;
    kw_fish(b, l + 1);
    return true;
  }

  // function_parameter_list?
  private static boolean function_define_header_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_header_3")) return false;
    function_parameter_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // paren_l tk_identifier (op_comma tk_identifier)* paren_r
  static boolean function_parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameter_list")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && function_parameter_list_2(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma tk_identifier)*
  private static boolean function_parameter_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameter_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_parameter_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_parameter_list_2", c)) break;
    }
    return true;
  }

  // op_comma tk_identifier
  private static boolean function_parameter_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameter_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_if expression kw_then?
  //              (eol fish_block)?
  //              (eol else_if_block)*
  //              (eol else_block)?
  //              eol kw_end_if
  public static boolean if_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_if(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && if_block_2(b, l + 1);
    r = r && if_block_3(b, l + 1);
    r = r && if_block_4(b, l + 1);
    r = r && if_block_5(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end_if(b, l + 1);
    exit_section_(b, m, IF_BLOCK, r);
    return r;
  }

  // kw_then?
  private static boolean if_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_2")) return false;
    kw_then(b, l + 1);
    return true;
  }

  // (eol fish_block)?
  private static boolean if_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_3")) return false;
    if_block_3_0(b, l + 1);
    return true;
  }

  // eol fish_block
  private static boolean if_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol else_if_block)*
  private static boolean if_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_block_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_block_4", c)) break;
    }
    return true;
  }

  // eol else_if_block
  private static boolean if_block_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && else_if_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol else_block)?
  private static boolean if_block_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_5")) return false;
    if_block_5_0(b, l + 1);
    return true;
  }

  // eol else_block
  private static boolean if_block_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && else_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_fish | kw_case_of | kw_case | kw_end_case | kw_def | kw_end | kw_exit | kw_global | kw_if | kw_then |
  //     kw_else_if | kw_else | kw_end_if | kw_local | kw_lock | kw_loop | kw_endloop | kw_continue | kw_return | kw_section | kw_end_section | kw_struct
  static boolean keywords_in_command_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywords_in_command_block")) return false;
    boolean r;
    r = kw_fish(b, l + 1);
    if (!r) r = kw_case_of(b, l + 1);
    if (!r) r = kw_case(b, l + 1);
    if (!r) r = kw_end_case(b, l + 1);
    if (!r) r = kw_def(b, l + 1);
    if (!r) r = kw_end(b, l + 1);
    if (!r) r = kw_exit(b, l + 1);
    if (!r) r = kw_global(b, l + 1);
    if (!r) r = kw_if(b, l + 1);
    if (!r) r = kw_then(b, l + 1);
    if (!r) r = kw_else_if(b, l + 1);
    if (!r) r = kw_else(b, l + 1);
    if (!r) r = kw_end_if(b, l + 1);
    if (!r) r = kw_local(b, l + 1);
    if (!r) r = kw_lock(b, l + 1);
    if (!r) r = kw_loop(b, l + 1);
    if (!r) r = kw_endloop(b, l + 1);
    if (!r) r = kw_continue(b, l + 1);
    if (!r) r = kw_return(b, l + 1);
    if (!r) r = kw_section(b, l + 1);
    if (!r) r = kw_end_section(b, l + 1);
    if (!r) r = kw_struct(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ARRAY
  static boolean kw_array(PsiBuilder b, int l) {
    return consumeToken(b, ARRAY);
  }

  /* ********************************************************** */
  // BREAK | (kw_exit kw_loop)
  static boolean kw_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_break")) return false;
    if (!nextTokenIs(b, "", BREAK, EXIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    if (!r) r = kw_break_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // kw_exit kw_loop
  private static boolean kw_break_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_break_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_exit(b, l + 1);
    r = r && kw_loop(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CASE
  static boolean kw_case(PsiBuilder b, int l) {
    return consumeToken(b, CASE);
  }

  /* ********************************************************** */
  // CASEOF
  static boolean kw_case_of(PsiBuilder b, int l) {
    return consumeToken(b, CASEOF);
  }

  /* ********************************************************** */
  // COMMAND
  static boolean kw_command(PsiBuilder b, int l) {
    return consumeToken(b, COMMAND);
  }

  /* ********************************************************** */
  // CONTINUE
  static boolean kw_continue(PsiBuilder b, int l) {
    return consumeToken(b, CONTINUE);
  }

  /* ********************************************************** */
  // DEFINE
  static boolean kw_def(PsiBuilder b, int l) {
    return consumeToken(b, DEFINE);
  }

  /* ********************************************************** */
  // ELSE
  static boolean kw_else(PsiBuilder b, int l) {
    return consumeToken(b, ELSE);
  }

  /* ********************************************************** */
  // ELSEIF | (kw_else kw_if)
  static boolean kw_else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else_if")) return false;
    if (!nextTokenIs(b, "", ELSE, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    if (!r) r = kw_else_if_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // kw_else kw_if
  private static boolean kw_else_if_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else_if_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_else(b, l + 1);
    r = r && kw_if(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // END
  static boolean kw_end(PsiBuilder b, int l) {
    return consumeToken(b, END);
  }

  /* ********************************************************** */
  // ENDCASE
  static boolean kw_end_case(PsiBuilder b, int l) {
    return consumeToken(b, ENDCASE);
  }

  /* ********************************************************** */
  // ENDCOMMAND
  static boolean kw_end_command(PsiBuilder b, int l) {
    return consumeToken(b, ENDCOMMAND);
  }

  /* ********************************************************** */
  // ENDIF
  static boolean kw_end_if(PsiBuilder b, int l) {
    return consumeToken(b, ENDIF);
  }

  /* ********************************************************** */
  // ENDSECTION
  static boolean kw_end_section(PsiBuilder b, int l) {
    return consumeToken(b, ENDSECTION);
  }

  /* ********************************************************** */
  // ENDLOOP
  static boolean kw_endloop(PsiBuilder b, int l) {
    return consumeToken(b, ENDLOOP);
  }

  /* ********************************************************** */
  // EXIT
  static boolean kw_exit(PsiBuilder b, int l) {
    return consumeToken(b, EXIT);
  }

  /* ********************************************************** */
  // FISH
  static boolean kw_fish(PsiBuilder b, int l) {
    return consumeToken(b, FISH);
  }

  /* ********************************************************** */
  // FOR
  static boolean kw_for(PsiBuilder b, int l) {
    return consumeToken(b, FOR);
  }

  /* ********************************************************** */
  // FOREACH
  static boolean kw_foreach(PsiBuilder b, int l) {
    return consumeToken(b, FOREACH);
  }

  /* ********************************************************** */
  // GLOBAL
  static boolean kw_global(PsiBuilder b, int l) {
    return consumeToken(b, GLOBAL);
  }

  /* ********************************************************** */
  // IF
  static boolean kw_if(PsiBuilder b, int l) {
    return consumeToken(b, IF);
  }

  /* ********************************************************** */
  // LOCAL
  static boolean kw_local(PsiBuilder b, int l) {
    return consumeToken(b, LOCAL);
  }

  /* ********************************************************** */
  // LOCK
  static boolean kw_lock(PsiBuilder b, int l) {
    return consumeToken(b, LOCK);
  }

  /* ********************************************************** */
  // LOOP
  static boolean kw_loop(PsiBuilder b, int l) {
    return consumeToken(b, LOOP);
  }

  /* ********************************************************** */
  // RETURN
  static boolean kw_return(PsiBuilder b, int l) {
    return consumeToken(b, RETURN);
  }

  /* ********************************************************** */
  // SECTION
  static boolean kw_section(PsiBuilder b, int l) {
    return consumeToken(b, SECTION);
  }

  /* ********************************************************** */
  // STRUCT
  static boolean kw_struct(PsiBuilder b, int l) {
    return consumeToken(b, STRUCT);
  }

  /* ********************************************************** */
  // THEN
  static boolean kw_then(PsiBuilder b, int l) {
    return consumeToken(b, THEN);
  }

  /* ********************************************************** */
  // WHILE
  static boolean kw_while(PsiBuilder b, int l) {
    return consumeToken(b, WHILE);
  }

  /* ********************************************************** */
  // NUMBER_LITERAL
  static boolean literal_number(PsiBuilder b, int l) {
    return consumeToken(b, NUMBER_LITERAL);
  }

  /* ********************************************************** */
  // STRING_LITERAL
  static boolean literal_string(PsiBuilder b, int l) {
    return consumeToken(b, STRING_LITERAL);
  }

  /* ********************************************************** */
  // loop_header (eol fish_block)? eol kw_endloop
  public static boolean loop_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_block")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = loop_header(b, l + 1);
    r = r && loop_block_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_endloop(b, l + 1);
    exit_section_(b, m, LOOP_BLOCK, r);
    return r;
  }

  // (eol fish_block)?
  private static boolean loop_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_block_1")) return false;
    loop_block_1_0(b, l + 1);
    return true;
  }

  // eol fish_block
  private static boolean loop_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_foreach assignment_left_loop expression
  static boolean loop_each(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_each")) return false;
    if (!nextTokenIs(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_foreach(b, l + 1);
    r = r && assignment_left_loop(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_for paren_l kw_local? expression op_comma expression op_comma expression paren_r
  static boolean loop_for(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_for")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_for(b, l + 1);
    r = r && paren_l(b, l + 1);
    r = r && loop_for_2(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // kw_local?
  private static boolean loop_for_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_for_2")) return false;
    kw_local(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_loop (loop_each | loop_indexed | loop_for | loop_while)
  public static boolean loop_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_header")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_loop(b, l + 1);
    r = r && loop_header_1(b, l + 1);
    exit_section_(b, m, LOOP_HEADER, r);
    return r;
  }

  // loop_each | loop_indexed | loop_for | loop_while
  private static boolean loop_header_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_header_1")) return false;
    boolean r;
    r = loop_each(b, l + 1);
    if (!r) r = loop_indexed(b, l + 1);
    if (!r) r = loop_for(b, l + 1);
    if (!r) r = loop_while(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // assignment_left_loop loop_indexed_range
  static boolean loop_indexed(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_left_loop(b, l + 1);
    r = r && loop_indexed_range(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paren_l expression op_comma
  //     expression (op_comma expression)? paren_r
  static boolean loop_indexed_range(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed_range")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && loop_indexed_range_4(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma expression)?
  private static boolean loop_indexed_range_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed_range_4")) return false;
    loop_indexed_range_4_0(b, l + 1);
    return true;
  }

  // op_comma expression
  private static boolean loop_indexed_range_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed_range_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_while expression
  static boolean loop_while(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_while")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_while(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // parenthesis_expression | function_call_expression | unary_expression | tk_value
  static boolean non_binary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_binary_expression")) return false;
    boolean r;
    r = parenthesis_expression(b, l + 1);
    if (!r) r = function_call_expression(b, l + 1);
    if (!r) r = unary_expression(b, l + 1);
    if (!r) r = tk_value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ASSIGNMENT_OPERATOR
  static boolean op_assign(PsiBuilder b, int l) {
    return consumeToken(b, ASSIGNMENT_OPERATOR);
  }

  /* ********************************************************** */
  // FUNCTION_CALL_OPERATOR
  static boolean op_at(PsiBuilder b, int l) {
    return consumeToken(b, FUNCTION_CALL_OPERATOR);
  }

  /* ********************************************************** */
  // BINARY_OPERATOR | MINUS_OPERATOR | ASSIGNMENT_OPERATOR
  static boolean op_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_binary")) return false;
    boolean r;
    r = consumeToken(b, BINARY_OPERATOR);
    if (!r) r = consumeToken(b, MINUS_OPERATOR);
    if (!r) r = consumeToken(b, ASSIGNMENT_OPERATOR);
    return r;
  }

  /* ********************************************************** */
  // COMMA_OPERATOR
  static boolean op_comma(PsiBuilder b, int l) {
    return consumeToken(b, COMMA_OPERATOR);
  }

  /* ********************************************************** */
  // DOT_OPERATOR
  static boolean op_dot(PsiBuilder b, int l) {
    return consumeToken(b, DOT_OPERATOR);
  }

  /* ********************************************************** */
  // UNARY_OPERATOR | MINUS_OPERATOR
  static boolean op_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_unary")) return false;
    if (!nextTokenIs(b, "", MINUS_OPERATOR, UNARY_OPERATOR)) return false;
    boolean r;
    r = consumeToken(b, UNARY_OPERATOR);
    if (!r) r = consumeToken(b, MINUS_OPERATOR);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS
  static boolean paren_l(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_PARENTHESIS);
  }

  /* ********************************************************** */
  // RIGHT_PARENTHESIS
  static boolean paren_r(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_PARENTHESIS);
  }

  /* ********************************************************** */
  // paren_l csv_expression paren_r
  static boolean parenthesis_csv_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesis_csv_expression")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && csv_expression(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paren_l expression paren_r
  static boolean parenthesis_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesis_expression")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (tk_identifier)
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = tk_identifier(b, l + 1);
    exit_section_(b, l, m, r, false, SimpleParser::recover_property);
    return r;
  }

  /* ********************************************************** */
  // !(tk_identifier)
  static boolean recover_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_property_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (tk_identifier)
  private static boolean recover_property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tk_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // eol* command_scope (eol command_scope)* eol*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleFile_0(b, l + 1);
    r = r && command_scope(b, l + 1);
    r = r && simpleFile_2(b, l + 1);
    r = r && simpleFile_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // eol*
  private static boolean simpleFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_0", c)) break;
    }
    return true;
  }

  // (eol command_scope)*
  private static boolean simpleFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simpleFile_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_2", c)) break;
    }
    return true;
  }

  // eol command_scope
  private static boolean simpleFile_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && command_scope(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // eol*
  private static boolean simpleFile_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // if_block | loop_block | case_of_block | command_block | fish_statement
  public static boolean single_fish_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_fish_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_FISH_BLOCK, "<single fish block>");
    r = if_block(b, l + 1);
    if (!r) r = loop_block(b, l + 1);
    if (!r) r = case_of_block(b, l + 1);
    if (!r) r = command_block(b, l + 1);
    if (!r) r = fish_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_SQUARE_BRACKET
  static boolean square_l(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_SQUARE_BRACKET);
  }

  /* ********************************************************** */
  // RIGHT_SQUARE_BRACKET
  static boolean square_r(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_SQUARE_BRACKET);
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean tk_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TK_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // literal_string | literal_number
  public static boolean tk_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_literal")) return false;
    if (!nextTokenIs(b, "<tk literal>", NUMBER_LITERAL, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TK_LITERAL, "<tk literal>");
    r = literal_string(b, l + 1);
    if (!r) r = literal_number(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // tk_identifier | tk_literal
  public static boolean tk_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TK_VALUE, "<tk value>");
    r = tk_identifier(b, l + 1);
    if (!r) r = tk_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // op_unary expression
  static boolean unary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression")) return false;
    if (!nextTokenIs(b, "", MINUS_OPERATOR, UNARY_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_unary(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
