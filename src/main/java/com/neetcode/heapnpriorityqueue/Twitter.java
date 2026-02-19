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

        // Get all followees of the user (people he follows)
        // If user follows no one, return empty map
        Map<Integer, Boolean> followeeIds = followings.getOrDefault(userId, new HashMap<>());

        // Cursor map:
        // For each user (self + followees), we store how many tweets we already consumed
        // Key   -> userId
        // Value -> offset from the latest tweet (0 = newest)
        Map<Integer, Integer> cursors = new HashMap<>();

        // User should see their own tweets as well
        cursors.put(userId, 0);

        // Add all followees into cursor map
        for (Map.Entry<Integer, Boolean> entry : followeeIds.entrySet()) {
            cursors.put(entry.getKey(), 0);
        }

        // Result list (maximum 10 tweets)
        List<Integer> newsFeed = new ArrayList<>();

        // Max-heap ordered by tweet timestamp (latest first)
        PriorityQueue<Tweet> tweetPQ =
                new PriorityQueue<>((a, b) -> Math.toIntExact(b.createdAt - a.createdAt));

        // This map ensures that in each round we only push ONE tweet per user
        // Prevents duplicate pushes within same iteration
        Map<String, Boolean> visited = new HashMap<>();

        // We need at most 10 tweets
        for (int i = 0; i < 10; ++i) {

            // Try to push the next available tweet from each user
            Iterator<Map.Entry<Integer, Integer>> iterator = cursors.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> cursor = iterator.next();
                Integer followeeId = cursor.getKey();
                // Get that user's tweet list
                List<Tweet> followeeTweets =
                        tweets.getOrDefault(followeeId, new ArrayList<>());

                // Calculate index from newest to oldest
                int index = followeeTweets.size() - 1 - cursor.getValue();

                // If no more tweets from this user, remove from cursors
                if (index < 0) {
                    iterator.remove();
                    continue;
                }
                // Get the next latest tweet
                Tweet followeeLatestTweet = followeeTweets.get(index);
                String key = String.format("tweet_id:%s:user_id:%s", followeeLatestTweet.id, followeeLatestTweet.userId);
                if (visited.containsKey(key)) {
                    continue;
                }
                // Push into max heap
                tweetPQ.add(followeeLatestTweet);

                // Mark this user as pushed for this round
                visited.put(key, true);
            }

            // If no tweets left at all → stop
            if (tweetPQ.isEmpty()) break;

            // Get the globally latest tweet
            Tweet latestTweet = tweetPQ.remove();

            // Move cursor forward for that tweet's owner
            if (cursors.containsKey(latestTweet.userId)) {
                cursors.put(latestTweet.userId,cursors.get(latestTweet.userId) + 1);
            }

            // Add tweet id to result
            newsFeed.add(latestTweet.id);
        }

        return newsFeed;
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
