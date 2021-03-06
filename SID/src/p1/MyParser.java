/* Generated By:JavaCC: Do not edit this line. MyParser.java */
package p1;

import java.io.*;
import java.net.*;
import java.util.*;

public class MyParser implements MyParserConstants {
  // URL donde obtener empresas y cotizaciones "actuales"
        private final static String URL = "http://www.infobolsa.es/acciones/ibex35";

  public static void main(String args []) throws ParseException
  {
    try {
        URL url = new URL(URL);
        URLConnection urlConnection = url.openConnection();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        //String cadena;
                //String fichero = "C:\\Users\\Daniel\\Documents\\Sistemas de informacion distribuidos\\pagina.html";
                //FileReader f = new FileReader(fichero);
                //BufferedReader buffer = new BufferedReader(f);
                //while((cadena = buffer.readLine())!=null) {
            //System.out.println(cadena);
        //}
        //buffer.close();
                // Entrada de datos de la web
                //InputStreamReader stream = new InputStreamReader(url);
                MyParser parser = new MyParser(buffer);
                System.out.println(parser.leeTablaCotizaciones());
                //Hashtable<String, Double> tablaCotizaciones = parser.leeTablaCotizaciones();

            System.out.print("\u005cn\u005cnIntroduzca el nombre de una empresa del IBEX 35: ");
            //Scanner scanner = new Scanner(System.in);
            //String empresa = scanner.nextLine(); 
            //double valorActual = tablaCotizaciones.get(empresa);
            //System.out.println("Cotización actual: " + valorActual);
    }catch(Exception e) {
                System.out.println("Exception " + e.getMessage());
    }
  }

  static final public Hashtable<String, Double> leeTablaCotizaciones() throws ParseException {
  Hashtable<String, Double> tablaLectura = new Hashtable<String, Double> ();
    jj_consume_token(CABECERA);
    jj_consume_token(HTML);
    jj_consume_token(HEAD);
    saltar();
    jj_consume_token(HEAD_FIN);
    tablaLectura = body();
    jj_consume_token(HTML_FIN);
      {if (true) return tablaLectura;}
    throw new Error("Missing return statement in function");
  }

  static final public void saltar() throws ParseException {
                 System.out.println("saltar()");
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARACTERES:
        jj_consume_token(CARACTERES);
        break;
      case META:
        jj_consume_token(META);
        break;
      case TITLE:
        jj_consume_token(TITLE);
        break;
      case ETIQUETA:
        jj_consume_token(ETIQUETA);
        break;
      case A_FIN:
        jj_consume_token(A_FIN);
        break;
      case ETIQUETA_FIN:
        jj_consume_token(ETIQUETA_FIN);
        break;
      case A_HREF:
        jj_consume_token(A_HREF);
        break;
      case BARRA:
        jj_consume_token(BARRA);
        break;
      case NUMERO:
        jj_consume_token(NUMERO);
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case META:
      case TITLE:
      case A_HREF:
      case A_FIN:
      case ETIQUETA:
      case ETIQUETA_FIN:
      case BARRA:
      case NUMERO:
      case CARACTERES:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
  }

  static final public Hashtable<String, Double> body() throws ParseException {
  Hashtable<String, Double> tablaBody = new Hashtable<String, Double> ();
    jj_consume_token(BODY);
    saltar();
                     System.out.println("encontrado inicio tabla");
    tablaBody = cotizaciones();
    saltar();
    jj_consume_token(BODY_FIN);
    {if (true) return tablaBody;}
    throw new Error("Missing return statement in function");
  }

  static final public Hashtable<String, Double> cotizaciones() throws ParseException {
  Hashtable<String, Double> tablaC= new Hashtable<String, Double> ();
  String nombre = " ";
  String cotizacion;
  System.out.println("cotizaciones()");
    label_2:
    while (true) {
      jj_consume_token(INICIO_TABLA);
                     System.out.println("1");
      jj_consume_token(A_FIN);
              System.out.println("y");
      jj_consume_token(TD_FIN);
      jj_consume_token(NOMBRE_EMPRESA);
                                 System.out.println("2");
      jj_consume_token(A_HREF);
      jj_consume_token(CARACTERES);
      jj_consume_token(ETIQUETA_FIN);
      nombre = cadena();
                                                       System.out.println(nombre);
      jj_consume_token(CARACTERES);
      jj_consume_token(A_FIN);
                         System.out.println("3");
      saltar();
      jj_consume_token(COTIZACION_EMPRESA);
      cotizacion = number();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INICIO_TABLA:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
    }
    jj_consume_token(FIN_TBODY);
    {if (true) return tablaC;}
    throw new Error("Missing return statement in function");
  }

  static final public String number() throws ParseException {
 Token t ;
    t = jj_consume_token(CARACTERES);
    {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  static final public String cadena() throws ParseException {
  Token s ;
System.out.println("cadena()");
    s = jj_consume_token(CARACTERES);
    {if (true) return s.image;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MyParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3ec0c00,0x3ec0c00,0x4000,};
   }

  /** Constructor with InputStream. */
  public MyParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MyParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MyParser(MyParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MyParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[26];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 26; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
