/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textreverse;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author subhi
 */
public class TextReverse {

    static public char[][] characters = {
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

    static public char getCharachterAsMedium(char c) {
        if (c == 'ا' || c == 'د' || c == 'ذ' || c == 'ر' || c == 'ز' || c == 'و') {
            return getCharachterAsLast(c);
        }
        return characters[getCharachterIndex(c)][3];
    }

    static public char getCharachterAsLast(char c) {
        return characters[getCharachterIndex(c)][1];
    }

    static public char getCharachterAsFirst(char c) {
        if (c == 'ا' || c == 'د' || c == 'ذ' || c == 'ر' || c == 'ز' || c == 'و') {
            return characters[getCharachterIndex(c)][0];
        }
        return characters[getCharachterIndex(c)][2];

    }

    static public int getCharachterIndex(char c) {
        int index = c;

        if (index < 1595) {
            index = index - 1575;
        } else {
            index = index - 1601 + 20;
        }
        return index;
    }

    static public char getCharachterPositioned(char previous, char current, char succ) {
        if (current=='َ'||current=='ِ'||current=='ُ'||current=='ّ'||current=='ً'
                ||current=='ٍ'||current=='ٌ')
        {
            return current;
        }
        else
        if (previous == '?') {
            return getCharachterAsFirst(current);
        }
        else
        if (previous == 'ا' || previous == 'د' || previous == 'ذ' || previous == 'ر' || previous == 'ز' || previous == 'و') {
            return getCharachterAsFirst(current);
        }
        else
        if (succ == '?') {
            return getCharachterAsLast(current);
        } else {
            return getCharachterAsMedium(current);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        char c;
        String s = "الكُلية";
        int L = s.length();
        char[] ss = s.toCharArray();
        char[] dd = new char[L];
        
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                c = getCharachterPositioned('?', ss[i], ss[i + 1]);
                int x = 0;
            } else if (i == s.length() - 1) {
                c = getCharachterPositioned(ss[i - 1], ss[i], '?');
            } else {
                c = getCharachterPositioned(ss[i - 1], ss[i], ss[i + 1]);
            }
            
            dd[L-1]=c;
            L--;
        }

        String result="";
        for (int k=0;k<dd.length;k++)
        {
        result=result+dd[k];
        }
        
        System.err.print(result);
//        
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
//        int i =0;
//        int j =1550;
//       
//         for ( i=0 ; i<200 ;i++)
//             
//         {
//          char tt=  (char) j;
//         System.err.println(j+"  "+ tt);
//            j++; 
//         }

    }
}
