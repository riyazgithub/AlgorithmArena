package com.live.coderound.ik;

import java.util.ArrayList;
import java.util.List;
/*
######### PROBLEM 1
Given 2 strings str1 and str2. Generate all permutations of str1 using recursion and
return true if str2 is a permutation of str1.


Example:
str1 = “abcd”
str2 = “dacb”
result = checkPermutation(str1, str2)
True

str1 = “abcd”
str2 = “waka”
result = checkPermutation(str1, str2)
False

1 <= s1.length, s2.length <= 10^4
s1 and s2 consist of lowercase english letters only

abcd
index 0     1   2   3
str1 abcd bacd cabd dabc
                    dabc
                    dcba
permute  dabc


###### PROBLEM 2
Implement the "paint fill" function that one might see on many image editing programs that is given a
screen (represented by a 2-dimensional array of colors), a point, and a new color fill in the
surrounding area (up, down, left, right) until the color changes from the original color.

# screen is the 2d matrix
# x, y are your starting row, colomn,
# ncolor is the new color

Example:
Starting at 1, 1 and ncolor is green,
[[red, blue, blue],
 [red, blue, green],
 [blue, blue, red],
]
The end result is
[[red, green, green],`
 [red, green, green],
 [green, green, red],
]

Example function header
def paintFill(screen, x, y, ncolor):"

x 1
y 1

rgb
rgg
bgr


###### PROBLEM 3
Given a hash that contains sub hashes or integers return the sum of all the integer values.

Example:
test = {'a': 2,
        'b': {
            'c': 5, 'd': 3
         },
         'c': 4
}
summation(test)
# result is 14



################
*/
public class recursionTest {

//    public int summation(HashMap<Character, complex> strHM) {
//
//        for(EntrySet es : hm.getEntrySet()) {
//            if(Character.isNumeric(es.getValue)) {
//                sum += es.getValue();
//            } else {
//                summation(strHM.getValue());
//            }
//        }
//
//
//    }




    // PROBLEM 2
    public void paintFill(char[][] screen, int x, int y, char color) {
        pfHelp(screen, x,y, color, screen[x][y]);

    }

    public void pfHelp(char[][] screen, int x, int y, char color, char curr){
        if(x<0 || x >= screen.length || y<0 || y>= screen[0].length)
            return;
        if(screen[x][y] != curr)
            return;
        screen[x][y] = color;
        pfHelp(screen, x,y-1, color, curr);
        pfHelp(screen, x,y+1, color, curr);
        pfHelp(screen, x-1,y, color, curr);
        pfHelp(screen, x+1,y, color, curr);
    }


    // PROBLEM 1
    public boolean checkPermutation(String str1, String str2) {
        List<String> permute = new ArrayList<String>();
        permuteHelp(permute, 0, str1.toCharArray());
        if(permute.contains(str2)) return true;
        return false;
    }

    public void permuteHelp(List<String> permute, int index, char[] str1) {
        if(index == str1.length){
            permute.add(new String(str1));
            return;
        }

        for(int j =0; j< str1.length;j++) {

            swap(str1,index,j);
            permuteHelp(permute, index +1, str1);
            swap(str1,index,j);
        }

    }

    public void swap(char[] str1, int i, int j){

        char c = str1[i];
        str1[i] = str1[j];
        str1[j] = c;
    }

}
