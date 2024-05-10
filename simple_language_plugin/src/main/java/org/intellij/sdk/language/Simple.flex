// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

import com.intellij.formatting.WhiteSpace;import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.bouncycastle.pqc.jcajce.interfaces.SABERKey;
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

%{
  StringBuffer string = new StringBuffer();
%}


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = {EndOfLineComment}

EndOfLineComment     = ";" {InputCharacter}* {LineTerminator}?

Identifier = [:jletter:] [:jletterdigit:]*

Number=[0-9][0-9.]*([eE]-?[0-9]+)?

Operators = [+\-*/!@#$%\^&*()<>=\[\]{}:,/?~`]

StringA = \" [^\"]* \"

StringB = \' [^\']* \'

String = {StringA} | {StringB}

Keyword=(
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
    "list"|"point"|"sphere"|"result"|"section"|"when"|"displacement"|"obtained"|"automatic"|"on"|"domain"|
    "inside"|"stiffness"|"else"|"assembled"|"tensile"|"cut"|"achieved"|"gm"|"all"|"broken"|"log-file"|"system.error"|
    "io.out"|"end_if"|

    "method"|"expand"|"obtained"|"clock"|"type"|"wall"|"stage"|"frozen"|"reload"|"radius"|"cracks"|"physical"|"base"|"state"|"in"|"event"|"group"|"loop"|"pebbles"|"domain"|"save"|"echo"|"energy"|"log"|"export"|"friction"|"desired"|"confinement"|"mech.age"|"celiangdingyi"|"project"|"cap"|"residual"|"pipes"|"fix"|"multiply"|"contact.list.all"|"polydisperse"|"and"|"linear"|"a"|"fracture"|"array"|"endcase"|"calm"|"pause"|"off"|"ks"|"inj.log"|"grains"|"jj"|"displacement"|"xcen"|"update"|"when"|"model"|"unbonded"|"until"|"dims"|"global.cycle"|"radial"|"thus"|"on"|"destroy"|"id"|"an"|"types"|"xdisplacement"|"aratio"|"are"|"during"|"cmat"|"suppress"|"timestep"|"median"|"effective"|"chusikuan"|"free"|"fish"|"walls"|"direction"|"restore"|"false"|"import"|"application"|"porosity"|"stressxx"|"kn"|"contactmodelmechanical"|"spread"|"compression"|"dir"|"within"|"tol"|"breaks"|"interval"|"nd"|"scale"|"exit"|"assembled"|"number"|"height"|"auto"|"fishcall"|"rblock.num"|"kratio"|"filename"|"measure"|"equilibrium"|"make"|"caseof"|"flatjoint"|"cycles"|"remove"|"add"|"their"|"continue"|"hist"|"always"|"been"|"ball"|"orphaned"|"default"|"automatic"|"end"|"clump"|"modulus"|"active"|"bond"|"activate"|"fully"|"point"|"microstructural"|"range"|"register"|"stop"|"pressure"|"package"|"deform"|"the"|"center"|"foreach"|"linearpbond"|"rs"|"extent"|"vp"|"displayed"|"updated"|"def"|"seating"|"with"|"gm"|"clear"|"stress"|"maximum"|"last"|"bin"|"call"|"np"|"rot"|"from"|"outside"|"called"|"..."|"static"|"stressyy"|"union"|"fishhalt"|"damp"|"dom.fis"|"pebcalculate"|"mechanical"|"box"|"position"|"tensile"|"for"|"vmax"|"clone"|"coordination"|"rc"|"strengths"|"result"|"distribution"|"view"|"construct"|"at"|"history"|"outer"|"was"|"timeout"|"no"|"slot"|"delete"|"then"|"press.fis"|"velocity"|"fractures"|"region"|"spin"|"localdir"|"successful"|"tolerance"|"clump.list"|"throughgoing"|"strength"|"erode"|"deformability"|"circumferential"|"truncate"|"xuanzuan"|"start"|"material"|"rotation"|"origin"|"breakage"|"via"|"restraint"|"proximity"|"file"|"platen"|"euler"|"title"|"failure"|"centers"|"occurred"|"endif"|"ball.num"|"density"|"mean"|"not"|"positive"|"mech"|"list"|"y"|"angle"|"contactmoment"|"if"|"yforce"|"callback"|"rb"|"fragment"|"bitmap"|"cycle"|"resolution"|"crack"|"rotational"|"else"|"zero"|"compute"|"ctr"|"xforce"|"strain"|"axis"|"near"|"nl"|"segments"|"orphan"|"table"|"internal"|"stiffness"|"fractured"|"setting"|"phase"|"rblock"|"nnn"|"new"|"endloop"|"define"|"distribute"|"shape"|"ydisplacement"|"prox"|"attribute"|"step"|"set"|"b"|"middle"|"age"|"is"|"rgap"|"while"|"true"|"gravity"|"dry"|"performing"|"or"|"into"|"ball.list"|"of"|"inside"|"return"|"tl"|"condition"|"unbond"|"local"|"polygon"|"diameter"|"frac"|"clean"|"normal"|"w.r.t."|"rotate"|"circle"|"grain"|"ratio"|"plot"|"liexi"|"cylinder"|"vertices"|"coef."|"shear"|"assemble"|"purge"|"sphere"|"max"|"case"|"clump.num"|"contact.list"|"achieved"|"endsection"|"hill"|"deforming"|"broken"|"geometry"|"program"|"inheritance"|"initially"|"aligned"|"cubic"|"brick"|"all"|"endcommand"|"solve"|"rblock.list"|"cut"|"property"|"removed"|"has"|"section"|"contactforce"|"sdev"|"standard"|"which"|"system"|"to"|"cpco"|"function"|"periodic"|"load"|"pct"|"generate"|"create"|"random"|"template"|"."|"servo"|"logfile"|"null"|"by"|"relative"|"command"|"plane"|
    "system"

)

%state STRING

%%

//Keywords
<YYINITIAL> {Keyword} {return SimpleTypes.KEY;}

//Identifiers
<YYINITIAL>{
    //Identifiers
    {Identifier} {return SimpleTypes.VALUE;}

    //Literals
    {Number} {return SimpleTypes.VALUE;}

    {String} {return SimpleTypes.VALUE;}

    // Operators
    ({Operators} | {WhiteSpace})+ {return SimpleTypes.SEPARATOR;}

    // Comments
    {Comment} {return SimpleTypes.COMMENT;}
}

/* error fallback */
[^] { return TokenType.BAD_CHARACTER; }
