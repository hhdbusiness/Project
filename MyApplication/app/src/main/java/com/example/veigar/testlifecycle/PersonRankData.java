package com.example.veigar.testlifecycle;

import java.io.Serializable;

/**
 * Created by Veigar on 16/12/2.
 */

public class PersonRankData implements Serializable {
    private int rank;
    private String rankTag;
    private String rankDesc;
    private Protecter protecter;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRankTag() {
        return rankTag;
    }

    public void setRankTag(String rankTag) {
        this.rankTag = rankTag;
    }

    public String getRankDesc() {
        return rankDesc;
    }

    public void setRankDesc(String rankDesc) {
        this.rankDesc = rankDesc;
    }

    public Protecter getProtecter() {
        return protecter;
    }

    public void setProtecter(Protecter protecter) {
        this.protecter = protecter;
    }

    public static class Protecter implements Serializable {
        private String bid;
        private String nickname;
        private String headImage;
        private String desc;

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadImage() {
            return headImage;
        }

        public void setHeadImage(String headImage) {
            this.headImage = headImage;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
