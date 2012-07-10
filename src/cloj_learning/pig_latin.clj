; the mirrored java code:

;public class PigLatin {
;
;    public static String pigLatin(String word) {
;        char firstLetter = word.charAt(0);
;        if ("aeiou".indexOf(firstLetter) != -1) return word + "ay";
;        return word.substring(1) + firstLetter + "ay";
;    }
;
;    public static void main(String args[]) {
;        System.out.println(pigLatin("red"));
;        System.out.println(pigLatin("orange"));
;    }
;}

; when a set is used as a function it returns a boolean
; that indicates if arg is in set.
(def vowel? (set "aeiou"))

(defn pig-latin [word]
  (let [first-letter (first word)] ; local binding with 'let
    (if (vowel? first-letter)
      (str word "ay")
      (str (subs word 1) first-letter "ay"))))

(println (pig-latin "red"))
(println (pig-latin "orange"))
(println (pig-latin "bicycle"))
