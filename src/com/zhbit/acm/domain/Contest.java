package com.zhbit.acm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by czf on 16-6-16.
 */
public class Contest {
        private static final long serialVersionUID = 1530127413381718585L;
        private Integer contest_id;
        private String title;
        private String description;
        private Date  start_time;
        private Date end_time;
        private Integer mode;
        private Set<ContestPlayer> players;
        public Contest() {}

        public Contest(Integer contest_id, String title, Date start_time, Date end_time) {
                this.contest_id = contest_id;
                this.title = title;
                this.start_time = start_time;
                this.end_time = end_time;
        }

        public Set<ContestPlayer> getPlayers() {
                return players;
        }

        public void setPlayers(Set<ContestPlayer> players) {
                this.players = players;
        }

        public void copyAll(Contest contest){
                contest_id=contest.getContest_id();
                title=contest.getTitle();
                description=contest.getDescription();
                start_time=contest.getStart_time();
                end_time=contest.getEnd_time();
                mode=contest.getMode();
        }
        public Integer getContest_id() {
                return contest_id;
        }
        public void setContest_id(Integer contest_id) {
                this.contest_id = contest_id;
        }

        public Integer getMode() {
                return mode;
        }

        public void setMode(Integer mode) {
                this.mode = mode;
        }

        public static long getSerialVersionUID() {
                return serialVersionUID;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Date getStart_time() {
                return start_time;
        }

        public void setStart_time(Date start_time) {
                this.start_time = start_time;
        }

        public Date getEnd_time() {
                return end_time;
        }

        public void setEnd_time(Date end_time) {
                this.end_time = end_time;
        }

//      比赛的进行状态  ,  如果Running返回0, 结束了返回1, 未开始返回-1 . 信息专家.
        public int status(){
                Date current = new Date();

                if (start_time.after(current))
                        return -1;
                if (end_time.before(current))
                        return 1;
                return 0;
        }

}
