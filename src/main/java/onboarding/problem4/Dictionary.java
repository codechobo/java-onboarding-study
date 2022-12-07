package onboarding.problem4;

import org.w3c.dom.CDATASection;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {

    private final Map<Character, Character> dictionaryMap;

    public Dictionary() {
        this.dictionaryMap = new ConcurrentHashMap<>();
        initDictionary();
    }

    private void initDictionary() {
        char reverseData = 'Z';
        for (char data = 'A'; data <= 'Z'; data++) {
            this.dictionaryMap.put(data, reverseData--);
        }
    }
}
