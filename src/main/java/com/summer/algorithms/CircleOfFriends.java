package com.summer.algorithms;

import lombok.Data;

import java.util.*;

/**
 * 计算最大朋友圈
 */
public class CircleOfFriends {
    private int circleOfFriends(int clubsCount, int personsCount) {

        List<ClubPerson> clubsT = new ArrayList<>();

        for (int i = 0; i < clubsCount; i++) {
            ClubPerson club = new ClubPerson();
            club.setClubName(i + "");
            club.setPersonCount(3+i);
            club.setMembers(new HashSet<>());

            clubsT.add(club);
            generateObj(club, personsCount);
        }

        return circleOfFriendsCore(clubsT);
    }

    private <T extends ClubPerson>void generateObj(T obj, int personsCount) {
        Random rd = new Random();
        while(obj.getPersonCount() != obj.getMembers().size()) {
            obj.getMembers().add(rd.nextInt(personsCount));
        }
    }

    @Data
    static class ClubPerson{
        public String clubName;
        public int personCount;
        public Set<Integer> members;
        public int cnt;
    }

    private int circleOfFriendsCore(List<ClubPerson> clubs) {

        Set<Integer> result = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();

        for (ClubPerson club:clubs) {

            result.clear();
            result.addAll(club.getMembers());

            for (ClubPerson clubIn:clubs) {
                if (!club.clubName.equals(clubIn.getClubName())) {
                    unionMembers(result,clubIn.getMembers(),tmp);
                }
            }

            club.setCnt(result.size());
        }

        int max = 0;
        for (ClubPerson club:clubs) {
            if (max < club.getCnt()) {
                max = club.getCnt();
            }
        }
        System.out.println(max);
        return max;
    }

    /**
     * @param t 目标集合
     * @param c 比较集合
     */
    private void unionMembers(Set<Integer> t, Set<Integer> c, Set<Integer> tmp) {
        // 遍历小集合
        if(t.size() <= c.size()) {
            for (int member:t) {
                if (c.contains(member)) {
                    tmp =c;
                    break;
                }
            }
        } else {
            for (int member:c) {
                if (t.contains(member)) {
                    tmp = c;
                    break;
                }
            }
        }
        t.addAll(tmp);
    }
}
