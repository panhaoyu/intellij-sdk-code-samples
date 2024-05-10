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
  // identifier | left_square_bracket | right_square_bracket | left_parenthesis | right_parenthesis | comma_operator |
  //     assignment_operator|
  //     unary_operator | binary_operator| dot_operator|at_operator | literal | ellipsis | keywords_in_command_block
  static boolean any_in_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_in_command")) return false;
    boolean r;
    r = identifier(b, l + 1);
    if (!r) r = left_square_bracket(b, l + 1);
    if (!r) r = right_square_bracket(b, l + 1);
    if (!r) r = left_parenthesis(b, l + 1);
    if (!r) r = right_parenthesis(b, l + 1);
    if (!r) r = comma_operator(b, l + 1);
    if (!r) r = assignment_operator(b, l + 1);
    if (!r) r = unary_operator(b, l + 1);
    if (!r) r = binary_operator(b, l + 1);
    if (!r) r = dot_operator(b, l + 1);
    if (!r) r = at_operator(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = ellipsis(b, l + 1);
    if (!r) r = keywords_in_command_block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier parenthesis_csv_expression assignment_right
  public static boolean array_assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_assignment_statement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && parenthesis_csv_expression(b, l + 1);
    r = r && assignment_right(b, l + 1);
    exit_section_(b, m, ARRAY_ASSIGNMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ASSIGNMENT_OPERATOR
  static boolean assignment_operator(PsiBuilder b, int l) {
    return consumeToken(b, ASSIGNMENT_OPERATOR);
  }

  /* ********************************************************** */
  // assignment_operator expression
  static boolean assignment_right(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_right")) return false;
    if (!nextTokenIs(b, ASSIGNMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier assignment_right
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && assignment_right(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION_CALL_OPERATOR
  static boolean at_operator(PsiBuilder b, int l) {
    return consumeToken(b, FUNCTION_CALL_OPERATOR);
  }

  /* ********************************************************** */
  // value binary_operator expression
  static boolean binary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    r = r && binary_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BINARY_OPERATOR | MINUS_OPERATOR
  static boolean binary_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_operator")) return false;
    if (!nextTokenIs(b, "", BINARY_OPERATOR, MINUS_OPERATOR)) return false;
    boolean r;
    r = consumeToken(b, BINARY_OPERATOR);
    if (!r) r = consumeToken(b, MINUS_OPERATOR);
    return r;
  }

  /* ********************************************************** */
  // CASE
  static boolean case_$(PsiBuilder b, int l) {
    return consumeToken(b, CASE);
  }

  /* ********************************************************** */
  // case_of expression case_clause* end_case
  static boolean case_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_block")) return false;
    if (!nextTokenIs(b, CASEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_of(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && case_block_2(b, l + 1);
    r = r && end_case(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // case_clause*
  private static boolean case_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!case_clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_block_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // case expression fish_block
  static boolean case_clause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_clause")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_$(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CASEOF
  static boolean case_of(PsiBuilder b, int l) {
    return consumeToken(b, CASEOF);
  }

  /* ********************************************************** */
  // COMMA_OPERATOR
  static boolean comma_operator(PsiBuilder b, int l) {
    return consumeToken(b, COMMA_OPERATOR);
  }

  /* ********************************************************** */
  // COMMAND
  static boolean command(PsiBuilder b, int l) {
    return consumeToken(b, COMMAND);
  }

  /* ********************************************************** */
  // command command_body* end_command
  public static boolean command_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1);
    r = r && command_block_1(b, l + 1);
    r = r && end_command(b, l + 1);
    exit_section_(b, m, COMMAND_BLOCK, r);
    return r;
  }

  // command_body*
  private static boolean command_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // any_in_command+
  static boolean command_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_body")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = any_in_command(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!any_in_command(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_body", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command_scope_inline_fish_statement|function_define|comment_block|command_block
  static boolean command_scope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_scope")) return false;
    boolean r;
    r = command_scope_inline_fish_statement(b, l + 1);
    if (!r) r = function_define(b, l + 1);
    if (!r) r = comment_block(b, l + 1);
    if (!r) r = command_block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // left_square_bracket fish_statement right_square_bracket
  static boolean command_scope_inline_fish_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_scope_inline_fish_expression")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = left_square_bracket(b, l + 1);
    r = r && fish_statement(b, l + 1);
    r = r && right_square_bracket(b, l + 1);
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
  // end_of_line_comment
  static boolean comment_block(PsiBuilder b, int l) {
    return end_of_line_comment(b, l + 1);
  }

  /* ********************************************************** */
  // CONTINUE
  static boolean continue_$(PsiBuilder b, int l) {
    return consumeToken(b, CONTINUE);
  }

  /* ********************************************************** */
  // expression (comma_operator expression)*
  static boolean csv_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csv_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && csv_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator expression)*
  private static boolean csv_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csv_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!csv_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "csv_expression_1", c)) break;
    }
    return true;
  }

  // comma_operator expression
  private static boolean csv_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csv_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEFINE
  static boolean define(PsiBuilder b, int l) {
    return consumeToken(b, DEFINE);
  }

  /* ********************************************************** */
  // DOT_OPERATOR
  static boolean dot_operator(PsiBuilder b, int l) {
    return consumeToken(b, DOT_OPERATOR);
  }

  /* ********************************************************** */
  // ELLIPSIS
  static boolean ellipsis(PsiBuilder b, int l) {
    return consumeToken(b, ELLIPSIS);
  }

  /* ********************************************************** */
  // ELSE
  static boolean else_$(PsiBuilder b, int l) {
    return consumeToken(b, ELSE);
  }

  /* ********************************************************** */
  // elseif expression then (newline fish_block)?
  static boolean else_if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_statement")) return false;
    if (!nextTokenIs(b, "", ELSE, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && then(b, l + 1);
    r = r && else_if_statement_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (newline fish_block)?
  private static boolean else_if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_statement_3")) return false;
    else_if_statement_3_0(b, l + 1);
    return true;
  }

  // newline fish_block
  private static boolean else_if_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = newline(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // else (newline fish_block)?
  static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = else_$(b, l + 1);
    r = r && else_statement_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (newline fish_block)?
  private static boolean else_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement_1")) return false;
    else_statement_1_0(b, l + 1);
    return true;
  }

  // newline fish_block
  private static boolean else_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = newline(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF | (else if)
  static boolean elseif(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif")) return false;
    if (!nextTokenIs(b, "", ELSE, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    if (!r) r = elseif_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // else if
  private static boolean elseif_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = else_$(b, l + 1);
    r = r && if_$(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // END
  static boolean end(PsiBuilder b, int l) {
    return consumeToken(b, END);
  }

  /* ********************************************************** */
  // ENDCASE
  static boolean end_case(PsiBuilder b, int l) {
    return consumeToken(b, ENDCASE);
  }

  /* ********************************************************** */
  // ENDCOMMAND
  static boolean end_command(PsiBuilder b, int l) {
    return consumeToken(b, ENDCOMMAND);
  }

  /* ********************************************************** */
  // COMMENT
  static boolean end_of_line_comment(PsiBuilder b, int l) {
    return consumeToken(b, COMMENT);
  }

  /* ********************************************************** */
  // ENDSECTION
  static boolean end_section(PsiBuilder b, int l) {
    return consumeToken(b, ENDSECTION);
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
  // EXIT
  static boolean exit(PsiBuilder b, int l) {
    return consumeToken(b, EXIT);
  }

  /* ********************************************************** */
  // parenthesis_expression | function_call_expression | unary_expression |binary_expression | value
  static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    r = parenthesis_expression(b, l + 1);
    if (!r) r = function_call_expression(b, l + 1);
    if (!r) r = unary_expression(b, l + 1);
    if (!r) r = binary_expression(b, l + 1);
    if (!r) r = value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // FISH
  static boolean fish(PsiBuilder b, int l) {
    return consumeToken(b, FISH);
  }

  /* ********************************************************** */
  // fish_internal_block (newline fish_internal_block)*
  public static boolean fish_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, FISH_BLOCK, "<fish block>");
    r = fish_internal_block(b, l + 1);
    r = r && fish_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (newline fish_internal_block)*
  private static boolean fish_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_block_1", c)) break;
    }
    return true;
  }

  // newline fish_internal_block
  private static boolean fish_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = newline(b, l + 1);
    r = r && fish_internal_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // if_block | loop_block | case_block | comment_block | command_block | fish_statement
  static boolean fish_internal_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_internal_block")) return false;
    boolean r;
    r = if_block(b, l + 1);
    if (!r) r = loop_block(b, l + 1);
    if (!r) r = case_block(b, l + 1);
    if (!r) r = comment_block(b, l + 1);
    if (!r) r = command_block(b, l + 1);
    if (!r) r = fish_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // array_assignment_statement | function_call_statement  | var_declare_statement |  assignment_statement | expression
  public static boolean fish_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_STATEMENT, "<fish statement>");
    r = array_assignment_statement(b, l + 1);
    if (!r) r = function_call_statement(b, l + 1);
    if (!r) r = var_declare_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier parenthesis_csv_expression
  static boolean function_call_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_expression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && parenthesis_csv_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // function_call_expression
  public static boolean function_call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_statement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_call_expression(b, l + 1);
    exit_section_(b, m, FUNCTION_CALL_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // function_define_header newline (fish_block newline)? end
  public static boolean function_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define")) return false;
    if (!nextTokenIs(b, FISH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_define_header(b, l + 1);
    r = r && newline(b, l + 1);
    r = r && function_define_2(b, l + 1);
    r = r && end(b, l + 1);
    exit_section_(b, m, FUNCTION_DEFINE, r);
    return r;
  }

  // (fish_block newline)?
  private static boolean function_define_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_2")) return false;
    function_define_2_0(b, l + 1);
    return true;
  }

  // fish_block newline
  private static boolean function_define_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish_block(b, l + 1);
    r = r && newline(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish define identifier function_parameter_list?
  static boolean function_define_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_header")) return false;
    if (!nextTokenIs(b, FISH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish(b, l + 1);
    r = r && define(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && function_define_header_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // function_parameter_list?
  private static boolean function_define_header_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_define_header_3")) return false;
    function_parameter_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // left_parenthesis identifier (comma_operator identifier)* right_parenthesis
  static boolean function_parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameter_list")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = left_parenthesis(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && function_parameter_list_2(b, l + 1);
    r = r && right_parenthesis(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator identifier)*
  private static boolean function_parameter_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameter_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_parameter_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_parameter_list_2", c)) break;
    }
    return true;
  }

  // comma_operator identifier
  private static boolean function_parameter_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameter_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GLOBAL
  static boolean global(PsiBuilder b, int l) {
    return consumeToken(b, GLOBAL);
  }

  /* ********************************************************** */
  // global identifier (comma_operator identifier)* (assignment_operator expression)?
  static boolean global_var_declare_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_var_declare_statement")) return false;
    if (!nextTokenIs(b, GLOBAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = global(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && global_var_declare_statement_2(b, l + 1);
    r = r && global_var_declare_statement_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator identifier)*
  private static boolean global_var_declare_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_var_declare_statement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!global_var_declare_statement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "global_var_declare_statement_2", c)) break;
    }
    return true;
  }

  // comma_operator identifier
  private static boolean global_var_declare_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_var_declare_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (assignment_operator expression)?
  private static boolean global_var_declare_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_var_declare_statement_3")) return false;
    global_var_declare_statement_3_0(b, l + 1);
    return true;
  }

  // assignment_operator expression
  private static boolean global_var_declare_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_var_declare_statement_3_0")) return false;
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
  // if expression then (newline fish_block)? (newline else_if_statement)* (newline else_statement)? endif
  public static boolean if_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_$(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && then(b, l + 1);
    r = r && if_block_3(b, l + 1);
    r = r && if_block_4(b, l + 1);
    r = r && if_block_5(b, l + 1);
    r = r && endif(b, l + 1);
    exit_section_(b, m, IF_BLOCK, r);
    return r;
  }

  // (newline fish_block)?
  private static boolean if_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_3")) return false;
    if_block_3_0(b, l + 1);
    return true;
  }

  // newline fish_block
  private static boolean if_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = newline(b, l + 1);
    r = r && fish_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (newline else_if_statement)*
  private static boolean if_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_block_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_block_4", c)) break;
    }
    return true;
  }

  // newline else_if_statement
  private static boolean if_block_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = newline(b, l + 1);
    r = r && else_if_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (newline else_statement)?
  private static boolean if_block_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_5")) return false;
    if_block_5_0(b, l + 1);
    return true;
  }

  // newline else_statement
  private static boolean if_block_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = newline(b, l + 1);
    r = r && else_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish | case_of | case | end_case | define | end | exit | global | if | then |
  //     elseif | else | endif | local | lock | loop | endloop | continue | return | section | end_section | struct  |
  static boolean keywords_in_command_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywords_in_command_block")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish(b, l + 1);
    if (!r) r = case_of(b, l + 1);
    if (!r) r = case_$(b, l + 1);
    if (!r) r = end_case(b, l + 1);
    if (!r) r = define(b, l + 1);
    if (!r) r = end(b, l + 1);
    if (!r) r = exit(b, l + 1);
    if (!r) r = global(b, l + 1);
    if (!r) r = if_$(b, l + 1);
    if (!r) r = then(b, l + 1);
    if (!r) r = elseif(b, l + 1);
    if (!r) r = else_$(b, l + 1);
    if (!r) r = endif(b, l + 1);
    if (!r) r = local(b, l + 1);
    if (!r) r = lock(b, l + 1);
    if (!r) r = loop(b, l + 1);
    if (!r) r = endloop(b, l + 1);
    if (!r) r = continue_$(b, l + 1);
    if (!r) r = return_$(b, l + 1);
    if (!r) r = section(b, l + 1);
    if (!r) r = end_section(b, l + 1);
    if (!r) r = struct(b, l + 1);
    if (!r) r = consumeToken(b, KEYWORDS_IN_COMMAND_BLOCK_22_0);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACKET
  static boolean left_curly_bracket(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_CURLY_BRACKET);
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS
  static boolean left_parenthesis(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_PARENTHESIS);
  }

  /* ********************************************************** */
  // LEFT_SQUARE_BRACKET
  static boolean left_square_bracket(PsiBuilder b, int l) {
    return consumeToken(b, LEFT_SQUARE_BRACKET);
  }

  /* ********************************************************** */
  // string_literal | number_literal
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    if (!nextTokenIs(b, "<literal>", NUMBER_LITERAL, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = string_literal(b, l + 1);
    if (!r) r = number_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LOCAL
  static boolean local(PsiBuilder b, int l) {
    return consumeToken(b, LOCAL);
  }

  /* ********************************************************** */
  // local identifier (comma_operator identifier)* (assignment_operator expression)?
  static boolean local_var_declare_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_declare_statement")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = local(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && local_var_declare_statement_2(b, l + 1);
    r = r && local_var_declare_statement_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma_operator identifier)*
  private static boolean local_var_declare_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_declare_statement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!local_var_declare_statement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "local_var_declare_statement_2", c)) break;
    }
    return true;
  }

  // comma_operator identifier
  private static boolean local_var_declare_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_declare_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comma_operator(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (assignment_operator expression)?
  private static boolean local_var_declare_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_declare_statement_3")) return false;
    local_var_declare_statement_3_0(b, l + 1);
    return true;
  }

  // assignment_operator expression
  private static boolean local_var_declare_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_declare_statement_3_0")) return false;
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
  // loop fish_block endloop
  public static boolean loop_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_block")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = loop(b, l + 1);
    r = r && fish_block(b, l + 1);
    r = r && endloop(b, l + 1);
    exit_section_(b, m, LOOP_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // NEWLINE+
  static boolean newline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newline")) return false;
    if (!nextTokenIs(b, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, NEWLINE)) break;
      if (!empty_element_parsed_guard_(b, "newline", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER_LITERAL
  static boolean number_literal(PsiBuilder b, int l) {
    return consumeToken(b, NUMBER_LITERAL);
  }

  /* ********************************************************** */
  // left_parenthesis csv_expression right_parenthesis
  static boolean parenthesis_csv_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesis_csv_expression")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = left_parenthesis(b, l + 1);
    r = r && csv_expression(b, l + 1);
    r = r && right_parenthesis(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // left_parenthesis expression right_parenthesis
  static boolean parenthesis_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesis_expression")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = left_parenthesis(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && right_parenthesis(b, l + 1);
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
  // !(identifier|end_of_line_comment)
  static boolean recover_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_property_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier|end_of_line_comment
  private static boolean recover_property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property_0")) return false;
    boolean r;
    r = identifier(b, l + 1);
    if (!r) r = end_of_line_comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // RETURN
  static boolean return_$(PsiBuilder b, int l) {
    return consumeToken(b, RETURN);
  }

  /* ********************************************************** */
  // RIGHT_CURLY_BRACKET
  static boolean right_curly_bracket(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_CURLY_BRACKET);
  }

  /* ********************************************************** */
  // RIGHT_PARENTHESIS
  static boolean right_parenthesis(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_PARENTHESIS);
  }

  /* ********************************************************** */
  // RIGHT_SQUARE_BRACKET
  static boolean right_square_bracket(PsiBuilder b, int l) {
    return consumeToken(b, RIGHT_SQUARE_BRACKET);
  }

  /* ********************************************************** */
  // SECTION
  static boolean section(PsiBuilder b, int l) {
    return consumeToken(b, SECTION);
  }

  /* ********************************************************** */
  // newline? command_scope? (newline command_scope)* newline*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleFile_0(b, l + 1);
    r = r && simpleFile_1(b, l + 1);
    r = r && simpleFile_2(b, l + 1);
    r = r && simpleFile_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean simpleFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_0")) return false;
    newline(b, l + 1);
    return true;
  }

  // command_scope?
  private static boolean simpleFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_1")) return false;
    command_scope(b, l + 1);
    return true;
  }

  // (newline command_scope)*
  private static boolean simpleFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simpleFile_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_2", c)) break;
    }
    return true;
  }

  // newline command_scope
  private static boolean simpleFile_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = newline(b, l + 1);
    r = r && command_scope(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline*
  private static boolean simpleFile_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!newline(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  static boolean string_literal(PsiBuilder b, int l) {
    return consumeToken(b, STRING_LITERAL);
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
  // unary_operator expression
  static boolean unary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression")) return false;
    if (!nextTokenIs(b, "", MINUS_OPERATOR, UNARY_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unary_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // UNARY_OPERATOR | MINUS_OPERATOR
  static boolean unary_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_operator")) return false;
    if (!nextTokenIs(b, "", MINUS_OPERATOR, UNARY_OPERATOR)) return false;
    boolean r;
    r = consumeToken(b, UNARY_OPERATOR);
    if (!r) r = consumeToken(b, MINUS_OPERATOR);
    return r;
  }

  /* ********************************************************** */
  // identifier | literal
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = identifier(b, l + 1);
    if (!r) r = literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // local_var_declare_statement | global_var_declare_statement
  public static boolean var_declare_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declare_statement")) return false;
    if (!nextTokenIs(b, "<var declare statement>", GLOBAL, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECLARE_STATEMENT, "<var declare statement>");
    r = local_var_declare_statement(b, l + 1);
    if (!r) r = global_var_declare_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
