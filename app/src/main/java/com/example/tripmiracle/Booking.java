package com.example.tripmiracle;

public class Booking {
        private int roomNo;
        private String historyDuration;
        private String historyTime;

        public int getRoomNo() {
                return roomNo;
        }

        public String getHistoryDuration() {
                return historyDuration;
        }

        public String getHistoryTime() {
                return historyTime;
        }

        public void setRoomNo(int roomNo) {
                this.roomNo = roomNo;
        }

        public void setHistoryDuration(String historyDuration) {
                this.historyDuration = historyDuration;
        }

        public void setHistoryTime(String historyTime) {
                this.historyTime = historyTime;
        }

        // constructor
        public Booking(int roomNo, String historyDuration, String historyTime) {
                this.roomNo = roomNo;
                this.historyDuration = historyDuration;
                this.historyTime = historyTime;
        }
}


