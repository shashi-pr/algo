package leetcode.heap;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

	private Map<Integer, Set<Integer>> friendsMap;
	private Map<Integer, PriorityQueue<Tweet>> tweetMap;
	// private PriorityQueue<Integer, rvgby8t8yh> // shayna shashi kanchan

	public Twitter() {
		friendsMap = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		Tweet tweet = new Tweet(tweetId, userId);
		
		//Collections.sort(
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {

		return null;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		Set<Integer> friendSet = friendsMap.getOrDefault(followerId, new HashSet<Integer>());
		friendSet.add(followeeId);
		friendsMap.put(followerId, friendSet);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		Set<Integer> friendSet = friendsMap.getOrDefault(followerId, new HashSet<Integer>());
		friendSet.remove(followeeId);
		friendsMap.put(followerId, friendSet);
	}

	private class Tweet {
		private Integer tweetId;
		private Integer userId;
		private long postTime;

		public Tweet(Integer tweetId, Integer userId) {
			this.tweetId = tweetId;
			this.userId = userId;
			this.postTime = Instant.now().toEpochMilli();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
