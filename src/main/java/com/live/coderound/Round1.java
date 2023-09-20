package com.live.coderound;

/**
 * We need to implement a system that helps us determine the winner(s) of an Innovation Week / Business Idea Competition.
 * There can be  ‘T’ teams participating with
 * ‘J’ judges voting for them across 3 categories:
 * Idea, Implementation, Impact.
 * Each category score ranges from 1 to 5 with a total score of any team ranging from 3 to 15 (maximum).
 * A judge’s vote is a set of  3 numbers denoting the score across each category.
 * For e.g., judge Judy can vote for team Tornadoes as such (Idea: 3,  Implementation: 5, Impact: 2).
 * Ask is to find the top 3 teams (Winner, 1st runner up, 2nd runner up).
 * Winner is team with largest scores.
 */

import java.util.*;

/**
 * Input : HashMap<String, HashMap<String, Score> </>></>
 *
 * Return top 3 winners
 * Every judge may not vote for all teams
 *
 * Parse through list
 * Store score in map<TeamName, Integer>
 *     </>
 */
public class Round1 {
    public List<String> findTop3(HashMap<String, HashMap<String,score>> input) {
        // Parse through the list
        HashMap<String, Integer> teamScore = new HashMap<>();
        for (Map.Entry<String, HashMap<String, score>> judgeMe : input.entrySet()){
            HashMap<String, score> judgeScore = judgeMe.getValue();
            for(Map.Entry<String, score> me : judgeScore.entrySet()) {
                Integer currTeamScore = teamScore.getOrDefault(me.getKey(), 0);
                score currScore = me.getValue();
                currTeamScore += currScore.idea +currScore.impact +currScore.implementation;
                teamScore.put(me.getKey(), currTeamScore);
            }
            // Find top 3 teams
        }
        PriorityQueue<TeamScore> pq = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof TeamScore && o2 instanceof TeamScore) {
                    return ((TeamScore) o2).teamScore - ((TeamScore) o1).teamScore;
                }
                return 0;
            }
        });

        for(Map.Entry<String, Integer> me : teamScore.entrySet()) {
            pq.offer(new TeamScore(me.getKey(), me.getValue()));
        }
        List<String> teamNameList = new ArrayList<>();

        for(int i =0; i< 3 && pq.size()>0; i++){
            TeamScore ts = pq.poll();
        teamNameList.add(ts.teamName);
        }
        return teamNameList;
    }
    public String doSomething(){
        return "test";
    }
}
