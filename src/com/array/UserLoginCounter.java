package com.array;
import java.util.*;

public class UserLoginCounter {

    public static List<List<String>> countUserLogins(List<List<String>> logs) {
        Map<String, Map<String, Integer>> logTreeMap = new TreeMap<>();

        for (List<String> log : logs) {
            if (log.size() != 3) {
                continue;  // Invalid data check
            }

            String user = log.get(0);
            String time = log.get(1);
            String date = log.get(2);

            if (!isValidTimeFormat(time) || !isValidDateFormat(date)) {
                continue;  // Invalid time or date format check
            }

            // Ensure there's an inner TreeMap for the user or create one if not present
            Map<String, Integer> userLogins = logTreeMap.get(user);
            if (userLogins == null) {
                userLogins = new TreeMap<>();
                logTreeMap.put(user, userLogins);
            }

            // Update or insert the login count for the date
            int currentCount = userLogins.getOrDefault(date, 0);
            userLogins.put(date, currentCount + 1);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> userEntry : logTreeMap.entrySet()) {
            for (Map.Entry<String, Integer> dateEntry : userEntry.getValue().entrySet()) {
                result.add(Arrays.asList(userEntry.getKey(), dateEntry.getKey(), String.valueOf(dateEntry.getValue())));
            }
        }

        return result;
    }

    private static boolean isValidTimeFormat(String time) {
        String[] parts = time.split(":");
        return parts.length == 3
                && isInteger(parts[0]) && Integer.parseInt(parts[0]) < 24
                && isInteger(parts[1]) && Integer.parseInt(parts[1]) < 60
                && isInteger(parts[2]) && Integer.parseInt(parts[2]) < 60;
    }

    private static boolean isValidDateFormat(String date) {
        String[] parts = date.split("-");
        return parts.length == 3
                && isInteger(parts[0]) && parts[0].length() == 4
                && isInteger(parts[1]) && Integer.parseInt(parts[1]) <= 12
                && isInteger(parts[2]) && Integer.parseInt(parts[2]) <= 31;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<List<String>> logs = Arrays.asList(
                Arrays.asList("user1", "09:00:00", "2021-01-01"),
                Arrays.asList("user1", "13:00:00", "2021-01-01"),
                Arrays.asList("user2", "14:00:00", "2021-01-01"),
                Arrays.asList("user1", "20:00:00", "2021-01-02"),
                Arrays.asList("user2", "21:00:00", "2021-01-01")
        );

//        System.out.println(countUserLogins(logs));

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q);

    }
}
