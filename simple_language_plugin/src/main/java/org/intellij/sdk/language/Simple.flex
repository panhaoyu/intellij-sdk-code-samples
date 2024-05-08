// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
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

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=";"[^\r\n]*
SEPARATOR=[:=]
DIGIT=[0-9]
NUMBER=[-0-9.]+
LINE_TERMINATOR=\r|\n|\r\n

//KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "
KEYWORD=(
    "log"|"throughgoing"|"jj"|"extent"|"unbonded"|"delete"|"angle"|"distribute"|"set"|"resolution"|"to"|"expand"|
    "spin"|"attribute"|"range"|"register"|"by"|"walls"|"cycles"|"seating"|"deform"|"yforce"|"fully"|"nd"|"origin"|"at"|
    "rblock"|"mech"|"vp"|"which"|"interval"|"setting"|"call"|"fix"|"porosity"|"a"|"their"|"polygon"|"project"|"dry"|
    "truncate"|"linearpbond"|"via"|"measure"|"import"|"foreach"|"strain"|"stop"|"clean"|"with"|"compression"|"diameter"|
    "tol"|"bitmap"|"sdev"|"brick"|"is"|"pressure"|"contactmoment"|"ctr"|"the"|"suppress"|"create"|"ratio"|"static"|
    "compute"|"b"|"effective"|"crack"|"timestep"|"last"|"damp"|"has"|"polydisperse"|"position"|"successful"|"bin"|
    "multiply"|"array"|"equilibrium"|"new"|"orphaned"|"linear"|"endsection"|"erode"|"positive"|"failure"|"servo"|"rot"|
    "timeout"|"reload"|"displayed"|"null"|"localdir"|"region"|"xcen"|"tl"|"package"|"physical"|"clump"|"desired"|
    "performing"|"stressxx"|"save"|"vmax"|"define"|"group"|"circle"|"residual"|"was"|"command"|"application"|"stressyy"|
    "no"|"bond"|"cracks"|"kratio"|"if"|"gravity"|"strengths"|"pct"|"axis"|"while"|"restraint"|"wall"|"function"|"dir"|
    "false"|"pebcalculate"|"aligned"|"id"|"types"|"proximity"|"called"|"true"|"exit"|"xforce"|"template"|"shape"|
    "solve"|"union"|"direction"|"add"|"standard"|"logfile"|"local"|"free"|"normal"|"restore"|"updated"|"pipes"|
    "confinement"|"pause"|"rotational"|"rotate"|"radial"|"make"|"scale"|"segments"|"hill"|"auto"|"of"|"friction"|
    "off"|"initially"|"file"|"fish"|"hist"|"chusikuan"|"strength"|"an"|"thus"|"rs"|"within"|"shear"|"fractured"|
    "outer"|"ks"|"endif"|"max"|"fishhalt"|"outside"|"vertices"|"loop"|"plane"|"assemble"|"cpco"|"zero"|"calm"|
    "radius"|"box"|"activate"|"caseof"|"grain"|"default"|"title"|"contactmodelmechanical"|"frozen"|"clock"|
    "ydisplacement"|"def"|"cap"|"base"|"density"|"prox"|"median"|"endloop"|"random"|"material"|"then"|
    "microstructural"|"echo"|"coordination"|"kn"|"view"|"mechanical"|"rb"|"export"|"for"|"continue"|
    "endcase"|"condition"|"breakage"|"phase"|"plot"|"step"|"pebbles"|"cycle"|"energy"|"dims"|"aratio"|
    "been"|"load"|"grains"|"in"|"xdisplacement"|"distribution"|"periodic"|"velocity"|"history"|"clone"|
    "number"|"or"|"rgap"|"slot"|"start"|"return"|"case"|"from"|"always"|"purge"|"property"|"method"|
    "contactforce"|"and"|"deforming"|"cubic"|"y"|"fracture"|"occurred"|"filename"|"state"|"frac"|"relative"|
    "destroy"|"nl"|"unbond"|"update"|"fragment"|"rotation"|"tolerance"|"celiangdingyi"|"stress"|"removed"|"euler"|
    "rc"|"modulus"|"nnn"|"model"|"maximum"|"deformability"|"flatjoint"|"during"|"clear"|"geometry"|"middle"|"into"|
    "age"|"until"|"breaks"|"end"|"near"|"are"|"not"|"program"|"xuanzuan"|"cylinder"|"ball"|"active"|"np"|"table"|
    "orphan"|"construct"|"spread"|"endcommand"|"fractures"|"stage"|"liexi"|"remove"|"center"|"inheritance"|"cmat"|
    "type"|"fishcall"|"platen"|"generate"|"internal"|"mean"|"height"|"callback"|"centers"|"circumferential"|"event"|
    "list"|"point"|"sphere"|"result"|"section"|"when"|"displacement"|"system"|"obtained"|"automatic"|"on"|"domain"|
    "inside"|"stiffness"|"else"|"assembled"|"tensile"|"cut"|"achieved"|"gm"|"all"|"broken"
)

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return SimpleTypes.COMMENT; }

<YYINITIAL> {WHITE_SPACE}                                       { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {KEYWORD}                                       { yybegin(YYINITIAL); return SimpleTypes.KEY; }

<YYINITIAL> {NUMBER}                                       { yybegin(YYINITIAL); return SimpleTypes.VALUE; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return SimpleTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return SimpleTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
