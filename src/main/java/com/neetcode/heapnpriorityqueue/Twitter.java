package com.neetcode.heapnpriorityqueue;

import java.util.*;

public class Twitter {
    private final Map<Integer, Map<Integer, Boolean>> followings; // followerId - []followeeId
    private final Map<Integer, List<Tweet>> tweets; // userId - []tweetId
    private Integer timestamp;

    public Twitter() {
        followings = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        List<Tweet> t = tweets.getOrDefault(userId, new ArrayList<>());
        t.add(new Tweet(tweetId, userId, timestamp++));
        tweets.put(userId, t);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> followeeIds =
                followings.getOrDefault(userId, new HashMap<>())
                        .keySet()
                        .stream()
                        .toList();

        // Max-heap ordered by timestamp (latest first)
        PriorityQueue<Tweet> tweetPQ =
                new PriorityQueue<>((a, b) -> b.createdAt - a.createdAt);

        // Cursor map: userId -> current index in that user's tweet list
        Map<Integer, Integer> cursors = new HashMap<>();

        // 1️⃣ Add user's own latest tweet (if exists)
        List<Tweet> selfTweets = tweets.get(userId);
        if (!isNullOrEmpty(selfTweets)) {
            int lastIndex = selfTweets.size() - 1;
            cursors.put(userId, lastIndex);
            tweetPQ.add(selfTweets.get(lastIndex));
        }

        // 2️⃣ Add each followee's latest tweet (if exists)
        for (Integer followeeId : followeeIds) {
            List<Tweet> followeeTweets = tweets.get(followeeId);
            if (isNullOrEmpty(followeeTweets)) continue;

            int lastIndex = followeeTweets.size() - 1;
            cursors.put(followeeId, lastIndex);
            tweetPQ.add(followeeTweets.get(lastIndex));
        }

        // 3️⃣ Extract up to 10 most recent tweets
        List<Integer> newsFeed = new ArrayList<>();

        while (!tweetPQ.isEmpty() && newsFeed.size() < 10) {

            // Get most recent tweet globally
            Tweet latestTweet = tweetPQ.remove();
            newsFeed.add(latestTweet.id);

            int ownerId = latestTweet.userId;

            // Move cursor to previous tweet of that user
            int index = cursors.get(ownerId) - 1;

            if (index >= 0) {
                cursors.put(ownerId, index);
                tweetPQ.add(tweets.get(ownerId).get(index));
            }
        }

        return newsFeed;
    }

    private boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public void follow(int followerId, int followeeId) {
        Map<Integer, Boolean> followeeIds = followings.getOrDefault(followerId, new HashMap<>());
        followeeIds.put(followeeId, true);
        followings.put(followerId, followeeIds);
    }

    public void unfollow(int followerId, int followeeId) {
        Map<Integer, Boolean> followeeIds = followings.getOrDefault(followerId, new HashMap<>());
        followeeIds.remove(followeeId);
        followings.put(followerId, followeeIds);
    }

    private static class Tweet {
        int id;
        int userId;
        int createdAt;

        Tweet(int id, int userId, int createdAt) {
            this.id = id;
            this.userId = userId;
            this.createdAt = createdAt;
        }
    }
}
