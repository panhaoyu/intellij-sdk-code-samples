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
  // kw_local? tk_identifier
  static boolean assign_left_for_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_left_for_loop")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assign_left_for_loop_0(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // kw_local?
  private static boolean assign_left_for_loop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_left_for_loop_0")) return false;
    kw_local(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // op_assign expr
  static boolean assign_right(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_right")) return false;
    if (!nextTokenIs(b, ASSIGNMENT_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_assign(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tk_identifier expr_paren_csv?
  static boolean assign_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_target")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tk_identifier(b, l + 1);
    r = r && assign_target_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr_paren_csv?
  private static boolean assign_target_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_target_1")) return false;
    expr_paren_csv(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_case_of expr (eol block_fish)? (eol block_case_option)* eol kw_end_case
  public static boolean block_case_of(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_of")) return false;
    if (!nextTokenIs(b, CASEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_case_of(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && block_case_of_2(b, l + 1);
    r = r && block_case_of_3(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end_case(b, l + 1);
    exit_section_(b, m, BLOCK_CASE_OF, r);
    return r;
  }

  // (eol block_fish)?
  private static boolean block_case_of_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_of_2")) return false;
    block_case_of_2_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_case_of_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_of_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol block_case_option)*
  private static boolean block_case_of_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_of_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_case_of_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_case_of_3", c)) break;
    }
    return true;
  }

  // eol block_case_option
  private static boolean block_case_of_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_of_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_case_option(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_case expr (eol block_fish)?
  public static boolean block_case_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_option")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_case(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && block_case_option_2(b, l + 1);
    exit_section_(b, m, BLOCK_CASE_OPTION, r);
    return r;
  }

  // (eol block_fish)?
  private static boolean block_case_option_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_option_2")) return false;
    block_case_option_2_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_case_option_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_case_option_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_command (eol body_cmd)? eol kw_end_command
  public static boolean block_cmd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_cmd")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_command(b, l + 1);
    r = r && block_cmd_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end_command(b, l + 1);
    exit_section_(b, m, BLOCK_CMD, r);
    return r;
  }

  // (eol body_cmd)?
  private static boolean block_cmd_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_cmd_1")) return false;
    block_cmd_1_0(b, l + 1);
    return true;
  }

  // eol body_cmd
  private static boolean block_cmd_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_cmd_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && body_cmd(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // define_header (eol block_fish)? eol kw_end
  public static boolean block_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_define")) return false;
    if (!nextTokenIs(b, "<block define>", DEFINE, FISH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_DEFINE, "<block define>");
    r = define_header(b, l + 1);
    r = r && block_define_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol block_fish)?
  private static boolean block_define_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_define_1")) return false;
    block_define_1_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_define_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_define_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_else (eol block_fish)?
  public static boolean block_else(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_else")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_else(b, l + 1);
    r = r && block_else_1(b, l + 1);
    exit_section_(b, m, BLOCK_ELSE, r);
    return r;
  }

  // (eol block_fish)?
  private static boolean block_else_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_else_1")) return false;
    block_else_1_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_else_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_else_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_else_if expr kw_then? (eol block_fish)?
  public static boolean block_else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_else_if")) return false;
    if (!nextTokenIs(b, "<block else if>", ELSE, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_ELSE_IF, "<block else if>");
    r = kw_else_if(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && block_else_if_2(b, l + 1);
    r = r && block_else_if_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_then?
  private static boolean block_else_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_else_if_2")) return false;
    kw_then(b, l + 1);
    return true;
  }

  // (eol block_fish)?
  private static boolean block_else_if_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_else_if_3")) return false;
    block_else_if_3_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_else_if_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_else_if_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // block_single_fish (eol block_single_fish)*
  public static boolean block_fish(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_fish")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_FISH, "<block fish>");
    r = block_single_fish(b, l + 1);
    r = r && block_fish_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol block_single_fish)*
  private static boolean block_fish_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_fish_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_fish_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_fish_1", c)) break;
    }
    return true;
  }

  // eol block_single_fish
  private static boolean block_fish_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_fish_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_single_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_loop (loop_each | loop_indexed | loop_for | loop_while)
  public static boolean block_header_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_header_loop")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_loop(b, l + 1);
    r = r && block_header_loop_1(b, l + 1);
    exit_section_(b, m, BLOCK_HEADER_LOOP, r);
    return r;
  }

  // loop_each | loop_indexed | loop_for | loop_while
  private static boolean block_header_loop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_header_loop_1")) return false;
    boolean r;
    r = loop_each(b, l + 1);
    if (!r) r = loop_indexed(b, l + 1);
    if (!r) r = loop_for(b, l + 1);
    if (!r) r = loop_while(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // kw_if expr kw_then?
  //              (eol block_fish)?
  //              (eol block_else_if)*
  //              (eol block_else)?
  //              eol kw_end_if
  public static boolean block_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_if(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && block_if_2(b, l + 1);
    r = r && block_if_3(b, l + 1);
    r = r && block_if_4(b, l + 1);
    r = r && block_if_5(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end_if(b, l + 1);
    exit_section_(b, m, BLOCK_IF, r);
    return r;
  }

  // kw_then?
  private static boolean block_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if_2")) return false;
    kw_then(b, l + 1);
    return true;
  }

  // (eol block_fish)?
  private static boolean block_if_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if_3")) return false;
    block_if_3_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_if_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol block_else_if)*
  private static boolean block_if_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_if_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_if_4", c)) break;
    }
    return true;
  }

  // eol block_else_if
  private static boolean block_if_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_else_if(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol block_else)?
  private static boolean block_if_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if_5")) return false;
    block_if_5_0(b, l + 1);
    return true;
  }

  // eol block_else
  private static boolean block_if_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_if_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_else(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // block_header_loop (eol block_fish)? eol kw_endloop
  public static boolean block_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_loop")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_header_loop(b, l + 1);
    r = r && block_loop_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_endloop(b, l + 1);
    exit_section_(b, m, BLOCK_LOOP, r);
    return r;
  }

  // (eol block_fish)?
  private static boolean block_loop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_loop_1")) return false;
    block_loop_1_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_loop_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_loop_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_section (eol block_fish)? eol kw_end_section
  public static boolean block_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_section")) return false;
    if (!nextTokenIs(b, SECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_section(b, l + 1);
    r = r && block_section_1(b, l + 1);
    r = r && eol(b, l + 1);
    r = r && kw_end_section(b, l + 1);
    exit_section_(b, m, BLOCK_SECTION, r);
    return r;
  }

  // (eol block_fish)?
  private static boolean block_section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_section_1")) return false;
    block_section_1_0(b, l + 1);
    return true;
  }

  // eol block_fish
  private static boolean block_section_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_section_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && block_fish(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // block_if | block_loop | block_case_of | block_section | block_cmd | stat_fish
  public static boolean block_single_fish(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_single_fish")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_SINGLE_FISH, "<block single fish>");
    r = block_if(b, l + 1);
    if (!r) r = block_loop(b, l + 1);
    if (!r) r = block_case_of(b, l + 1);
    if (!r) r = block_section(b, l + 1);
    if (!r) r = block_cmd(b, l + 1);
    if (!r) r = stat_fish(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // cmd_stat_other (eol cmd_stat_other)*
  public static boolean body_cmd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_cmd")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_CMD, "<body cmd>");
    r = cmd_stat_other(b, l + 1);
    r = r && body_cmd_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (eol cmd_stat_other)*
  private static boolean body_cmd_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_cmd_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_cmd_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_cmd_1", c)) break;
    }
    return true;
  }

  // eol cmd_stat_other
  private static boolean body_cmd_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_cmd_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && cmd_stat_other(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // cmd_stat_inline_fish |
  //     block_define |
  //     cmd_stat_func_call |
  //     cmd_stat_other
  public static boolean cmd_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CMD_BLOCK, "<cmd block>");
    r = cmd_stat_inline_fish(b, l + 1);
    if (!r) r = block_define(b, l + 1);
    if (!r) r = cmd_stat_func_call(b, l + 1);
    if (!r) r = cmd_stat_other(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // op_at tk_identifier expr_paren_csv?
  static boolean cmd_expr_func_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_expr_func_call")) return false;
    if (!nextTokenIs(b, FUNCTION_CALL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_at(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && cmd_expr_func_call_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr_paren_csv?
  private static boolean cmd_expr_func_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_expr_func_call_2")) return false;
    expr_paren_csv(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // square_l stat_fish square_r
  static boolean cmd_expr_inline_fish(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_expr_inline_fish")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = square_l(b, l + 1);
    r = r && stat_fish(b, l + 1);
    r = r && square_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // cmd_expr_func_call
  public static boolean cmd_stat_func_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_stat_func_call")) return false;
    if (!nextTokenIs(b, FUNCTION_CALL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cmd_expr_func_call(b, l + 1);
    exit_section_(b, m, CMD_STAT_FUNC_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // cmd_expr_inline_fish
  public static boolean cmd_stat_inline_fish(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_stat_inline_fish")) return false;
    if (!nextTokenIs(b, LEFT_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cmd_expr_inline_fish(b, l + 1);
    exit_section_(b, m, CMD_STAT_INLINE_FISH, r);
    return r;
  }

  /* ********************************************************** */
  // cmd_tk_all+
  public static boolean cmd_stat_other(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_stat_other")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CMD_STAT_OTHER, "<cmd stat other>");
    r = cmd_tk_all(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!cmd_tk_all(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cmd_stat_other", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // square_l | square_r | paren_l | paren_r | op_comma | op_assign | op_unary | op_binary| op_dot | op_at |
  //      tk_literal | cmd_tk_kw_all | tk_identifier
  static boolean cmd_tk_all(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_tk_all")) return false;
    boolean r;
    r = square_l(b, l + 1);
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
    if (!r) r = cmd_tk_kw_all(b, l + 1);
    if (!r) r = tk_identifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // kw_fish | kw_case_of | kw_case | kw_end_case | kw_def | kw_end | kw_exit | kw_global | kw_if | kw_then |
  //     kw_else_if | kw_else | kw_end_if | kw_local | kw_lock | kw_loop | kw_endloop | kw_continue | kw_return | kw_section | kw_end_section | kw_struct
  static boolean cmd_tk_kw_all(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cmd_tk_kw_all")) return false;
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
  // kw_fish? kw_def tk_identifier define_params?
  public static boolean define_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_header")) return false;
    if (!nextTokenIs(b, "<define header>", DEFINE, FISH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_HEADER, "<define header>");
    r = define_header_0(b, l + 1);
    r = r && kw_def(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && define_header_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // kw_fish?
  private static boolean define_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_header_0")) return false;
    kw_fish(b, l + 1);
    return true;
  }

  // define_params?
  private static boolean define_header_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_header_3")) return false;
    define_params(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // paren_l tk_identifier (op_comma tk_identifier)* paren_r
  static boolean define_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_params")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    r = r && define_params_2(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma tk_identifier)*
  private static boolean define_params_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_params_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!define_params_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "define_params_2", c)) break;
    }
    return true;
  }

  // op_comma tk_identifier
  private static boolean define_params_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_params_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && tk_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( NEWLINE | COMMENT )+
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

  // NEWLINE | COMMENT
  private static boolean eol_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // (square_l expr_binary square_r) |  expr_binary
  static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_0(b, l + 1);
    if (!r) r = expr_binary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // square_l expr_binary square_r
  private static boolean expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = square_l(b, l + 1);
    r = r && expr_binary(b, l + 1);
    r = r && square_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assign_target assign_right?
  static boolean expr_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_assign")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assign_target(b, l + 1);
    r = r && expr_assign_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assign_right?
  private static boolean expr_assign_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_assign_1")) return false;
    assign_right(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // expr_non_binary (op_binary expr_non_binary)*
  static boolean expr_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_binary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_non_binary(b, l + 1);
    r = r && expr_binary_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_binary expr_non_binary)*
  private static boolean expr_binary_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_binary_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_binary_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_binary_1", c)) break;
    }
    return true;
  }

  // op_binary expr_non_binary
  private static boolean expr_binary_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_binary_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && expr_non_binary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (op_comma expr)*
  static boolean expr_csv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_csv")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && expr_csv_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma expr)*
  private static boolean expr_csv_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_csv_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_csv_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_csv_1", c)) break;
    }
    return true;
  }

  // op_comma expr
  private static boolean expr_csv_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_csv_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tk_identifier expr_paren_csv
  static boolean expr_func_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_func_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tk_identifier(b, l + 1);
    r = r && expr_paren_csv(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr_paren | expr_func_call | expr_unary | tk_value
  static boolean expr_non_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_non_binary")) return false;
    boolean r;
    r = expr_paren(b, l + 1);
    if (!r) r = expr_func_call(b, l + 1);
    if (!r) r = expr_unary(b, l + 1);
    if (!r) r = tk_value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // paren_l expr paren_r
  static boolean expr_paren(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_paren")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paren_l expr_csv paren_r
  static boolean expr_paren_csv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_paren_csv")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && expr_csv(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // op_unary expr
  static boolean expr_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_unary")) return false;
    if (!nextTokenIs(b, "", MINUS_OPERATOR, UNARY_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_unary(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
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
  // EXITLOOP
  static boolean kw_exit_loop(PsiBuilder b, int l) {
    return consumeToken(b, EXITLOOP);
  }

  /* ********************************************************** */
  // EXITSECTION
  static boolean kw_exit_section(PsiBuilder b, int l) {
    return consumeToken(b, EXITSECTION);
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
  // kw_foreach assign_left_for_loop expr
  static boolean loop_each(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_each")) return false;
    if (!nextTokenIs(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_foreach(b, l + 1);
    r = r && assign_left_for_loop(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_for paren_l kw_local? expr op_comma expr op_comma expr paren_r
  static boolean loop_for(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_for")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_for(b, l + 1);
    r = r && paren_l(b, l + 1);
    r = r && loop_for_2(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && expr(b, l + 1);
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
  // assign_left_for_loop loop_indexed_range
  static boolean loop_indexed(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assign_left_for_loop(b, l + 1);
    r = r && loop_indexed_range(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paren_l expr op_comma
  //     expr (op_comma expr)? paren_r
  static boolean loop_indexed_range(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed_range")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_l(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && op_comma(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && loop_indexed_range_4(b, l + 1);
    r = r && paren_r(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (op_comma expr)?
  private static boolean loop_indexed_range_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed_range_4")) return false;
    loop_indexed_range_4_0(b, l + 1);
    return true;
  }

  // op_comma expr
  private static boolean loop_indexed_range_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_indexed_range_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_while expr
  static boolean loop_while(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_while")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_while(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
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
  // (eol? cmd_block)* eol?
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleFile_0(b, l + 1);
    r = r && simpleFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (eol? cmd_block)*
  private static boolean simpleFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simpleFile_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile_0", c)) break;
    }
    return true;
  }

  // eol? cmd_block
  private static boolean simpleFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleFile_0_0_0(b, l + 1);
    r = r && cmd_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // eol?
  private static boolean simpleFile_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_0_0_0")) return false;
    eol(b, l + 1);
    return true;
  }

  // eol?
  private static boolean simpleFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_1")) return false;
    eol(b, l + 1);
    return true;
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
  // kw_array tk_identifier paren_l literal_number paren_r
  static boolean stat_array_declare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_array_declare")) return false;
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
  // (kw_local | kw_global)? expr_assign (op_comma expr_assign)*
  public static boolean stat_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_assign")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STAT_ASSIGN, "<stat assign>");
    r = stat_assign_0(b, l + 1);
    r = r && expr_assign(b, l + 1);
    r = r && stat_assign_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (kw_local | kw_global)?
  private static boolean stat_assign_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_assign_0")) return false;
    stat_assign_0_0(b, l + 1);
    return true;
  }

  // kw_local | kw_global
  private static boolean stat_assign_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_assign_0_0")) return false;
    boolean r;
    r = kw_local(b, l + 1);
    if (!r) r = kw_global(b, l + 1);
    return r;
  }

  // (op_comma expr_assign)*
  private static boolean stat_assign_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_assign_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!stat_assign_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stat_assign_2", c)) break;
    }
    return true;
  }

  // op_comma expr_assign
  private static boolean stat_assign_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_assign_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_comma(b, l + 1);
    r = r && expr_assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // stat_array_declare |
  //     stat_assign |
  //     expr |
  //     kw_break |
  //     kw_continue |
  //     kw_exit_section |
  //     kw_exit_loop |
  //     kw_exit
  public static boolean stat_fish(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_fish")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STAT_FISH, "<stat fish>");
    r = stat_array_declare(b, l + 1);
    if (!r) r = stat_assign(b, l + 1);
    if (!r) r = expr(b, l + 1);
    if (!r) r = kw_break(b, l + 1);
    if (!r) r = kw_continue(b, l + 1);
    if (!r) r = kw_exit_section(b, l + 1);
    if (!r) r = kw_exit_loop(b, l + 1);
    if (!r) r = kw_exit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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

}
