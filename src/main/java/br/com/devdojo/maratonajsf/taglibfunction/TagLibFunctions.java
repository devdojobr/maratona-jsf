package br.com.devdojo.maratonajsf.taglibfunction;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author William Suane on 6/22/2017.
 */
public class TagLibFunctions {
    public static String capitalize(String str) {
        return WordUtils.capitalizeFully(str);
    }
}
