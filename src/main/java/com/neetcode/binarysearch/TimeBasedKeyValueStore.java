package com.neetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    class TimeMap {
        private Map<String, List<Entry>> map;
        public TimeMap() {
            map = new HashMap<>();
        }
        public void set(String key, String value, int timestamp) {
            List<Entry> entries = map.get(key);
            if (entries == null) {
                entries = new ArrayList<>();
                entries.add(new Entry(value, timestamp));
                map.put(key, entries);
                return;
            }
            int l = 0;
            int r = entries.size() - 1;
            while (l <= r) {
                int m = (l + r)/ 2;
                if (timestamp > entries.get(m).timestamp) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            entries.add(l, new Entry(value, timestamp));
            map.put(key, entries);
        }

        public String get(String key, int timestamp) {
            List<Entry> entries = map.get(key);
            if (entries == null) {
                return "";
            }
            int l = 0;
            int r = entries.size() - 1;
            String res = "";
            while (l <= r) {
                int m = (l + r) / 2;
                if (entries.get(m).timestamp <= timestamp) {
                    res = entries.get(m).value; // candidate
                    l = m + 1; // try to find later timestamp
                } else {
                    r = m - 1;
                }
            }
            return res;
        }

        private static class Entry {
            String value;
            int timestamp;

            Entry(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    }
}

class TimeBasedKeyValueStorePractice {
    class TimeMap {
        private Map<String, List<Entry>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Entry> list = map.getOrDefault(key, new ArrayList<>());
            list.add(new Entry(value, timestamp));
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            List<Entry> list = map.getOrDefault(key, new ArrayList<>());
            if (list.isEmpty()) return "";
            int l = 0;
            int r = list.size() - 1;
            // set() is called with strictly increasing timestamps for the same key.
            // so "list" is the ascending order list by timestamps
             while (l <= r) {
                 int mid = (l + r)/2;
                 Entry e = list.get(mid);
                 if (timestamp == e.timestamp) return e.value;
                 if (timestamp < e.timestamp) {
                     r = mid -1;
                 } else {
                     l = mid + 1;
                 }
             }
             // When loop "while (l <= r)" breaks, l = r + 1,
             // r = largest timestamp ≤ target
             // l = first timestamp > target
            if (r >= 0) {
                return list.get(r).value;
            }
             return "";
        }
    }

    class Entry {
        String value;
        int timestamp;

        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}