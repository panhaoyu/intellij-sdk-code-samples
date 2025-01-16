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
  // command_block_single (eol command_block_single)*
  public static boolean command_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_BLOCK, "<command block>");
    r = command_block_single(b, l + 1);
    r = r && command_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol command_block_single)*
  private static boolean command_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_block_1", c)) break;
    }
    return true;
  }

  // eol command_block_single
  private static boolean command_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && command_block_single(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_line_define_header
  //     (eol fish_block_body_define)?
  //     eol fish_line_define_footer
  public static boolean command_block_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_define")) return false;
    if (!nextTokenIs(b, "<command block define>", FISH_DEFINE, FISH_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_BLOCK_DEFINE, "<command block define>");
    r = fish_line_define_header(b, l + 1);
    r = r && command_block_define_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && fish_line_define_footer(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol fish_block_body_define)?
  private static boolean command_block_define_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_define_1")) return false;
    command_block_define_1_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_define
  private static boolean command_block_define_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_define_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_define(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command_block_define |
  //     command_line
  public static boolean command_block_single(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_block_single")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_BLOCK_SINGLE, "<command block single>");
    r = command_block_define(b, l + 1);
    if (!r) r = command_line(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // op_at fish_expr_func_call
  public static boolean command_expr_func_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_expr_func_call")) return false;
    if (!nextTokenIs(b, FUNCTION_CALL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_at(b, l + 1);
    r = r && fish_expr_func_call(b, l + 1);
    exit_section_(b, m, COMMAND_EXPR_FUNC_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // command_inline_fish_line_array_declare |
  //     command_inline_fish_line_assign |
  //     command_inline_fish_line_expr
  public static boolean command_inline_fish_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_inline_fish_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_INLINE_FISH_LINE, "<command inline fish line>");
    r = command_inline_fish_line_array_declare(b, l + 1);
    if (!r) r = command_inline_fish_line_assign(b, l + 1);
    if (!r) r = command_inline_fish_line_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // kw_array tk_identifier paren_l literal_number paren_r
  public static boolean command_inline_fish_line_array_declare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_inline_fish_line_array_declare")) return false;
    if (!nextTokenIs(b, ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_array(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && paren_l(b, l + 1);
    r = r && literal_number(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, COMMAND_INLINE_FISH_LINE_ARRAY_DECLARE, r);
    return r;
  }

  /* ********************************************************** */
  // fish_assign_scope fish_expr_assign (op_comma fish_expr_assign)*
  public static boolean command_inline_fish_line_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_inline_fish_line_assign")) return false;
    if (!nextTokenIs(b, "<command inline fish line assign>", GLOBAL, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_INLINE_FISH_LINE_ASSIGN, "<command inline fish line assign>");
    r = fish_assign_scope(b, l + 1);
    r = r && fish_expr_assign(b, l + 1);
    r = r && command_inline_fish_line_assign_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_comma fish_expr_assign)*
  private static boolean command_inline_fish_line_assign_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_inline_fish_line_assign_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_inline_fish_line_assign_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_inline_fish_line_assign_2", c)) break;
    }
    return true;
  }

  // op_comma fish_expr_assign
  private static boolean command_inline_fish_line_assign_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_inline_fish_line_assign_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && fish_expr_assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_expr
  public static boolean command_inline_fish_line_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_inline_fish_line_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_INLINE_FISH_LINE_EXPR, "<command inline fish line expr>");
    r = fish_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (command_token_all+ tk_comment?) | tk_comment
  public static boolean command_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_LINE, "<command line>");
    r = command_line_0(b, l + 1);
    if (!r) r = tk_comment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // command_token_all+ tk_comment?
  private static boolean command_line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_line_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_line_0_0(b, l + 1);
    r = r && command_line_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // command_token_all+
  private static boolean command_line_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_line_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_token_all(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!command_token_all(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_line_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // tk_comment?
  private static boolean command_line_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_line_0_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // paren_l (command_token_all (op_comma command_token_all)*)? paren_r |
  //     square_l (command_token_all (op_comma command_token_all)*)? square_r |
  //     curly_l (command_token_all (op_comma command_token_all)*)? curly_r |
  //     command_token_identifier |
  //     command_token_inline_fish |
  //     command_expr_func_call |
  //     op_comma | op_assign | op_unary | op_binary_without_minus | op_dot |
  //     tk_literal
  public static boolean command_token_all(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_TOKEN_ALL, "<command token all>");
    r = command_token_all_0(b, l + 1);
    if (!r) r = command_token_all_1(b, l + 1);
    if (!r) r = command_token_all_2(b, l + 1);
    if (!r) r = command_token_identifier(b, l + 1);
    if (!r) r = command_token_inline_fish(b, l + 1);
    if (!r) r = command_expr_func_call(b, l + 1);
    if (!r) r = op_comma(b, l + 1);
    if (!r) r = op_assign(b, l + 1);
    if (!r) r = op_unary(b, l + 1);
    if (!r) r = op_binary_without_minus(b, l + 1);
    if (!r) r = op_dot(b, l + 1);
    if (!r) r = tk_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // paren_l (command_token_all (op_comma command_token_all)*)? paren_r
  private static boolean command_token_all_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && command_token_all_0_1(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (command_token_all (op_comma command_token_all)*)?
  private static boolean command_token_all_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_0_1")) return false;
    command_token_all_0_1_0(b, l + 1);
    return true;
  }

  // command_token_all (op_comma command_token_all)*
  private static boolean command_token_all_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_token_all(b, l + 1);
    r = r && command_token_all_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma command_token_all)*
  private static boolean command_token_all_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_0_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_token_all_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_token_all_0_1_0_1", c)) break;
    }
    return true;
  }

  // op_comma command_token_all
  private static boolean command_token_all_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && command_token_all(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // square_l (command_token_all (op_comma command_token_all)*)? square_r
  private static boolean command_token_all_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = square_l(b, l + 1);
    r = r && command_token_all_1_1(b, l + 1);
    r = r && square_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (command_token_all (op_comma command_token_all)*)?
  private static boolean command_token_all_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_1_1")) return false;
    command_token_all_1_1_0(b, l + 1);
    return true;
  }

  // command_token_all (op_comma command_token_all)*
  private static boolean command_token_all_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_token_all(b, l + 1);
    r = r && command_token_all_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma command_token_all)*
  private static boolean command_token_all_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_token_all_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_token_all_1_1_0_1", c)) break;
    }
    return true;
  }

  // op_comma command_token_all
  private static boolean command_token_all_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && command_token_all(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // curly_l (command_token_all (op_comma command_token_all)*)? curly_r
  private static boolean command_token_all_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = curly_l(b, l + 1);
    r = r && command_token_all_2_1(b, l + 1);
    r = r && curly_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (command_token_all (op_comma command_token_all)*)?
  private static boolean command_token_all_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_2_1")) return false;
    command_token_all_2_1_0(b, l + 1);
    return true;
  }

  // command_token_all (op_comma command_token_all)*
  private static boolean command_token_all_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_token_all(b, l + 1);
    r = r && command_token_all_2_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma command_token_all)*
  private static boolean command_token_all_2_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_2_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_token_all_2_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_token_all_2_1_0_1", c)) break;
    }
    return true;
  }

  // op_comma command_token_all
  private static boolean command_token_all_2_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_all_2_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && command_token_all(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command_token_identifier_without_minus (op_minus (command_token_identifier_without_minus | literal_number))*
  public static boolean command_token_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_TOKEN_IDENTIFIER, "<command token identifier>");
    r = command_token_identifier_without_minus(b, l + 1);
    r = r && command_token_identifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_minus (command_token_identifier_without_minus | literal_number))*
  private static boolean command_token_identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_identifier_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_token_identifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_token_identifier_1", c)) break;
    }
    return true;
  }

  // op_minus (command_token_identifier_without_minus | literal_number)
  private static boolean command_token_identifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_identifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_minus(b, l + 1);
    r = r && command_token_identifier_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // command_token_identifier_without_minus | literal_number
  private static boolean command_token_identifier_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_identifier_1_0_1")) return false;
    boolean r;
    r = command_token_identifier_without_minus(b, l + 1);
    if (!r) r = literal_number(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // command_token_keyword_all | tk_identifier
  public static boolean command_token_identifier_without_minus(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_identifier_without_minus")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_TOKEN_IDENTIFIER_WITHOUT_MINUS, "<command token identifier without minus>");
    r = command_token_keyword_all(b, l + 1);
    if (!r) r = tk_identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // square_l command_inline_fish_line square_r
  public static boolean command_token_inline_fish(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_inline_fish")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = square_l(b, l + 1);
    r = r && command_inline_fish_line(b, l + 1);
    r = r && square_r(b, l + 1);
    exit_section_(b, m, COMMAND_TOKEN_INLINE_FISH, r);
    return r;
  }

  /* ********************************************************** */
  // kw_end | kw_return |
  //     kw_case_of | kw_case | kw_end_case |
  //     kw_exit | kw_global |  kw_local |
  //     kw_if | kw_then | kw_else_if | kw_else | kw_end_if |
  //     kw_lock |
  //     kw_loop | kw_endloop | kw_continue |
  //     kw_section | kw_end_section | kw_struct
  public static boolean command_token_keyword_all(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_token_keyword_all")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_TOKEN_KEYWORD_ALL, "<command token keyword all>");
    r = kw_end(b, l + 1);
    if (!r) r = kw_return(b, l + 1);
    if (!r) r = kw_case_of(b, l + 1);
    if (!r) r = kw_case(b, l + 1);
    if (!r) r = kw_end_case(b, l + 1);
    if (!r) r = kw_exit(b, l + 1);
    if (!r) r = kw_global(b, l + 1);
    if (!r) r = kw_local(b, l + 1);
    if (!r) r = kw_if(b, l + 1);
    if (!r) r = kw_then(b, l + 1);
    if (!r) r = kw_else_if(b, l + 1);
    if (!r) r = kw_else(b, l + 1);
    if (!r) r = kw_end_if(b, l + 1);
    if (!r) r = kw_lock(b, l + 1);
    if (!r) r = kw_loop(b, l + 1);
    if (!r) r = kw_endloop(b, l + 1);
    if (!r) r = kw_continue(b, l + 1);
    if (!r) r = kw_section(b, l + 1);
    if (!r) r = kw_end_section(b, l + 1);
    if (!r) r = kw_struct(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACKET
  public static boolean curly_l(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "curly_l")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACKET);
    exit_section_(b, m, CURLY_L, r);
    return r;
  }

  /* ********************************************************** */
  // RIGHT_CURLY_BRACKET
  public static boolean curly_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "curly_r")) return false;
    if (!nextTokenIs(b, RIGHT_CURLY_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RIGHT_CURLY_BRACKET);
    exit_section_(b, m, CURLY_R, r);
    return r;
  }

  /* ********************************************************** */
  // tk_newline+
  public static boolean eol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol")) return false;
    if (!nextTokenIs(b, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tk_newline(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!tk_newline(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "eol", c)) break;
    }
    exit_section_(b, m, EOL, r);
    return r;
  }

  /* ********************************************************** */
  // kw_local | kw_global
  public static boolean fish_assign_scope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_assign_scope")) return false;
    if (!nextTokenIs(b, "<fish assign scope>", GLOBAL, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_ASSIGN_SCOPE, "<fish assign scope>");
    r = kw_local(b, l + 1);
    if (!r) r = kw_global(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_block_single (eol fish_block_single)*
  public static boolean fish_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK, "<fish block>");
    r = fish_block_single(b, l + 1);
    r = r && fish_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol fish_block_single)*
  private static boolean fish_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_block_1", c)) break;
    }
    return true;
  }

  // eol fish_block_single
  private static boolean fish_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_single(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_block
  public static boolean fish_block_body_case_of(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_case_of")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_CASE_OF, "<fish block body case of>");
    r = fish_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // command_block
  public static boolean fish_block_body_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_COMMAND, "<fish block body command>");
    r = command_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_block
  public static boolean fish_block_body_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_define")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_DEFINE, "<fish block body define>");
    r = fish_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_block
  public static boolean fish_block_body_else(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_else")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_ELSE, "<fish block body else>");
    r = fish_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_block
  public static boolean fish_block_body_else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_else_if")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_ELSE_IF, "<fish block body else if>");
    r = fish_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_block
  public static boolean fish_block_body_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_if")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_IF, "<fish block body if>");
    r = fish_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_block
  public static boolean fish_block_body_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_loop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_LOOP, "<fish block body loop>");
    r = fish_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_block
  public static boolean fish_block_body_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_body_section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_BODY_SECTION, "<fish block body section>");
    r = fish_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_line_case_of_block_header
  //     (eol fish_block_body_case_of)?
  //     (eol fish_line_case_of_block_option eol fish_block_body_case_of)*
  //     eol fish_line_case_of_block_footer
  public static boolean fish_block_case_of(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_case_of")) return false;
    if (!nextTokenIs(b, CASEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish_line_case_of_block_header(b, l + 1);
    r = r && fish_block_case_of_1(b, l + 1);
    r = r && fish_block_case_of_2(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && fish_line_case_of_block_footer(b, l + 1);
    exit_section_(b, m, FISH_BLOCK_CASE_OF, r);
    return r;
  }

  // (eol fish_block_body_case_of)?
  private static boolean fish_block_case_of_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_case_of_1")) return false;
    fish_block_case_of_1_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_case_of
  private static boolean fish_block_case_of_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_case_of_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_case_of(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol fish_line_case_of_block_option eol fish_block_body_case_of)*
  private static boolean fish_block_case_of_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_case_of_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_block_case_of_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_block_case_of_2", c)) break;
    }
    return true;
  }

  // eol fish_line_case_of_block_option eol fish_block_body_case_of
  private static boolean fish_block_case_of_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_case_of_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_line_case_of_block_option(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && fish_block_body_case_of(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_line_command_header
  //     (eol fish_block_body_command)?
  //     eol fish_line_command_footer
  public static boolean fish_block_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_command")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish_line_command_header(b, l + 1);
    r = r && fish_block_command_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && fish_line_command_footer(b, l + 1);
    exit_section_(b, m, FISH_BLOCK_COMMAND, r);
    return r;
  }

  // (eol fish_block_body_command)?
  private static boolean fish_block_command_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_command_1")) return false;
    fish_block_command_1_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_command
  private static boolean fish_block_command_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_command_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_line_if_block_header
  //              (eol fish_block_body_if)?
  //              (eol fish_line_if_block_else_if (eol fish_block_body_else_if)?)*
  //              (eol fish_line_if_block_else (eol fish_block_body_else)?)?
  //              eol fish_line_if_block_footer
  public static boolean fish_block_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish_line_if_block_header(b, l + 1);
    r = r && fish_block_if_1(b, l + 1);
    r = r && fish_block_if_2(b, l + 1);
    r = r && fish_block_if_3(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && fish_line_if_block_footer(b, l + 1);
    exit_section_(b, m, FISH_BLOCK_IF, r);
    return r;
  }

  // (eol fish_block_body_if)?
  private static boolean fish_block_if_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_1")) return false;
    fish_block_if_1_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_if
  private static boolean fish_block_if_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_if(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol fish_line_if_block_else_if (eol fish_block_body_else_if)?)*
  private static boolean fish_block_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_block_if_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_block_if_2", c)) break;
    }
    return true;
  }

  // eol fish_line_if_block_else_if (eol fish_block_body_else_if)?
  private static boolean fish_block_if_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_line_if_block_else_if(b, l + 1);
    r = r && fish_block_if_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol fish_block_body_else_if)?
  private static boolean fish_block_if_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_2_0_2")) return false;
    fish_block_if_2_0_2_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_else_if
  private static boolean fish_block_if_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_else_if(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol fish_line_if_block_else (eol fish_block_body_else)?)?
  private static boolean fish_block_if_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_3")) return false;
    fish_block_if_3_0(b, l + 1);
    return true;
  }

  // eol fish_line_if_block_else (eol fish_block_body_else)?
  private static boolean fish_block_if_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_line_if_block_else(b, l + 1);
    r = r && fish_block_if_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol fish_block_body_else)?
  private static boolean fish_block_if_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_3_0_2")) return false;
    fish_block_if_3_0_2_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_else
  private static boolean fish_block_if_3_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_if_3_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_else(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_line_loop_block_header (eol fish_block_body_loop)? eol fish_line_loop_block_footer
  public static boolean fish_block_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_loop")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish_line_loop_block_header(b, l + 1);
    r = r && fish_block_loop_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && fish_line_loop_block_footer(b, l + 1);
    exit_section_(b, m, FISH_BLOCK_LOOP, r);
    return r;
  }

  // (eol fish_block_body_loop)?
  private static boolean fish_block_loop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_loop_1")) return false;
    fish_block_loop_1_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_loop
  private static boolean fish_block_loop_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_loop_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_loop(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_line_section_header (eol fish_block_body_section)? eol fish_line_section_footer
  public static boolean fish_block_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_section")) return false;
    if (!nextTokenIs(b, SECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fish_line_section_header(b, l + 1);
    r = r && fish_block_section_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && fish_line_section_footer(b, l + 1);
    exit_section_(b, m, FISH_BLOCK_SECTION, r);
    return r;
  }

  // (eol fish_block_body_section)?
  private static boolean fish_block_section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_section_1")) return false;
    fish_block_section_1_0(b, l + 1);
    return true;
  }

  // eol fish_block_body_section
  private static boolean fish_block_section_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_section_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && fish_block_body_section(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_block_command |
  //     fish_block_if |
  //     fish_block_loop |
  //     fish_block_case_of |
  //     fish_block_section |
  //     fish_line
  public static boolean fish_block_single(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_block_single")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_BLOCK_SINGLE, "<fish block single>");
    r = fish_block_command(b, l + 1);
    if (!r) r = fish_block_if(b, l + 1);
    if (!r) r = fish_block_loop(b, l + 1);
    if (!r) r = fish_block_case_of(b, l + 1);
    if (!r) r = fish_block_section(b, l + 1);
    if (!r) r = fish_line(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_expr_value (op_binary fish_expr)?
  public static boolean fish_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR, "<fish expr>");
    r = fish_expr_value(b, l + 1);
    r = r && fish_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_binary fish_expr)?
  private static boolean fish_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_1")) return false;
    fish_expr_1_0(b, l + 1);
    return true;
  }

  // op_binary fish_expr
  private static boolean fish_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && fish_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_expr_assign_target fish_expr_assign_right?
  public static boolean fish_expr_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_assign")) return false;
    if (!nextTokenIs(b, "<fish expr assign>", GLOBAL, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_ASSIGN, "<fish expr assign>");
    r = fish_expr_assign_target(b, l + 1);
    r = r && fish_expr_assign_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // fish_expr_assign_right?
  private static boolean fish_expr_assign_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_assign_1")) return false;
    fish_expr_assign_right(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_local? tk_identifier
  public static boolean fish_expr_assign_left_for_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_assign_left_for_loop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_ASSIGN_LEFT_FOR_LOOP, "<fish expr assign left for loop>");
    r = fish_expr_assign_left_for_loop_0(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_local?
  private static boolean fish_expr_assign_left_for_loop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_assign_left_for_loop_0")) return false;
    kw_local(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // op_assign fish_expr
  public static boolean fish_expr_assign_right(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_assign_right")) return false;
    if (!nextTokenIs(b, ASSIGNMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_assign(b, l + 1);
    r = r && fish_expr(b, l + 1);
    exit_section_(b, m, FISH_EXPR_ASSIGN_RIGHT, r);
    return r;
  }

  /* ********************************************************** */
  // fish_expr_func_call
  public static boolean fish_expr_assign_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_assign_target")) return false;
    if (!nextTokenIs(b, "<fish expr assign target>", GLOBAL, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_ASSIGN_TARGET, "<fish expr assign target>");
    r = fish_expr_func_call(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_expr (op_comma fish_expr)*
  public static boolean fish_expr_csv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_csv")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_CSV, "<fish expr csv>");
    r = fish_expr(b, l + 1);
    r = r && fish_expr_csv_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_comma fish_expr)*
  private static boolean fish_expr_csv_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_csv_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_expr_csv_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_expr_csv_1", c)) break;
    }
    return true;
  }

  // op_comma fish_expr
  private static boolean fish_expr_csv_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_csv_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && fish_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paren_l tk_identifier (op_comma tk_identifier)* paren_r
  public static boolean fish_expr_define_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_define_params")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && fish_expr_define_params_2(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, FISH_EXPR_DEFINE_PARAMS, r);
    return r;
  }

  // (op_comma tk_identifier)*
  private static boolean fish_expr_define_params_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_define_params_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_expr_define_params_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_expr_define_params_2", c)) break;
    }
    return true;
  }

  // op_comma tk_identifier
  private static boolean fish_expr_define_params_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_define_params_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fish_expr_func_call_func_name fish_expr_paren?
  public static boolean fish_expr_func_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_func_call")) return false;
    if (!nextTokenIs(b, "<fish expr func call>", GLOBAL, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_FUNC_CALL, "<fish expr func call>");
    r = fish_expr_func_call_func_name(b, l + 1);
    r = r && fish_expr_func_call_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // fish_expr_paren?
  private static boolean fish_expr_func_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_func_call_1")) return false;
    fish_expr_paren(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // tk_identifier
  public static boolean fish_expr_func_call_func_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_func_call_func_name")) return false;
    if (!nextTokenIs(b, "<fish expr func call func name>", GLOBAL, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_FUNC_CALL_FUNC_NAME, "<fish expr func call func name>");
    r = tk_identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_expr_assign_left_for_loop paren_l fish_expr op_comma fish_expr (op_comma fish_expr)? paren_r
  public static boolean fish_expr_loop_indexed(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_loop_indexed")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_LOOP_INDEXED, "<fish expr loop indexed>");
    r = fish_expr_assign_left_for_loop(b, l + 1);
    r = r && paren_l(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && fish_expr_loop_indexed_5(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_comma fish_expr)?
  private static boolean fish_expr_loop_indexed_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_loop_indexed_5")) return false;
    fish_expr_loop_indexed_5_0(b, l + 1);
    return true;
  }

  // op_comma fish_expr
  private static boolean fish_expr_loop_indexed_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_loop_indexed_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && fish_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paren_l fish_expr_csv paren_r
  public static boolean fish_expr_paren(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_paren")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && fish_expr_csv(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, FISH_EXPR_PAREN, r);
    return r;
  }

  /* ********************************************************** */
  // square_l fish_expr_csv square_r
  public static boolean fish_expr_square(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_square")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = square_l(b, l + 1);
    r = r && fish_expr_csv(b, l + 1);
    r = r && square_r(b, l + 1);
    exit_section_(b, m, FISH_EXPR_SQUARE, r);
    return r;
  }

  /* ********************************************************** */
  // op_unary fish_expr
  public static boolean fish_expr_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_unary")) return false;
    if (!nextTokenIs(b, "<fish expr unary>", MINUS_OPERATOR, UNARY_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_UNARY, "<fish expr unary>");
    r = op_unary(b, l + 1);
    r = r && fish_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_expr_paren |
  //     fish_expr_square |
  //     fish_expr_func_call |
  //     fish_expr_unary |
  //     tk_value
  public static boolean fish_expr_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_expr_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_EXPR_VALUE, "<fish expr value>");
    r = fish_expr_paren(b, l + 1);
    if (!r) r = fish_expr_square(b, l + 1);
    if (!r) r = fish_expr_func_call(b, l + 1);
    if (!r) r = fish_expr_unary(b, l + 1);
    if (!r) r = tk_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fish_line_break |
  //     fish_line_continue |
  //     fish_line_exit_section |
  //     fish_line_exit_loop |
  //     fish_line_exit |
  //     fish_line_array_declare |
  //     fish_line_assign |
  //     fish_line_return |
  //     fish_line_expr |
  //     fish_line_comment
  public static boolean fish_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_LINE, "<fish line>");
    r = fish_line_break(b, l + 1);
    if (!r) r = fish_line_continue(b, l + 1);
    if (!r) r = fish_line_exit_section(b, l + 1);
    if (!r) r = fish_line_exit_loop(b, l + 1);
    if (!r) r = fish_line_exit(b, l + 1);
    if (!r) r = fish_line_array_declare(b, l + 1);
    if (!r) r = fish_line_assign(b, l + 1);
    if (!r) r = fish_line_return(b, l + 1);
    if (!r) r = fish_line_expr(b, l + 1);
    if (!r) r = fish_line_comment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // kw_array tk_identifier paren_l literal_number paren_r tk_comment?
  public static boolean fish_line_array_declare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_array_declare")) return false;
    if (!nextTokenIs(b, ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_array(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && paren_l(b, l + 1);
    r = r && literal_number(b, l + 1);
    r = r && paren_r(b, l + 1);
    r = r && fish_line_array_declare_5(b, l + 1);
    exit_section_(b, m, FISH_LINE_ARRAY_DECLARE, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_array_declare_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_array_declare_5")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // fish_assign_scope? fish_expr_assign (op_comma fish_expr_assign)* tk_comment?
  public static boolean fish_line_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_assign")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_LINE_ASSIGN, "<fish line assign>");
    r = fish_line_assign_0(b, l + 1);
    r = r && fish_expr_assign(b, l + 1);
    r = r && fish_line_assign_2(b, l + 1);
    r = r && fish_line_assign_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // fish_assign_scope?
  private static boolean fish_line_assign_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_assign_0")) return false;
    fish_assign_scope(b, l + 1);
    return true;
  }

  // (op_comma fish_expr_assign)*
  private static boolean fish_line_assign_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_assign_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fish_line_assign_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fish_line_assign_2", c)) break;
    }
    return true;
  }

  // op_comma fish_expr_assign
  private static boolean fish_line_assign_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_assign_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && fish_expr_assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_assign_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_assign_3")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_break tk_comment?
  public static boolean fish_line_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_break")) return false;
    if (!nextTokenIs(b, "<fish line break>", BREAK, EXIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_LINE_BREAK, "<fish line break>");
    r = kw_break(b, l + 1);
    r = r && fish_line_break_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_break_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_break_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_end_case tk_comment?
  public static boolean fish_line_case_of_block_footer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_case_of_block_footer")) return false;
    if (!nextTokenIs(b, ENDCASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_end_case(b, l + 1);
    r = r && fish_line_case_of_block_footer_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_CASE_OF_BLOCK_FOOTER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_case_of_block_footer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_case_of_block_footer_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_case_of fish_expr tk_comment?
  public static boolean fish_line_case_of_block_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_case_of_block_header")) return false;
    if (!nextTokenIs(b, CASEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_case_of(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && fish_line_case_of_block_header_2(b, l + 1);
    exit_section_(b, m, FISH_LINE_CASE_OF_BLOCK_HEADER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_case_of_block_header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_case_of_block_header_2")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_case fish_expr tk_comment?
  public static boolean fish_line_case_of_block_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_case_of_block_option")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_case(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && fish_line_case_of_block_option_2(b, l + 1);
    exit_section_(b, m, FISH_LINE_CASE_OF_BLOCK_OPTION, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_case_of_block_option_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_case_of_block_option_2")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_end_command tk_comment?
  public static boolean fish_line_command_footer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_command_footer")) return false;
    if (!nextTokenIs(b, ENDCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_end_command(b, l + 1);
    r = r && fish_line_command_footer_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_COMMAND_FOOTER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_command_footer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_command_footer_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_command tk_comment?
  public static boolean fish_line_command_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_command_header")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_command(b, l + 1);
    r = r && fish_line_command_header_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_COMMAND_HEADER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_command_header_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_command_header_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // tk_comment
  public static boolean fish_line_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_comment")) return false;
    if (!nextTokenIs(b, COMMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tk_comment(b, l + 1);
    exit_section_(b, m, FISH_LINE_COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // kw_continue tk_comment?
  public static boolean fish_line_continue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_continue")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_continue(b, l + 1);
    r = r && fish_line_continue_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_CONTINUE, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_continue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_continue_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_end tk_comment?
  public static boolean fish_line_define_footer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_define_footer")) return false;
    if (!nextTokenIs(b, END)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_end(b, l + 1);
    r = r && fish_line_define_footer_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_DEFINE_FOOTER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_define_footer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_define_footer_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (kw_fish_define | kw_fish_operator) tk_identifier fish_expr_define_params? tk_comment?
  public static boolean fish_line_define_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_define_header")) return false;
    if (!nextTokenIs(b, "<fish line define header>", FISH_DEFINE, FISH_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_LINE_DEFINE_HEADER, "<fish line define header>");
    r = fish_line_define_header_0(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && fish_line_define_header_2(b, l + 1);
    r = r && fish_line_define_header_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_fish_define | kw_fish_operator
  private static boolean fish_line_define_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_define_header_0")) return false;
    boolean r;
    r = kw_fish_define(b, l + 1);
    if (!r) r = kw_fish_operator(b, l + 1);
    return r;
  }

  // fish_expr_define_params?
  private static boolean fish_line_define_header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_define_header_2")) return false;
    fish_expr_define_params(b, l + 1);
    return true;
  }

  // tk_comment?
  private static boolean fish_line_define_header_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_define_header_3")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_exit tk_comment?
  public static boolean fish_line_exit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_exit")) return false;
    if (!nextTokenIs(b, EXIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_exit(b, l + 1);
    r = r && fish_line_exit_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_EXIT, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_exit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_exit_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_exit_loop tk_comment?
  public static boolean fish_line_exit_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_exit_loop")) return false;
    if (!nextTokenIs(b, EXITLOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_exit_loop(b, l + 1);
    r = r && fish_line_exit_loop_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_EXIT_LOOP, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_exit_loop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_exit_loop_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_exit_section tk_comment?
  public static boolean fish_line_exit_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_exit_section")) return false;
    if (!nextTokenIs(b, EXITSECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_exit_section(b, l + 1);
    r = r && fish_line_exit_section_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_EXIT_SECTION, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_exit_section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_exit_section_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // fish_expr tk_comment?
  public static boolean fish_line_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_LINE_EXPR, "<fish line expr>");
    r = fish_expr(b, l + 1);
    r = r && fish_line_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_expr_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_else tk_comment?
  public static boolean fish_line_if_block_else(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_else")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_else(b, l + 1);
    r = r && fish_line_if_block_else_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_IF_BLOCK_ELSE, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_if_block_else_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_else_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_else_if fish_expr kw_then? tk_comment?
  public static boolean fish_line_if_block_else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_else_if")) return false;
    if (!nextTokenIs(b, "<fish line if block else if>", ELSE, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FISH_LINE_IF_BLOCK_ELSE_IF, "<fish line if block else if>");
    r = kw_else_if(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && fish_line_if_block_else_if_2(b, l + 1);
    r = r && fish_line_if_block_else_if_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_then?
  private static boolean fish_line_if_block_else_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_else_if_2")) return false;
    kw_then(b, l + 1);
    return true;
  }

  // tk_comment?
  private static boolean fish_line_if_block_else_if_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_else_if_3")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_end_if tk_comment?
  public static boolean fish_line_if_block_footer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_footer")) return false;
    if (!nextTokenIs(b, ENDIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_end_if(b, l + 1);
    r = r && fish_line_if_block_footer_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_IF_BLOCK_FOOTER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_if_block_footer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_footer_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_if fish_expr kw_then? tk_comment?
  public static boolean fish_line_if_block_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_header")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_if(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && fish_line_if_block_header_2(b, l + 1);
    r = r && fish_line_if_block_header_3(b, l + 1);
    exit_section_(b, m, FISH_LINE_IF_BLOCK_HEADER, r);
    return r;
  }

  // kw_then?
  private static boolean fish_line_if_block_header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_header_2")) return false;
    kw_then(b, l + 1);
    return true;
  }

  // tk_comment?
  private static boolean fish_line_if_block_header_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_if_block_header_3")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_endloop tk_comment?
  public static boolean fish_line_loop_block_footer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_loop_block_footer")) return false;
    if (!nextTokenIs(b, ENDLOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_endloop(b, l + 1);
    r = r && fish_line_loop_block_footer_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_LOOP_BLOCK_FOOTER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_loop_block_footer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_loop_block_footer_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_loop (loop_each | fish_expr_loop_indexed | loop_for | loop_while) tk_comment?
  public static boolean fish_line_loop_block_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_loop_block_header")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_loop(b, l + 1);
    r = r && fish_line_loop_block_header_1(b, l + 1);
    r = r && fish_line_loop_block_header_2(b, l + 1);
    exit_section_(b, m, FISH_LINE_LOOP_BLOCK_HEADER, r);
    return r;
  }

  // loop_each | fish_expr_loop_indexed | loop_for | loop_while
  private static boolean fish_line_loop_block_header_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_loop_block_header_1")) return false;
    boolean r;
    r = loop_each(b, l + 1);
    if (!r) r = fish_expr_loop_indexed(b, l + 1);
    if (!r) r = loop_for(b, l + 1);
    if (!r) r = loop_while(b, l + 1);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_loop_block_header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_loop_block_header_2")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_return fish_expr? tk_comment?
  public static boolean fish_line_return(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_return")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_return(b, l + 1);
    r = r && fish_line_return_1(b, l + 1);
    r = r && fish_line_return_2(b, l + 1);
    exit_section_(b, m, FISH_LINE_RETURN, r);
    return r;
  }

  // fish_expr?
  private static boolean fish_line_return_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_return_1")) return false;
    fish_expr(b, l + 1);
    return true;
  }

  // tk_comment?
  private static boolean fish_line_return_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_return_2")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_end_section tk_comment?
  public static boolean fish_line_section_footer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_section_footer")) return false;
    if (!nextTokenIs(b, ENDSECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_end_section(b, l + 1);
    r = r && fish_line_section_footer_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_SECTION_FOOTER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_section_footer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_section_footer_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_section tk_comment?
  public static boolean fish_line_section_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_section_header")) return false;
    if (!nextTokenIs(b, SECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_section(b, l + 1);
    r = r && fish_line_section_header_1(b, l + 1);
    exit_section_(b, m, FISH_LINE_SECTION_HEADER, r);
    return r;
  }

  // tk_comment?
  private static boolean fish_line_section_header_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fish_line_section_header_1")) return false;
    tk_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ARRAY
  public static boolean kw_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_array")) return false;
    if (!nextTokenIs(b, ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARRAY);
    exit_section_(b, m, KW_ARRAY, r);
    return r;
  }

  /* ********************************************************** */
  // BREAK | (kw_exit kw_loop)
  public static boolean kw_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_break")) return false;
    if (!nextTokenIs(b, "<kw break>", BREAK, EXIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_BREAK, "<kw break>");
    r = consumeToken(b, BREAK);
    if (!r) r = kw_break_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  public static boolean kw_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_case")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    exit_section_(b, m, KW_CASE, r);
    return r;
  }

  /* ********************************************************** */
  // CASEOF
  public static boolean kw_case_of(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_case_of")) return false;
    if (!nextTokenIs(b, CASEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASEOF);
    exit_section_(b, m, KW_CASE_OF, r);
    return r;
  }

  /* ********************************************************** */
  // COMMAND
  public static boolean kw_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_command")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND);
    exit_section_(b, m, KW_COMMAND, r);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE
  public static boolean kw_continue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_continue")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    exit_section_(b, m, KW_CONTINUE, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE
  public static boolean kw_else(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    exit_section_(b, m, KW_ELSE, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF | (kw_else kw_if)
  public static boolean kw_else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else_if")) return false;
    if (!nextTokenIs(b, "<kw else if>", ELSE, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_ELSE_IF, "<kw else if>");
    r = consumeToken(b, ELSEIF);
    if (!r) r = kw_else_if_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  public static boolean kw_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_end")) return false;
    if (!nextTokenIs(b, END)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, END);
    exit_section_(b, m, KW_END, r);
    return r;
  }

  /* ********************************************************** */
  // ENDCASE
  public static boolean kw_end_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_end_case")) return false;
    if (!nextTokenIs(b, ENDCASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENDCASE);
    exit_section_(b, m, KW_END_CASE, r);
    return r;
  }

  /* ********************************************************** */
  // ENDCOMMAND
  public static boolean kw_end_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_end_command")) return false;
    if (!nextTokenIs(b, ENDCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENDCOMMAND);
    exit_section_(b, m, KW_END_COMMAND, r);
    return r;
  }

  /* ********************************************************** */
  // ENDIF
  public static boolean kw_end_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_end_if")) return false;
    if (!nextTokenIs(b, ENDIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENDIF);
    exit_section_(b, m, KW_END_IF, r);
    return r;
  }

  /* ********************************************************** */
  // ENDSECTION
  public static boolean kw_end_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_end_section")) return false;
    if (!nextTokenIs(b, ENDSECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENDSECTION);
    exit_section_(b, m, KW_END_SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // ENDLOOP
  public static boolean kw_endloop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_endloop")) return false;
    if (!nextTokenIs(b, ENDLOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENDLOOP);
    exit_section_(b, m, KW_ENDLOOP, r);
    return r;
  }

  /* ********************************************************** */
  // EXIT
  public static boolean kw_exit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_exit")) return false;
    if (!nextTokenIs(b, EXIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXIT);
    exit_section_(b, m, KW_EXIT, r);
    return r;
  }

  /* ********************************************************** */
  // EXITLOOP
  public static boolean kw_exit_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_exit_loop")) return false;
    if (!nextTokenIs(b, EXITLOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXITLOOP);
    exit_section_(b, m, KW_EXIT_LOOP, r);
    return r;
  }

  /* ********************************************************** */
  // EXITSECTION
  public static boolean kw_exit_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_exit_section")) return false;
    if (!nextTokenIs(b, EXITSECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXITSECTION);
    exit_section_(b, m, KW_EXIT_SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // FISH_DEFINE
  public static boolean kw_fish_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_fish_define")) return false;
    if (!nextTokenIs(b, FISH_DEFINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FISH_DEFINE);
    exit_section_(b, m, KW_FISH_DEFINE, r);
    return r;
  }

  /* ********************************************************** */
  // FISH_OPERATOR
  public static boolean kw_fish_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_fish_operator")) return false;
    if (!nextTokenIs(b, FISH_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FISH_OPERATOR);
    exit_section_(b, m, KW_FISH_OPERATOR, r);
    return r;
  }

  /* ********************************************************** */
  // FOR
  public static boolean kw_for(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_for")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    exit_section_(b, m, KW_FOR, r);
    return r;
  }

  /* ********************************************************** */
  // FOREACH
  public static boolean kw_foreach(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_foreach")) return false;
    if (!nextTokenIs(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOREACH);
    exit_section_(b, m, KW_FOREACH, r);
    return r;
  }

  /* ********************************************************** */
  // GLOBAL
  public static boolean kw_global(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_global")) return false;
    if (!nextTokenIs(b, GLOBAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL);
    exit_section_(b, m, KW_GLOBAL, r);
    return r;
  }

  /* ********************************************************** */
  // IF
  public static boolean kw_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_if")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    exit_section_(b, m, KW_IF, r);
    return r;
  }

  /* ********************************************************** */
  // LOCAL
  public static boolean kw_local(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_local")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    exit_section_(b, m, KW_LOCAL, r);
    return r;
  }

  /* ********************************************************** */
  // LOCK
  static boolean kw_lock(PsiBuilder b, int l) {
    return consumeToken(b, LOCK);
  }

  /* ********************************************************** */
  // LOOP
  public static boolean kw_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_loop")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOOP);
    exit_section_(b, m, KW_LOOP, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN
  public static boolean kw_return(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_return")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    exit_section_(b, m, KW_RETURN, r);
    return r;
  }

  /* ********************************************************** */
  // SECTION
  public static boolean kw_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_section")) return false;
    if (!nextTokenIs(b, SECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SECTION);
    exit_section_(b, m, KW_SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // STRUCT
  public static boolean kw_struct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_struct")) return false;
    if (!nextTokenIs(b, STRUCT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRUCT);
    exit_section_(b, m, KW_STRUCT, r);
    return r;
  }

  /* ********************************************************** */
  // THEN
  public static boolean kw_then(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_then")) return false;
    if (!nextTokenIs(b, THEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THEN);
    exit_section_(b, m, KW_THEN, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE
  public static boolean kw_while(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_while")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    exit_section_(b, m, KW_WHILE, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER_LITERAL
  public static boolean literal_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_number")) return false;
    if (!nextTokenIs(b, NUMBER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER_LITERAL);
    exit_section_(b, m, LITERAL_NUMBER, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean literal_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_string")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, LITERAL_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // kw_foreach fish_expr_assign_left_for_loop fish_expr
  public static boolean loop_each(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_each")) return false;
    if (!nextTokenIs(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_foreach(b, l + 1);
    r = r && fish_expr_assign_left_for_loop(b, l + 1);
    r = r && fish_expr(b, l + 1);
    exit_section_(b, m, LOOP_EACH, r);
    return r;
  }

  /* ********************************************************** */
  // kw_for paren_l kw_local? fish_expr op_comma fish_expr op_comma fish_expr paren_r
  public static boolean loop_for(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_for")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_for(b, l + 1);
    r = r && paren_l(b, l + 1);
    r = r && loop_for_2(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && fish_expr(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, LOOP_FOR, r);
    return r;
  }

  // kw_local?
  private static boolean loop_for_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_for_2")) return false;
    kw_local(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_while fish_expr
  public static boolean loop_while(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_while")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_while(b, l + 1);
    r = r && fish_expr(b, l + 1);
    exit_section_(b, m, LOOP_WHILE, r);
    return r;
  }

  /* ********************************************************** */
  // ASSIGNMENT_OPERATOR
  public static boolean op_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_assign")) return false;
    if (!nextTokenIs(b, ASSIGNMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT_OPERATOR);
    exit_section_(b, m, OP_ASSIGN, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION_CALL_OPERATOR
  public static boolean op_at(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_at")) return false;
    if (!nextTokenIs(b, FUNCTION_CALL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION_CALL_OPERATOR);
    exit_section_(b, m, OP_AT, r);
    return r;
  }

  /* ********************************************************** */
  // op_binary_without_minus | op_minus
  public static boolean op_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_binary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OP_BINARY, "<op binary>");
    r = op_binary_without_minus(b, l + 1);
    if (!r) r = op_minus(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BINARY_OPERATOR | ASSIGNMENT_OPERATOR
  public static boolean op_binary_without_minus(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_binary_without_minus")) return false;
    if (!nextTokenIs(b, "<op binary without minus>", ASSIGNMENT_OPERATOR, BINARY_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OP_BINARY_WITHOUT_MINUS, "<op binary without minus>");
    r = consumeToken(b, BINARY_OPERATOR);
    if (!r) r = consumeToken(b, ASSIGNMENT_OPERATOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMA_OPERATOR
  public static boolean op_comma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_comma")) return false;
    if (!nextTokenIs(b, COMMA_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_OPERATOR);
    exit_section_(b, m, OP_COMMA, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_OPERATOR
  public static boolean op_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_comment")) return false;
    if (!nextTokenIs(b, COMMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT_OPERATOR);
    exit_section_(b, m, OP_COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // DOT_OPERATOR
  public static boolean op_dot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_dot")) return false;
    if (!nextTokenIs(b, DOT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT_OPERATOR);
    exit_section_(b, m, OP_DOT, r);
    return r;
  }

  /* ********************************************************** */
  // MINUS_OPERATOR
  public static boolean op_minus(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_minus")) return false;
    if (!nextTokenIs(b, MINUS_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS_OPERATOR);
    exit_section_(b, m, OP_MINUS, r);
    return r;
  }

  /* ********************************************************** */
  // UNARY_OPERATOR | op_minus
  public static boolean op_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_unary")) return false;
    if (!nextTokenIs(b, "<op unary>", MINUS_OPERATOR, UNARY_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OP_UNARY, "<op unary>");
    r = consumeToken(b, UNARY_OPERATOR);
    if (!r) r = op_minus(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS
  public static boolean paren_l(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_l")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    exit_section_(b, m, PAREN_L, r);
    return r;
  }

  /* ********************************************************** */
  // RIGHT_PARENTHESIS
  public static boolean paren_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_r")) return false;
    if (!nextTokenIs(b, RIGHT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, PAREN_R, r);
    return r;
  }

  /* ********************************************************** */
  // tk_newline* command_block? tk_newline*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleFile_0(b, l + 1);
    r = r && simpleFile_1(b, l + 1);
    r = r && simpleFile_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tk_newline*
  private static boolean simpleFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tk_newline(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_0", c)) break;
    }
    return true;
  }

  // command_block?
  private static boolean simpleFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_1")) return false;
    command_block(b, l + 1);
    return true;
  }

  // tk_newline*
  private static boolean simpleFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tk_newline(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LEFT_SQUARE_BRACKET
  public static boolean square_l(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "square_l")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_SQUARE_BRACKET);
    exit_section_(b, m, SQUARE_L, r);
    return r;
  }

  /* ********************************************************** */
  // RIGHT_SQUARE_BRACKET
  public static boolean square_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "square_r")) return false;
    if (!nextTokenIs(b, RIGHT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RIGHT_SQUARE_BRACKET);
    exit_section_(b, m, SQUARE_R, r);
    return r;
  }

  /* ********************************************************** */
  // op_comment tk_comment_text?
  public static boolean tk_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_comment")) return false;
    if (!nextTokenIs(b, COMMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comment(b, l + 1);
    r = r && tk_comment_1(b, l + 1);
    exit_section_(b, m, TK_COMMENT, r);
    return r;
  }

  // tk_comment_text?
  private static boolean tk_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_comment_1")) return false;
    tk_comment_text(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COMMENT_TEXT
  public static boolean tk_comment_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_comment_text")) return false;
    if (!nextTokenIs(b, COMMENT_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT_TEXT);
    exit_section_(b, m, TK_COMMENT_TEXT, r);
    return r;
  }

  /* ********************************************************** */
  // tk_identifier_raw | (kw_global op_dot tk_identifier_raw)
  public static boolean tk_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_identifier")) return false;
    if (!nextTokenIs(b, "<tk identifier>", GLOBAL, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TK_IDENTIFIER, "<tk identifier>");
    r = tk_identifier_raw(b, l + 1);
    if (!r) r = tk_identifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_global op_dot tk_identifier_raw
  private static boolean tk_identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_identifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_global(b, l + 1);
    r = r && op_dot(b, l + 1);
    r = r && tk_identifier_raw(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean tk_identifier_raw(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_identifier_raw")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TK_IDENTIFIER_RAW, r);
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
  // NEWLINE
  public static boolean tk_newline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tk_newline")) return false;
    if (!nextTokenIs(b, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    exit_section_(b, m, TK_NEWLINE, r);
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

}
