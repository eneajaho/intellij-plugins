/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package name.kropp.intellij.makefile;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static name.kropp.intellij.makefile.psi.MakefileTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>MakefileLexer.flex</tt>
 */
public class _MakefileLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int SQSTRING = 2;
  public static final int DQSTRING = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  1,  2,  3,  4, 5
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [8, 6, 7]
   * Total runtime size is 1040 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>13]|((ch>>7)&0x3f)]|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 136 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\207\100");

  /* The ZZ_CMAP_Y table has 128 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\177\200");

  /* The ZZ_CMAP_A table has 256 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\4\1\1\25\0\1\2\1\40\1\43\1\5\1\53\2\41\1\42\1\44\1\45\1\41\1\40\1"+
    "\46\1\27\14\41\1\37\1\51\1\41\1\36\1\41\1\40\1\35\33\41\1\3\3\41\1\47\1\12"+
    "\1\23\1\33\1\26\1\6\1\16\1\15\1\20\1\14\1\32\1\41\1\21\1\31\1\13\1\10\1\25"+
    "\1\52\1\7\1\17\1\24\1\22\1\34\1\11\1\30\2\41\1\54\1\50\1\55\1\41\201\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\1\1\1\2\1\3\1\4\1\3\1\5\24\4"+
    "\1\6\1\7\1\4\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\3\1\23"+
    "\1\5\2\4\1\24\1\4\1\25\1\26\1\27\2\5"+
    "\1\30\6\4\1\31\11\4\1\31\24\4\2\0\3\5"+
    "\1\30\1\0\1\4\1\30\13\4\1\31\33\4\1\30"+
    "\2\32\2\4\1\33\2\4\1\31\7\4\1\34\20\4"+
    "\1\35\1\36\11\4\1\37\1\4\1\40\12\4\1\41"+
    "\1\42\5\4\1\43\1\4\1\31\3\4\1\44\1\4"+
    "\1\45\2\4\1\46\1\47\1\4\1\50";

  private static int [] zzUnpackAction() {
    int [] result = new int[223];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\270\0\346\0\u0114\0\u0114"+
    "\0\u0142\0\u0170\0\u019e\0\u01cc\0\u01fa\0\u0228\0\u0256\0\u0284"+
    "\0\u02b2\0\u02e0\0\u030e\0\u033c\0\u036a\0\u0398\0\u03c6\0\u03f4"+
    "\0\u0422\0\u0450\0\u047e\0\u04ac\0\u04da\0\u0508\0\u0536\0\u0564"+
    "\0\u0114\0\u0592\0\u05c0\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114"+
    "\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114\0\u05ee\0\u061c"+
    "\0\u064a\0\u0678\0\u06a6\0\u0114\0\u0114\0\u0114\0\u06d4\0\u0114"+
    "\0\u0702\0\u0730\0\u075e\0\u078c\0\u07ba\0\u07e8\0\u0816\0\u0844"+
    "\0\u0872\0\u08a0\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986\0\u09b4"+
    "\0\u09e2\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8\0\u0af6\0\u0b24"+
    "\0\u0b52\0\u0b80\0\u0bae\0\u0bdc\0\u0c0a\0\u0c38\0\u0c66\0\u0c94"+
    "\0\u0cc2\0\u0cf0\0\u0d1e\0\u0d4c\0\u0d7a\0\u0da8\0\u0dd6\0\u0e04"+
    "\0\u0e32\0\u0e60\0\u0e8e\0\u0114\0\u0ebc\0\u0eea\0\u0f18\0\u0f46"+
    "\0\u0f74\0\u0fa2\0\u0fd0\0\u0ffe\0\u102c\0\u105a\0\u1088\0\u10b6"+
    "\0\u10e4\0\u1112\0\u1140\0\u116e\0\u03c6\0\u119c\0\u11ca\0\u11f8"+
    "\0\u1226\0\u1254\0\u1282\0\u12b0\0\u12de\0\u130c\0\u133a\0\u1368"+
    "\0\u1396\0\u13c4\0\u13f2\0\u1420\0\u144e\0\u147c\0\u14aa\0\u14d8"+
    "\0\u1506\0\u1534\0\u1562\0\u1590\0\u15be\0\u15ec\0\u161a\0\u1648"+
    "\0\u1676\0\u0114\0\u03c6\0\u16a4\0\u16d2\0\u03c6\0\u1700\0\u172e"+
    "\0\u175c\0\u178a\0\u17b8\0\u17e6\0\u1814\0\u1842\0\u1870\0\u189e"+
    "\0\u03c6\0\u18cc\0\u18fa\0\u1928\0\u1956\0\u1984\0\u19b2\0\u19e0"+
    "\0\u1a0e\0\u1a3c\0\u1a6a\0\u1a98\0\u1ac6\0\u1af4\0\u1b22\0\u1b50"+
    "\0\u1b7e\0\u03c6\0\u03c6\0\u1bac\0\u1bda\0\u1c08\0\u1c36\0\u1c64"+
    "\0\u1c92\0\u1cc0\0\u1cee\0\u1d1c\0\u03c6\0\u1d4a\0\u03c6\0\u1d78"+
    "\0\u1da6\0\u1dd4\0\u1e02\0\u1e30\0\u1e5e\0\u1e8c\0\u1eba\0\u1ee8"+
    "\0\u1f16\0\u03c6\0\u03c6\0\u1f44\0\u1f72\0\u1fa0\0\u1fce\0\u1ffc"+
    "\0\u03c6\0\u202a\0\u2058\0\u2086\0\u20b4\0\u20e2\0\u03c6\0\u2110"+
    "\0\u03c6\0\u213e\0\u216c\0\u03c6\0\u03c6\0\u219a\0\u03c6";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[223];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\27\1\33\1\34\1\35"+
    "\2\27\1\36\1\37\1\40\1\27\1\41\1\42\1\43"+
    "\1\27\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\27\1\54\1\55\1\56\1\7\1\10\1\57"+
    "\1\12\1\60\1\61\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\27\1\33\1\34\1\35\2\27\1\36\1\37"+
    "\1\40\1\62\1\41\1\42\1\43\1\27\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\27\1\54"+
    "\1\55\1\56\1\7\1\10\1\11\1\12\1\13\1\63"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\27\1\33"+
    "\1\34\1\35\2\27\1\36\1\37\1\40\1\27\1\41"+
    "\1\42\1\43\1\27\1\64\1\65\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\27\1\54\1\55\1\56\1\7"+
    "\1\10\1\11\1\12\1\60\1\63\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\27\1\33\1\34\1\35\2\27"+
    "\1\36\1\37\1\40\1\62\1\41\1\42\1\43\1\27"+
    "\1\64\1\65\1\46\1\47\1\50\1\51\1\52\1\53"+
    "\1\27\1\54\1\55\1\56\1\7\1\10\1\11\1\12"+
    "\1\13\1\63\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\27\1\33\1\34\1\35\2\27\1\36\1\37\1\40"+
    "\1\27\1\41\1\42\1\43\1\27\1\65\1\66\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\27\1\54\1\55"+
    "\1\56\1\7\1\10\1\11\1\12\1\60\1\63\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\27\1\33\1\34"+
    "\1\35\2\27\1\36\1\37\1\40\1\62\1\41\1\42"+
    "\1\43\1\27\1\65\1\66\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\27\1\54\1\55\1\56\60\0\1\11"+
    "\54\0\1\67\1\0\1\65\1\0\1\65\31\0\1\65"+
    "\3\0\1\70\2\65\14\0\1\13\51\0\1\71\1\0"+
    "\1\71\1\72\1\71\1\73\50\71\6\0\1\27\1\74"+
    "\3\27\1\75\5\27\1\76\6\27\1\77\3\27\1\100"+
    "\1\27\2\0\2\27\10\0\1\27\11\0\1\101\27\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\27\1\102\24\27"+
    "\1\103\1\27\2\0\2\27\10\0\1\27\11\0\2\27"+
    "\1\104\1\27\1\105\1\27\1\106\21\27\2\0\2\27"+
    "\10\0\1\27\11\0\5\27\1\107\7\27\1\110\2\27"+
    "\1\111\7\27\2\0\2\27\10\0\1\27\11\0\2\27"+
    "\1\112\25\27\2\0\2\27\10\0\1\27\11\0\5\27"+
    "\1\113\2\27\1\114\17\27\2\0\2\27\10\0\1\27"+
    "\11\0\14\27\1\115\13\27\2\0\2\27\10\0\1\27"+
    "\11\0\2\27\1\116\3\27\1\117\4\27\1\120\14\27"+
    "\2\0\2\27\10\0\1\27\11\0\2\27\1\121\3\27"+
    "\1\122\3\27\1\123\1\27\1\124\1\27\1\125\11\27"+
    "\2\0\2\27\10\0\1\27\11\0\30\27\2\0\2\27"+
    "\10\0\1\27\11\0\4\27\1\126\23\27\2\0\2\27"+
    "\10\0\1\27\11\0\5\27\1\127\22\27\2\0\2\27"+
    "\10\0\1\27\11\0\4\27\1\130\23\27\2\0\2\27"+
    "\10\0\1\27\11\0\1\27\1\131\2\27\1\132\23\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\133\5\27\1\134"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\6\27\1\122"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\2\27\1\135"+
    "\25\27\2\0\2\27\10\0\1\27\11\0\4\27\1\136"+
    "\23\27\2\0\2\27\10\0\1\27\11\0\4\27\1\137"+
    "\12\27\1\140\10\27\2\0\2\27\10\0\1\27\41\0"+
    "\1\41\1\141\24\0\30\27\1\41\1\0\2\27\10\0"+
    "\1\27\5\0\1\57\2\0\1\142\54\0\1\60\51\0"+
    "\1\143\1\144\1\143\1\145\1\143\1\146\50\143\1\147"+
    "\2\0\3\147\27\150\1\27\2\147\2\150\10\147\1\150"+
    "\3\147\5\0\1\63\52\0\1\67\1\0\1\67\51\0"+
    "\1\71\1\0\1\71\1\72\55\71\1\72\52\71\1\73"+
    "\1\0\1\73\1\151\52\73\6\0\1\27\1\152\26\27"+
    "\2\0\2\27\10\0\1\27\11\0\20\27\1\153\7\27"+
    "\2\0\2\27\10\0\1\27\11\0\11\27\1\154\16\27"+
    "\2\0\2\27\10\0\1\27\11\0\17\27\1\155\10\27"+
    "\2\0\2\27\10\0\1\27\11\0\4\27\1\156\23\27"+
    "\2\0\2\27\10\0\1\27\11\0\4\27\1\157\23\27"+
    "\2\0\2\27\10\0\1\27\11\0\6\27\1\160\21\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\161\27\27\2\0"+
    "\2\27\10\0\1\27\11\0\1\27\1\162\26\27\2\0"+
    "\2\27\10\0\1\27\11\0\1\27\1\163\26\27\2\0"+
    "\2\27\10\0\1\27\11\0\13\27\1\164\14\27\2\0"+
    "\2\27\10\0\1\27\11\0\20\27\1\165\7\27\2\0"+
    "\2\27\10\0\1\27\11\0\11\27\1\166\16\27\2\0"+
    "\2\27\10\0\1\27\11\0\20\27\1\167\7\27\2\0"+
    "\2\27\10\0\1\27\11\0\16\27\1\170\11\27\2\0"+
    "\2\27\10\0\1\27\11\0\10\27\1\171\14\27\1\172"+
    "\2\27\2\0\2\27\10\0\1\27\11\0\1\173\4\27"+
    "\1\174\12\27\1\175\7\27\2\0\2\27\10\0\1\27"+
    "\11\0\6\27\1\176\21\27\2\0\2\27\10\0\1\27"+
    "\11\0\1\27\1\177\26\27\2\0\2\27\10\0\1\27"+
    "\11\0\1\27\1\126\3\27\1\200\5\27\1\201\14\27"+
    "\2\0\2\27\10\0\1\27\11\0\4\27\1\202\23\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\27\1\203\26\27"+
    "\2\0\2\27\10\0\1\27\11\0\5\27\1\204\22\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\136\27\27\2\0"+
    "\2\27\10\0\1\27\11\0\10\27\1\205\4\27\1\206"+
    "\12\27\2\0\2\27\10\0\1\27\11\0\1\27\1\207"+
    "\26\27\2\0\2\27\10\0\1\27\11\0\11\27\1\210"+
    "\16\27\2\0\2\27\10\0\1\27\11\0\20\27\1\211"+
    "\7\27\2\0\2\27\10\0\1\27\11\0\11\27\1\212"+
    "\16\27\2\0\2\27\10\0\1\27\11\0\6\27\1\213"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\16\27\1\214"+
    "\11\27\2\0\2\27\10\0\1\27\11\0\10\27\1\215"+
    "\17\27\2\0\2\27\10\0\1\27\11\0\1\27\1\165"+
    "\26\27\2\0\2\27\10\0\1\27\11\0\6\27\1\216"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\13\27\1\156"+
    "\14\27\2\0\2\27\10\0\1\27\11\0\13\27\1\217"+
    "\14\27\2\0\2\27\10\0\1\27\11\0\4\27\1\220"+
    "\23\27\2\0\2\27\10\0\1\27\41\0\1\41\17\0"+
    "\1\142\1\144\54\142\1\143\1\144\1\143\1\145\53\143"+
    "\1\71\1\143\1\145\52\143\1\146\1\144\1\146\1\221"+
    "\52\146\1\147\2\0\32\147\1\222\21\147\2\0\3\147"+
    "\27\150\1\223\2\147\2\150\10\147\1\150\3\147\1\73"+
    "\1\71\1\73\1\151\52\73\6\0\2\27\1\134\25\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\224\5\27\1\225"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\1\226\27\27"+
    "\2\0\2\27\10\0\1\27\11\0\2\27\1\227\25\27"+
    "\2\0\2\27\10\0\1\27\11\0\13\27\1\165\14\27"+
    "\2\0\2\27\10\0\1\27\11\0\13\27\1\166\14\27"+
    "\2\0\2\27\10\0\1\27\11\0\7\27\1\135\20\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\27\1\230\26\27"+
    "\2\0\2\27\10\0\1\27\11\0\20\27\1\231\7\27"+
    "\2\0\2\27\10\0\1\27\11\0\5\27\1\232\22\27"+
    "\2\0\2\27\10\0\1\27\11\0\20\27\1\233\7\27"+
    "\2\0\2\27\10\0\1\27\11\0\17\27\1\234\10\27"+
    "\2\0\2\27\10\0\1\27\11\0\11\27\1\235\5\27"+
    "\1\236\10\27\2\0\2\27\10\0\1\27\11\0\20\27"+
    "\1\237\7\27\2\0\2\27\10\0\1\27\11\0\2\27"+
    "\1\165\25\27\2\0\2\27\10\0\1\27\11\0\13\27"+
    "\1\240\14\27\2\0\2\27\10\0\1\27\11\0\30\27"+
    "\2\0\2\27\10\0\1\241\11\0\1\242\17\27\1\243"+
    "\7\27\2\0\2\27\10\0\1\27\11\0\1\244\27\27"+
    "\2\0\2\27\10\0\1\27\11\0\13\27\1\245\14\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\246\27\27\2\0"+
    "\2\27\10\0\1\27\11\0\20\27\1\247\7\27\2\0"+
    "\2\27\10\0\1\27\11\0\1\165\15\27\1\250\11\27"+
    "\2\0\2\27\10\0\1\27\11\0\26\27\1\152\1\27"+
    "\2\0\2\27\10\0\1\27\11\0\16\27\1\165\11\27"+
    "\2\0\2\27\10\0\1\27\11\0\25\27\1\172\2\27"+
    "\2\0\2\27\10\0\1\27\11\0\10\27\1\251\17\27"+
    "\2\0\2\27\10\0\1\27\11\0\11\27\1\203\16\27"+
    "\2\0\2\27\10\0\1\27\11\0\6\27\1\252\21\27"+
    "\2\0\2\27\10\0\1\27\11\0\16\27\1\253\11\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\254\27\27\2\0"+
    "\2\27\10\0\1\27\11\0\1\255\27\27\2\0\2\27"+
    "\10\0\1\27\11\0\26\27\1\256\1\27\2\0\2\27"+
    "\10\0\1\27\11\0\11\27\1\257\16\27\2\0\2\27"+
    "\10\0\1\27\11\0\6\27\1\260\21\27\2\0\2\27"+
    "\10\0\1\27\11\0\5\27\1\165\22\27\2\0\2\27"+
    "\10\0\1\27\11\0\14\27\1\245\13\27\2\0\2\27"+
    "\10\0\1\27\11\0\16\27\1\261\11\27\2\0\2\27"+
    "\10\0\1\27\3\0\1\146\1\71\1\146\1\221\52\146"+
    "\6\0\10\27\1\262\17\27\2\0\2\27\10\0\1\27"+
    "\11\0\10\27\1\263\17\27\2\0\2\27\10\0\1\27"+
    "\11\0\1\27\1\264\26\27\2\0\2\27\10\0\1\27"+
    "\11\0\1\27\1\265\26\27\2\0\2\27\10\0\1\27"+
    "\11\0\11\27\1\165\1\27\1\266\14\27\2\0\2\27"+
    "\10\0\1\27\11\0\6\27\1\267\21\27\2\0\2\27"+
    "\10\0\1\27\11\0\25\27\1\270\2\27\2\0\2\27"+
    "\10\0\1\27\11\0\4\27\1\271\23\27\2\0\2\27"+
    "\10\0\1\27\11\0\14\27\1\272\13\27\2\0\2\27"+
    "\10\0\1\27\11\0\1\27\1\273\26\27\2\0\2\27"+
    "\10\0\1\27\11\0\6\27\1\134\21\27\2\0\2\27"+
    "\10\0\1\27\11\0\14\27\1\274\13\27\2\0\2\27"+
    "\10\0\1\27\11\0\30\27\2\0\2\27\10\0\1\275"+
    "\11\0\1\276\27\27\2\0\2\27\10\0\1\27\11\0"+
    "\10\27\1\277\17\27\2\0\2\27\10\0\1\27\11\0"+
    "\1\165\27\27\2\0\2\27\10\0\1\27\11\0\4\27"+
    "\1\300\23\27\2\0\2\27\10\0\1\27\11\0\11\27"+
    "\1\301\16\27\2\0\2\27\10\0\1\27\11\0\1\302"+
    "\27\27\2\0\2\27\10\0\1\27\11\0\6\27\1\303"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\17\27\1\165"+
    "\10\27\2\0\2\27\10\0\1\27\11\0\3\27\1\304"+
    "\24\27\2\0\2\27\10\0\1\27\11\0\10\27\1\305"+
    "\17\27\2\0\2\27\10\0\1\27\11\0\5\27\1\306"+
    "\22\27\2\0\2\27\10\0\1\27\11\0\4\27\1\307"+
    "\23\27\2\0\2\27\10\0\1\27\11\0\14\27\1\310"+
    "\13\27\2\0\2\27\10\0\1\27\11\0\5\27\1\311"+
    "\22\27\2\0\2\27\10\0\1\27\11\0\12\27\1\312"+
    "\15\27\2\0\2\27\10\0\1\27\11\0\16\27\1\313"+
    "\11\27\2\0\2\27\10\0\1\27\11\0\6\27\1\314"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\6\27\1\206"+
    "\21\27\2\0\2\27\10\0\1\27\11\0\5\27\1\315"+
    "\22\27\2\0\2\27\10\0\1\27\11\0\4\27\1\316"+
    "\23\27\2\0\2\27\10\0\1\27\11\0\16\27\1\317"+
    "\11\27\2\0\2\27\10\0\1\27\11\0\10\27\1\205"+
    "\17\27\2\0\2\27\10\0\1\27\11\0\1\205\27\27"+
    "\2\0\2\27\10\0\1\27\11\0\20\27\1\320\7\27"+
    "\2\0\2\27\10\0\1\27\11\0\10\27\1\321\17\27"+
    "\2\0\2\27\10\0\1\27\11\0\25\27\1\317\2\27"+
    "\2\0\2\27\10\0\1\27\11\0\16\27\1\322\11\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\27\1\323\26\27"+
    "\2\0\2\27\10\0\1\27\11\0\22\27\1\165\5\27"+
    "\2\0\2\27\10\0\1\27\11\0\2\27\1\316\25\27"+
    "\2\0\2\27\10\0\1\27\11\0\6\27\1\324\21\27"+
    "\2\0\2\27\10\0\1\27\11\0\4\27\1\325\23\27"+
    "\2\0\2\27\10\0\1\27\11\0\16\27\1\326\11\27"+
    "\2\0\2\27\10\0\1\27\11\0\15\27\1\206\12\27"+
    "\2\0\2\27\10\0\1\27\11\0\1\327\27\27\2\0"+
    "\2\27\10\0\1\27\11\0\20\27\1\330\7\27\2\0"+
    "\2\27\10\0\1\27\11\0\7\27\1\165\20\27\2\0"+
    "\2\27\10\0\1\27\11\0\1\27\1\107\26\27\2\0"+
    "\2\27\10\0\1\27\11\0\12\27\1\165\15\27\2\0"+
    "\2\27\10\0\1\27\11\0\1\331\27\27\2\0\2\27"+
    "\10\0\1\27\11\0\1\27\1\232\26\27\2\0\2\27"+
    "\10\0\1\27\11\0\21\27\1\332\6\27\2\0\2\27"+
    "\10\0\1\27\11\0\5\27\1\333\22\27\2\0\2\27"+
    "\10\0\1\27\11\0\23\27\1\245\4\27\2\0\2\27"+
    "\10\0\1\27\11\0\1\334\27\27\2\0\2\27\10\0"+
    "\1\27\11\0\1\335\27\27\2\0\2\27\10\0\1\27"+
    "\11\0\2\27\1\336\25\27\2\0\2\27\10\0\1\27"+
    "\11\0\1\337\27\27\2\0\2\27\10\0\1\27\11\0"+
    "\14\27\1\203\13\27\2\0\2\27\10\0\1\27\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8648];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\6\0\2\11\30\1\1\11\2\1\13\11\5\1\3\11"+
    "\1\1\1\11\50\1\2\0\1\1\1\11\2\1\1\0"+
    "\52\1\1\11\115\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[223];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _MakefileLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _MakefileLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      if (zzMarkedPosL > zzStartRead) {
        switch (zzBufferL.charAt(zzMarkedPosL-1)) {
        case '\n':
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':  // fall through
          zzAtBOL = true;
          break;
        case '\r': 
          if (zzMarkedPosL < zzEndReadL)
            zzAtBOL = zzBufferL.charAt(zzMarkedPosL) != '\n';
          else if (zzAtEOF)
            zzAtBOL = false;
          else {
            boolean eof = zzRefill();
            zzMarkedPosL = zzMarkedPos;
            zzEndReadL = zzEndRead;
            zzBufferL = zzBuffer;
            if (eof) 
              zzAtBOL = false;
            else 
              zzAtBOL = zzBufferL.charAt(zzMarkedPosL) != '\n';
          }
          break;
        default:
          zzAtBOL = false;
        }
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      if (zzAtBOL)
        zzState = ZZ_LEXSTATE[zzLexicalState+1];
      else
        zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 41: break;
          case 2: 
            { return EOL;
            } 
            // fall through
          case 42: break;
          case 3: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 43: break;
          case 4: 
            { return CHARS;
            } 
            // fall through
          case 44: break;
          case 5: 
            { return COMMENT;
            } 
            // fall through
          case 45: break;
          case 6: 
            { return ASSIGN;
            } 
            // fall through
          case 46: break;
          case 7: 
            { return COLON;
            } 
            // fall through
          case 47: break;
          case 8: 
            { yybegin(SQSTRING); return QUOTE;
            } 
            // fall through
          case 48: break;
          case 9: 
            { yybegin(DQSTRING); return DOUBLEQUOTE;
            } 
            // fall through
          case 49: break;
          case 10: 
            { return OPEN_PAREN;
            } 
            // fall through
          case 50: break;
          case 11: 
            { return CLOSE_PAREN;
            } 
            // fall through
          case 51: break;
          case 12: 
            { return COMMA;
            } 
            // fall through
          case 52: break;
          case 13: 
            { return BACKTICK;
            } 
            // fall through
          case 53: break;
          case 14: 
            { return PIPE;
            } 
            // fall through
          case 54: break;
          case 15: 
            { return SEMICOLON;
            } 
            // fall through
          case 55: break;
          case 16: 
            { return DOLLAR;
            } 
            // fall through
          case 56: break;
          case 17: 
            { return OPEN_CURLY;
            } 
            // fall through
          case 57: break;
          case 18: 
            { return CLOSE_CURLY;
            } 
            // fall through
          case 58: break;
          case 19: 
            { return TAB;
            } 
            // fall through
          case 59: break;
          case 20: 
            { yybegin(YYINITIAL); return QUOTE;
            } 
            // fall through
          case 60: break;
          case 21: 
            { yybegin(YYINITIAL); return DOUBLEQUOTE;
            } 
            // fall through
          case 61: break;
          case 22: 
            { return SPLIT;
            } 
            // fall through
          case 62: break;
          case 23: 
            { return ESCAPED_DOUBLEQUOTE;
            } 
            // fall through
          case 63: break;
          case 24: 
            { return DOC_COMMENT;
            } 
            // fall through
          case 64: break;
          case 25: 
            { return FUNCTION_NAME;
            } 
            // fall through
          case 65: break;
          case 26: 
            { return MACRO;
            } 
            // fall through
          case 66: break;
          case 27: 
            { return KEYWORD_ELSE;
            } 
            // fall through
          case 67: break;
          case 28: 
            { return KEYWORD_IFEQ;
            } 
            // fall through
          case 68: break;
          case 29: 
            { return KEYWORD_ENDEF;
            } 
            // fall through
          case 69: break;
          case 30: 
            { return KEYWORD_ENDIF;
            } 
            // fall through
          case 70: break;
          case 31: 
            { return KEYWORD_IFNEQ;
            } 
            // fall through
          case 71: break;
          case 32: 
            { return KEYWORD_IFDEF;
            } 
            // fall through
          case 72: break;
          case 33: 
            { return KEYWORD_VPATH;
            } 
            // fall through
          case 73: break;
          case 34: 
            { return KEYWORD_EXPORT;
            } 
            // fall through
          case 74: break;
          case 35: 
            { return KEYWORD_IFNDEF;
            } 
            // fall through
          case 75: break;
          case 36: 
            { return KEYWORD_DEFINE;
            } 
            // fall through
          case 76: break;
          case 37: 
            { return KEYWORD_INCLUDE;
            } 
            // fall through
          case 77: break;
          case 38: 
            { return KEYWORD_PRIVATE;
            } 
            // fall through
          case 78: break;
          case 39: 
            { return KEYWORD_OVERRIDE;
            } 
            // fall through
          case 79: break;
          case 40: 
            { return KEYWORD_UNDEFINE;
            } 
            // fall through
          case 80: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
