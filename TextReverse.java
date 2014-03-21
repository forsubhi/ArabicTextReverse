/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subhi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPopupMenu;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author subhi
 */
public class TextReverse {

    static public char[][] characters = {
        {'ﺁ', 'ﺂ'},
        {'ﺃ', 'ﺄ'},
        {'ﺅ', 'ﺆ'},
        {'ﺇ', 'ﺈ'},
        {'ﺉ', 'ﺊ', 'ﺋ', 'ﺌ'},
        {'ﺍ', 'ﺎ'},
        {'ﺏ', 'ﺐ', 'ﺑ', 'ﺒ'},
        {'ﺓ', 'ﺔ'},
        {'ﺕ', 'ﺖ', 'ﺗ', 'ﺘ'},
        {'ﺙ', 'ﺚ', 'ﺛ', 'ﺜ'},
        {'ﺝ', 'ﺞ', 'ﺟ', 'ﺠ'},
        {'ﺡ', 'ﺢ', 'ﺣ', 'ﺤ'},
        {'ﺥ', 'ﺦ', 'ﺧ', 'ﺨ'},
        {'ﺩ', 'ﺪ'},
        {'ﺫ', 'ﺬ'},
        {'ﺭ', 'ﺮ'},
        {'ﺯ', 'ﺰ'},
        {'ﺱ', 'ﺲ', 'ﺳ', 'ﺴ'},
        {'ﺵ', 'ﺶ', 'ﺷ', 'ﺸ'},
        {'ﺹ', 'ﺺ', 'ﺻ', 'ﺼ'},
        {'ﺽ', 'ﺾ', 'ﺿ', 'ﻀ'},
        {'ﻁ', 'ﻂ', 'ﻃ', 'ﻄ'},
        {'ﻅ', 'ﻆ', 'ﻇ', 'ﻈ'},
        {'ﻉ', 'ﻊ', 'ﻋ', 'ﻌ'},
        {'ﻍ', 'ﻎ', 'ﻏ', 'ﻐ'},
        {'ﻑ', 'ﻒ', 'ﻓ', 'ﻔ'},
        {'ﻕ', 'ﻖ', 'ﻗ', 'ﻘ'},
        {'ﻙ', 'ﻚ', 'ﻛ', 'ﻜ'},
        {'ﻝ', 'ﻞ', 'ﻟ', 'ﻠ'},
        {'ﻡ', 'ﻢ', 'ﻣ', 'ﻤ'},
        {'ﻥ', 'ﻦ', 'ﻧ', 'ﻨ'},
        {'ﻩ', 'ﻪ', 'ﻫ', 'ﻬ'},
        {'ﻭ', 'ﻮ'},
        {'ﻯ', 'ﻰ'},
        {'ﻱ', 'ﻲ', 'ﻳ', 'ﻴ'}
    };

    synchronized public static boolean IsSeperator(char c) {
        if (c == 'آ' || c == 'أ' || c == 'ؤ' || c == 'إ' || c == 'ئ' || c == 'ا' || c == 'د' || c == 'ذ' || c == 'ر' || c == 'ز' || c == 'و') {
            return true;
        }
        return false;
    }

   synchronized public static boolean IsTashkeel(char c) {
        if (c == 'َ' || c == 'ُ' || c == 'ِ' || c == 'ّ' || c == 'ً' || c == 'ٍ' || c == 'ٌ') {
            return true;
        }
        return false;
    }

    synchronized public static char getCharachterAsMedium(char c) {
        if (IsSeperator(c)) {
            return getCharachterAsLast(c);

        }
        return characters[getCharachterIndex(c)][3];
    }

    synchronized public static char getCharachterAsLast(char c) {
        return characters[getCharachterIndex(c)][1];
    }

    synchronized public static char getCharachterAsFirst(char c) {

        if (IsSeperator(c)) {
            return characters[getCharachterIndex(c)][0];
        }
        return characters[getCharachterIndex(c)][2];

    }

    synchronized public static int getCharachterIndex(char c) {
        int index = c;

        if (index < 1595) {
            index = index - 1570;
        } else {
            index = index - 1601 + 25;
        }
        return index;
    }

   synchronized public static  char getCharachterPositioned(char previous, char current, char succ) {
        if (current == 'َ' || current == 'ِ' || current == 'ُ' || current == 'ّ' || current == 'ً'
                || current == 'ٍ' || current == 'ٌ') {
            return current;
        } else if (previous == '?') {
            return getCharachterAsFirst(current);
        } else if (succ == '?') {
            return getCharachterAsLast(current);
        } else if (IsSeperator(previous)) {
            return getCharachterAsFirst(current);
        } else {
            return getCharachterAsMedium(current);
        }

    }

    /**
     * @param args the command line arguments
     */
    
    synchronized public static String GetTextReversed(String s) {

        char c;

        int L = s.length();
        char[] ss = s.toCharArray();
        char[] dd = new char[L];

        for (int i = 0; i < s.length(); i++) {

            if (s.length()==1)
            {
                c = ss[i];
            }
            else
            // firt case 
            if (i == 0) {

                c = getCharachterPositioned('?', ss[i], ss[i + 1]);
                int x = 0;
            } // last case 
            else if (i == s.length() - 1) {
                if (i >= 2 && IsTashkeel(ss[i - 1])) {
                    c = getCharachterPositioned(ss[i - 2], ss[i], '?');
                }
                c = getCharachterPositioned(ss[i - 1], ss[i], '?');
            } // medium case 
            else {
                if (IsTashkeel(ss[i + 1]) && i == s.length() - 2) {
                    if (i >= 2 && IsTashkeel(ss[i - 1])) {
                        c = getCharachterPositioned(ss[i - 2], ss[i], '?');
                    } else {
                        c = getCharachterPositioned(ss[i - 1], ss[i], '?');
                    }
                } else {
                    if (i >= 2 && IsTashkeel(ss[i - 1])) {
                        c = getCharachterPositioned(ss[i - 2], ss[i], ss[i + 1]);
                    } else {
                        c = getCharachterPositioned(ss[i - 1], ss[i], ss[i + 1]);
                    }
                }
            }

            dd[L - 1] = c;
            L--;
        }

        String result = "";
        for (int k = 0; k < dd.length; k++) {
            result = result + dd[k];
        }


        return result;

    }
}
//        for (int i = 0; i < 30; i++) {
//            System.err.println(characters[i][1]);
//        }
//   String x = "ااا";
//   String d= "ذﺫﺫ";
//        char[] source = x.toCharArray();
//        char[] source2= d.toCharArray();
//        char [] destination = new char[(x.length())];
//        int i , last =0;
//        last=x.length()-1;
//        for ( i=0; i <x.length();)
//        {
//            int char1 = source[i];
//            int char2 =  source2[i];
//          System.err.print(char1);
//          System.err.print("   ");
//           System.err.print(char2);
//            System.err.println();
//       destination[last]=source[i];
//       last--;
//            i++;
//        }
//        
//        System.err.print(destination);
//        
//        
//        
//        char v = 65259;
//        char vv=1607;
//        System.err.println(v);
//         System.err.println(vv);
//         System.err.println(v);
//         System.err.println(vv);
//         System.err.println();
//       int i =0;
//        int j =65140;
//       
//         for ( i=0 ; i<50 ;i++)
//             
//         {
//          char tt=  (char) j;
//         System.err.println(j+"  "+ tt);
//            j++; 
//         }
//
//         
//            i =0;
//            c='ء';
//         j =c;
//       
//         for ( i=0 ; i<50 ;i++)
//             
//         {
//          char tt=  (char) j;
//         System.err.println(j+"  "+ tt);
//            j++; 
//         }

