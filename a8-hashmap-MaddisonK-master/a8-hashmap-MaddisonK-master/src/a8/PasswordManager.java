package a8;

import java.util.*;
import java.lang.Math;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "pass";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }


    // TODO: put
    @Override
    public void put(K key, V value) {
        int h = Math.abs(key.hashCode());
        int i = h % 50;
        Account list = _passwords[i];
        if (list == null) {
            _passwords[i] = new Account<>(key, value);
        } else if (list.getWebsite().equals(key)) {
            list.setPassword(value);
            return;
        } else {
            while (list.getNext() != null) {
                if (list.getWebsite().equals(key)) {
                    list.setPassword(value);
                    return;
                }
                list = list.getNext();
            }
            // when next is null
            list.setNext(new Account<>(key, value));
        }
        return;
    }

    // TODO: get
    @Override
    public V get(K key) {
        int h = Math.abs(key.hashCode());
        int i = h % 50;
        Account list = _passwords[i];
        if (list == null) {
            return null;
        } else {
            while (list != null) {
                if (list.getWebsite().equals(key)) {
                    return (V) list.getPassword();
                }
                list = list.getNext();
            }
        }
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        int size = 0;
        for (Account list:_passwords) {
            if (list != null) {
                while (list != null) {
                    size += 1;
                    list = list.getNext();
                }
            }
        }
        return size;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<K>();
        for (Account list:_passwords) {
            if (list != null) {
                while (list != null) {
                    keys.add((K) list.getWebsite());
                    list = list.getNext();
                }
            }
        }
        return keys;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        int h = Math.abs(key.hashCode());
        int i = h % 50;
        Account list = _passwords[i];
        if (list == null) {
            return null;
        }
        if (list.getWebsite().equals(key)) {
            _passwords[i] = list.getNext();
            return (V) list.getPassword();
        }
        while (list.getNext() != null) {
            if (list.getNext().getWebsite().equals(key)) {
                V value = (V) list.getNext().getPassword();
                list.setNext(list.getNext().getNext());
                return value;
            }
        }
        return null;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        List<K> keys = new ArrayList<>();
        for (Account list:_passwords) {
            if (list != null) {
                while (list != null) {
                    if (list.getPassword().equals(value)) {
                        keys.add((K) list.getWebsite());
                    }
                    list = list.getNext();
                }
            }
        }
        return keys;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return enteredPassword.equals(MASTER_PASSWORD);
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }

    public void display(int i) {
        System.out.println(getPasswords()[i]);
    }
}
