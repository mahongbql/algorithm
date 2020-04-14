package com.algorithm.everyDay;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        System.out.println(twitter.getNewsFeed(1));

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 3);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));

//        // 用户1关注了用户2.
//        twitter.follow(1, 2);
//
//        // 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        System.out.println(twitter.getNewsFeed(1));
//
//        // 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        // 因为用户1已经不再关注用户2.
//        System.out.println(twitter.getNewsFeed(1));
    }

    private Map<Integer, List<Map<Integer, Integer>>> twitterMap;

    private Map<Integer, Set<Integer>> followMap;

    private int t = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        twitterMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Map<Integer, Integer>> twitterList = twitterMap.get(userId);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(tweetId, t++);
        twitterList = twitterList == null ? new ArrayList<>() : twitterList;
        twitterList.add(map);
        twitterMap.put(userId, twitterList);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>(11);
        Set<Integer> set = followMap.get(userId);
        set = set == null ? new HashSet<>() : set;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
        list.add(userId);

        Map<Integer, Integer> twitterListMap = new HashMap<>();
        for(Integer usrId : list) {
            List<Map<Integer, Integer>> mapList = twitterMap.get(usrId);
            mapList = mapList == null ? new ArrayList<>() : mapList;
            int size = mapList.size() > 10 ? mapList.size() - 10 : 0;
            for(int i = mapList.size()-1; i >= size; i--) {
                twitterListMap.putAll(mapList.get(i));
            }
        }

        List<Integer> resList = new ArrayList<>();
        twitterListMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> resList.add(ele.getKey()));

        return resList.size() > 10 ? resList.subList(0, 10) : resList;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followMap.get(followerId);
        set = set == null ? new HashSet<>() : set;
        set.add(followeeId);
        followMap.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followMap.get(followerId);
        set = set == null ? new HashSet<>() : set;
        set.remove(followeeId);
        followMap.put(followerId, set);
    }
}
