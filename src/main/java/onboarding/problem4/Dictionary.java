package onboarding.problem4;

import org.w3c.dom.CDATASection;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {

    private final Map<Character, Character> dictionaryMap;
    private StringBuilder sb = new StringBuilder();

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

    // 참고하다
    public void refer(char data) {
        if (Character.isLowerCase(data)) {
            char key = Character.toUpperCase(data);
            Character valueData = getValueData(key);

            char value = Character.toLowerCase(valueData);

            this.sb.append(value);
            return;
        }

        if (Character.isUpperCase(data)) {
            Character value = getValueData(data);

            this.sb.append(value);
            return;
        }

        if (data == ' ') {
            this.sb.append(' ');
        }

    }

    private Character getValueData(char key) {
        if (this.dictionaryMap.containsKey(key)) {
            return dictionaryMap.get(key);
        }

        throw new IllegalArgumentException("사전에 없는 문자입니다.");
    }

    // 번역하다.
    public String translate() {
        return this.sb.toString();
    }
}
